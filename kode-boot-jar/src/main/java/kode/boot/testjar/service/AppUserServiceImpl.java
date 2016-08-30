package kode.boot.testjar.service;

import kode.boot.testjar.mapper.AppUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public int countAllUser() {
		int count = appUserMapper.countAllUser();
		logger.debug("{0}: {1}", "count", count);
		return count;
	}
}
