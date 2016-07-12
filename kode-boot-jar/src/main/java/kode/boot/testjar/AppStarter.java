package kode.boot.testjar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Stark
 * @since 1.0, 2016/7/6
 */

@EnableAutoConfiguration
@SpringBootApplication
public class AppStarter {

	public static void main(String[] args) {
		SpringApplication.run(AppStarter.class, args);
	}
}
