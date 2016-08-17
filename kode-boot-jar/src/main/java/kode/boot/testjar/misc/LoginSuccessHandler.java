package kode.boot.testjar.misc;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登陆成功处理器
 * Created by Stark on 2016/8/17.
 *
 * @author Stark
 * @since 1.0
 */
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        Object object = authentication.getCredentials();
        System.out.println("!!!! LoginSuccessHandler.onAuthenticationSuccess");
        System.out.println(object);
        System.out.println("!!!! LoginSuccessHandler.onAuthenticationSuccess");

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
