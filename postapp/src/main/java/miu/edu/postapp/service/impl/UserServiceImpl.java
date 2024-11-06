package miu.edu.postapp.service.impl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import miu.edu.postapp.annotations.ExecutionTime;
import miu.edu.postapp.entity.Comment;
import miu.edu.postapp.entity.Post;
import miu.edu.postapp.entity.User;
import miu.edu.postapp.entity.dto.UserDto;
import miu.edu.postapp.repo.PostRepo;
import miu.edu.postapp.repo.UserRepo;
import miu.edu.postapp.service.LoggerService;
import miu.edu.postapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepo userRepo;

    @Autowired
    private final PostRepo postRepo;

    @Autowired
    private final LoggerService loggerService;

    @PersistenceContext
    EntityManager entityManager;

    @ExecutionTime
    @Override
    public void save(UserDto dto){
        User p = new User();
        p.setUsername(dto.getName());
       // p.setPosts(dto.getPost());
        loggerService.logOperation("Saved User with title: " + dto.getName());
        userRepo.save(p);
    }
    @ExecutionTime
    @Override
    public void delete(long id) {
        userRepo.deleteById(id);
        loggerService.logOperation("Deleted User with ID: " + id);
    }
    @ExecutionTime
    @Override
    public User getById(long id) {
        loggerService.logOperation("Retrieved User with ID: " + id);
        return userRepo.findById(id).get();
    }
    @ExecutionTime
    @Override
    public List<User> findAll() {
        Iterable<User> iterable = userRepo.findAll();
        loggerService.logOperation("Retrieved all users");
        List<User> list = Streamable.of(iterable).toList();
        return list;
    }
    @ExecutionTime
    public User addPostToUser(Long userId, Post post) {
        User user = getById(userId);
        if (user.getPosts() == null) {
            user.setPosts(new ArrayList<>());
        }
        //post.setUser(user);
        user.getPosts().add(post);
        postRepo.save(post);
        loggerService.logOperation("Add Post To User with ID: " + userId);
        return userRepo.save(user);
    }
}
