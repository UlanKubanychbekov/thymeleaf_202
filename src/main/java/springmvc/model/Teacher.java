//package springmvc.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.UUID;
//
//import static javax.persistence.CascadeType.MERGE;
//import static javax.persistence.CascadeType.PERSIST;
//import static javax.persistence.FetchType.LAZY;
//
//@Entity
//@Table(name = "teachers")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class Teacher {
//    //Teacher(id, firstName, email, lastName)
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private UUID id;
//
//    @Column(name = "first_name")
//    private String firstName;
//
//    @Column(name = "last_name")
//    private String lastName;
//
//    @Column(name = "email")
//    private String email;
//
//    @OneToOne(cascade = {PERSIST, MERGE}, fetch = LAZY)
//    private Course course;
//
//}
