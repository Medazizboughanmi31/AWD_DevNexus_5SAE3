package tn.healthfit.food;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "Ingredient")
public interface IngredientClient {

    @RequestMapping("/ingredients")
    public List<Ingredient> getAllIngredients();

    @GetMapping("/ingredients/{id}")
    Ingredient getIngredientById(@PathVariable("id") Integer id);
}
