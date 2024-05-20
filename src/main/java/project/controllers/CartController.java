package project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.dto.CartDto;
import project.exceptions.CartNotFoundException;
import project.models.CartEntity;
import project.models.PostEntity;
import project.models.UserEntity;
import project.service.CartService;
import project.service.PostServiceImpl;
import project.service.ProductService;
import project.service.UserService;


@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired private UserService userService;
    @Autowired private PostServiceImpl productService;

    @PostMapping("/add-cart/{iduser}/{idproduit}")
    public CartEntity addItemToCart( CartEntity cartDTO , @PathVariable("iduser") Long iduser, @PathVariable("idproduit") Long idproduit) throws CartNotFoundException {
        CartEntity cart=null;
        UserEntity userEntity= userService.findByid(iduser);

        PostEntity postEntity= productService.getPostById(idproduit);
        System.out.println(postEntity.getPrice());
        System.out.println(userEntity.getEmail());
        cartDTO.setUserEntity(userEntity);
        cartDTO.setProducts(postEntity);
       try {
    cart= cartService.addItemToCart(cartDTO);
       }catch (Exception e){
           e.printStackTrace();
       }
   return cart;
    }

    @PutMapping(value = "/update-cart/{id}")
    public CartEntity updateUserPut(@PathVariable int id ,@RequestBody CartEntity cart)
    {
        return cartService.updateItemToCart(id,cart);

    }

    @DeleteMapping(value = "/delete/{id}")
    public void deletecartitem(@PathVariable int id)
    {
        cartService.deleteItemFromCart(id);
    }





    @GetMapping(value = "getAllcart")
    public  List<CartEntity> getAllcart()
    {
        return cartService.getlistcart();


    }
    //recuperation par id
    @GetMapping(value = "getcartById/{id}")
    public CartEntity getUserById(@PathVariable int id)
    {
        return cartService.getById(id);

    }
}
