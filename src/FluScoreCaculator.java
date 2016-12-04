import java.util.ArrayList;

/**
 * This class will calculate the flu score given the start time and end time of a period
 * @author muyiyimiss
 *
 */
public class FluScoreCaculator {

	private KeywordsGetter keywordsGetter;

	public FluScoreCaculator(KeywordsGetter keywordsGetter){
		this.keywordsGetter = keywordsGetter;
	}

	public double getfluScore(ArrayList<Integer> counts, ArrayList<String> keywords){

		double fluScore = 0;

		for(int i = 0; i<counts.size(); i++){
			
			fluScore += counts.get(i)*keywordsGetter.getKeywordWeight(keywords.get(i));

		}

		return fluScore;
	}

}
