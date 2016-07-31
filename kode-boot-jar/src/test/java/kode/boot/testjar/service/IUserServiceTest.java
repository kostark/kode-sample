package kode.boot.testjar.service;

import kode.boot.testjar.ApplicationTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Stark
 * @since 1.0, 2016/7/28
 */
public class IUserServiceTest extends ApplicationTest {

	@Autowired
	IUserService userService;

	@Test
	public void countAllUser() throws Exception {
		int count = userService.countAllUser();
		Assert.assertEquals(count, 4);
	}

}