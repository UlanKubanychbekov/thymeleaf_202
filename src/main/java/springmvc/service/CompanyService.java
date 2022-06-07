package springmvc.service;

import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import springmvc.model.Company;
import springmvc.repositories.CompanyRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

//
//    public void saveCompany(Company company) {
//        companyRepository.saveCompany(company);
//    }
//
//    public Optional<Company> findCompanyById(UUID uuid) {
//        return companyRepository.findCompanyById(uuid);
//    }
//
//    public void deleteCompanyById(UUID uuid) throws NotFoundException {
//        Company companyById = findCompanyById(uuid)
//                .orElseThrow(() -> new NotFoundException(String.format("Company is id %s not found", uuid)));
//        System.out.println(companyById);
//        companyRepository.deleteCompanyById(uuid);
//    }
//
//    public void updateCompanyById(Company newCompany, UUID id) throws NotFoundException {
//
//        companyRepository.updateCompanyById(id, newCompany);
//        Company company = companyRepository.findCompanyById(id).orElseThrow(() -> new NotFoundException("not found"));
//        String companyName = company.getCompanyName();//
//        String newCompanyName = newCompany.getCompanyName();//
//        String newLocatedCountry = newCompany.getLocatedCountry();
//        if (!Objects.equals(newCompany, newCompanyName) || !Objects.equals(newCompany, newLocatedCountry)) {
//            company.setCompanyName(newCompanyName);
//            company.setLocatedCountry(newLocatedCountry);
//        }
//
//    }
//
//
//        public List<Company> companies () {
//            return companyRepository.getALLCompany();
//        }
//    }


    public void save(Company company) {
        companyRepository.save(company);
    }


    public List<Company> getCompanies() {
        return companyRepository.getCompanies();
    }


    public Company getCompanyById(UUID id) {
        return companyRepository.getCompanyById(id);
    }

    public void deleteCompany(UUID id) {
        companyRepository.deleteCompany(id);
    }


    public void updateCompany(UUID id, Company updatedCompany) {
        companyRepository.updateCompanyById( updatedCompany,id);
    }
}