package dev.sainath.productService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ExceptionDto {

    private  String message;
    private HttpStatus errorCode;

    public ExceptionDto(HttpStatus status,String message){
        this.message = message;
        this.errorCode = status;
    }
}
