package cn.com.glsx.admin.common.enums;

import lombok.Getter;

@Getter
public enum VehicleUsageEnum {

    TRIAL(1, "专属用途"),
    DEEP(2, "非专属用途");

    private final Integer code;
    private final String name;

    VehicleUsageEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getNameByCode(Integer code) {
        for (VehicleUsageEnum typeEnum : VehicleUsageEnum.values()) {
            if (typeEnum.getCode().equals(code)) {
                return typeEnum.getName();
            }
        }
        return "--";
    }

}
