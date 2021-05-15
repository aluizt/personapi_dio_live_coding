package one.digitalinnovation.personapi.exception;

import org.springframework.http.HttpStatus;

public class GenericException extends RuntimeException {

    private static final long serialVersionUID = 3703179933479504025L;

    private Integer code;
    private String message;
    private HttpStatus httpCode;

    public GenericException(String message, HttpStatus httpCode) {
        super(message);
        this.message = message;
        this.httpCode = httpCode;
    }

    public GenericException(Integer code, String message, HttpStatus httpCode) {
        super(message);
        this.code = code;
        this.message = message;
        this.httpCode = httpCode;
    }

    public Integer code() {
        return code;
    }

    public String message() {
        return message;
    }

    public HttpStatus httpCode() {
        return httpCode;
    }
}
