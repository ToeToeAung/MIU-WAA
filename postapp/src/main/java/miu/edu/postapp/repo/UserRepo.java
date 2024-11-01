package miu.edu.postapp.repo;
import miu.edu.postapp.entity.User;
import miu.edu.postapp.entity.dto.UserDto;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Long>  {

    public User save(UserDto p);
    public void deleteById(long id);
    public User getById(long id);
    public List<User> findAll();
    // void update(long id, PostDto p);
}
