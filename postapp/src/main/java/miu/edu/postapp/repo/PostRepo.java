package miu.edu.postapp.repo;
import miu.edu.postapp.entity.Post;
import miu.edu.postapp.entity.dto.PostDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo {
    public List<Post> findAll();

    void update(int id, Post p);

    public Post getById(int id);

    public void save(Post p);

    public void delete(int id);
}
