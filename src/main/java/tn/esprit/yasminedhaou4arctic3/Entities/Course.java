package tn.esprit.yasminedhaou4arctic3.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long numCourse;
    int level;

    @Enumerated(EnumType.STRING)
    TypeCourse typeCourse;

    @Enumerated(EnumType.STRING)
    Support support;

    Float price;
    int timeSlot;

    @OneToMany(mappedBy = "course")
    List<Registration> registrations;

}
