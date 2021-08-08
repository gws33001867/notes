package com.lance.learningnotes.entity;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;
    private String refreshToken;
    private String userId;
    private String userName;
}
