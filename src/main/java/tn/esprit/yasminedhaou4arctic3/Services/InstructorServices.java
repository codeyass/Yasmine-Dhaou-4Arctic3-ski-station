package tn.esprit.yasminedhaou4arctic3.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.yasminedhaou4arctic3.Entities.Instructor;
import tn.esprit.yasminedhaou4arctic3.Repositories.IInstructorRepository;

import java.util.List;

@Service
public class InstructorServices implements IInstructorServices{

    @Autowired
    private IInstructorRepository instructorRepository;

    @Override
    public List<Instructor> retrieveInstructors() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor addInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor updateInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);

    }

    @Override
    public Instructor retrieveInstructor(Long numInstructor) {
        return instructorRepository.findById(numInstructor).orElse(null);
    }

    @Override
    public void deleteInstructor(Long numInstructor) {
        instructorRepository.deleteById(numInstructor);

    }
}
