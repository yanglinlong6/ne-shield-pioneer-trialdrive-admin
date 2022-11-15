package cn.com.glsx.admin.common.constants;

/**
 * 设备相关的常量类
 */
public final class ConstantsDevice {

    /**
     * 设备绑定车辆状态：1绑定
     */
    public static final int BIND_VEHICLE_STATUS = 1;

    /**
     * 设备绑定车辆状态：2解绑
     */
    public static final int UN_BIND_VEHICLE_STATUS = 2;

    /**
     * 设备离线时间：三天 单位 s/秒
     */
    public static final long OFFLINE_TIME = 3 * 24 * 3600L;

    /**
     * 定位类型：gps：1
     */
    public static final int DEVICE_LOCATION_GPS = 1;
    /**
     * 定位类型：基站：2
     */
    public static final int DEVICE_LOCATION_BS = 2;

    /**
     * 试驾设备类型   0:非试驾设备
     */
    public static final int NOT_TRIAL_DEVICE_TYPE = 0;

    /**
     * 试驾设备类型  1:试驾设备
     */
    public static final int TRIAL_DEVICE_TYPE = 1;

    /**
     * 历史试驾类型   0:曾经不是试驾设备
     */
    public static final int HIS_NOT_TRIAL_DEVICE_TYPE = 0;

    /**
     * 历史试驾类型  1:曾经是试驾设备
     */
    public static final int HIS_TRIAL_DEVICE_TYPE = 1;

    /**
     * 删除标记   0=正常 -1=删除
     */
    public static final int NOT_DEL_FLAG = 0;

    /**
     * 设备未激活（0=未激活 1=激活）
     */
    public static final int DEVICE_UN_ACTIVED = 0;

    /**
     * 设备已激活（0=未激活 1=激活）
     */
    public static final int DEVICE_ACTIVED = 1;
}
