package responseerror.demo.api;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import responseerror.ApiResponse;
import responseerror.demo.exception.CustomException;

import java.util.Collections;
import java.util.List;

public class BaseController {

    public <T> ApiResponse<T> makeResponse(T result) {
        return makeResponse(Collections.singletonList(result));
    }

    public <T> ApiResponse<T> makeResponse(List<T> results) {
        return new ApiResponse<T>(results);
    }

    @ExceptionHandler(CustomException.class)
    public <T> ApiResponse<T> customExceptionHandelr(HttpServletResponse response, CustomException customException) {
        response.setStatus(customException.getErrorCode().getHttpStatus().value());
        return new ApiResponse<T>(
                customException.getErrorCode().getCode(),
                customException.getErrorCode().getMessage(),
                customException.getData()
                );
    }
}
