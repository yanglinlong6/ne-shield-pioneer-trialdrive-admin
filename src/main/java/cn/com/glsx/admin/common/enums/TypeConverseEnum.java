package cn.com.glsx.admin.common.enums;

/**
 * 设备激活参数转换枚举类
 *
 * @author Yanglinlong
 * @date 2021/12/20 14:36
 */
public class TypeConverseEnum {

    /**
     * 设备类型枚举类
     */
    public enum DeviceTypeEnum {
        DEVICE_TYPE_OBD(1, "OBD"),
        DEVICE_TYPE_GPS(8, "GPS");

        private final Integer deviceType;
        private final String deviceTypeStr;

        DeviceTypeEnum(Integer deviceType, String deviceTypeStr) {
            this.deviceType = deviceType;
            this.deviceTypeStr = deviceTypeStr;
        }

        public static String getStrByDeviceType(Integer deviceType) {
            for (DeviceTypeEnum deviceActiveEunm : DeviceTypeEnum.values()) {
                if (deviceActiveEunm.getDeviceType().equals(deviceType)) {
                    return deviceActiveEunm.getDeviceTypeStr();
                }
            }
            return null;
        }

        public Integer getDeviceType() {
            return deviceType;
        }

        public String getDeviceTypeStr() {
            return deviceTypeStr;
        }
    }

    /**
     * 设备有源无源枚举类
     */
    public enum SourceEnum {
        NO_SOURCE(0, "无线设备"),
        HAS_SOURCE(1, "有线设备");

        private final Integer sourceType;
        private final String sourceTypeStr;

        SourceEnum(Integer sourceType, String sourceTypeStr) {
            this.sourceType = sourceType;
            this.sourceTypeStr = sourceTypeStr;
        }

        public static String getStrBySourceType(Integer sourceType) {
            for (SourceEnum sourceEnum : SourceEnum.values()) {
                if (sourceEnum.getSourceType().equals(sourceType)) {
                    return sourceEnum.getSourceTypeStr();
                }
            }
            return null;
        }

        public Integer getSourceType() {
            return sourceType;
        }

        public String getSourceTypeStr() {
            return sourceTypeStr;
        }
    }

    /**
     * 设备有源无源枚举类
     */
    public enum SourceStatusEnum {
        NO_SOURCE(0, "无线"),
        HAS_SOURCE(1, "有线");

        private final Integer sourceType;
        private final String sourceTypeStr;

        SourceStatusEnum(Integer sourceType, String sourceTypeStr) {
            this.sourceType = sourceType;
            this.sourceTypeStr = sourceTypeStr;
        }

        public static String getStrBySourceType(Integer sourceType) {
            for (SourceStatusEnum sourceStatusEnum : SourceStatusEnum.values()) {
                if (sourceStatusEnum.getSourceType().equals(sourceType)) {
                    return sourceStatusEnum.getSourceTypeStr();
                }
            }
            return null;
        }

        public Integer getSourceType() {
            return sourceType;
        }

        public String getSourceTypeStr() {
            return sourceTypeStr;
        }
    }

    /**
     * 设备时候在线枚举类
     */
    public enum OnLineEnum {
        IS_ONLINE(1, "在线"),
        NOT_ONLINE(2, "离线");

        private final Integer onLineType;
        private final String onLineTypeStr;

        OnLineEnum(Integer onLineType, String onLineTypeStr) {
            this.onLineType = onLineType;
            this.onLineTypeStr = onLineTypeStr;
        }

        public static String getStrByonLineType(Integer onLineType) {
            for (OnLineEnum onLineEnum : OnLineEnum.values()) {
                if (onLineEnum.getOnLineType().equals(onLineType)) {
                    return onLineEnum.getOnLineTypeStr();
                }
            }
            return null;
        }

        public Integer getOnLineType() {
            return onLineType;
        }

        public String getOnLineTypeStr() {
            return onLineTypeStr;
        }
    }

    /**
     * 报警类型枚举类
     */
    public enum AlarmTypeEnum {
        //        BLACK_ZONE_ALARM(1, "黑区报警"),
        BLACK_ZONE_ALARM(3, "黑区报警"),
        ABNORMAL_AGGREGATION_ALARM(2, "异常聚集报警"),
        SECOND_AREA_ALARM(4, "二押区域报警");

        private final Integer alarmType;
        private final String alarmTypeStr;

        AlarmTypeEnum(Integer alarmType, String alarmTypeStr) {
            this.alarmType = alarmType;
            this.alarmTypeStr = alarmTypeStr;
        }

        public static String getStrByAlarmType(Integer alarmType) {
            for (AlarmTypeEnum alarmTypeEnum : AlarmTypeEnum.values()) {
                if (alarmTypeEnum.getAlarmType().equals(alarmType)) {
                    return alarmTypeEnum.getAlarmTypeStr();
                }
            }
            return null;
        }

        public Integer getAlarmType() {
            return alarmType;
        }

        public String getAlarmTypeStr() {
            return alarmTypeStr;
        }
    }

    /**
     * 报警状态枚举类
     */
    public enum AlarmStatusEnum {
        TAKE_EFFECT(1, "生效"),
        LOSE_EFFECTIVENESS(2, "失效");

        private final Integer alarmStatus;
        private final String alarmStatusStr;

        AlarmStatusEnum(Integer alarmStatus, String alarmStatusStr) {
            this.alarmStatus = alarmStatus;
            this.alarmStatusStr = alarmStatusStr;
        }

        public static String getStrByAlarmStatus(Integer alarmStatus) {
            for (AlarmStatusEnum alarmStatusEnum : AlarmStatusEnum.values()) {
                if (alarmStatusEnum.getAlarmStatus().equals(alarmStatus)) {
                    return alarmStatusEnum.getAlarmStatusStr();
                }
            }
            return null;
        }

        public Integer getAlarmStatus() {
            return alarmStatus;
        }

        public String getAlarmStatusStr() {
            return alarmStatusStr;
        }
    }

    /**
     * 报警类型枚举类
     */
    public enum AlarmRecTypeEnum {
        POWER_OFFER_ALARM(1, "断电报警"),
        LIGHT_ALARM(99, "光感报警");

        private final Integer alarmType;
        private final String alarmTypeStr;

        AlarmRecTypeEnum(Integer alarmType, String alarmTypeStr) {
            this.alarmType = alarmType;
            this.alarmTypeStr = alarmTypeStr;
        }

        public static String getStrByAlarmType(Integer alarmType) {
            for (AlarmRecTypeEnum alarmRecTypeEnum : AlarmRecTypeEnum.values()) {
                if (alarmRecTypeEnum.getAlarmType().equals(alarmType)) {
                    return alarmRecTypeEnum.getAlarmTypeStr();
                }
            }
            return null;
        }

        public Integer getAlarmType() {
            return alarmType;
        }

        public String getAlarmTypeStr() {
            return alarmTypeStr;
        }
    }

    /**
     * 报警状态枚举类
     */
    public enum AlarmRecStatusEnum {
        TAKE_EFFECT(0, "生效"),
        LOSE_EFFECTIVENESS(2, "失效");

        private final Integer alarmStatus;
        private final String alarmStatusStr;

        AlarmRecStatusEnum(Integer alarmStatus, String alarmStatusStr) {
            this.alarmStatus = alarmStatus;
            this.alarmStatusStr = alarmStatusStr;
        }

        public static String getStrByAlarmStatus(Integer alarmStatus) {
            for (AlarmRecStatusEnum alarmRecStatusEnum : AlarmRecStatusEnum.values()) {
                if (alarmRecStatusEnum.getAlarmStatus().equals(alarmStatus)) {
                    return alarmRecStatusEnum.getAlarmStatusStr();
                }
            }
            return null;
        }

        public Integer getAlarmStatus() {
            return alarmStatus;
        }

        public String getAlarmStatusStr() {
            return alarmStatusStr;
        }
    }

    /**
     * 报警状态枚举类
     */
    public enum SearchTypeEnum {
        SEARCH(1, "查询"),
        EXPORT(2, "导出");

        private final Integer type;
        private final String typeStr;

        SearchTypeEnum(Integer type, String typeStr) {
            this.type = type;
            this.typeStr = typeStr;
        }

        public static String getStrByAlarmStatus(Integer alarmStatus) {
            for (SearchTypeEnum searchTypeEnum : SearchTypeEnum.values()) {
                if (searchTypeEnum.getType().equals(alarmStatus)) {
                    return searchTypeEnum.getTypeStr();
                }
            }
            return null;
        }

        public Integer getType() {
            return type;
        }

        public String getTypeStr() {
            return typeStr;
        }
    }


    public enum FreqStatusEnum {

        /**
         * 生效
         */
        TAKE_EFFECT(1, "生效"),


        /**
         * 关闭
         */
        LOSE_EFFECTIVENESS(2, "关闭");

        private final Integer freqStatus;
        private final String freqStatusStr;

        FreqStatusEnum(Integer freqStatus, String freqStatusStr) {
            this.freqStatus = freqStatus;
            this.freqStatusStr = freqStatusStr;
        }

        public static String getStrByFreqStatus(Integer freqStatus) {
            for (FreqStatusEnum freqStatusEnum : FreqStatusEnum.values()) {
                if (freqStatusEnum.getFreqStatus().equals(freqStatus)) {
                    return freqStatusEnum.getFreqStatusStr();
                }
            }
            return null;
        }

        public Integer getFreqStatus() {
            return freqStatus;
        }

        public String getFreqStatusStr() {
            return freqStatusStr;
        }
    }

    /**
     * 调频类型枚举类
     */
    public enum FreqTypeEnum {
        /**
         * 设备调频模式 0 追车模式;1 闹钟模式;2 星期模式;3 初始化模式
         */

        CAR_CHASE_MODE(0, "追车模式"),
        ALARM_MODE(1, "闹钟模式"),
        WEEK_MODE(2, "星期模式"),
        INITIALIZATION_MODE(3, "初始化模式");


        private final Integer freqType;
        private final String freqTypeStr;

        FreqTypeEnum(Integer freqType, String freqTypeStr) {
            this.freqType = freqType;
            this.freqTypeStr = freqTypeStr;
        }

        public static String getStrByFreqType(Integer freqType) {
            for (FreqTypeEnum freqTypeEnum : FreqTypeEnum.values()) {
                if (freqTypeEnum.getFreqType().equals(freqType)) {
                    return freqTypeEnum.getFreqTypeStr();
                }
            }
            return null;
        }

        public Integer getFreqType() {
            return freqType;
        }

        public String getFreqTypeStr() {
            return freqTypeStr;
        }
    }

    /**
     * 用户类型枚举类
     */
    public enum UserTypeEnum {
        WEB(1, "WEB"),
        MINI(2, "小程序");

        private final Integer userType;
        private final String userTypeStr;

        UserTypeEnum(Integer userType, String userTypeStr) {
            this.userType = userType;
            this.userTypeStr = userTypeStr;
        }

        public static String getStrByUserType(Integer userType) {
            for (UserTypeEnum userTypeEnum : UserTypeEnum.values()) {
                if (userTypeEnum.getUserType().equals(userType)) {
                    return userTypeEnum.getUserTypeStr();
                }
            }
            return null;
        }

        public Integer getUserType() {
            return userType;
        }

        public String getUserTypeStr() {
            return userTypeStr;
        }
    }
}
