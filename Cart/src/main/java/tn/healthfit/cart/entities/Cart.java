package tn.healthfit.cart.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Cart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId; // Keycloak user ID

    @ElementCollection
    private Set<Long> CartProducts = new HashSet<>();

    public Set<Long> getCartProducts() {
        return CartProducts;
    }

    public void setCartProducts(Set<Long> cartProducts) {
        CartProducts = cartProducts;
    }

    public Long getId() {
        return id;
    }
    public String getUserId() {
        return userId;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
