package cn.com.glsx.admin.common.enums;

import com.glsx.plat.exception.SystemMessage;

/**
 * 数据部门 - 租户ID
 *
 * @author wangxw
 */
public enum TenantDataEnum {

    SHANDONG_SHUNCHENG(32, "山东顺骋");

    private final Integer code;
    private final String message;

    TenantDataEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    TenantDataEnum(SystemMessage systemMessage) {
        this.code = systemMessage.getCode();
        this.message = systemMessage.getMsg();
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
