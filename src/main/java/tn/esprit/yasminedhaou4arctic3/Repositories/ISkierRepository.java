package tn.esprit.yasminedhaou4arctic3.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.yasminedhaou4arctic3.Entities.Skier;

public interface ISkierRepository extends JpaRepository<Skier,Integer>// Long classe enveloppeur
{



}
