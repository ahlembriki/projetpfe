package project.dto;

import java.util.List;

import lombok.Data;

@Data
public class CartDto {

    private int productCount;
    private double totalPrice;
    private List<Integer> productId;



}
