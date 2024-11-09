package tn.healthfit.food;

import tn.healthfit.food.Food;
import tn.healthfit.food.Ingredient;

import java.util.List;

public class FoodWithIngredientsDTO {

    private Food food;
    private List<Ingredient> ingredients;

    public FoodWithIngredientsDTO(Food food, List<Ingredient> ingredients) {
        this.food = food;
        this.ingredients = ingredients;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}

