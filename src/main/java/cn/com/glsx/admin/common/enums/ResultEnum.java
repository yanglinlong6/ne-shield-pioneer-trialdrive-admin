package cn.com.glsx.admin.common.enums;

import com.glsx.plat.exception.SystemMessage;

/**
 * 试驾服务错误码
 *
 * @author zhouhaibao
 */
public enum ResultEnum {

    PARAM_ERROR(1001, "参数错误"),
    PARAM_EMPTY(1001, "参数错误：%s 不能为空"),
    ID_NOT_FOUND(1002, "ID不存在"),

    /**
     * 试驾服务相关业务异常错误码，错误信息
     */
    APPROVAL_ALREADY_EXISTS(12110001, "该业务审批单已经存在"),
    APPROVAL_NOT_EXISTS(12110002, "该业务id未查到审批单"),
    APPROVAL_BIZ_HANDLE_ERROR(12110003, "审核业务处理异常"),
    VEHICLE_NOT_FOUND(12110004, "车辆未查到"),

    /**
     * 试驾车辆管理相关业务异常错误码，错误信息 1212开头
     */
    TRIAL_DRIVE_DEVICE_EXISTS(12120001, "该设备已绑定车辆(%s)，vehicleId:%s"),
    IMPORT_FAIL_FILE(12120002, "导入文件与指定模板不匹配"),
    IMPORT_FILE_TYPE_ERROR(12120003, "导入文件类型错误"),
    IMPORT_FAIL_NOT_FOUND(12120004, "未找到失败的文件"),
    UN_BIND_DEVICE(12120005, "请先解绑原设备,再重新绑定新设备"),
    EXIST_VEHICLE(12120006, "该车辆已存在:vin %s"),
    IMPORT_SIZE_TIP(12120007, "每次只能导入 %s 条。"),
    IMPORT_EMPTY(12120008, "导入的数据为空。"),
    PARSE_EXCEL_ERROR(12120009, "解析excel文件异常"),
    IMPORT_FIAL_ERROR(12120010, "导入数据异常"),

    /**
     * 拆除报警
     */
    TEARDOWNALARM_HAS_NO_DATA(12110003, "没有查询到拆除报警数据"),

    /**
     * 车辆监控历史轨迹
     */
    TRACKHISTORY_HAS_EXCEED_LIMIT(12110004, "获取gps历史轨迹的数据条数已经超过最大限制"),
    TRACKHISTORY_HAS_NO_DATA(12110005, "没有查询到历史轨迹数据"),
    DEVICE_NOT_EXIST(12110006, "%s 设备未入库,请先入库!"),

    /**
     * 围栏管理相关业务异常错误码，错误信息 1213开头
     */
    TRIAL_ROUTE_EXISTED(121330001, "线路名称已存在"),
    ELECTRIC_FENCE_EXISTED(121330002, "围栏名称已存在"),

    /**
     * 特约店围栏管理相关业务异常错误码，错误信息 1214开头
     */
    TRIAL_DRIVE_SHOP_EXISTED(121430001, "特约店已存在"),
    TRIAL_DRIVE_SHOP_FENCE_EXISTED(121430002, "特约店围栏名称已存在"),

    TENANT_VEHICLE_TYPES_EXISTED(121430003, "该组织车型库已存在"),
    VEHICLE_VIN_EXISTED(121430004, "车架号已经在系统中存在,请重新修改"),
    VEHICLE_IS_EMPTY(121430005, "该工单没有绑定车辆,请重新修改"),
    VEHICLE_VIN_EXISTED_IN_SERVICE_CODE(121430006, "相同服务类型下,该车架号已经在系统中存在,请重新修改"),

    /**
     * 工单相关错误码，错误信息 1215开头
     */
    WORKORDER_DOCS_NOT_GENERATED(121510001, "工单暂无图片或图片压缩包暂未生成"),
    WORKORDER_HAS_ACTIVATED(121510002, "该工单已经激活"),
    DEVICE_COMPOSE_INCONSISTENT(121510003, "工单设备组合类型不一致"),

    /**
     * 车辆数据修改，错误信息 1216开头
     **/
    DEVICE_COMPOSS_NOT_MATCH(121610001, "设备组合不匹配");

    private final Integer code;
    private final String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    ResultEnum(SystemMessage systemMessage) {
        this.code = systemMessage.getCode();
        this.message = systemMessage.getMsg();
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
