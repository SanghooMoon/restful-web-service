package com.example.restfulwebservice.user;

// HTTP Status code
// 2xx -> OK
// 4xx -> Client Error
// 5xx -> Server Error

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 예외 클래스
@ResponseStatus(HttpStatus.NOT_FOUND)   // 이 예외 클래스는 5xx 에러가 아니라 NOT_FOUND로 변경되어 출력
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
