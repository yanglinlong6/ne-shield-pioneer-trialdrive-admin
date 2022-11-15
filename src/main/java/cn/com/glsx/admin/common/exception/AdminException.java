package cn.com.glsx.admin.common.exception;

import cn.com.glsx.admin.common.enums.ResultEnum;
import com.glsx.plat.exception.SystemMessage;
import lombok.Getter;
import lombok.Setter;

/**
 * @author payu
 */
@Setter
@Getter
public class AdminException extends RuntimeException {

    private int errorCode;

    private String message;

    public AdminException() {
    }

    public AdminException(String message) {
        super(message);
        this.errorCode = SystemMessage.FAILURE.getCode();
        this.message = message;
    }

    public AdminException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }

    public AdminException(ResultEnum resultEnum) {
        this.errorCode = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }

    public AdminException(Throwable cause) {
        super(cause);
    }

    public AdminException(String message, Throwable cause) {
        super(message, cause);
    }

}
