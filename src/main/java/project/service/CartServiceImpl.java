package project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.dto.CartDto;
import project.exceptions.CartNotFoundException;
import project.models.CartEntity;
import project.models.ProductEntity;

import project.models.UserEntity;
import project.repository.CartRepo;
import project.repository.ProductRepo;
import project.repository.UserRepository;


@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private UserRepository userRepository;

    @Override
    public CartEntity addItemToCart(CartEntity cartDTO) throws CartNotFoundException {

CartEntity cart=null;
        try {
           cart= cartRepo.save(cartDTO);

        } catch (Exception e) {
            throw new CartNotFoundException("Something went wrong while adding item to cart");
        }
        return cart;
    }






    @Override
    public CartEntity updateItemToCart(int id, CartEntity cart) {
        CartEntity crt= cartRepo.findById(id).get();
        crt.setQuantity(  cart.getQuantity()  );
        crt.setPrice( cart.getPrice()  );
        return cartRepo.save(crt);
    }

    @Override
    public CartEntity getById(int id) {
        return cartRepo.findById(id).orElse(null);
    }

    @Override
    public List<CartEntity> getlistcart() {
        return cartRepo.findAll();
    }

    @Override
    public void deleteItemFromCart(int id) {
        cartRepo.deleteById(id);

    }


}

   /* private CartEntity convertCartDtoToCartEntity(CartDto cartDto) {
        // Convert the CartDto object to a CartEntity object
        CartEntity cartEntity = new CartEntity();
        cartEntity.setProducts(cartDto.getProducts());
        cartEntity.setUserEntity(cartDto.getUserEntity());
        cartEntity.setQuantity(cartDto.getQuantity());

        return cartEntity;
    }*/


    /*@Override
    public String deleteItemFromCart(int cartId) throws CartNotFoundException {
        cartRepo.findById(cartId).orElseThrow(()->new CartNotFoundException("Cart not found"));
        cartRepo.deleteById(cartId);
        return "Deleted successfully";
    }


    @Override
    public CartEntity getCartById(int cartId) throws CartNotFoundException {
        return  cartRepo.findById(cartId).orElseThrow(()->new CartNotFoundException("Cart Not Found with given id"));
    }

    @Override
    public List<CartEntity> getAllCartItems() {
        return cartRepo.findAll();

    }

}*/
