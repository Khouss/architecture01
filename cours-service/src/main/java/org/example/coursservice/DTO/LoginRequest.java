package org.example.coursservice.DTO;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}

