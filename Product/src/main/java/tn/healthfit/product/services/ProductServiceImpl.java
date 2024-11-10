package tn.healthfit.product.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.healthfit.product.entities.Product;
import tn.healthfit.product.repositories.ProductRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService{

    @Autowired
    ProductRepository productRepository ;

    @Override
    public List<Product> retrieveAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product retrieveProduct(long idProduct) {
        return productRepository.findById(idProduct).get();
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void removeProduct(long idProduct) {
        productRepository.deleteById(idProduct);
    }

    public Product modifyProduct(long id, Product product) {
        if(productRepository.findById(id).isPresent())
        {
            Product existingProduct = productRepository.findById(id).get();
            existingProduct.setAvailable(product.isAvailable());
            existingProduct.setCategory(product.getCategory());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            return productRepository.save(existingProduct);
        } else
            return null;
    }
    public void markAsUnavailable(Long id) {
        Product product = productRepository.findById(id).get();
        product.setAvailable(false);
        productRepository.save(product);
    }
}
