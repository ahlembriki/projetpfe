package project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import project.dto.ProductDto;
import project.enums.Category;
import project.models.ProductEntity;
import project.repository.ProductRepo;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Override
    public String addProduct(ProductEntity product) {
        // TODO Auto-generated method stub
        ProductEntity products = new ProductEntity();
        products.setProductName(product.getProductName());
        products.setDescription(product.getDescription());
        products.setImageUrl(product.getImageUrl());
        products.setCategory(product.getCategory());
        products.setProductPrice(product.getProductPrice());
        productRepo.save(products);
        return "Product added successfully";
    }
    @Override
    public String deleteProduct(int producId) {
        // TODO Auto-generated method stub
        productRepo.deleteById(producId);
        return "Product deleted successfully";
    }
    @Override
    public List<ProductEntity> getAllProducts() {
        return productRepo.findAll();
    }
    @Override
    public List<ProductEntity> getProductByCategory(Category category) {
        // TODO Auto-generated method stub
        return productRepo.findByCategory(category);

    }
    @Override
    public ProductEntity getById(int productId) {
        // TODO Auto-generated method stub
        return productRepo.findById(productId).orElseThrow();
    }

    @Override
    public String updateProduct(ProductDto products , int productId) {
        Optional<ProductEntity> optionalProduct = productRepo.findById(productId);
        if (optionalProduct.isPresent()) {
            ProductEntity product = optionalProduct.get();
            // Update the fields of the product with the values from the DTO
            product.setProductId(products.getProductId());
            product.setProductName(products.getProductName());
            product.setDescription(products.getDescription());
            product.setCategory(products.getCategory());
            product.setImageUrl(products.getImageUrl());
            product.setProductPrice(products.getPrice());
            // Save the updated product
            productRepo.save(product);
            return "Product updated successfully.";
        } else {
            return "Product not found.";
        }





    }

}
