package cn.com.glsx.admin.common.enums;

import lombok.Getter;

@Getter
public enum OrgVehicleTreeIdTag {

    ORG("o", "组织"), USER("u", "用户"), VEHICLE("v", "车辆"), DEVICE("d", "设备");

    private final String tag;
    private final String desc;

    OrgVehicleTreeIdTag(String tag, String desc) {
        this.tag = tag;
        this.desc = desc;
    }

}
