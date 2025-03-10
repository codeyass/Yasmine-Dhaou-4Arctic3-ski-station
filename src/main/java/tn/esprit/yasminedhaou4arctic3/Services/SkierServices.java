package tn.esprit.yasminedhaou4arctic3.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.yasminedhaou4arctic3.Entities.Course;
import tn.esprit.yasminedhaou4arctic3.Entities.Skier;
import tn.esprit.yasminedhaou4arctic3.Repositories.ICourseRepository;
import tn.esprit.yasminedhaou4arctic3.Repositories.ISkierRepository;
import tn.esprit.yasminedhaou4arctic3.Repositories.ISubscriptionRepository;

import java.util.List;

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


}
