package kode.boot.testjar.controller;

import kode.boot.testjar.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.PermitAll;
import javax.sql.DataSource;
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

	private AppUserService appUserService;

	private DataSource dataSource;

	@Autowired
	public HomeController(AppUserService appUserService, DataSource dataSource) {
		this.appUserService = appUserService;
		this.dataSource = dataSource;
	}

    @RequestMapping("/")
    String home(Model model) {
        model.addAttribute("message", "Hello world! <br/>"
                + "desc: " + desc + "<br/>" +
                "test: " + test);
//        model.addAttribute("userCount", userService.countAllUser());
        model.addAttribute("date", new Date());

        model.addAttribute("userStatus", userService.getUserStatus(3));

        return "index";
    }

    @PermitAll
    @RequestMapping("test")
    String test(Model model) {
        model.addAttribute("message", "Hello world! ============== test sample ||| " + desc + " | test = " + test + " | devName = ");
        return "test";
    }

    @RequestMapping("access_denied")
    String accessDenied(Model model) {
        model.addAttribute("message", "您无此权限，请求被拒绝。");
        return "test";
    }

    @RequestMapping("hello")
    String hello() {
        return "test";
    }

	@RequestMapping("login")
	String login() {
		return "login";
	}

	@RequestMapping("create")
	@Secured("")
	String create() {
		return "test";
	}
}
