package tn.esprit.yasminedhaou4arctic3.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.yasminedhaou4arctic3.Entities.Course;
import tn.esprit.yasminedhaou4arctic3.Repositories.ICourseRepository;

import java.util.List;

@Service
public class CourseServices implements ICourseServices{


    @Autowired
    private ICourseRepository courseRepository;
    @Override
    public List<Course> retrieveAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course retrieveCourse(Long numCourse) {
        return courseRepository.findById(numCourse).orElse(null);
    }

    @Override
    public void deleteCourse(Long numCourse) {
        courseRepository.deleteById(numCourse);
    }

}
