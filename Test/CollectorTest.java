import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import twitter4j.GeoLocation;

public class CollectorTest {

	Collector c;
	
	@Before
	public void init() {
		c = new Collector();
	}
	
	@Test
	public void testExampleTweets() {
		int count = 0;
		c.setSince("2016-12-05");
		c.setUntil("2016-12-06");
		c.setLocation(new GeoLocation(47.6097, -122.3331));
		try {
			count = c.search("qwerty");
		} catch (LocationNotSelectedExeption e) {
		}
		
		System.out.println(count);
		System.out.println(c.getExampleTweet().getText());
		
	}

}
