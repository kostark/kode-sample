package kode.boot.testjar.domain;

import org.junit.Assert;
import org.junit.Test;

/**
 * @version 1.0
 * @since 2016/8/30
 */
public class AppAuthTest {

	@Test
	public void from() throws Exception {
		String str = AppAuth.UserCreate.toString();
		String str2 = AppAuth.UserCreate.name();
		System.out.println("toString: " + str);
		System.out.println("name: " + str2);
		AppAuth auth = AppAuth.from(str);
		AppAuth auth2 = AppAuth.from(str2);
		Assert.assertSame("toString", AppAuth.UserCreate, auth);
		Assert.assertSame("name", AppAuth.UserCreate, auth2);
	}
}
