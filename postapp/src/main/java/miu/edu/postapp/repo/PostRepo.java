package miu.edu.postapp.repo;
import miu.edu.postapp.entity.Post;
import miu.edu.postapp.entity.dto.PostDto;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post,Long>  {
    public Post save(PostDto p);
    public void deleteById(long id);
    public Post getById(long id);
    public List<Post> findAll();

   // void update(long id, PostDto p);
}
