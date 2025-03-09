package tn.esprit.yasminedhaou4arctic3.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.yasminedhaou4arctic3.Entities.Subscription;

public interface ISubscriptionRepository extends JpaRepository<Subscription,Long> {
}
