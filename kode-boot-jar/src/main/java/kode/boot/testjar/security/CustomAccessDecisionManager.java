package kode.boot.testjar.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.vote.AbstractAccessDecisionManager;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

/**
 * 访问决策管理器
 * 在认证时，所有的权限都将封装到一个 GrantedAuthority 对象数组中。这是赋予给认证主体的权限。
 * GrantedAuthority 对象通过 AuthenticationManager 保存到 Authentication 对象中，
 * 然后从 AccessDecisionManager 中读取出来，进行授权判断。
 *
 * @author Stark
 * @since 1.0
 */
public class CustomAccessDecisionManager extends AbstractAccessDecisionManager implements AccessDecisionManager {

	private final Logger logger = LoggerFactory.getLogger(CustomAccessDecisionManager.class);

	public CustomAccessDecisionManager(List<AccessDecisionVoter<? extends Object>> decisionVoters) {
		super(decisionVoters);
	}

	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {

		if (configAttributes == null) {
			return;
		}

		for (ConfigAttribute ca : configAttributes) {
			String needed = ca.getAttribute();

			//ga 为用户所被赋予的权限。 needRole 为访问相应的资源应该具有的权限。
			for (GrantedAuthority ga : authentication.getAuthorities()) {
				if (needed.trim().equals(ga.getAuthority().trim())) {
					return;
				}
			}
		}

		throw new AccessDeniedException("Do not hold a required authorization");
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		logger.debug("===== CustomAccessDecisionManager.support(ConfigAttribute)");
		logger.debug("===== {}", attribute.toString());
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		logger.debug("===== CustomAccessDecisionManager.support(Class<?>)");
		logger.debug("===== {}", clazz.getName());
		return true;
	}
}
