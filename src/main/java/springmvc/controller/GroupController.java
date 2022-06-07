package springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springmvc.model.Course;
import springmvc.model.Group;
import springmvc.service.CompanyService;
import springmvc.service.CourseService;
import springmvc.service.GroupService;

import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/groups/{id}")
public class GroupController {

    private final CourseService serviceCourse;
    private final CompanyService serviceCompany;
    private final GroupService serviceGroup;


    @Autowired
    public GroupController(CourseService serviceCourse, CompanyService serviceCompany,
                           GroupService serviceGroup) {
        this.serviceCourse = serviceCourse;
        this.serviceCompany = serviceCompany;
        this.serviceGroup = serviceGroup;

    }

    @GetMapping("/newGroup")
    public String newGroup(Model model) {
        Group group = new Group();
        model.addAttribute("group", group);
        model.addAttribute("courseName", group.getCourseName());
        return "group/newGroups";
    }

    @PostMapping("/saveGroup")
    public String saveGroup(@ModelAttribute("group") Group group, @ModelAttribute("courseName") String courseName, @PathVariable("id") UUID id) {
        group.setCompany(serviceCompany.getCompanyById(id));
        group.setCourses((List<Course>) serviceCourse.getCourseByName(courseName));
        serviceGroup.saveGroup(group);
        return "redirect:/courses/{id}/";
    }


    @DeleteMapping("/{idGroup}/deleteGroup")
    public String deleteGroup(@PathVariable("idGroup") UUID id) {
        serviceGroup.deleteGroup(id);
        return "redirect:/courses/{id}/";
    }

    @GetMapping("/{idGroup}/editGroup")
    public String editGroup(Model model, @PathVariable("id") Long id, @PathVariable("idGroup") UUID idGroup) {
        model.addAttribute("group", serviceGroup.getGroupById(idGroup));
        model.addAttribute("courseId", id);
        return "group/editGroups";
    }

    @PatchMapping("/{idGroup}/updateGroup")
    public String updateGroup(@ModelAttribute("group") Group group, @PathVariable("idGroup") UUID idGroup) {
        serviceGroup.updateGroup(idGroup, group);
        return "redirect:/courses/{id}/";
    }
}
