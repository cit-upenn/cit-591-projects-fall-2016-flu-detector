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

	public static void main(String[] args) throws TwitterException {
		
		Twitter tw = TwitterConnector.getTwitter();
		Twitter tw1 = TwitterConnector.getTwitter();
		Twitter tw2 = TwitterConnector.getTwitterBackup();
		Query q = new Query("Trump");
		q.setCount(2);
		q.setUntil("2016-12-01");
		
		QueryResult r  = tw.search(q); 
		QueryResult r1 = tw1.search(q);
		QueryResult r2 = tw2.search(q);

		List<Status> t  = r.getTweets(); 
		List<Status> t1 = r1.getTweets();
		List<Status> t2 = r2.getTweets();
		
		for (Status s : t) {
			System.out.println(s.getCreatedAt() + s.getText());
		}
		System.out.println("---------------------------------------------");
		for (Status s1 : t1) {
			System.out.println(s1.getCreatedAt() + s1.getText());
		}
		System.out.println("---------------------------------------------");
		for (Status s2 : t2) {
			System.out.println(s2.getCreatedAt() + s2.getText());
		}
		System.out.println("---------------------------------------------");
		System.out.println("---------------------------------------------");
		
		
		q = r.nextQuery();
		tw = TwitterConnector.getTwitterBackup();
		t.addAll(tw.search(q).getTweets());
		t1.addAll(tw1.search(q).getTweets());
		t2.addAll(tw2.search(q).getTweets());

		for (Status s : t) {
			System.out.println(s.getCreatedAt() + s.getText());
		}
		System.out.println("---------------------------------------------");
		for (Status s1 : t1) {
			System.out.println(s1.getCreatedAt() + s1.getText());
		}
		System.out.println("---------------------------------------------");
		for (Status s2 : t2) {
			System.out.println(s2.getCreatedAt() + s2.getText());
		}
		System.out.println("---------------------------------------------");
		System.out.println("---------------------------------------------");

		
		if (true) return;
		q = r2.nextQuery();
		t1.addAll(tw1.search(q).getTweets());
		t2.addAll(tw2.search(q).getTweets());
		
		for (Status s1 : t1) {
			System.out.println(s1.getCreatedAt() + s1.getText());
		}
		System.out.println("---------------------------------------------");
		for (Status s2 : t2) {
			System.out.println(s2.getCreatedAt() + s2.getText());
		}
		
		//		Status s1,s2;
		//		for (int i = 0 ; i < 10 ; i++) {
		//			s1 = t1.get(i);
		//			s2 = t2.get(i);
		//			System.out.println(s1.getText());
		//			System.out.println(s2.getText());
		//		}
	}

}
