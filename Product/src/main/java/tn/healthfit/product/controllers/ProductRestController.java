package tn.healthfit.product.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.healthfit.product.entities.Product;
import tn.healthfit.product.services.IProductService;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
//@CrossOrigin(origins = "http://localhost:4200/**")
@RequestMapping("/product")
public class ProductRestController {

    @Autowired
    IProductService productService;

    @GetMapping("/")
    public String home() {
        return "Welcome to the Product Application!";
    }
    @GetMapping("/retrieve-all-Products")
    public List<Product> getProducts() {
        return productService.retrieveAllProducts() ;
    }

    @GetMapping("/retrieve-Product/{idProduct}")
    public Product retrieveProduct(@PathVariable("idProduct") int idProduct) {
       return productService.retrieveProduct(idProduct) ;
    }

    @PostMapping("/add-Product")
    public Product addProduct(@RequestBody Product p) {
        return productService.addProduct(p) ;
    }

    @DeleteMapping("/remove-Product/{idProduct}")
    public void removeProduct(@PathVariable("idProduct") int idProduct) {
        productService.removeProduct(idProduct);
    }

    @PutMapping(value= "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Product> modifyProduct(@PathVariable(value = "id") Long idProduct,
                                                 @RequestBody Product p) {
       return new ResponseEntity<>(productService.modifyProduct(idProduct, p), HttpStatus.OK)  ;

    }
    @PutMapping("/{idProduct}/mark-as-unavailable")
    public void markAsUnavailable(@PathVariable Long idProduct) {
        productService.markAsUnavailable(idProduct);
    }
}
