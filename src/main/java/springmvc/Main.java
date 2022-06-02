//package springmvc;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import springmvc.config.WebAppConfig;
//import springmvc.model.Student;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//
//public class Main {
//    public static void main(String[] args) {
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(WebAppConfig.class);
//
//        EntityManagerFactory entityManagerFactory =
//                applicationContext.getBean("emf", EntityManagerFactory.class);
//
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//        entityManager.getTransaction().begin();
//
//        entityManager.persist(new Student());
//
//        entityManager.getTransaction().commit();
//
//        entityManager.close();
//
//        entityManagerFactory.close();
//    }
//}
