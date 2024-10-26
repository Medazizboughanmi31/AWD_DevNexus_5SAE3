package tn.healthfit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.healthfit.services.ICommentaireService;
import tn.healthfit.entities.Commentaire;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comments") // Base path remains
public class CommentaireController {

    @Autowired
    private ICommentaireService commentaireService;

    // Create a new comment
    @PostMapping("/create") // Changed path for creating a comment
    public ResponseEntity<Commentaire> createComment(@RequestBody Commentaire commentaire) {
        Commentaire createdComment = commentaireService.createComment(commentaire);
        return ResponseEntity.ok(createdComment);
    }

    // Retrieve all comments
    @GetMapping("/all") // New path for retrieving all comments
    public ResponseEntity<List<Commentaire>> getAllComments() {
        List<Commentaire> comments = commentaireService.getAllComments(); // Service method to fetch all comments
        return ResponseEntity.ok(comments);
    }

    // Retrieve comments by actuality ID
    @GetMapping("/by-actuality/{actualityId}") // Changed path for retrieving comments by actuality ID
    public ResponseEntity<List<Commentaire>> getCommentsByActualityId(@PathVariable Long actualityId) {
        List<Commentaire> comments = commentaireService.getCommentsByActualityId(actualityId);
        return ResponseEntity.ok(comments);
    }

    // Retrieve a comment by its ID
    @GetMapping("/{id}") // Path for retrieving a comment by ID remains
    public ResponseEntity<Commentaire> getCommentById(@PathVariable Long id) {
        Optional<Commentaire> comment = commentaireService.getCommentById(id);
        return comment.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a comment by its ID
    @PutMapping("/update/{id}") // Changed path for updating a comment
    public ResponseEntity<Commentaire> updateComment(@PathVariable Long id, @RequestBody Commentaire updatedCommentaire) {
        Commentaire updated = commentaireService.updateComment(id, updatedCommentaire);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    // Delete a comment by its ID
    @DeleteMapping("/delete/{id}") // Changed path for deleting a comment
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentaireService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }


}