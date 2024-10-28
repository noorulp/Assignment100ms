package v2100ms.util;

import java.io.File;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class AppiumServiceHelper {
	
	AppiumDriverLocalService service;
	
	public AppiumServiceHelper(String jsPath, String ipAddress, int port){
		
		this.service =  new AppiumServiceBuilder()
							.withAppiumJS(new File(jsPath)) 
							.withIPAddress(ipAddress)
							.usingPort(port)
							.build();
	}
	
	public void startService() {
		this.service.start();
	}
	
	public void stopService() {
		this.service.stop();
	}
	
	public AppiumDriverLocalService getService() {
		return service;
	}
}
