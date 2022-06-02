//package springmvc.repositories;
//
//import javassist.NotFoundException;
//import org.springframework.stereotype.Repository;
//import springmvc.model.Company;
//import springmvc.model.Teacher;
//
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.transaction.Transactional;
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//@Repository
//@Transactional
//public class TeacherRepositories {
//    private final EntityManager entityManager;
//
//    public TeacherRepositories(EntityManagerFactory entityManager) {
//        this.entityManager = entityManager.createEntityManager();
//    }
//
//    public void saveTeacher(Teacher teacher) {
//       entityManager.getTransaction().begin();
//       entityManager.persist(teacher);
//       entityManager.getTransaction().commit();
//    }
//
//    public Optional<Teacher> getById(UUID id) {
//        return Optional.ofNullable(entityManager.find(Teacher.class,id));
//    }
//
//    public void removeTeacherById(UUID id) throws NotFoundException {
//        getById(id).orElseThrow(()->new NotFoundException("Teacher is id %s not fount"));
//        entityManager.remove(id);
//
//    }
//
//
//    public List<Teacher> getAllTeacher() {
//        List<Teacher> teachers = entityManager.createQuery("select s from Teacher s", Teacher.class).getResultList();
//        return teachers;
//    }
//
//    public void updateTeacher(UUID id, Teacher teacher) throws NotFoundException {
//        getById(id).orElseThrow(()->new NotFoundException("not found Teacher"));
//        entityManager.createQuery("update Company set Company.id =:companyid").setParameter("companyid",id);
//
//                //Java
//        //Query query = session.createQuery("update ContactEntity set firstName = :nameParam, lastName = :lastNameParam" +
//        //                ", birthDate = :birthDateParam"+
//        //                " where firstName = :nameCode");
//        //
//        //        query.setParameter("nameCode", "Nick");
//        //        query.setParameter("nameParam", "NickChangedName1");
//        //        query.setParameter("lastNameParam", "LastNameChanged1" );
//        //        query.setParameter("birthDateParam", new Date());
//        //
//        //        int result = query.executeUpdate();
//
//    }
//}
