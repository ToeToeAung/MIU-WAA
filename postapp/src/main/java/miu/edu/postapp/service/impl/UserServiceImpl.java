package miu.edu.postapp.service.impl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import miu.edu.postapp.entity.User;
import miu.edu.postapp.entity.dto.UserDto;
import miu.edu.postapp.repo.UserRepo;
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
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepo userRepo;

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public void save(UserDto dto){
        User p = new User();
        p.setName(dto.getName());
       // p.setPosts(dto.getPost());
        userRepo.save(p);
    }

    @Override
    public void delete(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public User getById(long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public List<User> findAll() {
        Iterable<User> iterable = userRepo.findAll();
        List<User> list = Streamable.of(iterable).toList();
        return list;
    }


}
