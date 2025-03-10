package tn.esprit.yasminedhaou4arctic3.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.yasminedhaou4arctic3.Entities.Registration;
import tn.esprit.yasminedhaou4arctic3.Entities.Skier;
import tn.esprit.yasminedhaou4arctic3.Repositories.ICourseRepository;
import tn.esprit.yasminedhaou4arctic3.Repositories.IRegistrationRepository;
import tn.esprit.yasminedhaou4arctic3.Repositories.ISkierRepository;

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
    public Registration assignSkier(Registration registration, int numSkier) {
        Skier skier=skierRepository.findById(numSkier).orElse(null);
        registration.setSkier(skier);
        return registrationRepository.save(registration);
    }
}
