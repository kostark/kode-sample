package kode.boot.testjar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Stark
 * @since 1.0, 2016/7/6
 */
@RestController
@EnableAutoConfiguration
public class Application {

	@RequestMapping("/")
	String home() {
		return "Hello world! cccc";
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
