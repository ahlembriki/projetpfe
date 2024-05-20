package project.dto;



import lombok.Data;
import project.enums.Category;

@Data
public class ProductDto {

    private int ProductId;
    private String productName;
    private String description;
    private Category category;
    private String imageUrl;
    private double price;
    private double discount;


}
