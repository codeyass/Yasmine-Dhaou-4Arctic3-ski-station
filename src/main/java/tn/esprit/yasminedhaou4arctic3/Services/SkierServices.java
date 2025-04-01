package tn.esprit.yasminedhaou4arctic3.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.yasminedhaou4arctic3.Entities.Course;
import tn.esprit.yasminedhaou4arctic3.Entities.Skier;
import tn.esprit.yasminedhaou4arctic3.Entities.Subscription;
import tn.esprit.yasminedhaou4arctic3.Entities.TypeSubscription;
import tn.esprit.yasminedhaou4arctic3.Repositories.ICourseRepository;
import tn.esprit.yasminedhaou4arctic3.Repositories.ISkierRepository;
import tn.esprit.yasminedhaou4arctic3.Repositories.ISubscriptionRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class SkierServices implements ISkierServices{


    private ISkierRepository skierRepository;
    private ICourseRepository courseRepository;

    @Autowired
    private ISubscriptionRepository subscriptionRepository;

    @Override
    public Skier addSkier(Skier skier) {


        return skierRepository.save(skier);
    }

    @Override
    public Skier updateSkier(Skier skier) {

        return skierRepository.save(skier);
    }

    @Override
    public Skier retrieveSkier(int numSkier) {
        return skierRepository.findById(numSkier).orElse(null);
    }
    @Override
    public void deleteSkier(int numSkier) {
        skierRepository.deleteById(numSkier);

    }

    @Override
    public List<Skier> retrieveAll() {
        return skierRepository.findAll();
    }

    @Override
    public Skier addSkierAndAssignToCourse(Skier skier, Long numCourse) {
        Course course = courseRepository.findById(numCourse).orElse(null);
        skier.getRegistrations().forEach(r ->
                {
                    r.setCourse(course);
                    r.setSkier(skier);
                }
        );
        return skierRepository.save(skier);
    }

    @Override
    public List<Skier> retrieveSkiersBySubscriptionType(TypeSubscription typeAbonnement) {

        List<Skier> listSkiers = skierRepository.findAll();
        List<Skier> listSkierBySubs=new ArrayList<>();
        listSkiers.forEach(s->{
            if(s.getSubscription().getTypeSub()==typeAbonnement)
                listSkierBySubs.add(s);
                }


        );
        return listSkierBySubs;

    }

    @Override
    public Set<Subscription> getSubscriptionByType(TypeSubscription type) {
        List<Skier> listSkiers = skierRepository.findAll();
        Set<Subscription> listSubsByType=new HashSet<>();
        listSkiers.forEach(s->{
                    if(s.getSubscription().getTypeSub()==type)
                        listSubsByType.add(s.getSubscription());
                }


        );
        return listSubsByType;
    }

    @Override
    public List<Subscription> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate) {
        List<Skier> listSkiers = skierRepository.findAll();
        List<Subscription> listSubsByType=new ArrayList<>();
        listSkiers.forEach(s->{
                    if(s.getSubscription().getStartDate().isAfter(startDate) && s.getSubscription().getEndDate().isBefore(endDate))
                        listSubsByType.add(s.getSubscription());
                }


        );
        return listSubsByType;
    }


}
