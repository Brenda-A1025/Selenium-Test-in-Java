package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PositiveTest {
	
	@Test
	public void loginTest() {
		System.out.println("start test");
//		create driver
		WebDriver driver = new ChromeDriver();
		System.out.println("open chrome");
		sleep(1);
		
//		open test page
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		sleep(1);
		driver.manage().window().maximize();
		sleep(1);
		System.out.println("opened page");
		
		
//		enter username
		WebElement username= driver.findElement(By.id("username"));
		username.sendKeys("tomsmith");
		sleep(1);
		
//		enter password
		WebElement password= driver.findElement(By.name("password"));
		password.sendKeys("SuperSecretPassword!");
		sleep(1);
		
//		click login button
		WebElement loginbutton= driver.findElement(By.tagName("button"));
		loginbutton.click();
		sleep(1);
		
		
//		verifications:
//			new url
//			log out button is available
		WebElement logoutbutton= driver.findElement(By.xpath("//a[@class='button secondary radius']"));
		logoutbutton.click();
		sleep(1);
		
		
//			successful
		WebElement successmessage= driver.findElement(By.cssSelector("div#flash"));
		String messageText = successmessage.getText();
		String expectedName = " You logged into a secure area!";
		if (messageText.contains(expectedName)) {
		    System.out.println(expectedName + " was found in the success message.");
		} else {
		    System.out.println( expectedName + " was NOT found in the success message.");
		}

		
		
		driver.close();
		
		System.out.println("finish test");
//	
		}

	/**
	 * stop execution for the given amount of period
	 * @param seconds
	 */
	private void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
