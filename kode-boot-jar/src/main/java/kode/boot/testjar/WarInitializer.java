package kode.boot.testjar;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 打包为 war 时的初始化器
 *
 * @author Stark
 * @since 1.0, 2016/7/12
 */
public class WarInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(AppStarter.class);
	}

}
