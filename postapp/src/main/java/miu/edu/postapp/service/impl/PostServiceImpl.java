package miu.edu.postapp.service.impl;
import miu.edu.postapp.entity.Post;
import miu.edu.postapp.entity.dto.PostDto;
import miu.edu.postapp.entity.dto.PostDetailDto;
import miu.edu.postapp.helper.ListMapper;
import miu.edu.postapp.repo.PostRepo;
import miu.edu.postapp.service.PostService;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepo postRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper listMapper;

    public List<PostDto> findAll() {
        return (List<PostDto>) listMapper.mapList(postRepo.findAll(),new PostDto());}


    public PostDto getById(int id) {
        return modelMapper.map(postRepo.getById(id), PostDto.class);
    }
    @Override
    public void save(PostDto p) {
        postRepo.save(modelMapper.map(p, Post.class));
    }

    @Override
    public void delete(int id) {
        postRepo.delete(id);
    }

    @Override
    public void update(int id,  PostDto p) {
        postRepo.update(id, modelMapper.map(p, Post.class));
    }
}
