package tn.healthfit.ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;

    @GetMapping
    public List<Ingredient> getAllIngredients() {
        List<Ingredient> ingredients = ingredientService.getAllIngredients();
        System.out.println("Fetched Ingredients: " + ingredients); // Log the fetched ingredients
        return ingredients;
    }

    @PostMapping
    public Ingredient addIngredient(@RequestBody Ingredient ingredient) {
        return ingredientService.addIngredient(ingredient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable(value = "id") Long ingredientId) {
        ingredientService.deleteIngredient(ingredientId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable Long id) {
        return ingredientService.getIngredientById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> updateIngredient(
            @PathVariable(value = "id") Long ingredientId,
            @RequestBody Ingredient ingredientDetails) {
        Ingredient updatedIngredient = ingredientService.updateIngredient(ingredientId, ingredientDetails);
        return ResponseEntity.ok(updatedIngredient);
    }

    @GetMapping("/search")
    public Page<Ingredient> searchIngredientByName(
            @RequestParam String name,
            @RequestParam int page,
            @RequestParam int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return ingredientService.findIngredientByName(name, pageRequest);
    }
}
