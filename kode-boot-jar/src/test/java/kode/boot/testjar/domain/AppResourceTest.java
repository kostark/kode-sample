package kode.boot.testjar.domain;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

	@Test
	public void testCompare() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");

		List<Integer> list = Arrays.asList(1, 2, 3, 8, 7, 64, 9, 0, 12, 7, 3, 834, 5);
		list = list.stream().sorted((a, b) -> {
			if (a > b) return 1;
			if (a < b) return -1;
			else return 0;
		}).collect(Collectors.toList());
		System.out.println(list);
	}

	@Test
	public void testDateCompare() throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");

		Date dt1 = df.parse("20130101"), dt2 = df.parse("20160910");
		System.out.println("20130101 before 20160910: " + dt1.before(dt2));
		System.out.println("20130101 after 20160910: " + dt1.after(dt2));


		List<Date> list = Arrays.asList(
				df.parse("20130101"),
				df.parse("20140305"),
				df.parse("20100618"),
				df.parse("20160910"),
				df.parse("20150607")
		);

		list = list.stream().sorted((a, b) -> {
			if (a.before(b)) return 1;
			if (a.after(b)) return -1;
			else return 0;
		}).collect(Collectors.toList());
		System.out.println(list);
	}
}
