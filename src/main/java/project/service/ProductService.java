package project.service;

import project.dto.ProductDto;
import project.enums.Category;
import project.models.ProductEntity;

import java.util.List;




public interface ProductService {
    String addProduct(ProductEntity product);
    String deleteProduct(int productId);
    List<ProductEntity> getAllProducts();
    List<ProductEntity> getProductByCategory(Category category);
    //Product updateProduct(Product product);
    ProductEntity getById(int productId);
    String updateProduct(ProductDto product, int productid);
}