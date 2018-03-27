package cc.zenfery.hamster.common.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.apachecommons.CommonsLog;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.zenfery.hamster.common.response.ErrorCode;
import cc.zenfery.hamster.common.response.Status;

@ControllerAdvice
@CommonsLog
public class ExceptionHandlerControllerAdvice {

    public static final String STATUS_KEY = "Status";
    public static final String ERROR_CODE_KEY = "error_code";
    public static final String ERROR_MSG_KEY = "msg";

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, String> commonExceptionHandler(HttpServletRequest request, HttpServletResponse response,
            Exception e) {

        String errorCode = ErrorCode.COMMON_ERROR.errorCode();
        String msg = "error";

        if (e instanceof ResponseRuntimeException) {
            ResponseRuntimeException rre = (ResponseRuntimeException) e;
            //
            response.setHeader(STATUS_KEY, "" + rre.getErrorCode().getStatus().status());

            errorCode = rre.getErrorCode().errorCode();
            msg = rre.getMessage();

            log.error("commonExceptionHandler(): " + rre.getMessage());
        } else {

            response.setHeader(STATUS_KEY, "" + Status.ERROE.status());

            errorCode = ErrorCode.COMMON_ERROR.errorCode();
            msg = e.getMessage();

            log.error("commonExceptionHandler(): " + e.getMessage());
        }

        Map<String, String> ret = new HashMap<String, String>();
        ret.put(ERROR_CODE_KEY, errorCode);
        ret.put(ERROR_MSG_KEY, msg);

        return ret;

    }
}
