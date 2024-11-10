package tn.healthfit.cart.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;

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
