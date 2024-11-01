package miu.edu.postapp.service;

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
}
