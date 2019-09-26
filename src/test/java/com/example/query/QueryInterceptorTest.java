package com.example.query;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
@RunWith(SpringRunner.class)
public class QueryInterceptorTest {

	@Autowired MockMvc mockMvc;

	@Autowired QueryInterceptor interceptor;

	@Test
	public void works() throws Exception {
		mockMvc.perform(get("/foo?param=bar"));
		assertThat(interceptor.getQueryString(), is("param=bar"));
	}

	@Test
	public void fails() throws Exception {
		mockMvc.perform(get("/foo").param("param", "bar"));
		assertThat(interceptor.getQueryString(), is("param=bar"));
	}
}