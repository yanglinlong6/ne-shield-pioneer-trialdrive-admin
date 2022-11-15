package cn.com.glsx.admin.common.enums;

import lombok.Getter;

@Getter
public enum FenceTriggerTypeEnum {

    ENTER(1, "驶入"),
    LEAVE(2, "驶出"),
    ENTER_LEAVE(3, "驶入驶出");

    private final Integer code;
    private final String desc;

    FenceTriggerTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String getDescByCode(Integer code) {
        for (FenceTriggerTypeEnum typeEnum : FenceTriggerTypeEnum.values()) {
            if (typeEnum.getCode().equals(code)) {
                return typeEnum.getDesc();
            }
        }
        return "";
    }

}
