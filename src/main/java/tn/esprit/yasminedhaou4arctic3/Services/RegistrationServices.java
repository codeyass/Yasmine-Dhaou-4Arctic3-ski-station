package tn.esprit.yasminedhaou4arctic3.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.yasminedhaou4arctic3.Entities.Registration;
import tn.esprit.yasminedhaou4arctic3.Repositories.ICourseRepository;
import tn.esprit.yasminedhaou4arctic3.Repositories.IRegistrationRepository;
import tn.esprit.yasminedhaou4arctic3.Repositories.ISkierRepository;

import java.util.List;

@Service
public class RegistrationServices implements IRegistrationServices{

    @Autowired
    private IRegistrationRepository registrationRepository;

    @Autowired
    private ICourseRepository courseRepository;

    @Autowired
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
}
