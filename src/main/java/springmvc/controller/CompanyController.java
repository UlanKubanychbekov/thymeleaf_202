package springmvc.controller;
//
//import javassist.NotFoundException;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;

import springmvc.model.Company;
import springmvc.service.CompanyService;
//import java.util.List;
//import java.util.UUID;
//
//@Controller
//@RequestMapping(value = "/api/companies")
//public class CompanyController {
//
//    private final CompanyService companyService;
//
//    public CompanyController(CompanyService companyService) {
//        this.companyService = companyService;
//    }
//
//    @ModelAttribute("companyList")
//    public List<Company> findAllCompany() {
//        return companyService.companies();
//    }
//
//    @GetMapping
//    public String findAll(Model model) {
//        model.addAttribute("companyList", findAllCompany());
//        return "companies/allCompany";
//    }
//
//    @GetMapping("save")
//    public String saveCompanyPage(Model model) {
//        model.addAttribute("emptyCompany", new Company());
//        return "companies/saveCompany";
//    }
//    //    @Override
//    //    public Company getCompanyById(Long id) {
//    //        return entityManager.find(Company.class, id);
//    //    }
//
//    @PostMapping("/saves")
//    public String saveCompany(Company company) {
//        System.out.println(company);
//        companyService.saveCompany(company);
//        return "redirect:/api/companies";
//    }
//
//    @DeleteMapping("delete/{id}")
//    public String delete(@PathVariable("id") UUID id) throws NotFoundException {
//        companyService.deleteCompanyById(id);
//        return "redirect:/api/companies/";
//    }
//
////    @GetMapping("company/courses/delete/{courseId}")
////    public String deleteCourse(@PathVariable UUID) throws NotFoundException {
//////        Company company = courseService.findCourseById(courseId).getCompany();
//////        courseService.deleteCourseById(courseService.findCourseById(courseId));
////        companyService.deleteCompanyById(courseId);
//////        model.addAttribute("courses",)
////        System.out.println("ha delete");
////        return "redirect:/api/courses/company/" + courseId;
////    }
//
//
//    @GetMapping("/update/{id}")
//    public String edit(@PathVariable("id") UUID id,Model model){
//     model.addAttribute("companies", companyService.findCompanyById(id));
////        System.out.println("companyControllerHa");
////        model.addAttribute("company", company);
////        model.addAttribute("companyID",id);
//        System.out.println("go");
//        return "companies/updateCompanies";
//
//    }
//    @PostMapping("/update/{id}")
//    public String update(@ModelAttribute("company") Company company,
//                         @PathVariable("id") UUID id) throws NotFoundException {
//        companyService.updateCompanyById(company,id);
//        System.out.println("goo");
//        return "redirect:/api/companies";
//    }
//
//}
//
//


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@Controller
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService serviceCompany;

    @Autowired
    public CompanyController(CompanyService serviceCompany) {
        this.serviceCompany = serviceCompany;
    }

    @GetMapping("/new")
    public String newCompany(Model model) {
        model.addAttribute("company", new Company());
        return "company/newCompany";
    }

    @PostMapping("/save")
    public String createCompany(@ModelAttribute("company") Company company) {
        serviceCompany.save(company);
        return "redirect:/companies";
    }

    @GetMapping
    public String getCompanies(Model model) {
        model.addAttribute("companyLists", serviceCompany.getCompanies());
        return "company/getCompanies";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") UUID id) {
        model.addAttribute("company", serviceCompany.getCompanyById(id));
        return "company/editCompany";
    }

    @PatchMapping("/{id}")
    public String updateCompany(@ModelAttribute("company") Company company, @PathVariable("id") UUID id) {
        serviceCompany.updateCompany(id, company);
        return "redirect:/companies";
    }

    @DeleteMapping("/{id}")
    public String deleteCompany(@PathVariable("id") UUID id) {
        serviceCompany.deleteCompany(id);
        return "redirect:/companies";
    }
}