package springmvc.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springmvc.model.Student;
import springmvc.service.GroupService;
import springmvc.service.StudentService;

import java.util.UUID;

@Controller
@RequestMapping("/students/{id}")
public class StudentController {

    private final StudentService serviceStudent;
    private final GroupService serviceGroup;

    @Autowired
    public StudentController(StudentService serviceStudent, GroupService serviceGroup) {
        this.serviceStudent = serviceStudent;
        this.serviceGroup = serviceGroup;
    }

    @GetMapping("/newStudent")
    public String newStudent(Model model) {
        model.addAttribute("student", new Student());
        return "student/newStudent";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student, @PathVariable("id") UUID id) {
        student.setGroups(serviceGroup.getGroupById(id));
        serviceStudent.saveStudent(student);
        return "redirect:/students/{id}";
    }

    @GetMapping
    public String getStudents(Model model, @PathVariable("id") UUID id) {
        model.addAttribute("studentLists", serviceStudent.getStudents(id));
        model.addAttribute("groupId", id);
        return "student/getStudent";
    }

    @DeleteMapping("/{idStudent}/deleteStudent")
    public String deleteStudent(@PathVariable("idStudent") UUID id) {
        serviceStudent.deleteStudent(id);
        return "redirect:/students/{id}";
    }

    @GetMapping("/{idStudent}/editStudent")
    public String editStudent(Model model, @PathVariable("idStudent") UUID idStudent, @PathVariable ("id")UUID id){
        model.addAttribute("student", serviceStudent.getStudentById(idStudent));
        model.addAttribute("groupId", id);
        return "student/editStudent";
    }

    @PatchMapping("/{idStudent}/updateStudent")
    public String updateStudent(@ModelAttribute("student") Student student, @PathVariable("idStudent") UUID idStudent){
        serviceStudent.updateStudent(idStudent,student);
        return "redirect:/students/{id}";
    }
}