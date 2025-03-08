package br.com.dev.MechGear.infra.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ValidateException extends RuntimeException {
    private final HttpStatus status;

    public ValidateException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
