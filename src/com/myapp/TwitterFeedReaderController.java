package com.myapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Sairam Kotapati
 *
 */
public class TwitterFeedReaderController extends HttpServlet
{

	private static final long serialVersionUID = 1L;

	public TwitterFeedReaderController()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String responseObject = new TwitterRESTClient().retrieveAPIFeeds(10, "salesforce");
		PrintWriter writer = response.getWriter();
		writer.println(responseObject);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

}
