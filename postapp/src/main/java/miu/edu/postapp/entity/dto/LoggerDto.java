package miu.edu.postapp.entity.dto;

import lombok.Data;
import miu.edu.postapp.entity.Post;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class LoggerDto {
    private Long transactionId;
    private LocalDate date;
    private LocalTime time;
    private String principle;
    private String operation;
}
