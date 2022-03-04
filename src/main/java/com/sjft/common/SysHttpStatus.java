package com.sjft.common;

/**
 * @ClassName SysHttpStatus
 * @Description 系统http状态
 * @Author Mr.Baiyy
 * @Date 2020/12/16 16:08
 * @version 1.0
 **/
public enum SysHttpStatus {

    SYSTEM_IS_BUSY(10001, "提示：操作频繁，请稍后再试"),
    SYSTEM_IS_ERROR(10002, "提示：系统错误，请稍后再试"),

    OK(20000, "OK"),

    DATA_SOURCE_CONNECTION_FAILED(20001, "无法连接服务器，请检查IP、主机名、端口填写是否正确，检查网络安全组和防火墙配置是否正确，参考数据库返回消息connect timed out (Cdm.0941)"),
    UNSUPPORTED_DATA_SOURCE_TYPE(20002, "不支持的数据源类型,当前数据原支持 mysql"),


    SOURCE_DATABASES_NOT_EXIST(20003, "源端库不存在"),
    TARGET_DATABASES_NOT_EXIST(20003, "目标库不存在"),



    SYS_EXCEPTION(40001, "system exception"),
    PARAMETER_ERROR(40002, "请求参数错误"),
    QUERY_ERROR(40003, "查询错误"),
    API_NOT_EXIST(40004, "当前API不存在"),
    REQUEST_METHOD_ERROR(40005, "Request method error"),
    API_GROUP_NOT_EXIST(40006, "API 分组不存在"),
    JOB_IS_RUNNING(40007, "当前作业正在运行"),
    GROUP_DOSE_NOT_MATCH(40008, "当前分组不匹配"),
    API_KEY_VERIFICATION_FAILED(40009, "API KEY 验证不通过"),
    API_KEY_IS_DOWNLOAD(40010, "API KEY 已经下载,不支持绑定"),
    API_KEY_IS_BINDING(40011, "API KEY 已经绑定目录"),

    IP_NOT_EXIST_WHITELIST(40012, "ip错误（ip不在白名单中），请联系系统管理员添加白名单"),

    INTERNAL_SERVER_ERROR(50000, "当前作业正在运行");


    private final int value;
    private final String reasonPhrase;

    private SysHttpStatus(int value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    public int value() {
        return this.value;
    }

    public String getReasonPhrase() {
        return this.reasonPhrase;
    }
}
