package v2100ms.util;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class AndroidDriverHelper {
	
	AndroidDriver driver;
	
	public AndroidDriverHelper(String url, String deviceName, Boolean autoGrantPermissions) throws MalformedURLException, URISyntaxException{
	
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(deviceName);
		if( autoGrantPermissions ) {
			options.autoGrantPermissions();
		}
		this.driver = new AndroidDriver(new URI(url).toURL(), options);
	
	}
	
	public AndroidDriverHelper(String url, String deviceName, Boolean autoGrantPermissions, String appPackage, String appActivity) throws MalformedURLException, URISyntaxException{
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(deviceName);
		if( autoGrantPermissions ) {
			options.autoGrantPermissions();
		}
		options.setAppPackage(appPackage);
		options.setAppActivity(appActivity);
		options.noReset();
		this.driver = new AndroidDriver(new URI(url).toURL(), options);
	
	}
	
	public void stopDriver() {
		this.driver.quit();
	}
	
	public AndroidDriver getAndroidDriver() {
		return driver;
	}
	
}
