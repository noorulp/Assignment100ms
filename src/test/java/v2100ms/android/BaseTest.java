package v2100ms.android;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import v2100ms.util.AndroidDriverHelper;
import v2100ms.util.AppiumServiceHelper;

public class BaseTest{
	
	public AppiumServiceHelper serviceHelper;
	public AndroidDriverHelper driverHelper;
	public String appPackage;
	
	@BeforeSuite(alwaysRun=true)
	public void appiumStart() throws IOException {
		
		//start appium server at start of test suite
		Properties appiumProp = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\resources\\appium.properties");
		appiumProp.load(fis);
		String ipAddress = appiumProp.getProperty("appium_server_ip");
		int port = Integer.parseInt(appiumProp.getProperty("appium_server_port"));
		String appiumJSPath = appiumProp.getProperty("appium_server_js_path");
		
		serviceHelper = new AppiumServiceHelper(appiumJSPath, ipAddress, port);
		serviceHelper.startService();
	}
	
	@BeforeClass
	public void startDriver() throws IOException, URISyntaxException {
		
		Properties driverProp = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\resources\\driver.properties");
		driverProp.load(fis);
		String deviceName = driverProp.getProperty("device_name");
		appPackage = driverProp.getProperty("app_package");
		String appActivity = driverProp.getProperty("app_activity");
		Boolean autoGrantPermissions = Boolean.parseBoolean(driverProp.getProperty("auto_grant_permissions"));
		driverHelper = new AndroidDriverHelper( serviceHelper.getService().getUrl().toString(), deviceName, autoGrantPermissions, appPackage, appActivity );
	}
	
	@AfterClass
	public void stopDriver() {
		
		driverHelper.getAndroidDriver().terminateApp(appPackage);
		driverHelper.stopDriver();
	}
	
	@AfterSuite(alwaysRun=true)
	public void appiumStop() {
		serviceHelper.stopService();
	}
	
}
