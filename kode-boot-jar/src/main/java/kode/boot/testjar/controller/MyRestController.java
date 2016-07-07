package kode.boot.testjar.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @since 2016/7/7
 */
@RestController
@RequestMapping("/user")
public class MyRestController {

	@RequestMapping("/{user}")
	public String getUser(@PathVariable String user) {
		return "username:" + user + ". welcome!";
	}

}
