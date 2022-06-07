package springmvc.model;


//1) CRUD LMS приложение жазыныз. Spring MVC + Hibernate колдонунуз.
//
//2) Company(Peaksoft, ...), Course(Java1, Java2, Technical Sckils , ...), Teacher(Zamir Sabyrzhanov, ...), Student(Hadicha Zamirbekova, ...), Group(JavaBatch4, ...) деген класстар болушу керек.
//
//Company(id, companyName, locatedCountry)


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;
import java.util.UUID;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;



@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "company_nam")
    private String companyName;

    @Column(name = "located_country")
    private String locatedCountry;

    @OneToMany(cascade = ALL, fetch = EAGER, mappedBy = "company")
    private List<Course> courses;

    public Company(String companyName, String locatedCountry) {
        this.companyName = companyName;
        this.locatedCountry = locatedCountry;
    }

}