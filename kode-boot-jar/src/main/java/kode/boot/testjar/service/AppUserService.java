package kode.boot.testjar.service;

import kode.boot.testjar.domain.AppAuth;
import kode.boot.testjar.domain.AppUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Stark
 * @since 1.0, 2016/7/26
 */
@Service
public interface AppUserService {

	int countAllUser();

	AppUser findUserByUsername(String username);

	List<AppAuth> findAuth(long userId);
}
