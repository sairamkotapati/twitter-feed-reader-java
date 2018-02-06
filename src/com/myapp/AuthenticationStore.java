/**
 * 
 */
package com.myapp;

/**
 * This class stores the authentication details required for hitting Twitter API
 * This can be externalized to a database or a file or build a API with OAuth
 * 
 * @author Sairam Kotapati
 *
 */
public class AuthenticationStore
{
	public static final String consumer_key = "ZsdZMcsioZ3Wq88d8tMHjiNF3";
	public static final String consumer_secret = "PUz8sQth254QbVF0UHry27UA1d5cvfULkFWJwvowaTJymktMN6";
	public static final String authUrl = "https://api.twitter.com/oauth2/token";
	public static final String apiUri = "https://api.twitter.com/1.1/statuses/user_timeline.json";
	public static final String apiUriQueryParam_1 = "?screen_name=";
	public static final String apiUriQueryParam_2 = "&count=";
}
