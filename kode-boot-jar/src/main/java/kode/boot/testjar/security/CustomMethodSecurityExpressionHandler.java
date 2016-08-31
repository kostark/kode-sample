package kode.boot.testjar.security;

import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

/**
 * 自定义权限表达式处理器
 * 必须集成
 *
 * @author Stark
 * @since 1.0
 */
public class CustomMethodSecurityExpressionHandler extends DefaultWebSecurityExpressionHandler implements MethodSecurityExpressionOperations {

	private Object filterObject;
	private Object returnObject;
	private Object target;

	/**
	 * Creates a new instance
	 *
	 * @param authentication the {@link Authentication} to use. Cannot be null.
	 */
	public CustomMethodSecurityExpressionHandler(Authentication authentication) {
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

	@Override
	public Authentication getAuthentication() {
		return null;
	}

	@Override
	public boolean hasAuthority(String authority) {
		return false;
	}

	@Override
	public boolean hasAnyAuthority(String... authorities) {
		return false;
	}

	@Override
	public boolean hasRole(String role) {
		return false;
	}

	@Override
	public boolean hasAnyRole(String... roles) {
		return false;
	}

	@Override
	public boolean permitAll() {
		return false;
	}

	@Override
	public boolean denyAll() {
		return false;
	}

	@Override
	public boolean isAnonymous() {
		return false;
	}

	@Override
	public boolean isAuthenticated() {
		return false;
	}

	@Override
	public boolean isRememberMe() {
		return false;
	}

	@Override
	public boolean isFullyAuthenticated() {
		return false;
	}

	@Override
	public boolean hasPermission(Object target, Object permission) {
		return false;
	}

	@Override
	public boolean hasPermission(Object targetId, String targetType, Object permission) {
		return false;
	}
}
