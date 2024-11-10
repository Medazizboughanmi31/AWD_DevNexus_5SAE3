package tn.healthfit.cart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.healthfit.cart.entities.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

}
