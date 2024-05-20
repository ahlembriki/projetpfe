package project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.dto.ProductDto;
import project.enums.Category;
import project.models.ProductEntity;
import project.service.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @CrossOrigin
    @PostMapping("/add")
    public String addProduct(@RequestBody ProductEntity product) {
        return productService.addProduct(product);
    }
    @CrossOrigin
    @DeleteMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable int productId) {
        return productService.deleteProduct(productId);
    }
    @CrossOrigin
    @GetMapping("getallproducts")
    public List<ProductEntity> getAllProducts(){
        return productService.getAllProducts();
    }
    @CrossOrigin
    @GetMapping("{category}")
    public List<ProductEntity> getProductByCategory(@PathVariable Category category){
        return productService.getProductByCategory(category);
    }
    @CrossOrigin
    @PutMapping("/update/{productId}")
    public ResponseEntity<String> updateProduct(@RequestBody ProductDto productDto, @PathVariable("productId") int productId) {
        String message = productService.updateProduct(productDto, productId);
        HttpStatus status = message.equals("Product updated successfully.") ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(message);
    }
    @GetMapping("/getbyid/{productId}")
    public ProductEntity getById(@PathVariable int productId) {
        return productService.getById(productId);
    }
}