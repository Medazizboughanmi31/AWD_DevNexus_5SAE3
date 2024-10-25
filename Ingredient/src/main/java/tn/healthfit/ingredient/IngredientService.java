package tn.healthfit.ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;

    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    public Ingredient addIngredient(Ingredient ingredient) {
        ingredient.setCreatedAt(LocalDateTime.now());
        ingredient.setUpdatedAt(LocalDateTime.now());
        return ingredientRepository.save(ingredient);
    }

    public Ingredient updateIngredient(Long id, Ingredient ingredientDetails) {
        Optional<Ingredient> optionalIngredient = ingredientRepository.findById(id);
        if (optionalIngredient.isPresent()) {
            Ingredient ingredient = optionalIngredient.get();
            ingredient.setName(ingredientDetails.getName());
            ingredient.setCalories(ingredientDetails.getCalories());
            ingredient.setProteins(ingredientDetails.getProteins());
            ingredient.setCarbs(ingredientDetails.getCarbs());
            ingredient.setFats(ingredientDetails.getFats());
            ingredient.setPortionSize(ingredientDetails.getPortionSize());
            ingredient.setUnit(ingredientDetails.getUnit());
            ingredient.setCategory(ingredientDetails.getCategory());
            ingredient.setAllergens(ingredientDetails.getAllergens());
            ingredient.setUpdatedAt(LocalDateTime.now()); // Set the current time on update
            return ingredientRepository.save(ingredient);
        } else {
            throw new ResourceNotFoundException("Ingredient not found with id " + id);
        }
    }


    public void deleteIngredient(Long id) {
        if (!ingredientRepository.existsById(id)) {
            throw new ResourceNotFoundException("Ingredient not found with id " + id);
        }
        ingredientRepository.deleteById(id);
    }

    public Optional<Ingredient> getIngredientById(Long id) {
        return ingredientRepository.findById(id);
    }

    public Page<Ingredient> findIngredientByName(String name, Pageable pageable) {
        return ingredientRepository.findByName(name, pageable);
    }
}
