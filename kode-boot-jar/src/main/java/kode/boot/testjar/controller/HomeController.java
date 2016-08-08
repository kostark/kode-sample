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

    //从配置文件中读取配置
    @Value("${name}")
    private String name;

    @Value("${desc}")
    private String desc;

    @Value("${test:defaultTestValue}")
    private String test;

/*	@Autowired
    IUserService userService;

	@Autowired
	DataSource dataSource;*/

    @RequestMapping("/")
    String home(Model model) {
        model.addAttribute("message", "Hello world! <br/>"
                + "desc: " + desc + "<br/>" +
                "test: " + test);
//		model.addAttribute("userCount", userService.countAllUser());
        return "index";
    }

    @RequestMapping("test")
    String test(Model model) {
        model.addAttribute("message", "Hello world! ============== test sample ||| " + desc + " | test = " + test + " | devName = ");
        return "test";
    }
}
