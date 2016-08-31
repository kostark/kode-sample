package kode.boot.testjar.service;

import kode.boot.testjar.domain.AppResource;
import kode.boot.testjar.domain.AppUser;
import kode.boot.testjar.mapper.AppUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * 用户服务实现
 *
 * @author Stark
 * @since 1.0, 2016/7/26
 */
@Service
public class AppUserServiceImpl extends AppBaseService implements AppUserService {

	@Autowired
	AppUserMapper appUserMapper;

	private static List<AppUser> userRepo = new ArrayList<>();

	@PostConstruct
	private void init() {
		logger.info("===== init user repo");

		AppUser user1 = new AppUser() {{
			setId(1L);
			setUsername("admin");
			setPassword("pass");
		}};

		AppUser user2 = new AppUser() {{
			setId(2L);
			setUsername("user");
			setPassword("pass");
		}};

		userRepo.add(user1);
		userRepo.add(user2);
	}

	@Override
	@PreAuthorize("hasAuthority('koweb.user.delete')")
	public int countAllUser() {
		int count = userRepo.size();
		logger.debug("{}: {}", "count", count);
		return count;
	}

	@Override
	public AppUser findUserByUsername(String username) {
		Optional<AppUser> user = userRepo.stream().filter(c -> c.getUsername().equals(username)).findFirst();
		if (user.isPresent())
			return user.get();
		else
			return null;
	}

	@Override
	public List<AppResource> findAuth(long userId) {
		if (userId == 1) {
			return Arrays.asList(
					AppResource.from(AppResource.USER_QUERY),
					AppResource.from(AppResource.USER_CREATE),
					AppResource.from(AppResource.USER_MODIFY),
					AppResource.from(AppResource.USER_DELETE),
					AppResource.from(AppResource.USERROLE_QUERY));
		} else if (userId == 2) {
			return Arrays.asList(
					AppResource.from(AppResource.USER_QUERY),
					AppResource.from(AppResource.USERROLE_QUERY));
		} else {
			return Collections.emptyList();
		}
	}
}
