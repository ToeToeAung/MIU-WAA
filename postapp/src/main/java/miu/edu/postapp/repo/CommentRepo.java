package miu.edu.postapp.repo;

import miu.edu.postapp.entity.Comment;
import miu.edu.postapp.entity.dto.CommentDto;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment,Long>  {

    public Comment save(CommentDto p);
    public void deleteById(long id);
    public Comment getById(long id);
    public List<Comment> findAll();
    // void update(long id, PostDto p);
}
