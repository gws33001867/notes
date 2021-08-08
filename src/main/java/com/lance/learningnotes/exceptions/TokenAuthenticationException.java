package com.lance.learningnotes.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TokenAuthenticationException extends RuntimeException {
    private int code;
    private String message;
}
