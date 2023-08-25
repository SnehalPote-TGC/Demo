package com;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginPageFront {
	@Test(dataProvider = "getData", dataProviderClass = LoginPage.class)

	public void TestLogin(String userName, String password) {
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://coroebusbeta.in/b2b-beta-tgc/#/account/login?returnUrl=%2Ftop_dashboard");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@id='floatingPassword']")).sendKeys(password);
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement ele = driver.findElement(By.xpath("//button[@type='submit']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
	}

}
