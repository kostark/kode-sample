package kode.boot.testjar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @version 1.0
 * @since 2016/7/7
 */
@Controller
@RequestMapping(value = "rest")
public class ApiUserController {

	@RequestMapping("/test/{user}")
	@ResponseBody
	public String getUser(@PathVariable String user) {
		return "username:" + user + ". welcome!";
	}

	@ResponseBody
	@RequestMapping(params = {"method=api.user.get"})
	public String getUserInfo(HttpServletRequest request) {
		return "api.user.get";
	}

}
