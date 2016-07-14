package kode.boot.testjar.controller;

import kode.boot.testjar.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @version 1.0
 * @since 2016/7/7
 */
@Controller
@RequestMapping(value = "api")
public class ApiUserController {

	@RequestMapping("/test/{user}")
	@ResponseBody
	public String getUser(@PathVariable String user) {
		return "username:" + user + ". welcome!";
	}

	@ResponseBody
	@RequestMapping(params = {"method=api.user.get"})
	public User getUserInfo(HttpServletRequest request) {
		User user = new User();
		user.setId(1);
		user.setName("Stark Ko");
		user.setUsername("stark");
		user.setBirthday(new Date());

		return user;
	}

}
