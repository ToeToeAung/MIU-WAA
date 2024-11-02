package miu.edu.postapp.service;

import miu.edu.postapp.entity.Comment;
import miu.edu.postapp.entity.Post;
import miu.edu.postapp.entity.User;
import miu.edu.postapp.entity.dto.PostDetailDto;
import miu.edu.postapp.entity.dto.UserDto;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
public interface UserService {
    void save(UserDto p);
    void delete(long id);
    User getById(long id);
    public List<User> findAll();
    // void update(long id, PostDto p);

    public User addPostToUser(Long userId, Post post);

}
