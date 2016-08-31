package kode.boot.testjar.domain;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 权限编码
 *
 * @version 1.0
 * @since 2016/8/30
 */
@SuppressWarnings("unused")
public final class AppResource implements Serializable, GrantedAuthority {

	//region 用户相关

	/** 用户查询 */
	public static final String USER_QUERY = "koweb.user.query";
	/** 用户创建 */
	public static final String USER_CREATE = "koweb.user.create";
	/** 用户修改 */
	public static final String USER_MODIFY = "koweb.user.modify";
	/** 用户删除 */
	public static final String USER_DELETE = "koweb.user.delete";

	/** 用户角色查询 */
	public static final String USERROLE_QUERY = "koweb.userrole.query";
	/** 用户角色创建 */
	public static final String USERROLE_CREATE = "koweb.userrole.create";
	/** 用户角色修改 */
	public static final String USERROLE_MODIFY = "koweb.userrole.modify";
	/** 用户角色删除 */
	public static final String USERROLE_DELETE = "koweb.userrole.delete";

	//endregion

	private static final List<String> RESOURCE_LIST = new ArrayList<>();

	static {
		Field[] fields = AppResource.class.getFields();
		for (Field field : fields) {
			try {
				RESOURCE_LIST.add((String) field.get(null));
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	private String code;

	private AppResource(String code) {
		this.code = code;
	}

	/** Only for test */
	static List<String> getResourceList() {
		return RESOURCE_LIST;
	}

	/**
	 * get resource identity code
	 *
	 * @return code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * from code to AppResource object
	 *
	 * @param code code
	 * @return AppResource object
	 */
	public static AppResource from(String code) {
		if (RESOURCE_LIST.contains(code)) {
			return new AppResource(code);
		} else {
			throw new IllegalArgumentException("No AppResource constant can convert from " + code);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (null == o) return false;
		if (this == o) return true;
		if (o instanceof AppResource) {
			AppResource that = (AppResource) o;
			return getCode().equals(that.getCode());
		} else {
			return getCode().equals(o.toString());
		}
	}

	@Override
	public int hashCode() {
		return getCode().hashCode();
	}

	@Override
	public String toString() {
		return code;
	}

	public String getAuthority() {
		return code;
	}
}
