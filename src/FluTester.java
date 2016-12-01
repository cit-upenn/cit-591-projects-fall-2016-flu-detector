
public class FluTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FluScoreCaculator f = new FluScoreCaculator();
		DateCalculator dc = new DateCalculator(1);
		
		for (int i = 1 ; i <= 2 ; i++) {
			f.setSince(dc.getStartDate());
			f.setUntil(dc.getEndData());
			
			colo -> counts
			
			Flu
			
			dc.moveBackward();
			
		}
		
		
		if alert
		
		
		
		
		f.setSince("2016-11-27");
		f.setUntil("2016-11-28");
		
		double f1 = f.calculateFlueScore();
		f.setSince("2016-11-28");
		f.setUntil("2016-11-29");
		
		double f2 = f.calculateFlueScore();
		
		FluPredictor fp = new FluPredictor(f1, f2);
		
		if(fp.alert()){
			System.out.println("It is likely to be a flu soon");
		}else{
			System.out.println("It is not likely to be a flu soon");
		}
		
		
	}

}
