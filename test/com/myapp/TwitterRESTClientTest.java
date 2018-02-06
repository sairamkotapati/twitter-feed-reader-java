package com.myapp;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.net.HttpURLConnection;

import org.junit.Before;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

/**
 * @author Sairam Kotapati
 *
 */
public class TwitterRESTClientTest
{
	TwitterRESTClient client = null;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		client = new TwitterRESTClient();
	}

	/**
	 * Test method for {@link com.myapp.TwitterRESTClient#retrieveAccessToken()}.
	 * @throws Exception 
	 */
	@Test
	public void retrieveAccessTokenShouldReturnNotNullValue() throws Exception
	{
		String randomString = Whitebox.invokeMethod(client, "retrieveAccessToken");
		assertNotNull(randomString);
	}

	/**
	 * Test method for {@link com.myapp.TwitterRESTClient#retrieveAPIFeeds(int, java.lang.String)}.
	 */
	@Test
	public void retrieveAPIFeedsShouldReturnNotNullValue()
	{
		assertNotNull(client.retrieveAPIFeeds(1, "salesforce"));
	}
	
	/**
	 * Test method for {@link com.myapp.TwitterRESTClient#retrieveAPIFeeds(int, java.lang.String)}.
	 */
	@Test
	public void retrieveAPIFeedsShouldReturnTweetsCorrespondingToSpecificUser()
	{
		// Verify whether Screen name returned as part of the response has screen_name:salesforce
		assertTrue(client.retrieveAPIFeeds(1, "salesforce").contains("\"screen_name\":\"salesforce\""));
	}
	
	
	/**
	 * Test method for {@link com.myapp.TwitterRESTClient#createBasicAuth()}.
	 * @throws Exception 
	 */
	@Test
	public void createBasicAuthShouldReturnNotNullValue() throws Exception
	{
		String randomString = Whitebox.invokeMethod(client, "createBasicAuth");
		assertNotNull(randomString);
		// As token is supposed to be dynamic not validating whether it is specific value
	}
	
	/**
	 * Test method for {@link com.myapp.TwitterRESTClient#createBearerTokenConnection()}.
	 * @throws Exception 
	 */
	@Test
	public void createBearerTokenConnectionShouldReturnNotNullValue() throws Exception
	{
		HttpURLConnection connection = Whitebox.invokeMethod(client, "createBearerTokenConnection");
		assertNotNull(connection.toString());
		// As HttpURLConnection is supposed to be dynamic not validating whether it is specific value
	}
	
	/**
	 * Test method for {@link com.myapp.TwitterRESTClient#createTwitterAPIConnection()}.
	 * @throws Exception 
	 */
	@Test
	public void createTwitterAPIConnectionShouldReturnNotNullValue() throws Exception
	{
		HttpURLConnection connection = Whitebox.invokeMethod(client, "retrieveUserTimeLine",10,"salesforce");
		assertNotNull(connection.toString());
		// As HttpURLConnection is supposed to be dynamic not validating whether it is specific value
	}
	

}
