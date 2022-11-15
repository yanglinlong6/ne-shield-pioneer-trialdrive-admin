package cn.com.glsx.admin.common.constants;

public final class ConstantsVehicle {

    /**
     * 车辆类型  1：试乘试驶车
     */
    public static final int TRIAL_DRIVE_TYPE = 1;

    /**
     * 车辆类型 2:深度体验车
     */
    public static final int DEPTH_DRIVE_TYPE = 2;

    /**
     * 服役类型：0未上牌
     */
    public static final int UN_VEHICLE_TYPE_PLATE = 0;

    /**
     * 服役类型：1已上牌
     */
    public static final int VEHICLE_TYPE_PLATE = 1;

    /**
     * 服役类型：未上牌
     */
    public static final String UN_VEHICLE_TYPE_PLATE_STR = "未上牌";

    /**
     * 服役类型：已上牌
     */
    public static final String VEHICLE_TYPE_PLATE_STR = "已上牌";


    public static class OperatorLog {
        public static final String MODIFY_VIN = "车架号";
        public static final String MODIFY_CREATED = "车辆归属";
        public static final String MODIFY_PLATENO = "车牌号";
        public static final String BIND_DEVICE = "车辆绑定设备";
    }


    /**
     * 常驻地查询时间范围;1:一个月 2:三个月 3:半年内 4:截至到目前,5:自定义，-1测试用
     */
    public static final String RESIDENT_TYPE_ONE = "1";

    /**
     * 常驻地查询时间范围; 2:三个月
     */
    public static final String RESIDENT_TYPE_THREE = "2";

    /**
     * 常驻地查询时间范围; 3:半年内
     */
    public static final String RESIDENT_TYPE_SIX = "3";

    /**
     * 常驻地查询时间范围; 4:截至到目前
     */
    public static final String RESIDENT_TYPE_PRESENT = "4";

    /**
     * 常驻地查询时间范围;,5:自定义
     */
    public static final String RESIDENT_TYPE_CUSTOM = "5";


}
