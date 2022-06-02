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

    public void saveCourse(Course course) {
        courseRepositories.saveCourse(course);
    }

    public  Course findCourseById(UUID id) {
        return courseRepositories.findCourseById(id);

    }

    public void deleteCourseById(UUID id) {
        courseRepositories.removeCourseId(id);

    }
    public void deleteCourseById(Course id) {
        courseRepositories.removeCourseId(id);

    }
    public void updateCourseById(Course newCourse, UUID id) throws NotFoundException {
        System.out.println("start 1");
        System.out.println(id);
        Course course = courseRepositories.findCourseById(id);
        System.out.println(2);
        String CourseName = course.getCourseName();
        System.out.println("start");
        String newCourseName = newCourse.getCourseName();
        System.out.println(3);
        if(!Objects.equals(newCourse,newCourseName)){
            course.setCourseName(newCourseName);
        }
        System.out.println("finish");
    }

    public List<Course> getAllCoursesForCompany(UUID uuid) {
        return courseRepositories.getAllCourse(uuid);

    }
    public List<Course> findByCompanyId(UUID companyId){
        return courseRepositories.findByCourseId(companyId);
    }

}
