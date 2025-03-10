package tn.esprit.yasminedhaou4arctic3.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.yasminedhaou4arctic3.Entities.Piste;
import tn.esprit.yasminedhaou4arctic3.Entities.Skier;
import tn.esprit.yasminedhaou4arctic3.Repositories.IPisteRepository;
import tn.esprit.yasminedhaou4arctic3.Repositories.ISkierRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PisteServices implements IPisteServices{


    private IPisteRepository pisteRepository;
    private ISkierRepository skierRepository;

    @Override
    public Piste addPiste(Piste p){
     return    pisteRepository.save(p);

    }

    @Override
    public Piste update(Piste p) {
        return pisteRepository.save(p);
    }

    @Override
    public Piste retrievePiste(Long numPiste) {
        return pisteRepository.findById(numPiste).orElse(null);
    }

    @Override
    public void deletePiste(Long numPiste) {

        pisteRepository.deleteById(numPiste);
    }

    @Override
    public List<Piste> retrieveAll() {
        return pisteRepository.findAll();
    }

    @Override
    public Piste assignSkierToPiste(int numSkier, Long numPiste) {
        Piste piste = pisteRepository.findById(numPiste).orElse(null);
        Skier skier = skierRepository.findById(numSkier).orElse(null);
        if(piste != null && skier != null) {
            piste.getSkiers().add(skier);
            return pisteRepository.save(piste);
        }
        return null;
    }

}
