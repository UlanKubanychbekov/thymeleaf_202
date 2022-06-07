package springmvc.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springmvc.model.enumClass.StudyFormat;

import javax.persistence.*;
import java.util.UUID;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.DETACH;
import static javax.persistence.FetchType.EAGER;


@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "fisrt_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "study_format")
    @Enumerated(value = EnumType.STRING)
    private StudyFormat studyFormat;

    @ManyToOne(cascade = {PERSIST, MERGE, REFRESH, DETACH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group groups;

    public Student(String firstName, String email) {
        this.firstName = firstName;
        this.email = email;
    }
}
