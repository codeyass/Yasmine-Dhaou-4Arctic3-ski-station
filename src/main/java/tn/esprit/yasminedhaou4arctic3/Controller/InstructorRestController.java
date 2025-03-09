package tn.esprit.yasminedhaou4arctic3.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.yasminedhaou4arctic3.Entities.Instructor;
import tn.esprit.yasminedhaou4arctic3.Entities.Piste;
import tn.esprit.yasminedhaou4arctic3.Services.IInstructorServices;

import java.util.List;

@RestController
@RequestMapping("instructor")
public class InstructorRestController {

    @Autowired
    private IInstructorServices instructorServices;

    @PostMapping("add")
    public Instructor addInstructor(@RequestBody Instructor i){

        return instructorServices.addInstructor(i);
    }


    @PutMapping("update")
    public Instructor update(@RequestBody Instructor i){

        return instructorServices.updateInstructor(i);
    }

    @GetMapping("get/{numInstructor}")   //numPiste mm non de param de methode
    public Instructor retrieveInstructor(@PathVariable Long numInstructor){
        return instructorServices.retrieveInstructor(numInstructor);
    }

    @GetMapping("getall")
    public List<Instructor> retrieveAll(){

        return instructorServices.retrieveInstructors();
    }

    @DeleteMapping ("delete/{numInstructor}")
    public void deleteInstructor(@PathVariable Long numInstructor){
        instructorServices.deleteInstructor(numInstructor);
    }

}
