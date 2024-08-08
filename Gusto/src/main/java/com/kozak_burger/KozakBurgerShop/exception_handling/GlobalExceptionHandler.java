package com.kozak_burger.KozakBurgerShop.exception_handling;

import com.kozak_burger.KozakBurgerShop.exception_handling.exceptions.EntranceDataValidation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


        @ExceptionHandler(EntranceDataValidation.class)
        public ResponseEntity<Response> handleException(EntranceDataValidation e) {
            Response response = new Response(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
}