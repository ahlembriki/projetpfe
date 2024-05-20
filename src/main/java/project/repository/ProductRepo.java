package project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import project.enums.Category;
import project.models.ProductEntity;


public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {

    List<ProductEntity> findByCategory(Category category);


}
