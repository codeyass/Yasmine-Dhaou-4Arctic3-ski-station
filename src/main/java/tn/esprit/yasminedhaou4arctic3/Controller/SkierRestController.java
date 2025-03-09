package tn.esprit.yasminedhaou4arctic3.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.yasminedhaou4arctic3.Entities.Piste;
import tn.esprit.yasminedhaou4arctic3.Entities.Skier;
import tn.esprit.yasminedhaou4arctic3.Services.ISkierServices;

import java.util.List;

@RestController
@RequestMapping("skier")
public class SkierRestController {
    @Autowired
    private ISkierServices skierServices;

    @PostMapping("add")
    public Skier addSkier(@RequestBody Skier s){

        return skierServices.addSkier(s);
    }


    @PutMapping("update")
    public Skier update(@RequestBody Skier s){

        return skierServices.updateSkier(s);
    }

    @GetMapping("get/{numSkier}")   //numPiste mm non de param de methode
    public Skier retrieveSkier(@PathVariable int numSkier){

        return skierServices.retrieveSkier(numSkier);
    }

    @GetMapping("getall")
    public List<Skier> retrieveAll(){

        return skierServices.retrieveAll();
    }

    @DeleteMapping ("delete/{numSkier}")
    public void deleteSkier(@PathVariable int numSkier){

        skierServices.deleteSkier(numSkier);
    }

}
