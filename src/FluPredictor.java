import java.util.ArrayList;
/**
 * This class will predict flu, given the flu score of the first period and the second period
 * @author muyiyimiss
 *
 */
public class FluPredictor {

	private double firstPeriodFS;
	private double secondPeriodFS;

	public FluPredictor(double firstPeriodFS, double secondPeriodFS) {
		this.firstPeriodFS = firstPeriodFS;
		this.secondPeriodFS = secondPeriodFS;
	}
	
	public boolean alert(){
		
		double increaseRate = 0;
		
		increaseRate = (firstPeriodFS - secondPeriodFS)/firstPeriodFS;
		
		if(increaseRate >= 0.3){
			
			return true;
			
		}else{
			
			return false;
		}
		
	}
	

	
}

