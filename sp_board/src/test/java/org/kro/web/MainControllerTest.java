package org.kro.web;

import static org.junit.Assert.*;

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
public class MainControllerTest {
	
	private static final Logger logger = LoggerFactory.getLogger(MainControllerTest.class);
	
	@Autowired
	private WebApplicationContext ac;
	
	private MockMvc moc;

	@Before
	public void setUp() throws Exception {
		this.moc = MockMvcBuilders.webAppContextSetup(ac).build();
		logger.info("setup..... ");
	}

	@Test
	public void test() throws Exception {
		moc.perform(MockMvcRequestBuilders.get("/doJSON").param("msg", "moc_test.."));
	}

}
