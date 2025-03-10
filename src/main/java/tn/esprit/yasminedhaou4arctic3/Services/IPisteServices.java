package tn.esprit.yasminedhaou4arctic3.Services;

import tn.esprit.yasminedhaou4arctic3.Entities.Piste;

import java.util.List;

public interface IPisteServices {
    Piste addPiste(Piste p);
    Piste update(Piste p);
    Piste retrievePiste(Long numPiste);
    void deletePiste(Long numPiste);
    List<Piste> retrieveAll();
    Piste assignSkierToPiste(int numSkier, Long numPiste);
}
