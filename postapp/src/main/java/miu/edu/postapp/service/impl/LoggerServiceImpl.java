package miu.edu.postapp.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import miu.edu.postapp.entity.Logger;
import miu.edu.postapp.entity.dto.LoggerDto;
import miu.edu.postapp.repo.LoggerRepo;
import miu.edu.postapp.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.*;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class LoggerServiceImpl implements LoggerService {
    @Autowired
    private final LoggerRepo loggerRepo;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void logOperation(String operation){
        Logger log = new Logger();
        log.setDate(LocalDate.now());
        log.setTime(LocalTime.now());
        log.setPrinciple("User");
        log.setOperation(operation);
        loggerRepo.save(log);
    }

}
