package cn.com.glsx.admin.common.enums;

import lombok.Getter;

@Getter
public enum VehicleTypeEnum {

    TRIAL(1, "试驶车"),
    DEEP(2, "深度体验车"),
    SERVER(3, "服务车"),
    WALK(4, "代步车"),
    HELP(5, "救援车"),
    OFFICE(6, "办公车"),
    OTHER(7, "其他"),
    LUXURY(8, "高豪车");

    private final Integer code;
    private final String name;

    VehicleTypeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getNameByCode(Integer code) {
        for (VehicleTypeEnum typeEnum : VehicleTypeEnum.values()) {
            if (typeEnum.getCode().equals(code)) {
                return typeEnum.getName();
            }
        }
        return "--";
    }

}
