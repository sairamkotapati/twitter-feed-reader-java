/**
 * 
 */
package com.myapp;

/**
 * This class holds variables required to hold data that needs to be displayed on UI
 * 
 * @author Sairam Kotapati
 *
 */
public class TwitterFeedModel
{
	public String userName;
	public String screenName;
	public String profileImageURL;
	public String tweetContent;
	public int retweetCount;
	public String tweetDate;
	
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getScreenName()
	{
		return screenName;
	}
	public void setScreenName(String screenName)
	{
		this.screenName = screenName;
	}
	public String getProfileImage()
	{
		return profileImageURL;
	}
	public void setProfileImage(String profileImage)
	{
		this.profileImageURL = profileImage;
	}
	public String getTweetContent()
	{
		return tweetContent;
	}
	public void setTweetContent(String tweetContent)
	{
		this.tweetContent = tweetContent;
	}
	public int getRetweetCount()
	{
		return retweetCount;
	}
	public void setRetweetCount(int retweetCount)
	{
		this.retweetCount = retweetCount;
	}
	public String getTweetDate()
	{
		return tweetDate;
	}
	public void setTweetDate(String tweetDate)
	{
		this.tweetDate = tweetDate;
	}
}
