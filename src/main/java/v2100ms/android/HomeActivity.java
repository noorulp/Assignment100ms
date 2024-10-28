package v2100ms.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeActivity extends BaseActivity {
	
	By tbMeetingURL = By.id("live.hms.app2:id/edt_meeting_url");
	By btnJoin = By.id("live.hms.app2:id/btn_join_now");
	
	public HomeActivity(WebDriver driver){
		super(driver);
	}
	
	public void enterMeetingURL(String url) {
		inputText(tbMeetingURL, url);
	}
	
	public void tapJoin() {
		tap(btnJoin);
	}
	
	public Boolean isJoinBtnEnabled() {
		return isEnabled(btnJoin);
	}
}
