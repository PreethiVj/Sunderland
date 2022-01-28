package org.sunderland;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.nbase.NewBase;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LiveReport extends NewBase {


	@BeforeClass
	public void browsersetup() {
		openchrome();
		urllaunch("https://pf-prod-uk.engage2serve.com/#/login");
		maximize();
		implicitwait(10);


	}

	@BeforeMethod
	private void dummy() {
		sysout("--------------------------------------");
	}


	@AfterMethod

	private void dummy1() {
		sysout("--------------------------------------");
	}

	@Test(priority = 0)
	private void login() {
		waitsendkeys("xpath", " (//*[@name=\"usrnm\"])[1]",  "e2sadmin@yopmail.com");
		waitsendkeys("xpath", "//input[@type=\"password\"]","demo");
		Waitclick("xpath", "//button[@type=\"submit\"]");
		sysout("1. Staff portal login");
	}

	@Test(priority = 1)
	public void logout() throws InterruptedException {

		Waitclick("xpath", "//*[text()='Sunderland City']");
		Waitclick("xpath", "//img[@class=\"resolution_35x35 img-circle ng-scope\"]");
		Waitclick("xpath", "(//div[@class=\"ng-binding\"])[3]");
		sysout("2.Staff portall logout");
		Thread.sleep(3000);
		Waitclick("xpath", "//*[text()='Click here to log back in']");
		waitsendkeys("xpath", "//input[@type=\"password\"]","demo");
		Waitclick("xpath", "//button[@type=\"submit\"]");
		Waitclick("xpath", "//*[text()='Sunderland City']");
		sysout("3. Campus based and location based login");

	}


	@Test(priority=2)
	private void createticketloading() throws InterruptedException {
		Waitclick("xpath", "//i[@class=\"fa fa-thumb-tack\"]");
		Waitclick("xpath", "//span[contains(text(),'Service Desk')]");
		driver.findElement(By.linkText("Create Ticket")).click();
		Waitclick("xpath", "//i[@class=\"fa fa-thumb-tack\"]");
		sysout("4. Create ticket page loading");

	}


	@Test(priority = 3)
	private void PerformAnyaction() throws InterruptedException {
		Thread.sleep(10000);

		Waitclick("xpath", "//i[@class=\"fa fa-thumb-tack\"]");
		Waitclick("xpath", "(//span[@class=\"nav-label ng-binding\"])[6]");
		Thread.sleep(4000);
		Waitclick("xpath", "//i[@class=\"fa fa-thumb-tack\"]");
		Waitclick("xpath","(//a[@class=\"ng-binding\"])[7]" );
		sysout("7.  All tickets are loaded in inbox ");
		Thread.sleep(10000);
		Waitclick("xpath", "//i[@class='fa fa-filter fa-chevron-down']");
		waitsendkeys("xpath", "//input[@placeholder=\"Ticket no\"]","UH247564");
		scrolldown(300);
		Waitclick("xpath", "//*[@class=\"btn btn-sm btn-primary ladda-button\"]");
		String text = getText(finelel("xpath", "//*[text()='FADY NESIM']"));
		sysout("8. ALL information are loaded in ticket :" + text);
	}

	@Test(priority = 4)
	private void attachmentopenbystaff()throws IOException, InterruptedException {
		Thread.sleep(3000);
		Waitclick("xpath", "//a[text()=' UH247564']");
		scrollup(-1000);
		Waitclick("xpath", "//*[text()=' Attachments (2)']");
		String windowHandle = driver.getWindowHandle();
		Waitclick("xpath", "//a[text()='Fady Nesim COE.pdf']");
		//new tab
		Set<String> windowHandles = driver.getWindowHandles();
		for (String allwindow : windowHandles) {
			if(!(allwindow.equals(windowHandle)));{
				driver.switchTo().window(allwindow);
			}
			TakesScreenshot tc=(TakesScreenshot) driver;
			File src=tc.getScreenshotAs(OutputType.FILE);
			File dest=new File("C:/Users/preethi.n/eclipse-workspace/Sundland/target/newfile.pdf");
			FileUtils.copyFile(src, dest);
			Thread.sleep(5000);
			driver.switchTo().window(windowHandle);

		}
		sysout("9. Attachment is able to open by staff");
	}	

	@Test(priority=5)
	private void audience() throws InterruptedException {
		Waitclick("xpath", "//i[@class=\"fa fa-thumb-tack\"]");
		Waitclick("xpath", "//li[@title=\"Audience\"]");
		Waitclick("xpath", "//i[@class=\"fa fa-thumb-tack\"]");
		Waitclick("xpath", "//button[text()='Individuals']");
		Waitclick("xpath", "(//i[@class=\"fa fa-user\"])[3]");
		Thread.sleep(3000);
		Waitclick("xpath", "//a[text()='Staff']");
		Thread.sleep(3000);
		sysout("12. Student and Staff should load in the audience individual");
	}

		@Test(priority=6)
		private void student360() {
			Waitclick("xpath", "//i[@class=\"fa fa-filter fa-chevron-up\"]");
	waitsendkeys("xpath", "//input[@placeholder=\"Search by student ID\"]", "UH247564");
		}


	@AfterClass

	private void closeall() {

		close();

	}

}
