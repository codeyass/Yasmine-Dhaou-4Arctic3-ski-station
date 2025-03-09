package tn.esprit.yasminedhaou4arctic3.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)  //optimisation de private pour chaque att
public class Piste implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //MySql
     long numPiste;
     String namePiste;
     int length;
     int slope;
    @Enumerated(EnumType.STRING)
     Color color;

    @ManyToMany
    Set<Skier> skiers;  //avoir primary key dans la table associative
}
