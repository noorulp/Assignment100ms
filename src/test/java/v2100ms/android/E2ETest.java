package v2100ms.android;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import v2100ms.util.APIHelper;

public class E2ETest extends BaseTest {
	
	String displayName;
	
	@Test
	public void joinMeeting() {
		//get this string from a data provider 
		String url = APIHelper.URL;
		//enter URL in homepage
		HomeActivity home = new HomeActivity(driverHelper.getAndroidDriver());
		home.enterMeetingURL(url);
		//check join enabled
		Assert.assertTrue(home.isJoinBtnEnabled());
		home.tapJoin();
	}
	
	@Test( dependsOnMethods = { "joinMeeting" } )
	public void videoVerify() throws InterruptedException {
		
		//enter meting page
		MeetingActivity meeting = new MeetingActivity(driverHelper.getAndroidDriver());
		displayName = meeting.getNameFromMeeting();
		meeting.tapJoin();
		Assert.assertTrue(meeting.videoViewIsDisplayed());
	}
	
	@Test( dependsOnMethods = { "videoVerify" } )
	public void nameVerify() throws IOException {
		
		ArrayList<String> names = APIHelper.getNames(APIHelper.roomId);
		if( names!= null )
			Assert.assertTrue(names.contains(displayName));
		else
			Assert.assertTrue(false);
	}
}
