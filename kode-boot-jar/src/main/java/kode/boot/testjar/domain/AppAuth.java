package kode.boot.testjar.domain;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Optional;

/**
 * 权限编码
 *
 * @version 1.0
 * @since 2016/8/30
 */
public enum AppAuth implements Serializable, GrantedAuthority {

    //region 用户相关

    UserQuery("user.query", "查询用户"),
    UserCreate("user.create", "创建用户"),
    UserModify("user.modify", "修改用户"),
    UserDelete("user.delete", "删除用户"),

    UserRoleQuery("user_role.query", "查询角色"),
    UserRoleCreate("user_role.create", "创建角色"),
    UserRoleModify("user_role.modify", "修改角色"),
    UserRoleDelete("user_role.delete", "删除角色"),

    //endregion
    ;


    private String code;
    private String desc;

    private AppAuth(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return name();
    }

    /**
     * 从枚举名或者编码转成 AppAuth 对象
     *
     * @param s 转换的字符串
     */
    public static AppAuth from(String s) {
        try {
            return valueOf(s);
        } catch (Exception ignored) {
        }

        Optional<AppAuth> optional = Arrays.stream(values()).filter(c -> c.getCode().equals(s)).findFirst();
        if (optional.isPresent())
            return optional.get();

        throw new IllegalArgumentException("No AppAuth constant can convert from " + s);
    }

    @Override
    public String toString() {
        return code;
    }

    public String getAuthority() {
        return code;
    }
}
