package dev.sainath.productService.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class NotFoundException extends Exception{
       public NotFoundException(String msg){
            super(msg);
        }
}
