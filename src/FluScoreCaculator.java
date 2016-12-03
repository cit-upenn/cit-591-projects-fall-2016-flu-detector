import java.io.FileNotFoundException;

import twitter4j.GeoLocation;
import twitter4j.Location;
import twitter4j.TwitterException;
/**
 * This class will calculate the flu score given the start time and end time of a period
 * @author muyiyimiss
 *
 */
public class FluScoreCaculator {

	private KeywordsGetter keywordsGetter;

	public FluScoreCaculator(){
		try {
			keywordsGetter = new KeywordsGetter("keywords.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public double getfluScore(Collector keyWordsCollector){

		int c;
		double fluScore = 0;
		
		try {
			
			for(String key: keywordsGetter.getKeywords()){

				c = keyWordsCollector.search(key);

				double score = c*keywordsGetter.getKeywordWeight(key);

				fluScore += score;

			}
		} catch (TwitterException e) {

			e.printStackTrace();
		}

		return fluScore;
	}

}
