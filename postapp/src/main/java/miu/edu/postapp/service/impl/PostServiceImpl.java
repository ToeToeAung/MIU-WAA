package miu.edu.postapp.service.impl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import miu.edu.postapp.entity.Comment;
import miu.edu.postapp.entity.Post;
import miu.edu.postapp.entity.dto.PostDto;
import miu.edu.postapp.repo.CommentRepo;
import miu.edu.postapp.repo.PostRepo;
import miu.edu.postapp.service.PostService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.*;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl implements PostService {
    @Autowired
    private final PostRepo postRepo;

    @Autowired
    private final CommentRepo commentRepo;

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public void save(PostDto dto){
        Post p = new Post();
        p.setTitle(dto.getTitle());
        p.setContent(dto.getContent());
        p.setAuthor(dto.getAuthor());
        postRepo.save(p);
    }

   @Override
    public void delete(long id) {
       postRepo.deleteById(id);
   }

    @Override
    public Post getById(long id) {
        return postRepo.findById(id).get();
    }

    @Override
    public List<Post> findAll() {
        Iterable<Post> iterable = postRepo.findAll();
        List<Post> list = Streamable.of(iterable).toList();
        return list;
    }

    public Comment addCommentToPost(Long postId, Comment comment) {
        Post postComment = postRepo.findById(postId).orElse(null);
        comment.setPost(postComment);
        return commentRepo.save(comment);
    }

    public List<Comment> findCommentsByPostId(Long postId) {
        Post post = postRepo.findById(postId).orElse(null);
        return post.getComments();
    }

//    @Override
//    public void update(long id,  PostDto dto) {
//        Post existingPost = postRepo.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
//        existingPost.setTitle(dto.getTitle());
//        existingPost.setContent(dto.getContent());
//        existingPost.setAuthor(dto.getAuthor());
//        postRepo.save(existingPost);
//    }
}
