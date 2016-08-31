package kode.boot.testjar.security;

import kode.boot.testjar.domain.AppAuth;
import kode.boot.testjar.domain.AppUser;
import kode.boot.testjar.service.AppUserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 自定义用户服务
 * 主要作用是为 Spring Security 提供一个经过用户认证后的 UserDetails。
 * 该 UserDetails 包括用户名、密码、是否可用、是否过期等信息。
 *
 * @author Stark
 * @since 1.0
 */
@Component
public class CustomUserDetailService implements UserDetailsService {

	private AppUserService appUserService;

	public CustomUserDetailService(AppUserService userService) {
		this.appUserService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser user = appUserService.findUserByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException("didn't found user with name '" + username + "'");

		List<AppAuth> auth = appUserService.findAuth(user.getId());
		return new User(user.getUsername(), user.getPassword(), true, true, true, true, auth);
	}

	public AppUserService getAppUserService() {
		return appUserService;
	}

	public void setAppUserService(AppUserService appUserService) {
		this.appUserService = appUserService;
	}
}
