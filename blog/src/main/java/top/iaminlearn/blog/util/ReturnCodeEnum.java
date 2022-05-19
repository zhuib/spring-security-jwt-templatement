package top.iaminlearn.blog.util;

/**
 * 错误状态码enum
 */
public enum ReturnCodeEnum {

    // 200，通用操作成功 3xx，资源重定向 4xx，客户端错误 500，通用操作失败
    SUCCESS(200, "操作成功"),
    UNAUTHORIZED(401, "没有权限，请联系管理员授权"),
    FORBIDDEN(403, "认证失败，请联系管理员授权"),
    NOT_FOUND(404, "路径不存在，请检查路径是否正确"),
    ERROR(500, "操作失败"),
    USER_ACCOUNT_PASSWORD_ERROR(5102, "用户账号或密码错误"),
    CUSTOM_ERROR(5000, ""),
    USER_NOT_EXISTS_ERROR(5101, "用户不存在"),
    /**
     * 4xxx，参数类型错误
     */
    PARAMETER_MISS_ERROR(4001, "参数缺失"),
    PARAMETER_TYPE_ERROR(4002, "参数类型错误"),


    LOGOUT(200,"注销成功" );
    private int code;
    private String msg;

    ReturnCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public ReturnCodeEnum setMsg(String msg) {
        this.msg = msg;
        return this;
    }


}
