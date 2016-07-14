package kode.boot.testjar.config;

import kode.boot.testjar.Application;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @version 1.0
 * @since 2016/7/7
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = Application.class)
public class ServletConfig extends WebMvcAutoConfiguration {

}
