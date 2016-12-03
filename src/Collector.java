//
import twitter4j.GeoLocation;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Collector {
	
	private Twitter twitter;
	private String startTime;
	private String endTime;
	private GeoLocation location;
	
	public Collector() {

		twitter = TwitterConnector.getTwitter();

	}
	
	public void setSince(String startTime) {
		this.startTime = startTime;
	}
	
	public void setUntil(String endTime){
		this.endTime = endTime;
	}
	
	public void setLocation(GeoLocation location) {
		this.location = location;
		
	}
	
	public int search(String keyword) throws TwitterException {
		
		Query query = new Query(keyword);
		query.setCount(100);
		query.setSince(startTime);
		query.setUntil(endTime);
		query.setGeoCode(location, 150, Query.MILES);
		
		QueryResult result;
		int count = 0;

		for(;;) {
			
			result = twitter.search(query);
			count += result.getTweets().size();
			
//			Status status = result.getTweets().get(0);
//			System.out.println(status.getUser().getScreenName() + status.getCreatedAt()+ ":" + status.getText() );
			
			if (!result.hasNext()){
				return count;
			}
			
			query = result.nextQuery();
//			
		}
		
	}
	/*
	 * https://dev.twitter.com/rest/reference/get/search/tweets
	 * the search index has a 7-day limit. In other words, no tweets will be found for a date older than one week.
	 */
	// some commit from another local repo
	//test pull cofiliction
	
	public static void main(String[] args) throws TwitterException {
		
		String[] keywords = {"flu symptoms","influenza","fever flu","fever cough","cold flu"};
		int[] counts = new int[keywords.length];
		
		Collector c = new Collector();
		c.setSince("2016-11-27");
		c.setUntil("2016-11-28");
		c.setLocation(new GeoLocation(39.954435, -75.194937));
		
		for (int i = 0 ; i < keywords.length ; i ++) {
			counts[i] = c.search(keywords[i]);
			System.out.printf("The number of tweets containing \"%s\" : %d%n",keywords[i],counts[i]);
		}
		
	}
}
