package springmvc.repositories;

import javassist.NotFoundException;
import org.springframework.stereotype.Repository;
import springmvc.model.Company;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
public class CompanyRepository {

    private final EntityManager entityManager;


    public CompanyRepository(EntityManagerFactory entityManager) {
        this.entityManager = entityManager.createEntityManager();
    }

    public void saveCompany(Company company){
        entityManager.getTransaction().begin();
        entityManager.persist(company);
        entityManager.getTransaction().commit();

    }

    public Optional<Company> findCompanyById(UUID uuid){
     return Optional.ofNullable(entityManager.find(Company.class,uuid));
    }

    public void deleteCompanyById(UUID uuid) throws NotFoundException {
        findCompanyById(uuid)
                .orElseThrow(()->new NotFoundException("Company is id %s not found "));

        entityManager.remove(uuid);
    }

    public void updateCompanyById(UUID uuid, Company company) throws NotFoundException {
        findCompanyById(uuid)
                .orElseThrow(()->new NotFoundException("Company is id %s not found "));
        entityManager.merge(company);


    }

    public List<Company> getALLCompany(){
        List<Company> companies = entityManager.createQuery("select c from Company c", Company.class).getResultList();
        return companies;
    }

}
