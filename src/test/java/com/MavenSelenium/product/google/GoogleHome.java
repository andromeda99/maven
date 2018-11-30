package com.MavenSelenium.product.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class GoogleHome{

	
	@Test
	public void searchStringInGoogle(){//(String searchValue, WebDriver driver){
		
		System.out.println("In search string method1");
		
	}
	
	@Test
	public void searchResultInGoogle(){//(String searchValue, WebDriver driver){
		
		System.out.println("In search result method2");
		
	}
	
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

}
