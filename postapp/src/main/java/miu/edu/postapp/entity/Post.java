package miu.edu.postapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
//@AllArgsConstructor
public class Post {

    private long id;
    private String title;
    private String content;
    private String author;

    public Post(long id, String title,String content,String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }

}
