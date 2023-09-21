package com.NaserGharbieh.Authentication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class AuthenticationApplicationTests {
	@Autowired
	MockMvc mockMvc;
	@Test
	void testHomePage()throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/"))
				.andDo(print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(containsString("<h1> Authentication with Bcrypt Spring MVC App</h1>")))
				.andExpect(MockMvcResultMatchers.content().string(containsString("<h2>Available Routes:</h2>")))
				.andExpect(MockMvcResultMatchers.content().string(containsString("<li><a href=\"/posts\">/posts</a> <ul> <li> <b> Avilable for only loged in users </b></li>")));
	}
	@Test
	void testPostsPageRediectToLoginForNotlogedinUser()throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/posts"))
				.andDo(print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(containsString("<h1>Please log in!</h1>")));


	}

	@Test
	void contextLoads() {
	}

}
