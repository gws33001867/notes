package com.lance.learningnotes.entity;

import lombok.Data;

@Data
public class RefreshRequest {
    private String userId;
    private String refreshToken;
}
