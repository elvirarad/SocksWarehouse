package me.elvira.sockswarehouseapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid sock request")
public class InvalidSockRequestException extends RuntimeException{

    public InvalidSockRequestException(String massage) {
        super(massage);
    }
}
