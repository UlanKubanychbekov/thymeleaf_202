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


    public void saveCompany(Company company) {
        companyRepository.saveCompany(company);
    }

    public Optional<Company> findCompanyById(UUID uuid) {
        return companyRepository.findCompanyById(uuid);
    }

    public void deleteCompanyById(UUID uuid) throws NotFoundException {
        Company companyById = findCompanyById(uuid)
                .orElseThrow(() -> new NotFoundException(String.format("Company is id %s not found", uuid)));
        System.out.println(companyById);
        companyRepository.deleteCompanyById(uuid);
    }

    public void updateCompanyById(Company newCompany, UUID id) throws NotFoundException {
        Company company = companyRepository.findCompanyById(id).orElseThrow(() -> new NotFoundException("not found"));
        String companyName = company.getCompanyName();
        String newCompanyName = newCompany.getCompanyName();

        if (!Objects.equals(companyName, newCompanyName)) {
            company.setCompanyName(newCompanyName);
        }

        String locatedCountry = company.getLocatedCountry();
        String newLocatedCountry = newCompany.getLocatedCountry();
        if (!Objects.equals(locatedCountry, newLocatedCountry)) {
            company.setLocatedCountry(newLocatedCountry);
        }
    }

    public List<Company> companies() {
        return companyRepository.getALLCompany();
    }
}
