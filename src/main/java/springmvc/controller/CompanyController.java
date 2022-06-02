package springmvc.controller;

import javassist.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springmvc.model.Company;
import springmvc.model.Course;
import springmvc.service.CompanyService;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/api/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @ModelAttribute("companyList")
    public List<Company> findAllCompany() {
        return companyService.companies();
    }

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("companyList", findAllCompany());
        return "companies/allCompany";
    }

    @GetMapping("save")
    public String saveCompanyPage(Model model) {
        model.addAttribute("emptyCompany", new Company());
        return "companies/saveCompany";
    }
    //    @Override
    //    public Company getCompanyById(Long id) {
    //        return entityManager.find(Company.class, id);
    //    }

    @PostMapping("/saves")
    public String saveCompany(Company company) {
        System.out.println(company);
        companyService.saveCompany(company);
        return "redirect:/api/companies";
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable("id") UUID id) throws NotFoundException {
        companyService.deleteCompanyById(id);
        return "redirect:/api/companies/";
    }

//    @GetMapping("company/courses/delete/{courseId}")
//    public String deleteCourse(@PathVariable UUID) throws NotFoundException {
////        Company company = courseService.findCourseById(courseId).getCompany();
////        courseService.deleteCourseById(courseService.findCourseById(courseId));
//        companyService.deleteCompanyById(courseId);
////        model.addAttribute("courses",)
//        System.out.println("ha delete");
//        return "redirect:/api/courses/company/" + courseId;
//    }


    @PatchMapping("/{id}")
    public String update(@ModelAttribute("company")Company company, @PathVariable("id") UUID id) throws NotFoundException {
        companyService.updateCompanyById(company,id);
        return "redirect:/api/companies"+id;
    }

    @GetMapping("update/{id}")
    public String edit(@PathVariable UUID id,Model model){
        model.addAttribute("company", companyService.findCompanyById(id));
        return "companies/updateCompanies";
    }

}


