package kode.boot.testjar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
