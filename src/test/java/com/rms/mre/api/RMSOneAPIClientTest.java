package com.rms.mre.api;

import com.rms.mre.api.types.Activity;
import com.rms.mre.api.types.Token;
import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.*;

public class RMSOneAPIClientTest {

	@Test
	public void testGetToken() throws ClientProtocolException, IOException, URISyntaxException {
		RMSOneAPIClient client = new RMSOneAPIClient();
		Token token = client.getToken();
		assertTrue(token.access_token != null && token.access_token.length() > 0);
	}

	@Test
	public void testGetActivities() throws ClientProtocolException, URISyntaxException, IOException{
		RMSOneAPIClient client = new RMSOneAPIClient();
		Activity[] activities = client.getActivities(client.getToken());
		assertTrue(activities.length > 0);
	}
	
	@Test
	public void testGetActivity() throws ClientProtocolException, URISyntaxException, IOException{
		RMSOneAPIClient client = new RMSOneAPIClient();
		Activity activity = client.getActivity(client.getToken(), 1);
		assertTrue(activity.jobId == 1);
	}
}
