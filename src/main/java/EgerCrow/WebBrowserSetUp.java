package EgerCrow;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class WebBrowserSetUp {
	public static void openBrowser(String browserName) {
		switch (browserName) {
		case "Chrome":
			System.out.println("Opening Chrome Browser");
			WebDriverManager.chromedriver().setup();
			BrowserInstance.driver = new ChromeDriver();
			break;
		case "Firefox":
			WebDriverManager.chromedriver().setup();
			BrowserInstance.driver = new FirefoxDriver();
			break;
		case "HTMLUnit":
			WebDriverManager.chromedriver().setup();
			BrowserInstance.driver = new HtmlUnitDriver();
			break;
		case "Safari":
			break;
		default:
			System.out.println("Invalide browser name: " + browserName);
		}

	}

	public static void openURL(String url) {
		System.out.println(url + " is loading");
		BrowserInstance.driver.get(url);
	}
	private static WebElement getWebElement(String locatorType, String locatorValue) {
		WebElement element = null;
		switch (locatorType) {
		case "XPATH":
			element = BrowserInstance.driver.findElement(By.xpath(locatorValue));
			break;
		case "CSS":
			element = BrowserInstance.driver.findElement(By.cssSelector(locatorValue));
			break;
		case "ID":
			element = BrowserInstance.driver.findElement(By.id(locatorValue));
			break;
		case "LINKTEXT":
			element = BrowserInstance.driver.findElement(By.linkText(locatorValue));
			break;
		case "PARTIAL_LINK_TEXT":
			element = BrowserInstance.driver.findElement(By.partialLinkText(locatorValue));
			break;
		case "CLASS_NAME":
			element = BrowserInstance.driver.findElement(By.className(locatorValue));
			break;
		default:
			System.err.println("Invalid Lopcator Type" + locatorType
					+ ("Expected: CSS, XPATH, ID, LINKTEXT, PARTIAL_LINK_TEXT, CLASS_NAME"));
			break;
		}
		return element;

	}

	public static void enterText(String locatorType, String locatorValue, String textToEnter) {
		getWebElement(locatorType, locatorValue).sendKeys(textToEnter);
	}

	public static void clickonElement(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
	}
	public static void maximizeBrowser() {
		BrowserInstance.driver.manage().window().maximize();
	}
	public static void WindowHandlies(String webElement) {
		String parent_window=BrowserInstance.driver.getWindowHandle();
		System.out.println("Before Swiching Title is ="+BrowserInstance.driver.getTitle());
		Set<String> s1 =BrowserInstance.driver.getWindowHandles();
		Iterator<String> itr=s1.iterator();
		while(itr.hasNext()) {
			String childwindow=itr.next();
			if(parent_window.equals(childwindow)) {
				BrowserInstance.driver.switchTo().window(childwindow);
				System.out.println(BrowserInstance.driver.getTitle());
				BrowserInstance.driver.findElement(By.xpath(webElement)).click();
			}
		}
	}
	public static void addToCard(String element) {
		BrowserInstance.driver.findElement(By.xpath(element));
	}
	public static void JSE_ScrollBar() {
		JavascriptExecutor js=(JavascriptExecutor)BrowserInstance.driver;
		js.executeScript("window.scrollBy(0,200)");
	}
	public static void actionOnElement(String action) {
		Actions action1=new Actions(BrowserInstance.driver);
		action1.moveToElement(BrowserInstance.driver.findElement(By.xpath(action))).click();
		action1.build().perform();
	}
	public static void closeBrowser() {
		BrowserInstance.driver.close();
	}

	public static void closeAllBrowser() {
		BrowserInstance.driver.quit();
	}
}
