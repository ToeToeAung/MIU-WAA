package miu.edu.postapp.entity;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Data
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @Getter
    @Setter
    @OneToMany
    //@JoinColumn(name = "post_id")
    @JoinColumn(name = "user_id")
    private List<Post> posts;

    public User(long id, String name,List<Post> posts) {
        this.id = id;
        this.name = name;
        this.posts = posts != null ? posts : new ArrayList<>();
    }

    public User() {

    }

}