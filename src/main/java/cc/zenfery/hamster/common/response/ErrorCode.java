package cc.zenfery.hamster.common.response;

import lombok.Getter;
import cc.zenfery.hamster.common.i18n.MessageConfig;

@Getter
public enum ErrorCode {

    // 成功
    COMMON_SUCCESS(Status.SUCCESS, "common.success"),
    // 通用失败
    COMMON_ERROR(Status.ERROE, "0001", "common.error"),
    //
    ;

    private Status status;
    private String code = "0000"; // 四位数字字符串
    private String msgKey; // 国际化key

    private ErrorCode(Status status, String msgKey) {
        this.status = status;
        this.msgKey = msgKey;
    }

    private ErrorCode(Status status, String code, String msgKey) {
        this.status = status;
        this.code = code;
        this.msgKey = msgKey;
    }

    public String message(Object[] args) {
        return this.msgKey == null ? null : MessageConfig.getMessage(this.msgKey, args);
    }

    public String errorCode() {
        return "" + this.status.status() + this.code;
    }
}
