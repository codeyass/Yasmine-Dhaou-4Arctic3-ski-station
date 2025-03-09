package tn.esprit.yasminedhaou4arctic3.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.yasminedhaou4arctic3.Entities.Skier;
import tn.esprit.yasminedhaou4arctic3.Repositories.ISkierRepository;
import tn.esprit.yasminedhaou4arctic3.Repositories.ISubscriptionRepository;

import java.util.List;

@Service
public class SkierServices implements ISkierServices{

    @Autowired
    private ISkierRepository skierRepository;

    @Autowired
    private ISubscriptionRepository subscriptionRepository;

    @Override
    public Skier addSkier(Skier skier) {

        if (skier.getSubscription() != null) {
            subscriptionRepository.save(skier.getSubscription());
        }
        return skierRepository.save(skier);
    }

    @Override
    public Skier updateSkier(Skier skier) {
        if (skier.getSubscription() != null) {
            subscriptionRepository.save(skier.getSubscription());
        }
        return skierRepository.save(skier);
    }

    @Override
    public Skier retrieveSkier(int numSkier) {
        return skierRepository.findById(numSkier).orElse(null);
    }
    @Override
    public void deleteSkier(int numSkier) {
        skierRepository.deleteById(numSkier);

    }

    @Override
    public List<Skier> retrieveAll() {
        return skierRepository.findAll();
    }


}
