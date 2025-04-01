package tn.esprit.yasminedhaou4arctic3.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.yasminedhaou4arctic3.Entities.Piste;
import tn.esprit.yasminedhaou4arctic3.Entities.Registration;
import tn.esprit.yasminedhaou4arctic3.Services.IRegistrationServices;

import java.util.List;

@RestController
@RequestMapping("registration")
public class RegistrationRestController {

    @Autowired
    private IRegistrationServices registrationServices;

    @PostMapping("add")
    public Registration addReg(@RequestBody Registration r){

        return registrationServices.addReg(r);
    }


    @PutMapping("update")
    public Registration update(@RequestBody Registration r){

        return registrationServices.addReg(r);
    }

    @GetMapping("get/{numReg}")   //numPiste mm non de param de methode
    public Registration retrieveReg(@PathVariable Long numReg){
        return registrationServices.retrieveReg(numReg);
    }

    @GetMapping("getall")
    public List<Registration> retrieveAll(){

        return registrationServices.retrieveAll();
    }

    @DeleteMapping ("delete/{numReg}")
    public void deleteReg(@PathVariable Long numReg){
        registrationServices.deleteReg(numReg);
    }

    @PostMapping("addReg/{numSkier}")
    public Registration addRegistrationAndAssignToSkier(@RequestBody Registration registration, @PathVariable(name = "numSkier") int numSkier) {
        return registrationServices.addRegistrationAndAssignToSkier(registration, numSkier);
    }

    @PostMapping("ddRegAndAssignToSkAndCo/{numSkier}/{numCourse}")
    public Registration addRegistrationAndAssignToSkierAndCourse(@RequestBody  Registration registration,@PathVariable int numSkier, @PathVariable Long numCourse){
        return registrationServices.addRegistrationAndAssignToSkierAndCourse(registration,numSkier,numCourse);
    }
}
