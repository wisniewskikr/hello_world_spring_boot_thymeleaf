package pl.kwi.springboot.controllers;

import java.io.File;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class InputControllerTest {

	@Test
	public void test() throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver(new FirefoxBinary(new File(
				"C:\\java\\FF\\firefox.exe")), new FirefoxProfile());
		
		driver.get("http://localhost:8080/input");
		WebElement input = driver.findElement(By.id("name"));
		input.sendKeys("Chris");
		input.submit();
		WebElement output = driver.findElement(By.id("name"));
		assertEquals("Hello World Chris", output.getText());
		
		driver.quit();
		
	}

}
