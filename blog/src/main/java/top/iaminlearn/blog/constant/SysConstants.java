package top.iaminlearn.blog.constant;

/**
 * 系统常量
 */
public class SysConstants {

    // ------------------------------------------------ 用户常量 ------------------------------------------------------------------------
    public static final String DEFAULT_AVATAR = "https://iaminlearn-mall-oss.oss-cn-hangzhou.aliyuncs.com/mall/images/300%20%281%29.jpg";

    /**
     * 用户默认密码
     */
    public static final String DEFAULT_PASSWORD = "123456";
    /**
     * 令牌
     */
    public static final String TOKEN = "token";

    /**
     * 验证码有效期（分钟）
     */
    public static final Integer CAPTCHA_EXPIRATION = 2;
    /**
     * 登录用户 redis key
     */
    public static final String LOGIN_TOKEN_KEY = "login_tokens:";

    /**
     * 登录用户key
     */
    public static final String SIGN_KEY = "login_user_key";

    /**
     * 令牌前缀
     */
    public static final String TOKEN_PREFIX = "Bearer ";



}
