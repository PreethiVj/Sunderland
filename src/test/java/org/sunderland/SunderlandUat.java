package org.sunderland;

import java.util.Date;

import org.nbase.NewBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SunderlandUat extends NewBase {
	WebDriver driver;

	@DataProvider(name = "user_login")
	public Object[][] dpmultilogin() {
		return new Object[][] { { "e2sadmin@yopmail.com", "demo" } };
		// {"wq0asm@yopmail.com ","demo"}};
	}
	// dataProvider="user_login"
// https://pf-prod-uk.engage2serve.com
	@Test
	public void multiLogin() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https//www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(6000);
		System.out.println(gettitle());

		Assert.assertEquals(gettitle(), "Engage2Serve | Login");

		// driver.findElement(By.xpath("(//input[contains(@name,'usrnm')])[1]")).sendKeys(mailid);
		// driver.findElement(By.xpath("(//input[contains(@name,'usrnm')])[2]")).sendKeys(password);
		// driver.findElement(By.xpath("//button[@class=\"btn btn-primary ng-binding
		// ng-scope\"]")).click();
	}
}
