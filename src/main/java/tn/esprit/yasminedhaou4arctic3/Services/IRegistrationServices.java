package tn.esprit.yasminedhaou4arctic3.Services;

import tn.esprit.yasminedhaou4arctic3.Entities.Piste;
import tn.esprit.yasminedhaou4arctic3.Entities.Registration;

import java.util.List;

public interface IRegistrationServices {

    Registration addReg(Registration r);
    Registration update(Registration r);
    Registration retrieveReg(Long numReg);
    void deleteReg(Long numReg);
    List<Registration> retrieveAll();
}
