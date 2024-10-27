package tn.healthfit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.healthfit.entities.Commentaire;
import tn.healthfit.repositories.CommentaireRepo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentaireService implements ICommentaireService {

    @Autowired
    private CommentaireRepo commentaireRepository;

    // Create a new comment
    @Override
    public Commentaire createComment(Commentaire commentaire) {
        commentaire.setTimestamp(LocalDateTime.now());
        return commentaireRepository.save(commentaire);
    }

    // Retrieve all comments
    @Override
    public List<Commentaire> getAllComments() {
        return commentaireRepository.findAll();
    }

    // Retrieve all comments for a specific actuality
    @Override
    public List<Commentaire> getCommentsByActualityId(Long actualityId) {
        return commentaireRepository.findByActualityId(actualityId);
    }

    // Retrieve a specific comment by ID
    @Override
    public Optional<Commentaire> getCommentById(Long id) {
        return commentaireRepository.findById(id);
    }

    // Update an existing comment
    @Override
    public Commentaire updateComment(Long id, Commentaire updatedCommentaire) {
        if (commentaireRepository.existsById(id)) {
            updatedCommentaire.setId(id);
            return commentaireRepository.save(updatedCommentaire);
        }
        return null;
    }

    // Delete a comment
    @Override
    public void deleteComment(Long id) {
        commentaireRepository.deleteById(id);
    }
}