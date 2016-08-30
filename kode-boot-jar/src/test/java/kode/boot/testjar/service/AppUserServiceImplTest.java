package kode.boot.testjar.service;

import kode.boot.testjar.Application;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Stark on 2016/8/30.
 *
 * @author Stark
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class AppUserServiceImplTest {

	@Autowired
	AppUserService appUserService;

	@Test
	public void countAllUser() throws Exception {
		int count = appUserService.countAllUser();
		Assert.assertEquals(count, 2);
	}
}