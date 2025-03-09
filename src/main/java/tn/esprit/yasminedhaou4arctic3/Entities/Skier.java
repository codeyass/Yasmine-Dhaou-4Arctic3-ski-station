package tn.esprit.yasminedhaou4arctic3.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Skier implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int numSkier;
    String firstName;
    String lastName;
    LocalDate dateOfBirth;
    String city;

    @OneToMany(mappedBy = "skier")
    List<Registration> registrations;

    @OneToOne(cascade = {CascadeType.PERSIST , CascadeType.REMOVE})
    Subscription subscription;

    @ManyToMany(mappedBy = "skiers")

    Set<Piste> pistes;


}
