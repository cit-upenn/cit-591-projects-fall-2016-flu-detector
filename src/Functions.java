import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Set;

import twitter4j.GeoLocation;

public class Functions {
	
	private LocationGetter lg;
	private KeywordsGetter kg;
	private GeoLocation location;
	
	public Functions(){
		try {
			lg = new LocationGetter("Locations.csv");
			kg = new KeywordsGetter("keywords.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		
		FluScoreCaculator f = new FluScoreCaculator(kg);
		Collector c = new Collector();
		DateCalculator d = new DateCalculator(3);
		
		ArrayList<Integer> counts = new ArrayList<Integer>();
		ArrayList<String> keywords = new ArrayList<String>();
		
		int numberOfPeriods = 2;
		
		double[] fluScoreArray = new double[numberOfPeriods];

		c.setLocation(location);

		for(int i = 1; i<=numberOfPeriods; i++){
			c.setSince(d.getStartDate());
			c.setUntil(d.getEndData());
			
			counts.clear();
			keywords.clear();
			
			for(String key: kg.getKeywords()){
					counts.add(c.search(key));
				keywords.add(key);
			}
			
			
			fluScoreArray[i-1] = f.getfluScore(counts, keywords);

			d.moveBackward();
		}


		FluPredictor fp = new FluPredictor(fluScoreArray[1], fluScoreArray[0]);

		return fp.alert();
		
		
		
	}

	
	
}
