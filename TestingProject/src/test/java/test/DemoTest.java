package test;

import org.testng.annotations.Test;

import myLibrary.common;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DemoTest extends common{
	
	@Test
	public void testCostco() throws InterruptedException {
		driver.findElement(By.id("header_sign_in")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("logonId")).sendKeys("123123@gmail.com");
		driver.findElement(By.id("logonPassword")).sendKeys("123123");
		driver.findElement(By.className("primary")).click();;
		
	}
	
	@Test
	public void testCostco1() throws InterruptedException {
		driver.findElement(By.id("cart-d")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("footer-search-field")).sendKeys("123123@gmail.com");
		driver.findElement(By.id("footer-email-offers")).sendKeys("123123");
		driver.findElement(By.xpath("//*[@id=\"EmailOffersForm\"]/div/span/button")).click();
		
	}

}
