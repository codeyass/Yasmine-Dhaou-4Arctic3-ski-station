package tn.esprit.yasminedhaou4arctic3.Services;

import tn.esprit.yasminedhaou4arctic3.Entities.Course;
import tn.esprit.yasminedhaou4arctic3.Entities.Piste;

import java.util.List;

public interface ICourseServices {
    List<Course> retrieveAllCourses();
    Course addCourse(Course course);
    Course updateCourse(Course course);
    Course retrieveCourse(Long numCourse);
    void deleteCourse(Long numCourse);
}
