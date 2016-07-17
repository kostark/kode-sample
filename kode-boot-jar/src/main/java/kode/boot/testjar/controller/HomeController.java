package kode.boot.testjar.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @version 1.0
 * @since 2016/7/7
 */
@Controller
public class HomeController {

	//从配置文件中读取配置
	@Value("${name}")
	private String name;

	@Value("${desc}")
	private String desc;

	@Value("${test:defaultTestValue}")
	private String test;


	@RequestMapping("/")
	String home(Model model) {
		model.addAttribute("message", "Hello world! <br/>"
				+ "desc: " + desc + "<br/>" +
				"test: " + test);
		return "index";
	}

	@RequestMapping("test")
	String test(Model model) {
		model.addAttribute("message", "Hello world! ============== test sample ||| " + desc + " | test = " + test + " | devName = ");
		return "test";
	}

	String sample(
			@NotNull
			@Min(0)
					Long id,
			@NotNull
			@Future
					Date date) {
		return "";
	}

}
