package tn.healthfit.commentaire;

import java.util.List;
import java.util.Optional;

public interface ICommentaireService {

    Commentaire createComment(Commentaire commentaire);

    List<Commentaire> getCommentsByActualityId(Long actualityId);

    Optional<Commentaire> getCommentById(Long id);

    Commentaire updateComment(Long id, Commentaire updatedCommentaire);

    void deleteComment(Long id);

    List<Commentaire> getAllComments(); // New method to get all comments
}