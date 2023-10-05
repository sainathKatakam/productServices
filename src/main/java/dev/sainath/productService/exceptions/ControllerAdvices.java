package dev.sainath.productService.exceptions;

import dev.sainath.productService.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvices {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundException exp){

        return new ResponseEntity(
                new ExceptionDto(HttpStatus.NOT_FOUND,exp.getMessage()),
                HttpStatus.NOT_FOUND
        );

    }
}
