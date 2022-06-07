package springmvc.controller;

import javassist.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import springmvc.model.Company;
import springmvc.model.Course;
import springmvc.service.CompanyService;
import springmvc.service.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import springmvc.service.GroupService;
import springmvc.service.TeacherService;

import java.util.UUID;

//
//import java.util.UUID;
//
//@Controller
//@RequestMapping("/api/courses")
//public class CourseController {
//    private final CourseService courseService;
//    private final CompanyService companyService;
//
//
//    public CourseController(CourseService courseService, CompanyService companyService) {
//        this.courseService = courseService;
//        this.companyService = companyService;
//
//    }
//    @GetMapping("/company/{id}")
//    public String findAllCourses(@PathVariable("id") UUID uuid, Model model) throws NotFoundException {
//        model.addAttribute("courses", courseService.getAllCoursesForCompany(uuid));
//        model.addAttribute("companyId", uuid);
//        return "courses/allCourses";
//
//    }
//
//    @GetMapping("{id}")
//    public String findById(@PathVariable UUID id,Model model){
//        model.addAttribute("course",courseService.findCourseById(id));
//        return "coursePage";
//    }
//
//
//    @GetMapping("company/courses/save/{companyId}")
//    public String saveCourses(Model model,@PathVariable UUID companyId) {
//        System.out.println("save company id "+companyId);
//        model.addAttribute("emptyCourses", new Course());
//        model.addAttribute("company",companyId);
//        return "courses/courseSavePage";
//    }
//
//    @PostMapping("/saveCourse/{companyId}")
//    public String saveCourse(@ModelAttribute("course") Course course,@PathVariable UUID companyId) {
////        try{
////            course.setCompany(companyService.findCompanyById(course.getCompanyId()));
////            if (course.getCompanyId() == null){
////                throw new Exception();
////            }
////    } catch (Exception e) {
////            e.printStackTrace();
////        }
//        course.setCompany(companyService.findCompanyById(companyId).get());
//        courseService.saveCourse(companyId,course);
//        return "redirect:/api/courses/company/"+companyId;
//    }
//    @GetMapping("/company/courses/delete/{courseId}")
//    public String deleteCourse(@PathVariable UUID courseId) throws NotFoundException {
////        Company company = courseService.findCourseById(courseId).getCompany();
////        courseService.deleteCourseById(courseService.findCourseById(courseId));
////        model.addAttribute("courses",)
//        courseService.deleteCourseById(courseId);
//        System.out.println("ha delete");
//        return "redirect:/api/companies";
//    }
//    @GetMapping("company/courses/update/{courseId}")
//    public String updateCourse(@PathVariable UUID courseId,Model model) throws NotFoundException {
//        Company company = courseService.findCourseById(courseId).getCompany();
//        System.out.println("he");
////        courseService.updateCourseById(courseId);
//        model.addAttribute("course",courseService.findCourseById(courseId));
//        model.addAttribute("companyId",company.getId());
//        model.addAttribute("courseId",courseId);
//        System.out.println("ha");
//        return "courses/updateCourse";
//    }
//    @PostMapping("update/update/{companyId}")
//    public String updateCourse2(@PathVariable UUID companyId,Model model, Course course) throws NotFoundException {
//        Company company = courseService.findCourseById(companyId).getCompany();
//
//        System.out.println(course);
//        courseService.updateCourseById(course,companyId);
//        return "redirect:/api/courses/company/"+company.getId();
//    }
//
//
//}


@Controller
@RequestMapping("/courses/{id}")
public class CourseController {

    private final CourseService serviceCourse;
    private final CompanyService serviceCompany;
    private final GroupService serviceGroup;
    private final TeacherService
            serviceTeacher;


    @Autowired
    public CourseController(CourseService serviceCourse, CompanyService serviceCompany,
                            GroupService serviceGroup,TeacherService serviceTeacher) {
        this.serviceCourse = serviceCourse;
        this.serviceCompany = serviceCompany;
        this.serviceGroup = serviceGroup;
        this.serviceTeacher=serviceTeacher;

    }

    @GetMapping("/newCourse")
    public String newCourse(Model model) {
        model.addAttribute("course", new Course());
        return "course/newCourse";
    }

    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute("course") Course course, @PathVariable("id") UUID id) {
        course.setCompany(serviceCompany.getCompanyById(id));
        serviceCourse.save(course);
        return "redirect:/courses/{id}";
    }

    @GetMapping
    public String getCourses(Model model, @PathVariable("id") UUID id) {
        model.addAttribute("courseLists", serviceCourse.getCourses(id));
        model.addAttribute("companyId", id);
        model.addAttribute("groupLists", serviceGroup.getGroupByCompanyId(id));
        model.addAttribute("teacherLists", serviceTeacher.getTeachers(id));
        return "course/getCourses";
    }


    @GetMapping("/{idCourse}/editCourse")
    public String editCourse(Model model, @PathVariable("id") UUID id,@PathVariable("idCourse")UUID idCourse) {
        model.addAttribute("course", serviceCourse.getCourseById(idCourse));
        model.addAttribute("companyId", id);
        return "course/editCourse";
    }

    @PatchMapping("/{idCourse}/updateCourse")
    public String updateCourse(@ModelAttribute("course") Course course, @PathVariable("idCourse") UUID idCourse) {
        serviceCourse.updateCourse(idCourse, course);
        return "redirect:/courses/{id}";
    }

    @DeleteMapping("/{idCourse}/deleteCourse")
    public String deleteCourse(@PathVariable("idCourse") UUID id) {
        serviceCourse.deleteCourse(id);
        return "redirect:/courses/{id}";
    }

}
