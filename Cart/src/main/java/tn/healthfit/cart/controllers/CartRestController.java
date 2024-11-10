package tn.healthfit.cart.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.healthfit.cart.entities.Cart;
import tn.healthfit.cart.entities.Produit;
import tn.healthfit.cart.services.ICartService;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
//@CrossOrigin(origins = "http://localhost:4200/**")
@RequestMapping("/cart")
public class CartRestController {


    @Autowired
    ICartService cartService;

    @RequestMapping("/products")
    public  List<Produit> retrieveAllProducts() {
        return cartService.retrieveAllProducts();
    }

    @RequestMapping("/products/{id}")
    public  Produit retrieveProduct(@PathVariable long id) {
        return cartService.retrieveProduct(id);
    }
    @GetMapping("/{id}/cart-products")
    public List<Produit> getCartProducts(@PathVariable long id) {
        return cartService.getCartProducts(id);
    }
    @PostMapping("/{id}/cart-products/{productId}")
    public ResponseEntity<String> saveCartProducts(@PathVariable long id, @PathVariable
    long productId) {
        Produit produit = cartService.retrieveProduct(productId);
        if (produit != null) {
            cartService.saveCartProduct(id, productId);
            return ResponseEntity.status(HttpStatus.OK).body("Product added to cart successfully.");
        } else {
            // Gérer le cas où le job n'existe pas
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Product not found with ID: " + productId);
        }
    }

    @GetMapping("/retrieve-all-Carts")
    public List<Cart> getCarts() {
        return cartService.retrieveAllCarts() ;
    }

    @GetMapping("/retrieve-Cart/{idCart}")
    public Cart retrieveCart(@PathVariable("idCart") int idCart) {
        return cartService.retrieveCart(idCart) ;
    }

    @PostMapping("/add-Cart")
    public Cart addCart(@RequestBody Cart e) {
        return cartService.addCart(e) ;
    }

    @DeleteMapping("/remove-Cart/{idCart}")
    public void removeCart(@PathVariable("idCart") int idCart) {
        cartService.removeCart(idCart);
    }

    @PutMapping("/modify-Cart")
    public Cart modifyCart(@RequestBody Cart e) {
        return cartService.modifyCart(e) ;

    }
}
