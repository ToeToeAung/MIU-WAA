package miu.edu.postapp.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import miu.edu.postapp.entity.Comment;
import miu.edu.postapp.entity.dto.CommentDto;
import miu.edu.postapp.repo.CommentRepo;
import miu.edu.postapp.repo.UserRepo;
import miu.edu.postapp.service.CommentService;
import miu.edu.postapp.service.LoggerService;
import miu.edu.postapp.service.UserService;
import miu.edu.postapp.annotations.ExecutionTime;

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

    @Autowired
    private final LoggerService loggerService;
    @PersistenceContext
    EntityManager entityManager;

    @ExecutionTime
    @Override
    public void save(CommentDto dto){
        Comment c = new Comment();
        c.setName(dto.getName());
        c.setPost(dto.getPost());
        commentRepo.save(c);
        loggerService.logOperation("Saved comment with name: " + dto.getName());
    }

    @ExecutionTime
    @Override
    public void delete(long id) {
        commentRepo.deleteById(id);
        loggerService.logOperation("Deleted comment with ID: " + id);
    }

    @ExecutionTime
    @Override
    public Comment getById(long id) {
        loggerService.logOperation("Retrieved comment with ID: " + id);
        return commentRepo.findById(id).get();
    }

    @ExecutionTime
    @Override
    public List<Comment> findAll() {
        loggerService.logOperation("Retrieved all comments");
        Iterable<Comment> iterable = commentRepo.findAll();
        List<Comment> list = Streamable.of(iterable).toList();
        return list;
    }
}
