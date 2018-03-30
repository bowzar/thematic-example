package com.yulintu.thematic.example.employee;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_GATEWAY, reason = "这是一个测试异常")
public class EmployeeTestException extends RuntimeException {
    public EmployeeTestException() {
    }

    public EmployeeTestException(String message) {
        super(message);
    }

    public EmployeeTestException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeTestException(Throwable cause) {
        super(cause);
    }

    public EmployeeTestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
