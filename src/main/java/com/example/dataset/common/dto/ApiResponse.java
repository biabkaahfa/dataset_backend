package com.example.dataset.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ApiResponse<T> {
    private int statusCode;
    private String message;
    private T data;
    private LocalDateTime timestamp;
    
    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<>(200, message, data, LocalDateTime.now());
    }
    
    public static <T> ApiResponse<T> created(T data, String message) {
        return new ApiResponse<>(201, message, data, LocalDateTime.now());
    }
    
    public static <T> ApiResponse<T> error(int statusCode, String message) {
        return new ApiResponse<>(statusCode, message, null, LocalDateTime.now());
    }
}
