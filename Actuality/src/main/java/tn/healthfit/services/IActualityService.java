package tn.healthfit.services;

import tn.healthfit.entities.Actualities;

import java.util.List;

public interface IActualityService {
    List<Actualities> getAllActualities();
    Actualities createActuality(Actualities actuality);
    Actualities getActuality(Long id);
    void deleteActuality(Long id);
    Actualities updateActuality(Long id, Actualities updatedActuality);
}
