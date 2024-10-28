package v2100ms.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MeetingActivity extends BaseActivity{
	
	By btnJoin = By.id("live.hms.app2:id/button_join_meeting");
	By imgvNetworkQuality = By.id("live.hms.app2:id/network_quality");
	By textvName = By.id("live.hms.app2:id/edit_text_name");
	By videoView = By.id("live.hms.app2:id/hms_video_view");
	
	public MeetingActivity(WebDriver driver) {
		super(driver);
	}
	
	public void tapJoin() {
		tap(btnJoin);
	}
	
	public Boolean checkNetworkQuality() {
		return isDisplayed(imgvNetworkQuality);
	}
	
	public Boolean videoViewIsDisplayed() {
		return isDisplayed(videoView);
	}
	
	public String getNameFromMeeting() {
		super.waitForElement(textvName);
		return super.driver.findElement(textvName).getText();
	}

}
