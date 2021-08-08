package com.lance.learningnotes.entity;

import lombok.Data;

@Data
public class LoginRequest {
    private String userName;
    private String password;
}
