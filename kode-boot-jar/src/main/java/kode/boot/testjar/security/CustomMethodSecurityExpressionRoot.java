package kode.boot.testjar.security;

import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 自定义权限表达式处理器
 * 必须集成
 *
 * @author Stark
 * @since 1.0
 */
public class CustomMethodSecurityExpressionRoot extends SecurityExpressionRoot implements MethodSecurityExpressionOperations {

	private Object filterObject;
	private Object returnObject;
	private Object target;
	private Set<String> roles;

	/**
	 * Creates a new instance
	 *
	 * @param authentication the {@link Authentication} to use. Cannot be null.
	 */
	public CustomMethodSecurityExpressionRoot(Authentication authentication) {
		super(authentication);
	}

	public boolean has(String permission) {
		return getAuthoritySet().contains(permission);
	}

	private Set<String> getAuthoritySet() {
		if (roles == null) {
			roles = new HashSet<>();
			Collection<? extends GrantedAuthority> userAuthorities = authentication.getAuthorities();

			roles = AuthorityUtils.authorityListToSet(userAuthorities);
		}

		return roles;
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

	void setThis(Object target) {
		this.target = target;
	}

	public Object getThis() {
		return target;
	}
}
