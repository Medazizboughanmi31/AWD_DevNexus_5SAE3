package tn.healthfit.cart.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import tn.healthfit.cart.entities.Cart;
import tn.healthfit.cart.entities.Produit;
import tn.healthfit.cart.repositories.CartRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CartServiceImpl implements ICartService{


    @Autowired
    CartRepository cartRepository ;

    @Autowired
    private ProductClient productService;

    public List<Produit> retrieveAllProducts(){
        return productService.retrieveAllProducts();
    }

    public Produit retrieveProduct(long id){
        return productService.retrieveProduct(id);
    }

    public List<Produit> getCartProducts(long cartId) {
        Cart cart = cartRepository.findById(cartId).get();
        return cart.getCartProducts().stream()
                .map(productService::retrieveProduct)
                .collect(Collectors.toList());
    }

    // Method to save product in the cart
    public void saveCartProduct(long cartId, long produitId) {
        Cart cart = cartRepository.findById(cartId).get();
        cart.getCartProducts().add(produitId);
        cartRepository.save(cart);
    }



    @Override
    public List<Cart> retrieveAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public Cart retrieveCart(long idCart) {
        return cartRepository.findById(idCart).get();
    }

    @Override
    public Cart addCart(Cart cart) {
        return cartRepository.save(cart);
    }


    public void removeCart(long idCart) {
        cartRepository.deleteById(idCart);
    }

    @Override
    public Cart modifyCart(Cart cart) {
        return cartRepository.save(cart);
    }
}
