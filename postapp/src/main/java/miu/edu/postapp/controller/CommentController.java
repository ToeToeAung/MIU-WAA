package miu.edu.postapp.controller;
import miu.edu.postapp.entity.Comment;
import miu.edu.postapp.entity.dto.CommentDto;
import miu.edu.postapp.service.CommentService;
import miu.edu.postapp.entity.dto.PostDetailDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@CrossOrigin(origins = {"*"})

public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody CommentDto p) {
        commentService.save(p);
    }

    @GetMapping
    public List<Comment> getAll() {
        return commentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getById(@PathVariable long id) {
        var comment = commentService.getById(id);
        return ResponseEntity.ok(comment);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        commentService.delete(id);
    }

}
