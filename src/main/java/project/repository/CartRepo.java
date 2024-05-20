package project.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import project.models.CartEntity;


public interface CartRepo extends JpaRepository<CartEntity, Integer>{

}