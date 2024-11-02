package miu.edu.postapp.controller;
import miu.edu.postapp.entity.Comment;
import miu.edu.postapp.entity.Post;
import miu.edu.postapp.entity.dto.PostDetailDto;
import miu.edu.postapp.entity.dto.PostDto;
import miu.edu.postapp.service.PostService;
import miu.edu.postapp.entity.dto.PostDetailDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/posts")
@CrossOrigin(origins = {"*"})

public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody PostDto p) {
        postService.save(p);
    }

    @GetMapping
    public List<Post> getAll() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getById(@PathVariable long id) {
        var product = postService.getById(id);
        return ResponseEntity.ok(product);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        postService.delete(id);
    }

    @PostMapping("/{id}/comments")
    public ResponseEntity<Comment> addComment(@PathVariable Long id, @RequestBody Comment comment) {
        Comment createdComment = postService.addCommentToPost(id, comment);
        return ResponseEntity.ok(createdComment);
    }

    @GetMapping("/{id}/comments")
    public ResponseEntity<List<Comment>> getCommentsByPostId(@PathVariable Long id) {
        List<Comment> comments = postService.findCommentsByPostId(id);
        return ResponseEntity.ok(comments);
    }

//    @PutMapping("/{id}")
//    public void update(@PathVariable("id") long postId, @RequestBody PostDto p) {
//        postService.update(postId,p);
//    }
}
