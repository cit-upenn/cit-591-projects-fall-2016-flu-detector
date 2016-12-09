import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import twitter4j.GeoLocation;
import twitter4j.Status;

public class Functions {
	
	private LocationGetter lg;
	private KeywordsGetter kg;
	private GeoLocation location;
	private Collector c; 
	private ArrayList<HashMap<String, Integer>> keywordsCounts;
	
	public Functions(){
		try {
			lg = new LocationGetter("Locations.csv");
			kg = new KeywordsGetter("keywords.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		c = new Collector();
		keywordsCounts = new ArrayList<HashMap<String, Integer>>();
		
	}
	
	public Set<String> getStates(){
		return lg.getStates();
	}
	
	public void setLocation(String state){
		
		location = lg.getLocation(state);
	}
	
	public GeoLocation getLocation(String state) {
		return lg.getLocation(state);
	}
	
	public boolean alert() throws LocationNotSelectedExeption{
		keywordsCounts.clear();
		FluScoreCaculator f = new FluScoreCaculator(kg);
		//Collector c = new Collector();
		DateCalculator d = new DateCalculator(3);
		c.resetCollector();
		ArrayList<Integer> counts = new ArrayList<Integer>();
		ArrayList<String> keywords = new ArrayList<String>();
		
		int numberOfPeriods = 2;
		
		double[] fluScoreArray = new double[numberOfPeriods];

		c.setLocation(location);

		for(int i = 1; i<=numberOfPeriods; i++){
			
			HashMap<String, Integer> k = new HashMap<String, Integer>();
			
			c.setSince(d.getStartDate());
			c.setUntil(d.getEndData());
			
			counts.clear();
			keywords.clear();
			
			for(String key: kg.getKeywords()){
				int count = c.search(key); 
				counts.add(count);
				keywords.add(key);
				k.put(key, count);
			}
			keywordsCounts.add(k);
			
			
			fluScoreArray[i-1] = f.getfluScore(counts, keywords);

			d.moveBackward();
		}


		FluPredictor fp = new FluPredictor(fluScoreArray[1], fluScoreArray[0]);

		return fp.alert();
		
	}
	
	public ArrayList<HashMap<String, Integer>> getkeyWordsCounts(){
		return keywordsCounts;
		
	}

	
	
}
