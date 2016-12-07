//
import java.util.ArrayList;
import java.util.Random;

import twitter4j.GeoLocation;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class Collector {
	
	private Twitter twitter;
	private String startTime;
	private String endTime;
	private GeoLocation location;
	private ArrayList<Status> exampleTweets;
	private Random rand;
	
	public Collector() {
		twitter = TwitterConnector.getTwitter();
		exampleTweets = new ArrayList<>();
		rand = new Random();
	}
	
	public void resetCollector() {
		exampleTweets.clear();
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
	
	public Status getExampleTweet() {
		int index = rand.nextInt(exampleTweets.size());
		return exampleTweets.remove(index);
	}
	
	public int search(String keyword) throws LocationNotSelectedExeption {
		
		if (location == null) {
			throw new LocationNotSelectedExeption();
		}
		
		Query query = new Query(keyword);
		query.setGeoCode(location, 150, Query.MILES);
		query.setCount(100);
		query.setSince(startTime);
		query.setUntil(endTime);
		
		QueryResult result;
		int count = 0;

		for(;;) {
			
			try {
				
				result = twitter.search(query);
				exampleTweets.addAll(result.getTweets());
				count += result.getTweets().size();
				
				if (!result.hasNext()){
					return count;
				}				
		
				query = result.nextQuery();
		
			} catch (TwitterException e) {
				twitter = TwitterConnector.getTwitterBackup();
			}
			
		}
	}

}
