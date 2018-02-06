# twitter-feed-reader-java
Please use below url to validate application:
https://twitterfeedreaderjavaapp.azurewebsites.net/

About CodeBase:

- src/com/myapp - folder has java code for Controller and RESTClient used to invoke Twitter REST API
- test/com/myapp - folder has junit tests
- index.html has the code to display values on UI, I used AngularJS to quickly display data fetched from Controller
- This is hosted on Azure free trial cloud for now.

Future Scope Items:
- There is still scope for more junit test cases
- UI can be done little bit more pretty
- I tried writing a main class to act as stand alone server instead of deploying to cloud, but for some reason AJAX calls did not work so I had to use cloud.
- I created a dummy twitter account and fetched consumer key and hardcoded it in code, it could have been done in a better way by providing login screen and integrating with SSO of twitter
