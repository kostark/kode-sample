package kode.boot.testjar;

import kode.boot.testjar.config.ServletConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

/**
 * 应用起始类，SpringBootServletInitializer 是为了支持 war 包启动。
 *
 * @author Stark
 * @since 1.0, 2016/7/6
 */
@EnableAutoConfiguration
@SpringBootApplication
@Import({ServletConfig.class})
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return super.configure(builder);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
