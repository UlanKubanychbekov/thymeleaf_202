package springmvc.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "date")
    private String data;

    @ManyToOne(cascade = {ALL},fetch = LAZY)
    private Company company;

//    @ManyToMany(cascade = {MERGE, PERSIST, REFRESH}, fetch = EAGER, mappedBy = "courses")
//    private List<Group> groups;
//
//    @OneToOne(cascade = ALL, fetch = EAGER, mappedBy = "course")
//    private Teacher teacher;
//
//    public void getAllGroup(Group group) {
//        if (group == null) {
//            groups = new ArrayList<>();
//        }
//        groups.add(group);
//    }


    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", data='" + data + '\'' +
                ", company=" + company +
                '}';
    }
}
