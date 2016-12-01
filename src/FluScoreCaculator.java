import twitter4j.TwitterException;
/**
 * This class will calculate the flu score given the start time and end time of a period
 * @author muyiyimiss
 *
 */
public class FluScoreCaculator {
	
	private Collector keyWordsCollector;
	private KeyWords keywords;
	private String startTime;
	private String endTime;
	
	public FluScoreCaculator(){
		keyWordsCollector = new Collector();
		keywords = new KeyWords();
	}
	
	public void setSince(String startTime) {
		this.startTime = startTime;
	}

	public void setUntil(String endTime){
		this.endTime = endTime;
	}
	
	public int[] getKeywordsCounts(){
		
		keyWordsCollector.setSince(startTime);
		keyWordsCollector.setUntil(endTime);
		
		int size = keywords.getkeyWords().size();
		
		int[] counts = new int[size];
		
		for(int i = 0; i<size; i++){
			try {
				counts[i] = keyWordsCollector.search(keywords.getAKeyWord(i));
			} catch (TwitterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return counts;
	}

	
	public double calculateFlueScore(){
		double flueScore = 0;
		
		int[] counts = getKeywordsCounts();
		
		flueScore = 0.35*counts[0] + 0.35*counts[1] + 0.1*counts[2] + 0.1*counts[3]+ 0.1*counts[4];
		
		return flueScore;
	}
	



	
	
}
