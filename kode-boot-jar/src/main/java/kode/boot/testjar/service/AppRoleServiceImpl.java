package kode.boot.testjar.service;

import kode.boot.testjar.domain.AppAuth;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 角色服务实现
 *
 * @version 1.0
 * @since 2016/8/30
 */
@Service
public class AppRoleServiceImpl extends AppBaseService implements AppRoleService {
	@Override
	public List<AppAuth> getAuthByRoleId(long roleId) {
		return Arrays.asList(AppAuth.UserCreate, AppAuth.UserModify);
	}
}
