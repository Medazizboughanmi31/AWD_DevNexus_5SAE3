package tn.healthfit.product.services;



import tn.healthfit.product.entities.Product;

import java.util.List;

public interface IProductService {
    public List<Product> retrieveAllProducts() ;
    public Product retrieveProduct(long idProduct) ;
    public Product addProduct(Product product) ;
    public void removeProduct(long idProduct) ;
    public Product modifyProduct(long id, Product product);
    public void markAsUnavailable(Long id);
}
