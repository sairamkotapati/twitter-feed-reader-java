package com.myapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Base64;

/**
 * @author Sairam Kotapati
 *
 */
public class TwitterRESTClient
{
	/**
	 * creates authorization header required to fetch oauth tokens
	 * 
	 * @return String
	 * @throws UnsupportedEncodingException
	 */
	private String createBasicAuth() throws UnsupportedEncodingException
	{
		String consumer_key = AuthenticationStore.consumer_key;
		String consumer_secret = AuthenticationStore.consumer_secret;

		consumer_key = URLEncoder.encode(consumer_key, "UTF-8");
		consumer_secret = URLEncoder.encode(consumer_secret, "UTF-8");

		String authorization_header_string = consumer_key + ":" + consumer_secret;
		byte[] encoded = Base64.getEncoder().encode(authorization_header_string.getBytes());

		return new String(encoded); // converting byte to string
	}

	/**
	 * fetches connection required to retrieve OAuth token using consumer key and oauth url
	 * 
	 * @return HttpURLConnection
	 * @throws IOException
	 */
	private HttpURLConnection createBearerTokenConnection() throws IOException
	{
		URL url = new URL(AuthenticationStore.authUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		connection.setRequestProperty("Authorization", "Basic " + createBasicAuth());
		connection.setRequestMethod("POST");
		connection.setUseCaches(false);
		connection.setDoInput(true);
		connection.setDoOutput(true);
		String formData = "grant_type=client_credentials";
		byte[] formDataInBytes = formData.getBytes("UTF-8");
		OutputStream os = connection.getOutputStream();
		os.write(formDataInBytes);
		os.close();
		return connection;
	}

	/**
	 * Reads accessToken from the connection obtained 
	 * This is required to make subsequent actual API call
	 * 
	 * @return accessToken
	 */
	private String retrieveAccessToken()
	{
		StringBuffer accessToken = new StringBuffer();
		try
		{
			HttpURLConnection connection = new TwitterRESTClient().createBearerTokenConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null)
			{
				accessToken.append(inputLine);
			}
			in.close();
		} 
		catch (Exception e)
		{
			// could have handled exception in a better way
			e.printStackTrace();
		}
		return accessToken.toString().substring(accessToken.toString().indexOf("access_token") + 15,
				accessToken.toString().length() - 2);
	}
	
	/**
	 * makes actual service call to 
	 * 
	 * @param feedCount
	 * @param screenName
	 * @return HttpURLConnection
	 * @throws IOException
	 */
	private HttpURLConnection retrieveUserTimeLine(int feedCount, String screenName) throws IOException
	{
		String apiUri = AuthenticationStore.apiUri;
		StringBuilder apiUrl = new StringBuilder();
		apiUrl.append(apiUri);
		apiUrl.append(AuthenticationStore.apiUriQueryParam_1 + screenName + AuthenticationStore.apiUriQueryParam_2
				+ feedCount);
		URL url = new URL(apiUrl.toString());
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("Authorization", "Bearer " + retrieveAccessToken());
		connection.setDoOutput(true);
		connection.setRequestMethod("GET");
		connection.connect();
		return connection;
	}

	/**
	 * fetches tweet info from Twitter Rest API call 
	 * 
	 * @param feedCount
	 * @param screenName
	 * @return feedData
	 */
	public String retrieveAPIFeeds(int feedCount, String screenName)
	{
		StringBuffer feedData = new StringBuffer();
		try
		{
			HttpURLConnection connection = retrieveUserTimeLine(feedCount, screenName);
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null)
			{
				feedData.append(inputLine);
			}
			in.close();

		} 
		catch (Exception e)
		{
			// could have handled exception in a better way
			e.printStackTrace();
		}
		return feedData.toString();
	}
	
}
