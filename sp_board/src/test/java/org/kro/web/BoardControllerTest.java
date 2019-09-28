package org.kro.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:config/spring/*.xml"})
public class BoardControllerTest {
	
@Autowired
WebApplicationContext wac;
MockMvc mockMvc;

private static Logger logger = LoggerFactory.getLogger(BoardControllerTest.class);

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		logger.info("setup .. mockMvc");
	}

	@Test
	public void testListPage() throws Throwable {
		mockMvc.perform(MockMvcRequestBuilders.get("/board/listPage"));
		logger.info("lostAll");
	}

}
