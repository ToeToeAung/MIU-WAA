package miu.edu.postapp.repo;
import miu.edu.postapp.entity.Logger;
import miu.edu.postapp.entity.dto.LoggerDto;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerRepo extends JpaRepository<Logger, Long> {
    public Logger save(LoggerDto l);
}
