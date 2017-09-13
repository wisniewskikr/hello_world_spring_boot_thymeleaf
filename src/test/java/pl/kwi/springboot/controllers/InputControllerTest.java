package pl.kwi.springboot.controllers;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InputControllerTest {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@LocalServerPort
    protected int serverPort;
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();		
		wait = new WebDriverWait(driver, 20);
	}
	
	@After
	public void close() {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
			
		driver.get("http://localhost:" + serverPort + "/input");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text()='Page: Input']")));
		WebElement input = driver.findElement(By.id("name"));
		input.sendKeys("Chris");
		input.submit();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text()='Page: Output']")));
		WebElement output = driver.findElement(By.id("name"));
		assertEquals("Hello World Chris", output.getText());		
		driver.findElement(By.id("back")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text()='Page: Input']")));
		
	}

}
