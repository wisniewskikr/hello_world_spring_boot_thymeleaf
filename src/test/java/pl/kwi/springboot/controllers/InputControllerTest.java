package pl.kwi.springboot.controllers;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.kwi.springboot.Application;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest(value = "server.port=9000")
@SeleniumTest(driver = ChromeDriver.class, baseUrl = "http://localhost:9000")
public class InputControllerTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
