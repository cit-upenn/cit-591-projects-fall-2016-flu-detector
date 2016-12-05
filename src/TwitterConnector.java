import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterConnector {

	public static Twitter getTwitter() {

		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		.setOAuthConsumerKey("VzKbJjQHrc3fxS7hm2DGGi3hm")
		.setOAuthConsumerSecret("sB6lvUpN601KWXk0tiE6VgfEu6oVtoToNKrN46Ir3D82gF7IEU")
		.setOAuthAccessToken("1036064185-bacpuZqOca8iSdUF8neqKA5uMok1zDi1vXalGAw")
		.setOAuthAccessTokenSecret("VC610RpP6mcLk0L9qB7kcbe6IS0woSsuxxMEOyOhDc8ie");

		return new TwitterFactory(cb.build()).getInstance();

	}

	public static Twitter getTwitterBackup() {

		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		.setOAuthConsumerKey("JPlfMmqWtSqJzmENJV7FjbbyZ")
		.setOAuthConsumerSecret("1LPzdw2vuQFGHvs1ZiW7GpcOzOBLRhYuQkvBVOhKBHU5EUXGRT")
		.setOAuthAccessToken("512682400-xWHuVGLbkIWeEJY0OVyG5ATUOrDq0DYIm59nqjTz")
		.setOAuthAccessTokenSecret("FyKmeCiG5aQHSSd0GrlAxi6kpOwjXn4ab3f2ttHWrWI8l");

		return new TwitterFactory(cb.build()).getInstance();

	}

}
