package kode.boot.testjar.security;

import kode.boot.testjar.domain.AppAuth;
import kode.boot.testjar.domain.AppUser;
import kode.boot.testjar.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Stark on 2016/8/17.
 *
 * @author Stark
 * @since 1.0
 */
@Service
public class CustomUserDetailService implements UserDetailsService {

	private AppUserService appUserService;

	@Autowired
	public CustomUserDetailService(AppUserService appUserService) {
		this.appUserService = appUserService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser user = appUserService.findUserByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException("didn't found user with name '" + username + "'");

		List<AppAuth> auth = appUserService.findAuth(user.getId());
		return new User(user.getUsername(), user.getPassword(), true, true, true, true, auth);
	}
}
