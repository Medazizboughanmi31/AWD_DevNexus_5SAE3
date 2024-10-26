package tn.healthfit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.healthfit.entities.Commentaire;

import java.util.List;

public interface CommentaireRepo extends JpaRepository<Commentaire,Long> {
    List<Commentaire> findByActualityId(Long actualityId);
}
