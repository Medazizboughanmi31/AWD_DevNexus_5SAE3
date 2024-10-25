package tn.healthfit.food;


import jakarta.persistence.*;
import java.util.List;

@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double quantity;
    private String unit; // e.g., grams, liters, etc.
    private Double calories;
    private Double proteins;
    private Double fats;
    private Double carbs;
    private String category; // e.g., Vegetarian, Non-Vegetarian, Vegan, etc.
    @ElementCollection
    private List<String> ingredients;

    public Double getProteins() {
        return proteins;
    }

    public void setProteins(Double proteins) {
        this.proteins = proteins;
    }

    public Double getFats() {
        return fats;
    }

    public void setFats(Double fats) {
        this.fats = fats;
    }

    public Double getCarbs() {
        return carbs;
    }

    public void setCarbs(Double carbs) {
        this.carbs = carbs;
    }

    public Double getquantity() {
        return quantity;
    }

    public void setquantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getcalories() {
        return calories;
    }

    public void setcalories(Double calories) {
        this.calories = calories;
    }

    public String getunit() {
        return unit;
    }

    public void setunit(String unit) {
        this.unit = unit;
    }
    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngrediens(List<String> ingredients) {
        this.ingredients = ingredients;
    }


}

