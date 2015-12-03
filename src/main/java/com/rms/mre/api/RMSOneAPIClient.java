package com.rms.mre.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rms.mre.api.types.Activities;
import com.rms.mre.api.types.Activity;
import com.rms.mre.api.types.Token;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class RMSOneAPIClient {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RMSOneAPIClient.class);
	
	private URI buildURI(String extension) throws URISyntaxException{
		URI uri = new URIBuilder()
		.setScheme("http")
		.setHost("localhost:8080")
		.setPath(String.format("/%s", extension))
		.build();
		
		return uri;
	}

	public Token getToken() throws ClientProtocolException, IOException, URISyntaxException {
		URI uri = buildURI("tokens");
		List<NameValuePair> requestParameters = new ArrayList<NameValuePair>();
		requestParameters.add(new BasicNameValuePair("username","rmsUser"));
		requestParameters.add(new BasicNameValuePair("password","P@ssword1"));
		requestParameters.add(new BasicNameValuePair("grant_type","password"));
		requestParameters.add(new BasicNameValuePair("tenant","rms"));
		
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost postRequest = new HttpPost(uri);
		
		postRequest.setEntity(new UrlEncodedFormEntity(requestParameters));
		
		postRequest.addHeader("Authorization", "Basic mTpzZWNyZXQ=");
		CloseableHttpResponse response = client.execute(postRequest);
		int status = response.getStatusLine().getStatusCode();
		
		if(status == 201){
			LOGGER.debug("201");
		}else {
			LOGGER.error(String.format("ERROR: %s", response.getStatusLine().toString()));
			LOGGER.error(response.getEntity().toString());
		}
		String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
		Gson gson = new GsonBuilder().create();
		Token t = gson.fromJson(responseString, Token.class);
		return t;
	}
	
	public Activity[] getActivities(Token token) throws URISyntaxException, ClientProtocolException, IOException{
		URI uri = buildURI("activities");
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet getRequest = new HttpGet(uri);
		getRequest.addHeader("Authorization", String.format("%s %s", token.token_type, token.access_token));
		getRequest.addHeader("Content-Type", "application/json");
		
		CloseableHttpResponse response = client.execute(getRequest);
		int status = response.getStatusLine().getStatusCode();
		
		if(status == 200){
			LOGGER.debug("200");
		}else {
			LOGGER.error(String.format("ERROR: %s", response.getStatusLine().toString()));
			LOGGER.error(response.getEntity().toString());
		}
		String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
		Gson gson = new GsonBuilder().create();
		Activities activities = gson.fromJson(responseString, Activities.class);
		return activities.items;
	}
	
	public Activity getActivity(Token token, int activityId) throws URISyntaxException, ClientProtocolException, IOException{
		URI uri = buildURI(String.format("activities/%d", activityId));
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet getRequest = new HttpGet(uri);
		getRequest.addHeader("Authorization", String.format("%s %s", token.token_type, token.access_token));
		getRequest.addHeader("Content-Type", "application/json");
		
		CloseableHttpResponse response = client.execute(getRequest);
		int status = response.getStatusLine().getStatusCode();
		
		if(status == 200){
			LOGGER.debug("200");
		}else {
			LOGGER.error(String.format("ERROR: %s", response.getStatusLine().toString()));
			LOGGER.error(response.getEntity().toString());
		}
		String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
		Gson gson = new GsonBuilder().create();
		Activity activity = gson.fromJson(responseString, Activity.class);
		return activity;
	}
}
