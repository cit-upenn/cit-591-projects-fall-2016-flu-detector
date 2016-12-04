import java.util.ArrayList;
/**
 * This class will predict flu, given the flu score of the first period and the second period
 * @author muyiyimiss
 *
 */
public class FluPredictor {

	private double fsBefore;
	private double fsNow;

	public FluPredictor(double firstPeriodFS, double secondPeriodFS) {
		this.fsBefore = firstPeriodFS;
		this.fsNow = secondPeriodFS;
	}
	
	public boolean alert(){
		
		double increaseRate = 0;
		
		increaseRate = (fsNow - fsBefore)/fsBefore;
		
		if(increaseRate >= 0.3){
			
			return true;
			
		}else{
			
			return false;
		}
		
	}
	

	
}

