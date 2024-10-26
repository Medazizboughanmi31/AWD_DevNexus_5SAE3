package tn.healthfit.commentaire;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentaireRepo extends JpaRepository<Commentaire,Long> {
    List<Commentaire> findByActualityId(Long actualityId);
}
