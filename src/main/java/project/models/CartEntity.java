package project.models;

import java.util.List;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@Table(name="Panier")
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;

    @ManyToOne
    @JoinColumn(name = "user_id")
      private  UserEntity userEntity;

    private String size;

    private int quantity;

    private Integer price;

    @OneToOne
    private PostEntity products;




}
