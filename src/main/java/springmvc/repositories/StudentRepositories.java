package springmvc.repositories;

import javassist.NotFoundException;
import org.springframework.stereotype.Repository;
import springmvc.model.Student;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
public class StudentRepositories {
    private final EntityManager entityManager;

    public StudentRepositories(EntityManagerFactory entityManager) {
        this.entityManager = entityManager.createEntityManager();
    }
//
//    public void saveStudent(Student student) {
//        entityManager.getTransaction().begin();
//        entityManager.persist(student);
//        entityManager.getTransaction().commit();
//    }
//
//    public Optional<Student> findStudentById(UUID id) {
//        return Optional.ofNullable(entityManager.find(Student.class, id));
//
//    }
//
//
//    public void removeStudentById(UUID id) throws NotFoundException {
//        findStudentById(id).orElseThrow(()->new NotFoundException("student is id %s not found"));
//        entityManager.merge(id);
//
//    }
//
//
//    public List<Student> getAllStudent() {
//        List<Student> students = entityManager.createQuery("select s from Student s", Student.class).getResultList();
//        return students;
//    }
//
//
//    public void updateStudent(UUID id, Student student) throws NotFoundException {
//        findStudentById(id).orElseThrow(()->new NotFoundException("not found student"));
//        entityManager.createQuery("update Company set ");
//
//    }
//}


    public void saveStudent(Student student) {
        entityManager.merge(student);
    }


    public List<Student> getStudents(UUID id) {
        return entityManager.createQuery("select s from Student s where s.groups.id=:id",Student.class).setParameter("id",id).getResultList();
    }


    public Student getStudentById(UUID id) {
        return entityManager.find(Student.class,id);
    }


    public void deleteStudent(UUID id) {
        entityManager.remove(getStudentById(id));
    }


    public void updateStudent(UUID id, Student updatedStudent) {
        Student student = getStudentById(id);
        student.setFirstName(updatedStudent.getFirstName());
        student.setLastname(updatedStudent.getLastname());
        student.setEmail(updatedStudent.getEmail());
        student.setStudyFormat(updatedStudent.getStudyFormat());
        entityManager.merge(student);
    }
}
