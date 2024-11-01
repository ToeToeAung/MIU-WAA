package miu.edu.postapp.entity.dto;
import lombok.Data;
import miu.edu.postapp.entity.Post;
import java.util.List;

@Data
public class UserDto {
    private long id;
    private String name;
    private List<Post> post;
}
