package kode.boot.testjar.security;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;

import java.util.Collection;

/**
 * 权限投票器
 *
 * @author Stark
 * @since 1.0
 */
//TODO: 能够使用精简的授权语句，如 @PreAuthority('koweb.user.create' or 'koweb.user.query')
public class CustomResourceVoter implements AccessDecisionVoter {

	@Override
	public boolean supports(ConfigAttribute attribute) {
		return false;
	}

	@Override
	public int vote(Authentication authentication, Object object, Collection collection) {
		return 0;
	}

	@Override
	public boolean supports(Class clazz) {
		return false;
	}
}
