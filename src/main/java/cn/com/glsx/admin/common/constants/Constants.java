package cn.com.glsx.admin.common.constants;

/**
 * @Desc:公共的常量类
 * @Author huangxc
 * @Date 2021/5/22
 */
public final class Constants {

    /**
     * 删除标识 0:正常
     */
    public static final Integer NORMAL_FLAG = 0;

    /**
     * 删除标识 -1:删除
     */
    public static final Integer DELETE_FLAG = -1;

    /**
     * 广汽离线设备时间：一天 单位 s/秒 注：在sql中大多是秒，在java代码中大多是毫秒
     */
    public static final long OFFLINE_TIME_GQ = 24 * 3600L;

    /**
     * 其他公司 设备离线时间：三天 单位 s/秒
     */
    public static final long OFFLINE_TIME_OTHER = 3 * 24 * 3600L;

    /**
     * 有源在线时间点 6分钟 单位 毫秒/ms
     */
    public static final long ONLINE_SOURCE_TIME = 6 * 60 * 1000L;
    /**
     * 字典表中车辆车型的type
     */
    public static final String TRIALDRIVE_VEHICLE_MODEL = "trialdrive_vehicle_model";
    /**
     * 字典表中试驾车辆配置的type
     */
    public static final String TRIALDRIVE_VEHICLE_CONFIG = "trialdrive_vehicle_config";

    /**
     * 同步渠道 timed_task：定时任务渠道
     */
    public static final String SYNC_CHANNEL_TIMED_TASK = "edun_timed_task";

    /**
     * 厂商ID-博实结
     */
    public static final String BSJ_FACTORY_ID = "BSJ";

    /**
     * 设备调频模式 0 追车模式;1 闹钟模式;2 星期模式;3 初始化模式
     */
    public static final int ADJ_FREQ_CATCHING = 0;
    public static final int ADJ_FREQ_TIMER = 1;
    public static final int ADJ_FREQ_WEEK = 2;
    public static final int ADJ_FREQ_INITIAL = 3;

    /**
     * 过滤（开）ON
     */
    public static final int FILTER_GPS_BS_ON = 1;

    /**
     * 过滤（关）OFF
     */
    public static final int FILTER_GPS_BS_OFF = 0;

    /**
     * xlsx 文件拓展名
     */
    public static final String XLSX_FILE_EXTENSION = "xlsx";

    /**
     * 定位类型 GPS
     */
    public static final String POI_TYPE_GPS = "GPS";

    /**
     * 定位类型 基站
     */
    public static final String POI_TYPE_BS = "基站";

    /**
     * 今天
     */
    public static final int TIMETYPE_TODAY = 1;
    /**
     * 昨天
     */
    public static final int TIMETYPE_YESTERDAY = 2;
    /**
     * 本周
     */
    public static final int TIMETYPE_THISWEEK = 3;
    /**
     * 上周
     */
    public static final int TIMETYPE_LASTWEEK = 4;
    /**
     * 本月
     */
    public static final int TIMETYPE_THISMONTH = 5;
    /**
     * 上月
     */
    public static final int TIMETYPE_LASTMONTH = 6;
    /**
     * 时间段
     */
    public static final int TIMETYPE_SCOPE = 7;
    /**
     * 时间范围 近12小时
     */
    public static final int TIMETYPE_IN_12_HOURS = 8;
    /**
     * 时间范围 近24小时
     */
    public static final int TIMETYPE_IN_24_HOURS = 9;
    /**
     * 近七天
     */
    public static final int TIMETYPE_IN_7_DAYS = 10;
    /**
     * 近30天
     */
    public static final int TIMETYPE_IN_30_DAYS = 11;
    /**
     * 时间段 带时间
     */
    public static final int TIMETYPE_SCOPE_WITH_TIME = 12;

    /**
     * 包活干返回成功码
     */
    public static final int BHG_RET_CODE_SUCCESS = 200;

    /**
     * 导出最大限制
     */
    public static final int MAX_EXPORT_LIMIT = 10000;


    public static final String EMPTY_CONTENT_EXCEL = "--";


    //--------------- 调频响应状态----------------

    /**
     * 响应状态已响应
     */
    public static final int STATUS_RESPONSE = 2;


    /**
     * 发送中
     */
    public static final int STATUS_RESPONSE_SENDING = 1;
}
