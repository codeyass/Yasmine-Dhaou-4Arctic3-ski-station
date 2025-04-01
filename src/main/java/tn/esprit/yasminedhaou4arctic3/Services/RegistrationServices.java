package tn.esprit.yasminedhaou4arctic3.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.yasminedhaou4arctic3.Entities.Course;
import tn.esprit.yasminedhaou4arctic3.Entities.Registration;
import tn.esprit.yasminedhaou4arctic3.Entities.Skier;
import tn.esprit.yasminedhaou4arctic3.Entities.TypeCourse;
import tn.esprit.yasminedhaou4arctic3.Repositories.ICourseRepository;
import tn.esprit.yasminedhaou4arctic3.Repositories.IRegistrationRepository;
import tn.esprit.yasminedhaou4arctic3.Repositories.ISkierRepository;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
@AllArgsConstructor
@Service
public class RegistrationServices implements IRegistrationServices{


    private IRegistrationRepository registrationRepository;


    private ICourseRepository courseRepository;


    private ISkierRepository skierRepository;

    @Override
    public Registration addReg(Registration r) {

        if (r.getCourse() != null) {
            courseRepository.save(r.getCourse());
        }

        if (r.getSkier() != null) {
            skierRepository.save(r.getSkier());
        }
        return registrationRepository.save(r);
    }

    @Override
    public Registration update(Registration r) {
        if (r.getCourse() != null) {
            courseRepository.save(r.getCourse());
        }

        if (r.getSkier() != null) {
            skierRepository.save(r.getSkier());
        }
        return registrationRepository.save(r);
    }

    @Override
    public Registration retrieveReg(Long numReg) {
        return registrationRepository.findById(numReg).orElse(null);
    }

    @Override
    public void deleteReg(Long numReg) {
registrationRepository.deleteById(numReg);
    }

    @Override
    public List<Registration> retrieveAll() {
        return registrationRepository.findAll();
    }

    @Override
    public Registration addRegistrationAndAssignToSkier(Registration registration, int numSkier) {
        Skier skier=skierRepository.findById(numSkier).orElse(null);
        registration.setSkier(skier);
        return registrationRepository.save(registration);
    }

    @Override

    public Registration addRegistrationAndAssignToSkierAndCourse(Registration registration, int numSkier, Long numCourse) {
        Skier skier = skierRepository.findById(numSkier)
                .orElseThrow(() -> new IllegalArgumentException("Skier with ID " + numSkier + " not found"));

        Course course = courseRepository.findById(numCourse)
                .orElseThrow(() -> new IllegalArgumentException("Course with ID " + numCourse + " not found"));

        int maxNbSkPerCourse = 6;
        int ageSk = Period.between(skier.getDateOfBirth(), LocalDate.now()).getYears();
        TypeCourse typeCourse = course.getTypeCourse();


        if (course.getRegistrations().size() >= maxNbSkPerCourse) {
            throw new IllegalStateException("The course with ID " + numCourse + " is full (max " + maxNbSkPerCourse + " skiers allowed).");
        }


        if (ageSk < 18 && typeCourse != TypeCourse.COLLECTIVE_CHILDREN) {
            throw new IllegalArgumentException("A child cannot be registered in an adult course.");
        }
        if (ageSk >= 18 && typeCourse != TypeCourse.COLLECTIVE_ADULT) {
            throw new IllegalArgumentException("An adult cannot be registered in a children’s course.");
        }


        registration.setSkier(skier);
        registration.setCourse(course);
        return registrationRepository.save(registration);
    }

}
