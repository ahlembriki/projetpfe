package project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String objet;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date created;
    @Lob
    @Column(length = 100000)
    private byte[] image;
    @Column
    private int price;


    @JsonIgnore
    @ManyToOne
    private UserEntity user;
}
