package responseerror.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    OK(2000, HttpStatus.OK, "OK"),
    BAD_REQUEST(4000, HttpStatus.BAD_REQUEST, "BAD REQUEST"),
    INTERNAL_SERVER_ERROR(5000, HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL SERVER ERROR");

    private final int code;
    private final HttpStatus httpStatus;
    private final String message;
}
