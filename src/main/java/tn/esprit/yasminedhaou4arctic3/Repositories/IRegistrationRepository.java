package tn.esprit.yasminedhaou4arctic3.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.yasminedhaou4arctic3.Entities.Registration;

public interface IRegistrationRepository extends JpaRepository<Registration,Long> {
}
