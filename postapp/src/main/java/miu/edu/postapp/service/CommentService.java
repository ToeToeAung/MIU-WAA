package miu.edu.postapp.service;

import miu.edu.postapp.entity.Comment;
import miu.edu.postapp.entity.dto.CommentDto;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
public interface CommentService {
    void save(CommentDto p);
    void delete(long id);
    Comment getById(long id);
    public List<Comment> findAll();
    // void update(long id, PostDto p);
}
