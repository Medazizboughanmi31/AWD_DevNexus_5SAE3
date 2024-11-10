package tn.healthfit.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.healthfit.product.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
