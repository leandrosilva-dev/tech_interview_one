package tech.interview.one.tech_interview_one.authorizer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AuthorizerExceptionAdvice {
    @ExceptionHandler(AuthorizerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String authorizerException(AuthorizerException ex){
        return ex.getMessage();
    }
}
