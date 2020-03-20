package com.zw.activitidemo.common;

/**
 * 6位业务码
 */
public enum ResultCode {
	NOT_LOGGED_IN(301, "未登录,请先登录"),
    PARAM_NULL(401, "参数为空"),
    PARAM_ERROR(402, "参数异常"),
    OPERATION_SUCCESS(200, "操作成功"),
    OPERATION_CONCURRENCY_FAIL(1000, "正在处理，请勿重复提交，稍后再试！"),
    OPERATION_OCCUR_EXCEPTION(999999, "系统繁忙，请稍后再试"),
    ERROR(500, "系统错误"),
    INVALID(501, "非法操作"),
    // 排班申请-100000-100100
    PARENT_POST_NOT_FOUND(100000, "上级领导信息不存在"),
    NOT_IN_OFFICE_TIME(100001, "排班请选择在办公时间范围内"),
    ALL_IN_REST_TIME(100002, "排班时间请不要都在休息时间范围内"),
    NOT_APPLY_HOLIDAY(100003, "节假日不能排班"),
    CONFLICT_EXIST_DISPATCH(100004, "与已派班时段存在冲突"),
    CONFLICT_EXIST_NOWDAY(100005, "与今日已排班时段冲突"),
    CONFLICT_EXIST_LEAVE(100006, "与请假时间冲突"),
    LEAVE_TIME_NOT_ENOUGH(100007, "月剩余排班时间不足"),
    APPROVE_NOT_EXIST(100008, "审核信息不存在"),
    SCHEDULE_NOT_EXIST(100009, "当前勤务时段信息不存在"),
    SCHEDULE_START(100010, "排班时段已经开始，无法取消排班"),
    SCHEDULE_TYPE_NOT_EXIST(100011, "排班类型不匹配"),
    DATE_TYPE_NOT_RIGHT(100012, "日期格式不匹配"),
    DATETIME_START(100013, "时段已开始"),
    DATETIME_30_START(100015, "需提前30分钟发起排班"),
    DATETIME_DISPATCH_30_START(100016, "需提前30分钟发起派班"),
    DATETIME_CONFLIC_APPLY(100017, "存在重复的申请时段"),
    SCHEDULE_NEED_REFRESH(100018, "无法撤回当前排班，请刷新"),
    SCHEDULE_APPROVE_NEED_REFRESH(100019, "勤务数据已处理，请刷新"),
    //SCHEDULE_NOT_EXIST(100014, "时段信息不存在"),   100099不可以被使用

    // 异常申请-100101-100200
    SCHEDULE_CAN_NOT_EXCEPTION_APPLY(100101, "当前勤务时段不能进行异常申诉"),
    STRUCTURE_ERROR_CAN_NOT_EXCEPTION_APPLY(100102, "组织架构异常，当前勤务时段无法异常申诉"),
    SCHEDULE_CAN_NOT_EXCEPTION_GIVEUP(100103, "当前勤务时段不能放弃异常申诉"),
    APPROVE_NOT_HAVE_APPLY(100104, "当前审核没有申请信息"),
    APPLY_NOT_EXIST(100105, "申请信息不存在"),
    CAN_NOT_REVOKE(100106, "无法撤回当前已发，请刷新"),
    EXCEPTION_DATA_NOT_ENOUGH(100107, "可申请时长不足，请重新申请"),
    EXCEPTION_DATA_LAST_MONTH(100108, "只能申请上月缺勤时长，请重新申请"),
    EXCEPTION_DATA_DATE_LIMIT(100109, "已过申请日期截止日期，无法申请"),


    // 加时申请-100201-100300
    APPEND_SCHEDULE_NOT_IN_RANGE(100201, "加时时段不在可申请时间范围内"),
    FESTIVAL_CAN_NOT_APPEND(100202, "节假日不能加时"),
    APPEND_SCHEDULE_DURATION_ERROR(100203, "单个加时时段必须大于30分钟"),
    MONTH_APPEND_DURATION_LIMIT(100204, "月加班时长已超过36小时"),
    APPEND_CONFLICT(100205, "加时时段与已有排班、派班、加时或请假冲突"),
    APPEND_SELF_CONFLICT(100206, "申请的加时时段自身存在冲突"),
    APPEND_SCHEDULE_CAN_NOT_AFTER_NOW(100207, "加时时段不能超过现在时间"),
    APPEND_SCHEDULE_CAN_NOT_REVOKE(100208, "无法撤回当前加时，请刷新"),
    APPEND_SCHEDULE_POST_NOT_SAME(100209, "加时岗位与原时段岗位不同，请刷新"),
    APPEND_SCHEDULE_CONTAIN_RESTTIME(100210, "加时时段不可包含休息时间，请刷新"),
    // 请假申请-100301-100400
    LEAVE_DATE_RANGE_ERROR(100301, "请假日期范围错误"),
    LEAVE_DATE_BEFORE_CURRENT_MONTH(100302, "请假日期不能早于当月"),
    LEAVE_TIME_LIMIT(100303, "未来的请假需至少提前30分钟"),
    LEAVE_TIME_DURATION_LIMIT(100304, "单日请假时长不能超过8小时"),
    LEAVE_SCHEDULE_DURATION_LIMIT(100305, "单一时段请假时长不能为0"),
    LEAVE_CONFLICT(100306, "请假时段与已有排班、派班、加时或请假冲突"),
    LEAVE_SELF_CONFLICT(100307, "申请的请假时段自身存在冲突"),
    LEAVE_TIME_ADVANCE_LIMIT(100308, "时段已开始，无法请假"),
    LEAVE_TYPE_CLOSED(100309, "请假类型已关闭，请重新刷新"),
    LEAVE_ANNUAL_LEFT(100310, "假期余额不足，请重新请假"),
    LEAVE_WORK_TIME(100311, "当前假期按工作日计算，请假请选择工作日"),
    LEAVE_APPLY_LIMIT(100312, "不符合公司请假要求，请重新请假"),
    LEAVE_TIME_GONE(100313, "时段已全部结束，不能变更请假"),
    LEAVE_OLD_NONE(100314, "原请假数据不存在，请刷新"),
    LEAVE_0LD_DONE(100315, "原请假数据已在处理中，请不要重复变更"),
    LEAVE_LEFT_NONE(100316, "已有排班或派班（包含审核中的），请先取消排班或派班"),
    LEAVE_TIME_LEFT_NOT_ENOUGH(100317, "剩余单日请假时长不足"),
    LEAVE_ANUNAL_NOT_ENOUGH(102318,"假期余额不足，请重新请假"),
    LEAVE_NOT_AGREE(102319,"请假功能，即将上线"),
    LEAVE_NOT_REVOKE(102320, "请假已在审批中，无法撤回"),
    LEAVE_NOT_DELETE(102321, "该请假记录，无法删除"),
    LEAVE_NOT_CANCEL(102322, "该请假记录，无法撤回"),
    LEAVE_NOT_USER(102323,"该请假入口已关闭，请使用请假功能进行请假"),
    LEAVE_ANUNAL_NOT_USE(102324,"管理员未开启年假余额限制，请重新选择"),
    LEAVE_ANUNAL_NOT_ENOUGH2(102325,"假期余额不足"),

    //设置异常-100401-100500
    SET_UPDAGE_ERROR(100401,"数据已变更，请重新刷新页面后操作"),
    SET_POST_REPEAT(100402,"%s已存在别的规则内，请先去除。"),
    SET_WIFI_OVERDUE(100403,"二维码已过期,请刷新二维码"),
    ATTEND_HOME_SET_POST_REPEAT(100404,"%s已存在别的分组内，请先去除。"),
    ATTEND_HOME_SET_NAME_REPEAT(100405,"分组名称重复"),
    ATTEND_HOME_SET_NOT_EXIST(100406,"对应分组不存在"),

	//日程 102101-102199
    MEMO_DONT_EXIST(102101,"备忘日程不存在"),
    MEMO_CANOT_OPERATE(102102,"备忘日程无权操作"),

    // 勤务评分 102201-102299
    GRADE_SCHEDULE_NOT_EXIST(102201,"对应可评分时段不存在"),
    GRADE_SCORE_NOT_IN_RANGE(102202,"该评分不在规则范围内"),
    DEFAULT_SCORE_ERROR(102203,"默认分必须大于最低分"),
    LOWEST_SCORE_ERROR(102204,"最低分必须大于等于0"),

    // 请假规则设置 102301-102399
    LEAVE_TYPE_NOT_EXIST(102301,"请假类型不存在"),
    LEAVE_TYPE_CAN_NOT_DELETE(102302,"该请假类型不能删除"),
    LEAVE_HOLIDAY_NAME_REPEAT(102303,"节假日名称重复"),
    LEAVE_TYPE_NAME_REPEAT(102304,"请假类型名称重复"),
    LEAVE_TYPE_IS_NOT_SET(102403,"请先设置请假类型"),
    LEAVE_HOLIDAY_DATE_REPEAT(102305,"节假日期重复"),

    //假期设置102401-102499
    HOLIDAY_TIME_REPEAT(102401,"假期时间重复"),
    HOLIDAY_IS_APPROVAL(102402,"假期已审批"),
    ;


    private Integer resultCode;
    private String desc;

    ResultCode(Integer resultCode, String desc) {
        this.resultCode = resultCode;
        this.desc = desc;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }}
