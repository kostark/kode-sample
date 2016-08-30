package kode.boot.testjar;

import kode.boot.testjar.config.DataConfig;
import kode.boot.testjar.config.ServletConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.Arrays;

/**
 * 应用起始类，SpringBootServletInitializer 是为了支持 war 包启动。
 *
 * @author Stark
 * @since 1.0, 2016/7/6
 */
@EnableAutoConfiguration
@SpringBootApplication
@Import({ServletConfig.class, DataConfig.class, ServletConfig.class})
public class Application extends SpringBootServletInitializer implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return super.configure(builder);
	}

	public static void main(String[] args) {

		ApplicationContext app = new SpringApplicationBuilder(Application.class)
				.bannerMode(Banner.Mode.OFF)
				.build()
				.run(args);

		String[] beanNames = app.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String bean : beanNames) {
			logger.info(bean);
		}
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
