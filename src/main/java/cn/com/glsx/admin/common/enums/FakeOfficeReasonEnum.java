package cn.com.glsx.admin.common.enums;

import com.glsx.plat.exception.SystemMessage;

/**
 * @author Yanglinlong
 * @date 2022/3/11 18:07
 */
public enum FakeOfficeReasonEnum {
    WHITELIST(1, "纳入离线白名单数据"),
    SINGLE_OFFLINE(2, "车辆多设备组合单离线"),
    RESIDENCE(3, "常驻地中【家庭/工作】地址离线"),
    HOME_ADDR(4, "常驻地中【家庭】地址离线"),
    WORK_ADDR(5, "常驻地中【工作】地址离线"),

    /**
     * 十日内状态反复变化
     */
    CHANGE_FREQUENTLY(6, "十日内状态反复变化"),
    ;

    private final Integer code;
    private final String message;

    FakeOfficeReasonEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    FakeOfficeReasonEnum(SystemMessage systemMessage) {
        this.code = systemMessage.getCode();
        this.message = systemMessage.getMsg();
    }

    public static String getMessageByCode(Integer code) {
        for (FakeOfficeReasonEnum reasonEnum : FakeOfficeReasonEnum.values()) {
            if (reasonEnum.getCode().equals(code)) {
                return reasonEnum.getMessage();
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
