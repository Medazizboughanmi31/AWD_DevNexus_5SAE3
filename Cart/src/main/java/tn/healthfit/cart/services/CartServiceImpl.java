package tn.healthfit.cart.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import tn.healthfit.cart.entities.Cart;
import tn.healthfit.cart.repositories.CartRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class CartServiceImpl implements ICartService{


    @Autowired
    CartRepository cartRepository ;

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
