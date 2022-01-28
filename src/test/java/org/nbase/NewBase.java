package org.nbase;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.hc.client5.http.utils.DateUtils;
import org.apache.poi.ss.format.CellFormatType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.model.Image;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewBase {

	public static WebDriver driver;

	//1. BROWSER LAUNCH 1

	public static void openchrome() {

		WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();  //to disable browser notifications
		ChromeOptions addArguments = co.addArguments("--disable-notifications");  //to disable browser notifications
		driver = new ChromeDriver(addArguments);

	}

	//2. BROWSER LAUNCH 2

	public static void openfirefox() {

		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions fo=new FirefoxOptions();
		FirefoxOptions addArguments = fo.addArguments("-disable-notifications");
		driver = new FirefoxDriver(addArguments);

	}

	//3. BROWSER LAUNCH 3

	public static void openedge() {

		WebDriverManager.edgedriver().setup();
		EdgeOptions eo=new EdgeOptions();
		EdgeOptions addArguments = eo.addArguments("--disable-notifications");
		driver = new EdgeDriver(addArguments);

	}

	//4. URL LAUNCH
	public static void urllaunch(String url) {

		driver.get(url);
	}

	//5. MAXIMIZE
	public static void maximize() {

		driver.manage().window().maximize();
	}

	//6. IMPLICIT WAIT
	public static void implicitwait(int num) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(num));
	}

	//7. SENDKEYS
	public static void sendkeys(WebElement ref, String value) {
		ref.sendKeys(value);
	}

	//8. FINDELEMENT
	public static WebElement finelel(String value, String loc)

	{
		WebElement ele = null;
		if (value.equals("id")) {
			ele = driver.findElement(By.id(loc));
		} else if (value.equals("name")) {
			ele = driver.findElement(By.name(loc));
		} else if (value.equals("xpath")) {
			ele = driver.findElement(By.xpath(loc));
		} else {
			System.out.println("invalid");
		}
		return ele;
	}

	//9. CLICK
	public static void click(WebElement ref) {

		ref.click();
	}

	//10. CLOSE
	public static void close() {

		driver.close();

	}

	//11. QUIT
	public static void quit() {

		driver.quit();
	}

	//12. SYSOUT
	public static void sysout(String typesomething) {

		System.out.println(typesomething);
	}

	//13. SYSERR
	public static void syserr(String typesomething) {

		System.err.println(typesomething);
	}

	//14. GET CURRENT URL
	public static String geturl() {

		String url = driver.getCurrentUrl();
		return url;

	}

	//15. GET TITLE
	public static String gettitle() {

		String title = driver.getTitle();
		return title;

	}

	//16. GET TEXT
	public static String getText(WebElement loc) {

		String text = loc.getText();
		return text;
	}

	//17. GET ATTRIBUTE
	public static String getAttribute(WebElement loc) {
		String attribute = loc.getAttribute("value");
		return attribute;
	}

	//18. CLEAR
	public static void clear(WebElement a) {

		a.clear();

	}

	//19. IS ENABLED
	public static boolean isenabled(WebElement loc) {
		boolean enabled = loc.isEnabled();
		return enabled;

	}

	//20. IS SELECTED
	public static boolean isselected(WebElement loc) {
		boolean selected = loc.isSelected();
		return selected;
	}

	//21. IS DISPLAYED
	public static boolean isdisplayed(WebElement loc) {
		boolean displayed = loc.isDisplayed();
		return displayed;
	}

	//22. SELECT BY INDEX
	public static void selectbyindex(WebElement loc, int num) {

		Select s = new Select(loc);
		s.selectByIndex(num);
	}

	//23. SELECT BY VALUE
	public static void selectbyvalue(WebElement loc, String value) {

		Select s = new Select(loc);
		s.selectByValue(value);
	}

	//24. SELECT BY VISIBLE TEXT
	public static void selectbyvisibletext(WebElement loc, String value) {

		Select s = new Select(loc);
		s.selectByVisibleText(value);
	}

	//25. MOVE TO ELEMENT

	public static void movetoelement(WebElement target) {

		Actions a = new Actions(driver);
		a.moveToElement(target).build().perform();
	}

	//26. DRAG AND DROP
	public static void draganddrop(WebElement source, WebElement target) {

		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).build().perform();

	}

	//27. DOUBLE CLICK
	public static void doubleclick(WebElement target) {

		Actions a = new Actions(driver);
		a.doubleClick(target).build().perform();

	}

	//28. RIGHT CLICK
	public static void rightclick(WebElement target) {

		Actions a = new Actions(driver);
		a.contextClick(target).build().perform();

	}

	//29. CLICK AND HOLD
	public static void clickandhold(WebElement target) {

		Actions a = new Actions(driver);
		a.clickAndHold(target).build().perform();

	}
	//30. ROBOT CLASS FOR ONE STEP

	public static void robotonestep() throws AWTException {

		Robot r = new Robot();
		for (int i = 0; i < 1; i++) // here we can change number based on dropdown
		{
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	//31. SCROLL DOWN

	public static void scrolldown(int value) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0," + value + ")");
	}

	//32. SCROLL UP
	public static void scrollup(int value) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0," + value + ")");
	}

	//33. SCREENSHOT
	public static void screenshot(Image picture) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\preethi.n\\Pictures\\Saved Pictures" + picture + "");
		FileUtils.copyFile(src, dest);

	}

	//34. ROBOT CLASS
	public static void ROBOT() throws AWTException {
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}

	//35. WINDOW HANDLING NEW TAB
	public static String windowhandle() {

		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}

	//36. WINDOW HANDLING BY LIST
	public static void windowhandles() {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String string : windowHandles) {
			if (!(string.equals(windowhandle()))) {
				driver.switchTo().window(string);
			}
		}
	}

	//37. READ DATA FROM EXCEL

	public static void readdata(String sheetname, int rowvalue, int cellvalue) throws IOException {

		File f = new File("C:\\Users\\preethi.n\\eclipse-workspace\\MDX\\Workbook\\Book1.xlsx");
		FileInputStream fil = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(fil);
		Sheet s = book.getSheet(sheetname);
		Row r = s.getRow(rowvalue);
		Cell c = r.getCell(cellvalue);
		int cellType = c.getCellType();

	}

	//38. fluent wait

	public static WebElement fluentwait(String value, String loc) {
		FluentWait<WebDriver> f = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(Exception.class);
		WebElement until = null;
		if (value.equals("id")) {
			until = f.until(ExpectedConditions.visibilityOfElementLocated(By.id(loc)));
		} else if (value.equals("name")) {
			until = f.until(ExpectedConditions.visibilityOfElementLocated(By.name(loc)));
		}

		else if (value.equals("xpath")) {
			until = f.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc)));
		} else {
			System.out.println("invalid");
		}
		return until;
	}


	//39. Webdriver wait

	public static WebElement webdriverwait(String value,String loc) {

		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(300));

		WebElement until=null;
		if(value.equals("id")){
			until = w.until(ExpectedConditions.visibilityOfElementLocated(By.id(loc)));
		}
		else if(value.equals("name")) {
			until = w.until(ExpectedConditions.visibilityOfElementLocated(By.name(loc)));
		}

		else if (value.equals("xpath")) {
			until = w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc)));
		}
		else
		{
			System.out.println("invalid");
		}
		return until;
}
//40. Webdriverwait sendkeys
	
	public static WebElement waitsendkeys(String value,String loc,String sendkey ) {
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(50));
		 WebElement until = null;
		 if(value.equals("id")) {
		 until=w.until(ExpectedConditions.visibilityOfElementLocated(By.id(loc)));
		 until.sendKeys(sendkey);
		 }
		 else if(value.equals("name")) {
				until = w.until(ExpectedConditions.visibilityOfElementLocated(By.name(loc)));
				 until.sendKeys(sendkey);
			}

			else if (value.equals("xpath")) {
				until = w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc)));
				 until.sendKeys(sendkey);
			}
			else
			{
				System.out.println("invalid");
			}
			return until;
	}
//41. WEbdriverwait click
	
	public static WebElement Waitclick(String value,String loc) {
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(50));
		 WebElement until = null;
		 if(value.equals("id")) {
		 until=w.until(ExpectedConditions.visibilityOfElementLocated(By.id(loc)));
		 until.click();
		 }
		 else if(value.equals("name")) {
				until = w.until(ExpectedConditions.visibilityOfElementLocated(By.name(loc)));
				 until.click();
			}

			else if (value.equals("xpath")) {
				until = w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc)));
				 until.click();
			}
			else
			{
				System.out.println("invalid");
			}
			return until;
	}
	
	
//40. Alert accept
	
public static void alertaccept() {
	driver.switchTo().alert().accept();
}
//41. Alert dismiss

public static void alertdismiss() {
	driver.switchTo().alert().dismiss();
}
//42.Alert sendkeys

public static void alertsendkeys(String text) {
	Alert alt = driver.switchTo().alert();
alt.sendKeys(text);
}

//43. Webdriver alertispresent sendkeys

public static void Alertispresent(String text) {
	WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(300));
Alert until = w.until(ExpectedConditions.alertIsPresent());
until.sendKeys(text);
}

//44. Alertispresent accept
public static void altisprst() {

WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(300));
 w.until(ExpectedConditions.alertIsPresent()).accept();

}

//45.Frames
public static void frame() {
	
	driver.switchTo().frame(0);
	driver.switchTo().defaultContent();

}

//46.Webdriver frame

public static void webframe(WebElement loc) {

	WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(300));
	 w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(loc));

}








}