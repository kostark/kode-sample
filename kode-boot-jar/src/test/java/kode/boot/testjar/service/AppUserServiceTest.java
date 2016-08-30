package kode.boot.testjar.service;

import kode.boot.testjar.ApplicationTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Stark
 * @since 1.0, 2016/7/28
 */
public class AppUserServiceTest extends ApplicationTest {

	@Autowired
	AppUserService appUserService;

	@Test
	public void countAllUser() throws Exception {
		int count = appUserService.countAllUser();
		Assert.assertEquals(count, 4);
	}

}