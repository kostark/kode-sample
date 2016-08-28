package kode.boot.testjar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Stark on 2016/8/16.
 * <p>
 * <pre>
 *
 *     <http auto-config="true">
 *
 *     </http>
 *
 *
 *
 * </pre>
 *
 * @author Stark
 * @since 1.0
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 开启调试信息
        web.debug(true);

        // 过滤对应匹配路径下的请求，优于 HttpSecurity 中用拦截路径来过滤
        web.ignoring().antMatchers("/webjars/**", "/resources/**", "/static/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 该方法用来配置 HttpSecurity，不要调用 super.configure(http)，否则有可能覆盖自定义配置

        // 首行引入对应过滤器，缩进进行配置
        // @formatter:off
        http
                //关闭 csrf（跨站点请求伪造保护） 支持
                .csrf()
                    .disable()

                /*
                .antMatcher("")
                .requestMatchers()
                    .antMatchers("")
                .and()
                */

                // 请求授权
                .authorizeRequests()
                    .antMatchers("/", "/home").permitAll()
                    .anyRequest().authenticated()

                // form 登陆
                .and().formLogin()
                    .loginPage("/login").permitAll()

                // 退出过滤器
                .and().logout()
                    .permitAll()

                // 开启记住登陆
                .and().rememberMe()

                // 要求特定通道
                .and().requiresChannel()
                    .anyRequest().requiresSecure()

                // 配置端口隐射
                .and().portMapper()
                    .http(8000).mapsTo(8443)
                    .http(80).mapsTo(443)

                // session 管理
                .and().sessionManagement()
                    .maximumSessions(1);

        // @formatter:on
    }

    @Autowired
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //@formatter:off
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
        //@formatter:on
    }
}
