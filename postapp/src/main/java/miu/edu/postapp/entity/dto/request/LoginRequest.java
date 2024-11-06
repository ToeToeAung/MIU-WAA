package miu.edu.postapp.entity.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequest {
    private String username;
    private String password;
}