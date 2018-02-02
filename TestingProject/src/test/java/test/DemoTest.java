package test;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import library.common;

public class DemoTest extends common{
	
	@Test
	public void testWalmart() throws InterruptedException {
		Actions move = new Actions(driver);
		move.moveToElement(driver.findElement(By.id("header-GlobalAccountFlyout-flyout-link")));
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#header-GlobalAccountFlyout-flyout-link > div.header-GlobalAccountFlyout-customerName.dropdown-link"));
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/section/form/div[1]/div/label/div[2]/div/input")).sendKeys("21312@gmail.com");
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/section/form/div[2]/div/div[1]/label/div[2]/div/input")).sendKeys("123");
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/section/form/div[5]/button")).click();
	}

}
