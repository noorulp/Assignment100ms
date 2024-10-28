package v2100ms.util;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class APIHelper {
	
	public final static String roomId = "6717cc46e1c77fcc4c276ff5";
	public final static String URL = "https://noorul-videoconf-2131.app.100ms.live/meeting/phh-dmfz-mux";
	
	public static JSONObject getPeers(String roomId) throws IOException {
		
		OkHttpClient client = new OkHttpClient().newBuilder()
  				.build();

		//RequestBody body = RequestBody.create(mediaType, "");
		Request request = new Request.Builder()
			  				.url("https://api.100ms.live/v2/active-rooms/" + roomId + "/peers")
							.addHeader("Authorization", "Bearer " + System.getenv("API_AUTH_TOKEN"))
							.build();
		Response response = client.newCall(request).execute();
		
		String jsonData = response.body().string();
		JSONObject jObject = new JSONObject(jsonData);
		
		return jObject;
	}
	
	public static ArrayList<String> getNames(String roomId) throws IOException {
		
		JSONObject output = getPeers(roomId);
		String[] fieldNames = JSONObject.getNames(output);
		if( fieldNames[0].equals("code") )
			return null;
		
		JSONObject peerIds = output.getJSONObject("peers");
		String[] keys = JSONObject.getNames(peerIds);
		
		ArrayList<String> names = new ArrayList<String>();
		
		for( int i=0; i < keys.length ; i++ ) {
			names.add(peerIds.getJSONObject(keys[i]).getString("name"));
		}
		
		return names;
		
	}

}
