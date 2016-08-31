package kode.boot.testjar.domain;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @version 1.0
 * @since 2016/8/30
 */
public class AppResourceTest {

	@Test
	public void staticFields() throws IllegalAccessException {
		Field[] fields = AppResource.class.getFields();
		Class<?> clazz = AppResource.class;
		for (Field f : fields) {
			String name = f.getName();
			String value = (String) f.get(null);
			System.out.println(f.getName() + " : " + value);
		}
	}

	@Test
	public void testResourceList() {
		System.out.println(AppResource.getResourceList());
		Assert.assertTrue(AppResource.getResourceList().size() > 0);
	}

	@Test
	public void from() throws Exception {
//		String str = AppResource.UserCreate.toString();
//		String str2 = AppResource.UserCreate.name();
//		System.out.println("toString: " + str);
//		System.out.println("name: " + str2);
//		AppResource auth = AppResource.from(str);
//		AppResource auth2 = AppResource.from(str2);
//		Assert.assertSame("toString", AppResource.UserCreate, auth);
//		Assert.assertSame("name", AppResource.UserCreate, auth2);
	}
}
