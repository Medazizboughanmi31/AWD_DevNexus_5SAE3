package tn.healthfit.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/foods")
public class FoodController {

    @Autowired
    private FoodService foodService;

    // Create a new food item
    @PostMapping
    public Food createFood(@RequestBody Food food) {
        return foodService.createFood(food);
    }

    @RequestMapping("/ingredients")
    public List<Ingredient> getAllIngredients(){
        return foodService.getAllIngredients();
    }
//    @RequestMapping("/ingredients/{id}")
//    public Ingredient getIngredient(@PathVariable Long id){
//        return foodService.getIngredient(id);
//    }
    // Get a food item by ID
    @GetMapping("/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable Long id) {
        Optional<Food> food = foodService.getFoodById(id);
        return food.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all food items
    @GetMapping
    public List<Food> getAllFoods() {
        return foodService.getAllFoods();
    }

    // Update a food item
    @PutMapping("/{id}")
    public ResponseEntity<Food> updateFood(@PathVariable Long id, @RequestBody Food food) {
        try {
            Food updatedFood = foodService.updateFood(id, food);
            return ResponseEntity.ok(updatedFood);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a food item
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFood(@PathVariable Long id) {
        foodService.deleteFood(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}/with-ingredients")
    public ResponseEntity<FoodWithIngredientsDTO> getFoodWithIngredients(@PathVariable Long id) {
        try {
            FoodWithIngredientsDTO foodWithIngredientsDTO = foodService.getFoodWithIngredients(id);
            return ResponseEntity.ok(foodWithIngredientsDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
