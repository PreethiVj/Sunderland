package org.sunderland;

import org.nbase.NewBase;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SunderlandReport extends NewBase {
	@BeforeClass
	public void browsersetup() {
		openchrome();
		urllaunch("https://pf-prod-uk.engage2serve.com/#/login");
		maximize();
		implicitwait(10);
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
		Waitclick("xpath", "//li[@title=\"Inbox\"]");
		Thread.sleep(4000);
		Waitclick("xpath", "//i[@class=\"fa fa-thumb-tack\"]");
		Waitclick("xpath","(//li[@class=\"ng-scope active\"])[1]" );
		sysout("7.  All tickets are loaded in inbox ");
		Thread.sleep(10000);
		Waitclick("xpath", "//i[@class='fa fa-filter fa-chevron-down']");
		waitsendkeys("xpath", "//input[@placeholder=\"Ticket no\"]","UH247564");
		scrolldown(300);
		Waitclick("xpath", "//*[@class=\"btn btn-sm btn-primary ladda-button\"]");
		String text = getText(finelel("xpath", "//*[text()='FADY NESIM']"));
		sysout("8. ALL information are loaded in ticket :" + text);
	}

}
