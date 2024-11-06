package miu.edu.postapp.entity;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String email;
    private String password;
    private String firstname;
    private String lastname;

    @Getter
    @Setter
    @OneToMany
    //@JoinColumn(name = "post_id")
    @JoinColumn(name = "user_id")
    private List<Post> posts;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Role> roles;

    public User(long id, String username,String email,String password,String firstname,String lastname,List<Post> posts) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.posts = posts != null ? posts : new ArrayList<>();
    }

    public User() {

    }

}