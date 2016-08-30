package kode.boot.testjar.controller;

import kode.boot.testjar.ApplicationTest;
import kode.boot.testjar.service.AppUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Stark on 2016/8/30.
 *
 * @author Stark
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
public class HomeControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private AppUserService userService;

	@Test
	public void testExample() throws Exception {
		given(this.userService.countAllUser()).willReturn(2);
		mvc.perform(get("/hello").accept(MediaType.TEXT_PLAIN)).andExpect(status().isUnauthorized());
	}

}