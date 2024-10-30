package miu.edu.postapp.repo.impl;
import miu.edu.postapp.repo.PostRepo;
import miu.edu.postapp.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepoImpl implements PostRepo {

public static List<Post> posts;
    private static int postId = 300;
    static {
        posts = new ArrayList<>();
        Post p1 = new Post(1,"Modern JS with ES6","May 1995 - Originally developed under the name Mocha","Kevin Langley Jr.");
        Post p2 = new Post(2,"RESTful Service Best Practices","Recommendations for Creating Web Services","Todd Fredrich");
        Post p3 = new Post(3,"Spring Java Application Framework","Reference Documentation","Rod Johnson");
        posts.add(p1);
        posts.add(p2);
        posts.add(p3);
    }

    @Override
    public List<Post> findAll() {
        return posts;
    }
    public void save(Post p) {
        p.setId(postId);
        postId++;
        posts.add(p);
    }

    @Override
    public void delete(int id) {
        var post =posts
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst().get();
        posts.remove(post);
    }

    @Override
    public void update(int id, Post p) {
        Post toUpdate = getById(id);
        toUpdate.setTitle(p.getTitle());
        toUpdate.setContent(p.getContent());
        toUpdate.setAuthor(p.getAuthor());
    }

    public Post getById(int id) {
        return posts
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElse(null);

    }
}
