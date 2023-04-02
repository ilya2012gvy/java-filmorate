package controller;

import exception.PostNotFoundException;
import exception.UserNotFoundException;
import exception.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleInvalidEmailException(final ValidationException e) {
        log.info("Ошибка с полем \"%s\": {}", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handlePostNotFoundException(final PostNotFoundException e) {
        log.info("Произошла ошибка с постами: {}", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleUserNotFoundException(final UserNotFoundException e) {
        log.info("Произошла ошибка на стороне пользователя: {}", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void handleThrowable(final Throwable e) {
        log.error("Произошла непредвиденная ошибка: {}", e.getMessage());
    }
}
