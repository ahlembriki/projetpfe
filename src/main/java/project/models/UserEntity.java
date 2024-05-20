package project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
@ToString
public class UserEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;

    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<PostEntity> postEntity = new ArrayList<>();
}
