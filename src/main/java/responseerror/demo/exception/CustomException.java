package responseerror.demo.exception;

import lombok.Getter;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;

@Getter
public class CustomException extends RuntimeException {
    private final ErrorCode errorCode;

    private Map.Entry<String, Object> data;

    public CustomException(ErrorCode errorCode, String message, Object data) {
        super(message);
        this.errorCode = errorCode;
        this.data = new AbstractMap.SimpleEntry<>(data.getClass().getSimpleName(), data);
    }
}