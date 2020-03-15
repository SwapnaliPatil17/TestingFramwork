package EgerCrowTestPackage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import EgerCrow.WebBrowserSetUp;

public class TestEgerCrow {
	@BeforeClass
	public void EagerCrowWebAppLogIn() throws InterruptedException {	
		WebBrowserSetUp.openBrowser("Chrome");
		WebBrowserSetUp.openURL("https://eagercrow.com");
		WebBrowserSetUp.maximizeBrowser();
		WebBrowserSetUp.clickonElement("XPATH", "//*[text()='Sign In']");
	}
	@BeforeMethod
	public void SignIn() throws InterruptedException {
		Thread.sleep(3000);
		WebBrowserSetUp.WindowHandlies("html/body/app-root/app-header/header/div[1]/div[2]/div[2]/a");
		WebBrowserSetUp.enterText("XPATH", "//*[@type='email']", "swapnayawalkar@gmail.com");
		WebBrowserSetUp.clickonElement("XPATH", "//button[@type='submit']");
		Thread.sleep(3000);
		WebBrowserSetUp.enterText("XPATH", "//*[@type='password']", "Nilesh@123");
		WebBrowserSetUp.clickonElement("XPATH", "//button[@type='submit']");
	}	
	
	@Test
	public void addtocart() {
		WebBrowserSetUp.WindowHandlies("/html/body/app-root/app-header/header/div[1]/div[2]/div[1]/nav/ul/li[2]/a");
		WebBrowserSetUp.JSE_ScrollBar();
		WebBrowserSetUp.actionOnElement("html/body/app-root/app-main-content/div/section[3]/div/div[2]/mat-card/div/div/div/div/div/div/div[7]/div/div[1]/div/div/button[2]");
		
	}
		
	@Test
	public static void closeBrowser() {
		WebBrowserSetUp.closeAllBrowser();
	}

}