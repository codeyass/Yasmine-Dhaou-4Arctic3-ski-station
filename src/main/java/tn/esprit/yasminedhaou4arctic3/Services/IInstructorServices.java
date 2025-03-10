package tn.esprit.yasminedhaou4arctic3.Services;

import tn.esprit.yasminedhaou4arctic3.Entities.Instructor;

import java.util.List;

public interface IInstructorServices {

    List<Instructor> retrieveInstructors();
    Instructor addInstructor(Instructor instructor);
    Instructor updateInstructor (Instructor instructor);
    Instructor retrieveInstructor (Long numInstructor);
    void deleteInstructor(Long numInstructor);

    Instructor addInstructorAndAssignToCourse(Instructor instructor, Long numCourse);

}
