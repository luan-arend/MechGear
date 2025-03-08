package br.com.dev.MechGear.infra.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class ApiError {

    private int status;
    private String error;
    private String timestamp;
    private String trace;

    public ApiError(int status, String error, String trace) {
        this.status = status;
        this.error = error;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        this.trace = trace;
    }
}
