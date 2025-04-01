package tn.esprit.yasminedhaou4arctic3.Services;

import tn.esprit.yasminedhaou4arctic3.Entities.Skier;
import tn.esprit.yasminedhaou4arctic3.Entities.Subscription;
import tn.esprit.yasminedhaou4arctic3.Entities.TypeSubscription;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface ISkierServices {
    Skier addSkier(Skier skier);
    Skier updateSkier(Skier skier);
    Skier retrieveSkier(int numSkier);
    void deleteSkier(int numSkier);
    List<Skier> retrieveAll();

    Skier addSkierAndAssignToCourse(Skier skier, Long numCourse);

    List<Skier> retrieveSkiersBySubscriptionType(TypeSubscription typeAbonnement);
    Set<Subscription> getSubscriptionByType(TypeSubscription type);
    List<Subscription> retrieveSubscriptionsByDates(LocalDate startDate,
                                                    LocalDate endDate);
}
