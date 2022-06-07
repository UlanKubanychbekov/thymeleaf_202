package springmvc.service;

import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import springmvc.model.Course;
import springmvc.repositories.CourseRepositories;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class CourseService {

    private final CourseRepositories courseRepositories;

    public CourseService(CourseRepositories courseRepositories) {
        this.courseRepositories = courseRepositories;

    }
//
//    public void saveCourse(UUID id,Course course) {
//        courseRepositories.saveCourse(id,course);
//    }
//
//    public  Course findCourseById(UUID id) {
//        return courseRepositories.findCourseById(id);
//
//    }
//
////    public void deleteCourseById(UUID id) {
////        courseRepositories.removeCourseId(id);
////
////    }
//    public void deleteCourseById(UUID id) {
//        courseRepositories.removeCourseId(id);
//
//    }
//    public void updateCourseById(Course newCourse, UUID id) throws NotFoundException {
////        System.out.println("start 1");
////        System.out.println(id);
////        Course course = courseRepositories.findCourseById(id);
////        System.out.println(2);
////        String CourseName = course.getCourseName();
////        System.out.println("start");
////        String newCourseName = newCourse.getCourseName();//задаю новую переменную названия
////        String newLocalDate = newCourse.getData();//задаю новую переменную для даты
////        System.out.println(3);
////        if(!Objects.equals(newCourse,newCourseName)||!Objects.equals(newCourse,newLocalDate)){
//////            course.setData(newLocalDate);
//////            course.setCourseName(newCourseName);
////            courseRepositories.saveCourse(newCourse);
////            courseRepositories.saveCourse(newCourse.setData(newLocalDate));
////        }
//
//        courseRepositories.update(id,newCourse);
//        courseRepositories.saveCourse(id,newCourse);
//
//    }
//
//    public List<Course> getAllCoursesForCompany(UUID uuid) {
//        return courseRepositories.getAllCourse(uuid);
//
//    }
//    public List<Course> findByCompanyId(UUID companyId){
//        return courseRepositories.findByCourseId(companyId);
//    }
//
//}


    public void save(Course course) {
        courseRepositories.save(course);
    }


    public List<Course> getCourses(UUID id) {
        return courseRepositories.getCourses(id);
    }


    public Course getCourseById(UUID id) {
        return courseRepositories.getCourseById(id);
    }


    public void deleteCourse(UUID id) {
        courseRepositories.deleteCourse(id);
    }


    public void updateCourse(UUID id, Course updatedCourse) {
        courseRepositories.updateCourse(id, updatedCourse);
    }


    public Course getCourseByName(String name) {
        return courseRepositories.getCourseByName(name);
    }
}
