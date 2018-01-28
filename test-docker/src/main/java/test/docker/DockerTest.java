package test.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * test.docker.DockerTest
 *
 * @author Stark
 * @date 2018/1/28
 */
@Controller
@SpringBootApplication
public class DockerTest {
	public static void main(String[] args) {
		SpringApplication.run(DockerTest.class, args);
	}

	@ResponseBody
	@RequestMapping("/hello")
	public String hello(@RequestParam(required = false, defaultValue = "tony") String name) {
		return "hello from " + name;
	}
}
