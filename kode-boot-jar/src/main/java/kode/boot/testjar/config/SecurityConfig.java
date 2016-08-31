package kode.boot.testjar.config;

import kode.boot.testjar.security.CustomAccessDecisionManager;
import kode.boot.testjar.security.CustomSecurityInterceptor;
import kode.boot.testjar.security.CustomSecurityMetadataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.ExpressionBasedFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.Collection;
import java.util.LinkedHashMap;

/**
 * 安全信息配置
 * Created by Stark on 2016/8/16.
 *
 * @author Stark
 * @since 1.0
 */
@Configuration
@EnableWebSecurity // 开启安全验证
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true, securedEnabled = true) // 开启全局方法安全验证
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;


	@Bean
	public CustomAccessDecisionManager accessDecisionManager() {
		return new CustomAccessDecisionManager();
	}

	@Bean
	public CustomSecurityInterceptor securityInterceptor() throws Exception {
		CustomSecurityInterceptor interceptor = new CustomSecurityInterceptor();
		interceptor.setAccessDecisionManager(accessDecisionManager());

		interceptor.setAuthenticationManager(getAuthenticationManager());
		interceptor
				.setAccessDecisionManager(accessDecisionManager());
		interceptor.setRunAsManager(runAsManager());
		LinkedHashMap<RequestMatcher, Collection> requestMap = new LinkedHashMap<RequestMatcher, Collection>();

		requestMap.put(new AntPathRequestMatcher("/user/**"),
				SecurityConfig.createList("hasRole('" + UserAuth.ROLE_CANDIDATE.name() + "')"));
		requestMap.put(new AntPathRequestMatcher("/recruiter/**"),
				SecurityConfig.createList("hasRole('" + UserAuth.ROLE_RECRUITER.name() + "')"));
		requestMap.put(new AntPathRequestMatcher("/admin/**"),
				SecurityConfig.createList("hasRole('" + UserAuth.ROLE_ADMIN.name() + "')"));
		FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource =
				new CustomSecurityMetadataSource(requestMap, new DefaultWebSecurityExpressionHandler());
		interceptor
				.setSecurityMetadataSource(filterInvocationSecurityMetadataSource);
		interceptor.afterPropertiesSet();

		return interceptor;
	}

	@Bean
	public CustomSecurityMetadataSource securityMetadataSource() {
		return new CustomSecurityMetadataSource();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// 开启调试信息
		// web.debug(true);

		// 过滤对应匹配路径下的请求，优于 HttpSecurity 中用拦截路径来过滤
		web.ignoring().antMatchers("/webjars/**",
				"/resources/**",
				"/static/**",
				"/**/*.ico");
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

				.addFilterAt(securityInterceptor(), FilterSecurityInterceptor.class)

                /*
				.antMatcher("")
                .requestMatchers()
                    .antMatchers("")
                .and()
                */


				// 请求授权
				.authorizeRequests().accessDecisionManager(accessDecisionManager())
//                    .antMatchers("/", "/home", "/test").permitAll()
				.anyRequest().authenticated()
				.expressionHandler(null)


				// form 登陆，必须保证登陆页面
				.and().formLogin()
				.loginPage("/login").permitAll()

				.and().exceptionHandling()
				.accessDeniedPage("/access_denied")

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
				.http(8080).mapsTo(8443)
				.http(80).mapsTo(443)

				// session 管理
				.and().sessionManagement()
				.maximumSessions(1);

		// @formatter:on
	}

	@Autowired
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// @formatter:off
		//auth.inMemoryAuthentication().withUser("u").password("p");
		auth.userDetailsService(userDetailsService);
		// @formatter:on
	}
}
