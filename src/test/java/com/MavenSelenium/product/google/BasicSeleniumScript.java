package com.MavenSelenium.product.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicSeleniumScript {
	
	@Test
	public void testingFirefoxScript() throws InterruptedException{	
		
		System.setProperty("webdriver.chrome.driver", 
				"F:\\selenium class\\chromedriver_win32_B39\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		
		driver.get("https://www.seleniumhq.org/");
		
		Thread.sleep(7000);
		driver.findElement(By.xpath("//div/ul/li/a[@title='Selenium Projects']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div/ul/li/a[@title='Get Selenium']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("q")).sendKeys("Selenium");
		Thread.sleep(2000);
		boolean result = true;
		String failingMsg = "";
		try{
			driver.findElement(By.xpath("//div/ul/li/a[@title='Radical Selenium']"));
		}
		catch(Exception e){
			result = false;
			System.out.println("Radical selenium tab not present");
			failingMsg =failingMsg+ "Radical selenium tab not present  ";
		}
		
		try {
			driver.findElement(By.xpath("//div/ul/li/a[@title='Technical references and guides']"));
		} catch (Exception e) {
			result = false;
			System.out.println("Documentation tab not present");
			failingMsg =failingMsg+ "Documentation tab not present   ";
		}
		
		Assert.assertTrue(result, failingMsg);
		System.out.println("after assert");
		
		
	}
	
	@Test
	public void testingFirefoxScript1() throws InterruptedException{	
		
		System.setProperty("webdriver.chrome.driver", 
				"F:\\selenium class\\chromedriver_win32_B39\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/admin/workspace111/MavenSelenium/src/test/java/com/MavenSelenium/resources/index.html");

	}
	
	
	@Test
	public void testMethod() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", 
				"F:\\selenium class\\chromedriver_win32_B39\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		
		driver.get("http://demo.automationtesting.in/Register.html");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@ng-model='FirstName']")).sendKeys("Anil");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='Movies']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='FeMale']")).click();
		Thread.sleep(1000);
		
//		//case 1
//		driver.findElement(By.xpath("//select[@id='Skills']")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//select[@id='Skills']/option[contains(text(),'Android')]")).click();
		
		
//		//case 2
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//select[@id='Skills']/option[contains(text(),'Android')]")).click();
		
		//Case 3
		WebElement ele = driver.findElement(By.xpath("//select[@id='Skills']"));
		Select sel = new Select(ele);
		sel.selectByVisibleText("Android");

}
}
