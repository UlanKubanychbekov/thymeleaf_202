package springmvc.repositories;

import javassist.NotFoundException;
import org.springframework.stereotype.Repository;
import springmvc.model.Company;
import springmvc.model.Course;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
public class CourseRepositories {

    private final EntityManager entityManager;

    public CourseRepositories(EntityManagerFactory entityManager) {
        this.entityManager = entityManager.createEntityManager();
    }

//
//    public void saveCourse(UUID id,Course course) {
//        entityManager.getTransaction().begin();
//        System.out.println("begin");
//        System.out.println(course);
//        entityManager.merge(course);
//        System.out.println("persist");
//        entityManager.getTransaction().commit();
//        System.out.println("commit save so;ucrs");
//    }
//
//
//    public Course findCourseById(UUID id) {
//        return entityManager.find(Course.class, id);
//
//    }
//
//
////    public void removeCourseId(UUID uuid) {
////        entityManager.createQuery("delete  from Course c where c.id = ?1", Course.class).setParameter(1, uuid);
////        System.out.println(uuid);
////        ;
////    }
//    public void removeCourseId(UUID uuid) {
//        System.out.println(uuid);
//        entityManager.remove(findCourseById(uuid));
//    }
//
//    public List<Course> getAllCourse(UUID id) {
//        List<Course> courses = entityManager.createQuery("select c from Course c where c.company.id=?1", Course.class).setParameter(1, id).getResultList();
//        return courses;
//    }
//
//
//    public void  update(UUID id, Course course) throws NotFoundException {
//        Course course1 = findCourseById(id);
//        entityManager.remove(course);
//        course1.setCourseName(course.getCourseName());
//        course1.setData(course.getData());
//        entityManager.merge(course1);
//
//
//
//
//    }
//
//    public List<Course> findByCourseId(UUID courseId) {
//        return entityManager
//                .createQuery("select c from Company c where (select c1 from Course c1 where c1.id = ?1) " +
//                        "member of c.courses", Course.class)
//                .setParameter(1, courseId)
//                .getResultList();
//    }




        public void save(Course course) {
            entityManager.merge(course);
        }


        public List<Course> getCourses(UUID id) {
            return entityManager.createQuery("SELECT c FROM Course c where c.company.id=:id", Course.class).setParameter("id", id).getResultList();
        }


        public Course getCourseById(UUID id) {
            return entityManager.find(Course.class, id);
        }

        public void deleteCourse(UUID id) {
            entityManager.remove(getCourseById(id));
        }


        public void updateCourse(UUID id, Course updatedCourse) {
            Course course = getCourseById(id);
            course.setCourseName(updatedCourse.getCourseName());
            course.setData(updatedCourse.getData());
            entityManager.merge(course);
        }


        public Course getCourseByName(String name) {
            return entityManager.createQuery("select c from Course c where c.courseName like:name", Course.class).setParameter("name", name).getSingleResult();

    }
}
