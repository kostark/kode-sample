package kode.boot.testjar.service;

import kode.boot.testjar.domain.AppResource;
import kode.boot.testjar.domain.AppUser;

import java.util.List;

/**
 * @author Stark
 * @since 1.0, 2016/7/26
 */
public interface AppUserService {

	int countAllUser();

	AppUser findUserByUsername(String username);

	List<AppResource> findAuth(long userId);
}
