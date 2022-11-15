package cn.com.glsx.admin.common.enums;

import com.glsx.plat.exception.SystemMessage;

/**
 * 数据部门 - 数据同步操作
 *
 * @author wangxw
 */
public enum TenantDataOperatorEnum {

    ADD_DEVICE(1, "添加"),
    DELETE_DEVICE(2, "删除"),
    UPDATE_DEVICE(3, "更新");

    private final Integer code;
    private final String message;

    TenantDataOperatorEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    TenantDataOperatorEnum(SystemMessage systemMessage) {
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
