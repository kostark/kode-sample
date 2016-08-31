package kode.boot.testjar.security;

import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;

/**
 * 自定义权限表达式处理器
 * 必须集成
 *
 * @author Stark
 * @since 1.0
 */
public class CustomMethodSecurityExpressionOperations extends SecurityExpressionRoot implements MethodSecurityExpressionOperations {

	private Object filterObject;
	private Object returnObject;
	private Object target;

	/**
	 * Creates a new instance
	 *
	 * @param authentication the {@link Authentication} to use. Cannot be null.
	 */
	public CustomMethodSecurityExpressionOperations(Authentication authentication) {
		super(authentication);
	}

	public boolean has(String permission) {
		if ("user.edit".equals(permission))
			return true;
		else
			return false;
	}

	public void setFilterObject(Object filterObject) {
		this.filterObject = filterObject;
	}

	public Object getFilterObject() {
		return filterObject;
	}

	public void setReturnObject(Object returnObject) {
		this.returnObject = returnObject;
	}

	public Object getReturnObject() {
		return returnObject;
	}

	public Object getThis() {
		return target;
	}
}
