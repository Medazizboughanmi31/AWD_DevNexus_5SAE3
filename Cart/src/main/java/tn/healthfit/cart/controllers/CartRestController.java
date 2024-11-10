package tn.healthfit.cart.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.healthfit.cart.entities.Cart;
import tn.healthfit.cart.services.ICartService;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
//@CrossOrigin(origins = "http://localhost:4200/**")
@RequestMapping("/cart")
public class CartRestController {


    @Autowired
    ICartService eventService;

    @GetMapping("/retrieve-all-Carts")
    public List<Cart> getCarts() {
        return eventService.retrieveAllCarts() ;
    }

    @GetMapping("/retrieve-Cart/{idCart}")
    public Cart retrieveCart(@PathVariable("idCart") int idCart) {
        return eventService.retrieveCart(idCart) ;
    }

    @PostMapping("/add-Cart")
    public Cart addCart(@RequestBody Cart e) {
        return eventService.addCart(e) ;
    }

    @DeleteMapping("/remove-Cart/{idCart}")
    public void removeCart(@PathVariable("idCart") int idCart) {
        eventService.removeCart(idCart);
    }

    @PutMapping("/modify-Cart")
    public Cart modifyCart(@RequestBody Cart e) {
        return eventService.modifyCart(e) ;

    }
}
