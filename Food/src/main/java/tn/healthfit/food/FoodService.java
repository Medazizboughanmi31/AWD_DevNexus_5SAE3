package tn.healthfit.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private IngredientClient ingredientClient;

    // Fetch all ingredients via FeignClient
    public List<Ingredient> getAllIngredients() {
        return ingredientClient.getAllIngredients();
    }

    // Create a new Food item
    public Food createFood(Food food) {
        return foodRepository.save(food);
    }

    // Get a Food item by ID
    public Optional<Food> getFoodById(Long id) {
        return foodRepository.findById(id);
    }

    // Get all Food items
    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    // Update an existing Food item by ID
    public Food updateFood(Long id, Food updatedFood) {
        return foodRepository.findById(id).map(food -> {
            food.setName(updatedFood.getName());
            food.setCategory(updatedFood.getCategory());
            food.setcalories(updatedFood.getcalories());
            food.setProteins(updatedFood.getProteins());
            food.setFats(updatedFood.getFats());
            food.setCarbs(updatedFood.getCarbs());
            food.setquantity(updatedFood.getquantity());
            food.setunit(updatedFood.getunit());
            food.setdescription(updatedFood.getdescription());
            food.setIngredients(updatedFood.getIngredients());
            return foodRepository.save(food);
        }).orElseThrow(() -> new RuntimeException("Food not found with id: " + id));
    }

    // Delete a Food item by ID
    public void deleteFood(Long id) {
        foodRepository.deleteById(id);
    }

    // Fetch Food item with full ingredient details
    public FoodWithIngredientsDTO getFoodWithIngredients(Long foodId) {
        // Fetch the food from the database
        Food food = foodRepository.findById(foodId)
                .orElseThrow(() -> new RuntimeException("Food not found with id: " + foodId));  // Generic exception

        // Fetch the ingredients using the ingredient client
        List<Ingredient> ingredients = new ArrayList<>();
        for (Integer ingredientId : food.getIngredients()) {
            Ingredient ingredient = ingredientClient.getIngredientById(ingredientId);
            if (ingredient != null) {
                ingredients.add(ingredient);
            } else {
                System.out.println("Ingredient not found for ID: " + ingredientId);
            }
        }

        // Return the DTO containing the food and its ingredients
        return new FoodWithIngredientsDTO(food, ingredients);
    }

}
