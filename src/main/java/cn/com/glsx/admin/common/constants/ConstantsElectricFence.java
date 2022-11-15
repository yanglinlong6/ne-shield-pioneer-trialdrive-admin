package cn.com.glsx.admin.common.constants;

public final class ConstantsElectricFence {

    //围栏形状类型 1.圆形（默认） 3.多边形 4行政区域(大数据侧没有4，我方以areaCode判断)
    /**
     * 围栏形状 圆形
     */
    public static final int SHAPE_TYPE_CIRCLE = 1;

    /**
     * 围栏形状 多边形
     */
    public static final int SHAPE_TYPE_POLYGON = 3;

    /**
     * 围栏形状 行政区域
     */
    public static final int SHAPE_TYPE_ADMINISTRATIVE = 4;

    /**
     * 电子围栏 关闭状态
     */
    public static final Integer ELECTRIC_FENCE_CLOSE = 0;

    /**
     * 电子围栏 开启状态
     */
    public static final Integer ELECTRIC_FENCE_OPEN = 1;

    /**
     * 电子围栏 删除状态
     */
    public static final Integer ELECTRIC_FENCE_DELETE = 2;

    /**
     * 电子围栏 新增状态
     */
    public static final Integer ELECTRIC_FENCE_ADD = 3;

    /**
     * 电子围栏 修改状态
     */
    public static final Integer ELECTRIC_FENCE_UPDATE = 4;

    /**
     * 电子围栏 关联设备新增状态
     */
    public static final Integer ELECTRIC_FENCE_SNS_ADD = 5;

    /**
     * 电子围栏 关联设备删除状态
     */
    public static final Integer ELECTRIC_FENCE_SNS_DELETE = 6;

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
}
