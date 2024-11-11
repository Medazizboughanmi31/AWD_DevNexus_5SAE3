package tn.healthfit.cart.services;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import tn.healthfit.cart.entities.Produit;

import java.util.List;

@FeignClient(name = "product-s", url = "http://localhost:8008")
public interface ProductClient {
    @RequestMapping("product/retrieve-all-Products")
    public List<Produit> retrieveAllProducts();

    @RequestMapping("product/retrieve-Product/{idProduct}")
    public Produit retrieveProduct(@PathVariable("idProduct") long id);
}

