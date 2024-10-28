package v2100ms.android;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseActivity {
	
	final WebDriver driver;
	final WebDriverWait wait;
	
	public BaseActivity(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	public void waitForElement(By by) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public void tap(By by) {
		waitForElement(by);
		driver.findElement(by).click();
	}
	
	public void inputText(By by, String text) {
		waitForElement(by);
		driver.findElement(by).sendKeys(text);
	}
	
	public Boolean isDisplayed(By by) {
		waitForElement(by);
		return driver.findElement(by).isDisplayed();
	}
	
	public Boolean isEnabled(By by) {
		waitForElement(by);
		return driver.findElement(by).isEnabled();
	}
}
