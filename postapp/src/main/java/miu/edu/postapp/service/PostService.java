package miu.edu.postapp.service;

import miu.edu.postapp.entity.Post;
import miu.edu.postapp.entity.dto.PostDetailDto;
import miu.edu.postapp.entity.dto.PostDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
public interface PostService {

    public List<PostDto> findAll();
    PostDto getById(int id);
    void save(PostDto p);
    void delete(int id);
    void update(int id, PostDto p);
}
