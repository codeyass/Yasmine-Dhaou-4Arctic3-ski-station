package tn.esprit.yasminedhaou4arctic3.Services;

import tn.esprit.yasminedhaou4arctic3.Entities.Skier;

import java.util.List;

public interface ISkierServices {
    Skier addSkier(Skier skier);
    Skier updateSkier(Skier skier);
    Skier retrieveSkier(int numSkier);
    void deleteSkier(int numSkier);
    List<Skier> retrieveAll();

    Skier addSkierAndAssignToCourse(Skier skier, Long numCourse);



}
