package springmvc.repositories;

import javassist.NotFoundException;
import org.springframework.stereotype.Repository;
import springmvc.model.Company;
import springmvc.model.Course;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
public class CourseRepositories {

    private final EntityManager entityManager;

    public CourseRepositories(EntityManagerFactory entityManager) {
        this.entityManager = entityManager.createEntityManager();
    }


    public void saveCourse(Course course) {
        entityManager.getTransaction().begin();
        System.out.println("begin");
        System.out.println(course);
        entityManager.merge(course);
        System.out.println("persist");
        entityManager.getTransaction().commit();
        System.out.println("commit save so;ucrs");
    }


    public  Course findCourseById(UUID id) {
        return entityManager.find(Course.class, id);

    }


    public void removeCourseId(UUID uuid) {
        entityManager.createQuery("delete from Course c where c.id = ?1",Course.class).setParameter(1,uuid);

    }
    public void removeCourseId(Course uuid) {
        System.out.println(uuid);
        entityManager.remove(uuid);
    }

    public List<Course> getAllCourse(UUID id) {
        List<Course> courses = entityManager.createQuery("select c from Course c where c.company.id=?1", Course.class).setParameter(1,id).getResultList();
        return courses;
    }


    public void update(UUID id, Course course) throws NotFoundException {
        entityManager.merge(course);

    }
    public List<Course> findByCourseId(UUID courseId) {
        return entityManager
                .createQuery("select c from Company c where (select c1 from Course c1 where c1.id = ?1) " +
                        "member of c.courses", Course.class)
                .setParameter(1, courseId)
                .getResultList();
    }
}
