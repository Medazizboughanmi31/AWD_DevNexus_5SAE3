package tn.healthfit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.stereotype.Service;
import tn.healthfit.entities.Actualities;
import tn.healthfit.repositories.ActualityRepo;
import tn.healthfit.services.IActualityService;

import java.util.List;

@Service
public class ActualityService implements IActualityService {
    @Autowired
    private ActualityRepo actualityRepository;

    public List<Actualities> getAllActualities() {
        return actualityRepository.findAll();
    }

    public Actualities createActuality(Actualities actuality) {
        return actualityRepository.save(actuality);
    }

    public Actualities getActuality(Long id) {
        return actualityRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Actuality not found with id " + id));
    }

    public void deleteActuality(Long id) {
        actualityRepository.deleteById(id);
    }

    public Actualities updateActuality(Long id, Actualities updatedActuality) {
        Actualities existingActuality = actualityRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Actuality not found with id " + id));

        existingActuality.setTitle(updatedActuality.getTitle());
        existingActuality.setDescription(updatedActuality.getDescription());

        return actualityRepository.save(existingActuality);
    }
}