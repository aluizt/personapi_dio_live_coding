package one.digitalinnovation.personapi.exception.exceptionhandler;

import one.digitalinnovation.personapi.exception.ApiExceptionImpl;
import one.digitalinnovation.personapi.exception.GenericException;
import one.digitalinnovation.personapi.exception.PersonNotFoundException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(PersonNotFoundException.class)
    @ResponseBody
    public ApiExceptionImpl handle(PersonNotFoundException error) {
        return ApiExceptionImpl.builder()
                .code(400)
                .message(error.getMessage())
                .build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public ApiExceptionImpl handle(ConstraintViolationException error) {
        return ApiExceptionImpl.builder()
                .code(500)
                .message(error.getMessage())
                .detail(error.getConstraintName())
                .field(error.getSQLState())
                .build();
    }

    @ExceptionHandler(GenericException.class)
    @ResponseBody
    public ApiExceptionImpl handle(GenericException error) {
        return ApiExceptionImpl.builder()
                .code(error.code())
                .message(error.getMessage())
                .build();
    }
}
