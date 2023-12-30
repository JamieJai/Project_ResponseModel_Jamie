package responseerror;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import responseerror.demo.exception.ErrorCode;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ApiResponse<T> {

    private Status status;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Metadata metadata;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<T> results;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Object data;


    @Getter
    @AllArgsConstructor
    private class Status {
        private int code;
        private String message;
    }

    @Getter
    @AllArgsConstructor
    private class Metadata {
        private int resultCount = 0;
    }

    public ApiResponse(List<T> results) {
        this.status = new Status(ErrorCode.OK.getCode(), ErrorCode.OK.getMessage());
        this.metadata = new Metadata(results.size());
        this.results = results;
    }

    public ApiResponse(int code, String message, Object data) {
        this.status = new Status(code, message);
        this.data = data;
    }
}
