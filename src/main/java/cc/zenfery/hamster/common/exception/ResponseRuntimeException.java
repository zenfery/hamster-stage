package cc.zenfery.hamster.common.exception;

import lombok.Getter;
import lombok.Setter;
import cc.zenfery.hamster.common.response.ErrorCode;

@Getter
@Setter
public class ResponseRuntimeException extends RuntimeException {

    private ErrorCode errorCode;
    private Object[] args;

    public ResponseRuntimeException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ResponseRuntimeException(ErrorCode errorCode, Object... args) {
        this.errorCode = errorCode;
        this.args = args;
    }

    public String getMessage() {
        return errorCode.message(args);
    }

}
