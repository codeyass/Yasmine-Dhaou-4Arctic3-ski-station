package tn.esprit.yasminedhaou4arctic3.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.yasminedhaou4arctic3.Entities.Course;
import tn.esprit.yasminedhaou4arctic3.Entities.Piste;
import tn.esprit.yasminedhaou4arctic3.Services.ICourseServices;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseRestController {

    @Autowired
    private ICourseServices courseServices;

    @PostMapping("add")
    public Course addCourse(@RequestBody Course c){

        return courseServices.addCourse(c);
    }


    @PutMapping("update")
    public Course update(@RequestBody Course c){

        return courseServices.updateCourse(c);
    }

    @GetMapping("get/{numCourse}")   //numPiste mm non de param de methode
    public Course retrieveCourse(@PathVariable Long numCourse){
        return courseServices.retrieveCourse(numCourse);
    }

    @GetMapping("getall")
    public List<Course> retrieveAll(){

        return courseServices.retrieveAllCourses();
    }

    @DeleteMapping ("delete/{numCourse}")
    public void deleteCourse(@PathVariable Long numCourse){
       courseServices.deleteCourse(numCourse);
    }

}
