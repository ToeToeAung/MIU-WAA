package miu.edu.postapp.service;

import miu.edu.postapp.entity.Post;
import miu.edu.postapp.entity.dto.PostDetailDto;
import miu.edu.postapp.entity.dto.PostDto;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
public interface PostService {
    void save(PostDto p);
    void delete(long id);
    Post getById(long id);
    public List<Post> findAll();
   // void update(long id, PostDto p);
}
