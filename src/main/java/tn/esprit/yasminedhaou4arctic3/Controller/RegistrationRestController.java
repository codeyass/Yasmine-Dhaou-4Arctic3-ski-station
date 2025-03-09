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
}
