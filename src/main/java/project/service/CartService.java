package project.service;

import project.dto.CartDto;
import project.exceptions.CartNotFoundException;
import project.models.CartEntity;

import java.util.List;



public interface CartService {

    CartEntity addItemToCart(CartEntity cartDTO ) throws CartNotFoundException;

    

    





    CartEntity updateItemToCart(int id, CartEntity cart);

    CartEntity getById(int id);

    List<CartEntity> getlistcart();

    void deleteItemFromCart(int id);
}
