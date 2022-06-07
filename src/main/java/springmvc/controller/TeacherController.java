package springmvc.controller;

import org.springframework.stereotype.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import springmvc.model.Teacher;
import springmvc.service.CompanyService;
import springmvc.service.CourseService;
import springmvc.service.TeacherService;

import java.util.UUID;

@Controller
@RequestMapping("/teachers/{id}")
public class TeacherController {

    private final CourseService serviceCourse;
    private final CompanyService serviceCompany;
    private final TeacherService serviceTeacher;

    @Autowired
    public TeacherController(CourseService serviceCourse, CompanyService serviceCompany,
                             TeacherService serviceTeacher) {
        this.serviceCourse = serviceCourse;
        this.serviceCompany = serviceCompany;
        this.serviceTeacher = serviceTeacher;

    }

    @GetMapping("/newTeacher")
    public String newTeacher(Model model) {
        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);
        model.addAttribute("courseName", teacher);
        return "teacher/newTeachers";
    }

    @PostMapping("/saveTeacher")
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher, @ModelAttribute("courseName") String courseName, @PathVariable("id") UUID id) {
        teacher.setCompany(serviceCompany.getCompanyById(id));
        teacher.setCourse(serviceCourse.getCourseByName(courseName));
        serviceTeacher.saveTeacher(teacher);
        return "redirect:/courses/{id}";
    }

    @DeleteMapping("/{idTeacher}/deleteTeacher")
    public String deleteTeacher(@PathVariable("idTeacher") UUID id) {
        serviceTeacher.deleteTeacher(id);
        return "redirect:/courses/{id}";
    }

    @GetMapping("/{idTeacher}/editTeacher")
    public String editTeacher(Model model, @PathVariable("id") UUID id, @PathVariable("idTeacher") UUID idTeacher) {
        model.addAttribute("teacher", serviceTeacher.getTeacherById(idTeacher));
        model.addAttribute("courseId", id);
        return "teacher/editTeachers";
    }

    @PatchMapping("/{idTeacher}/updateTeacher")
    public String updateTeacher(@ModelAttribute("teacher") Teacher teacher, @PathVariable("idTeacher") UUID idTeacher) {
        serviceTeacher.updateTeacher(idTeacher, teacher);
        return "redirect:/courses/{id}/";
    }
}
