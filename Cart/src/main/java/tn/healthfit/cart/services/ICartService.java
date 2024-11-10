package tn.healthfit.cart.services;



import tn.healthfit.cart.entities.Cart;
import tn.healthfit.cart.entities.Produit;

import java.util.List;

public interface ICartService {
    public List<Cart> retrieveAllCarts() ;
    public Cart retrieveCart(long idCart) ;
    public Cart addCart(Cart cart) ;
    public void removeCart(long idCart) ;
    public Cart modifyCart(Cart cart) ;


    public List<Produit> retrieveAllProducts();
    public Produit retrieveProduct(long id);
    public List<Produit> getCartProducts(long cartId);
    public void saveCartProduct(long cartId, long produitId);
}
