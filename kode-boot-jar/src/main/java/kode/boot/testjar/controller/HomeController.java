package kode.boot.testjar.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @version 1.0
 * @since 2016/7/7
 */
@Controller
public class HomeController {

	@Value("${name}")
	private String name;

	@Value("${desc}")
	private String desc;

	@Value("${test:defaultTestValue}")
	private String test;


	@RequestMapping("/")
	String home(Model model) {
		model.addAttribute("message", "Hello world! " + desc + " | test = " + test + " | devName = ");
		return "index";
	}
}
