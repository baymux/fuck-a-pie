package com.sjft.common;

/**
 * 通用常量信息
 *
 * @author lzg
 * @date 2020年8月10日18:00:34
 */
public class Constants {

    private Constants() {
    }

    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";

    public static final String ISO = "ISO-8859-1";

    /**
     * 登录成功
     */
    public static final String LOGIN_SUCCESS = "Success";

    /**
     * 注销
     */
    public static final String LOGOUT = "Logout";

    /**
     * 登录失败
     */
    public static final String LOGIN_FAIL = "Error";

    /**
     * 通用成功标识
     */
    public static final int SUCCESS = 200;

    /**
     * 通用失败标识
     */
    public static final int FAIL = 500;

    /**
     * 验证码 redis key
     */
    public static final String CAPTCHA_CODE_KEY = "captcha_codes:";

    /**
     * 登录用户 redis key
     */
    public static final String LOGIN_TOKEN_KEY = "login_tokens:";

    /**
     * 验证码有效期（分钟）
     */
    public static final Integer CAPTCHA_EXPIRATION = 2;

    /**
     * 令牌
     */
    public static final String TOKEN = "token";

    /**
     * 令牌前缀
     */
    public static final String TOKEN_PREFIX = "Bearer ";

    /**
     * 令牌前缀
     */
    public static final String LOGIN_USER_KEY = "login_user_key";

    /**
     * 用户权限
     */
    public static final String JWT_AUTHORITIES = "authorities";

    /**
     * 资源映射路径 前缀
     */
    public static final String RESOURCE_PREFIX = "/profile";

    /**
     * 路径分隔符
     */
    public static final String SLASH_DELIMITER = "/";

    public static final String SPACE_DELIMITER = " ";

    /**
     * 逗号分隔符
     */
    public static final String COMMA_SEPARATION = ",";

    /**
     * 逗号分隔符
     */
    public static final String UNDERLINE_SEPARATION = "_";

    /**
     * 白名单key
     */
    public static final String WHITE_KEY = "WHITE";

    /**
     * jasypt 加密盐值
     */
    public static final String JASYPT_SALT = "sjft";

    /**
     * 消息保存redis key
     */
    public static final String RE_MSG_KEY_PREFIX = "id:";

    /**
     * 透传标识位 1
     */
    public static final String PENETRATE_MARK_1 = "AA AA";
    /**
     * 透传标识位 1
     */
    public static final String PENETRATE_MARK_2 = "BB BB";

    /**
     * 心跳标识
     */
    public static final String HEARTBEAT_MARK = "AAAAAAAA";


}
