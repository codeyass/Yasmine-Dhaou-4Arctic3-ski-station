package tn.esprit.yasminedhaou4arctic3.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.yasminedhaou4arctic3.Entities.Piste;
import tn.esprit.yasminedhaou4arctic3.Entities.Skier;
import tn.esprit.yasminedhaou4arctic3.Entities.Subscription;
import tn.esprit.yasminedhaou4arctic3.Entities.TypeSubscription;
import tn.esprit.yasminedhaou4arctic3.Services.ISkierServices;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

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


    @PostMapping("addSkierCourse/{numCourse}")
    public Skier addSkierAndAssignToCourse(@RequestBody  Skier skier, @PathVariable(name = "numCourse") Long numCourse)
    {
        return skierServices.addSkierAndAssignToCourse(skier, numCourse);
    }

    @GetMapping("skierBySubs/{typeAbonnement}")
    public List<Skier>  retrieveSkiersBySubscriptionType(@PathVariable  TypeSubscription typeAbonnement){
        return skierServices.retrieveSkiersBySubscriptionType(typeAbonnement);
    }

    @GetMapping("getAllSubsByType/{type}")

    public Set<Subscription> getSubscriptionByType(@PathVariable TypeSubscription type){
        return skierServices.getSubscriptionByType(type);
    }

    @GetMapping("getSubsByDates")
    public List<Subscription> retrieveSubscriptionsByDates(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate){
        return skierServices.retrieveSubscriptionsByDates(startDate,endDate);
    }
}
