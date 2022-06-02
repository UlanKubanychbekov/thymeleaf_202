package springmvc.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "groups")
@Getter
@Setter
@NoArgsConstructor
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "start_date")
    private LocalDate startData;

    @Column(name = "finish_date")
    private LocalDate finishDate;

    @ManyToMany(cascade = {PERSIST, MERGE}, fetch = LAZY)
    @JoinTable(name = "group_id_course_id", joinColumns = @JoinColumn(name = "group_id"), inverseJoinColumns =
    @JoinColumn(name = "course_id"))
    private List<Course> courses;

//    @OneToMany(cascade = {PERSIST, MERGE, REMOVE}, fetch = EAGER, mappedBy = "group")
//    private List<Student> students;
//}
}