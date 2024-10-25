package tn.healthfit.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public Food createFood(Food food) {
        return foodRepository.save(food);
    }

    public Optional<Food> getFoodById(Long id) {
        return foodRepository.findById(id);
    }

    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

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
            food.setIngrediens(updatedFood.getIngredients());


            return foodRepository.save(food);
        }).orElseThrow(() -> new RuntimeException("Food not found with id: " + id));
    }

    public void deleteFood(Long id) {
        foodRepository.deleteById(id);
    }
}
