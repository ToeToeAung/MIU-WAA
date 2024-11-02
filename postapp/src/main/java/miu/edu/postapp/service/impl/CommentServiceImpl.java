package miu.edu.postapp.service.impl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import miu.edu.postapp.entity.Comment;
import miu.edu.postapp.entity.dto.CommentDto;
import miu.edu.postapp.repo.CommentRepo;
import miu.edu.postapp.repo.UserRepo;
import miu.edu.postapp.service.CommentService;
import miu.edu.postapp.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.*;


import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentServiceImpl implements CommentService {
    @Autowired
    private final CommentRepo commentRepo;

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public void save(CommentDto dto){
        Comment c = new Comment();
        c.setName(dto.getName());
        c.setPost(dto.getPost());
        commentRepo.save(c);
    }

    @Override
    public void delete(long id) {
        commentRepo.deleteById(id);
    }

    @Override
    public Comment getById(long id) {
        return commentRepo.findById(id).get();
    }

    @Override
    public List<Comment> findAll() {
        Iterable<Comment> iterable = commentRepo.findAll();
        List<Comment> list = Streamable.of(iterable).toList();
        return list;
    }


}
