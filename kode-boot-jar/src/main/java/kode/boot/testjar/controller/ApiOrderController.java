package kode.boot.testjar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @version 1.0
 * @since 2016/7/7
 */
@Controller
@RequestMapping("api")
public class ApiOrderController {

    @ResponseBody
    @RequestMapping(params = {"method=api.order.get"})
    public String getUserInfo(HttpServletRequest request) {
        return "api.order.get";
    }

}
