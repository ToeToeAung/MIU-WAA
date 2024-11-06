package miu.edu.postapp.service;
import miu.edu.postapp.entity.Logger;
import miu.edu.postapp.repo.LoggerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalTime;

@Service
public interface LoggerService {

   public void logOperation(String operation);
}
