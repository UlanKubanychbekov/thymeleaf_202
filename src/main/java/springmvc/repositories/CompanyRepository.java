package springmvc.repositories;

import javassist.NotFoundException;
import org.springframework.stereotype.Repository;
import springmvc.model.Company;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
public class CompanyRepository {

    private final EntityManager entityManager;


    public CompanyRepository(EntityManagerFactory entityManager) {
        this.entityManager = entityManager.createEntityManager();
    }
//
//    public void saveCompany(Company company){
//        entityManager.getTransaction().begin();
//        entityManager.persist(company);
//        entityManager.getTransaction().commit();
//
//    }
//
//    public Optional<Company> findCompanyById(UUID uuid){
//     return Optional.ofNullable(entityManager.find(Company.class,uuid));
//    }
//
//    public void deleteCompanyById(UUID uuid) throws NotFoundException {
//        findCompanyById(uuid)
//                .orElseThrow(()->new NotFoundException("Company is id %s not found "));
//
//        entityManager.getTransaction().begin();
//        entityManager.remove(uuid);
//        entityManager.getTransaction().commit();
//    }
//
//    @Transactional
//    public void updateCompanyById(UUID uuid, Company company) throws NotFoundException{
////        findCompanyById(uuid)
////                .orElseThrow(()->new NotFoundException("Company is id %s not found "));
////        entityManager.merge(company);
//        Optional<Company> company1 = findCompanyById(uuid);
//        company1.get().setCompanyName(company.getCompanyName());
//        company1.get().setLocatedCountry(company.getLocatedCountry());
//        entityManager.merge(company1);
//
//
//    }
//
//    public List<Company> getALLCompany(){
//        List<Company> companies = entityManager.createQuery("select c from Company c", Company.class).getResultList();
//        return companies;
//    }
//
//}


    public void save(Company company) {
        entityManager.getTransaction().begin();
        entityManager.persist(company);
        entityManager.getTransaction().commit();

    }


    public List<Company> getCompanies() {
        return entityManager.createQuery("SELECT e FROM Company e", Company.class).getResultList();
    }


    public Company getCompanyById(UUID id) {
        return entityManager.find(Company.class, id);

    }


    public void deleteCompany(UUID id) {
        entityManager.getTransaction().begin();
        entityManager.remove(getCompanyById(id));
        entityManager.getTransaction().commit();
    }


    @Transactional
//    public void updateCompany(UUID id, Company updatedCompany) {
//        Company company = getCompanyById(id);
//        company.setCompanyName(updatedCompany.getCompanyName());
//        company.setLocatedCountry(updatedCompany.getLocatedCountry());
//        entityManager.merge(company);
//    }
    public void updateCompanyById(Company newCompany, UUID id){
        entityManager.getTransaction().begin();
        Company company = getCompanyById(id);
        String companyName = company.getCompanyName();
        String newCompanyName = newCompany.getCompanyName();
        System.out.println(1);

        if (!Objects.equals(companyName, newCompanyName)) {
            company.setCompanyName(newCompanyName);
            System.out.println(2);
        }

        String locatedCountry = company.getLocatedCountry();
        String newLocatedCountry = newCompany.getLocatedCountry();
        System.out.println(3);
        if (!Objects.equals(locatedCountry, newLocatedCountry)) {
            company.setLocatedCountry(newLocatedCountry);
            System.out.println(4);
        }
        entityManager.merge(company);
        entityManager.getTransaction().commit();
        System.out.println(5);
    }
}