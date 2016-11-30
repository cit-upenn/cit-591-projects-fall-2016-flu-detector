import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateCalculator {	
	
	private LocalDate localDate = LocalDate.now();
	private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private int period;
	
	public DateCalculator(int period) {
		this.period = period;
	}
	
	public String getStartDate() {
		return dateFormat.format(localDate.minusDays(period));
	}
	
	public String getEndData() {
		return dateFormat.format(localDate);
	}
	
	public void moveBackward() {
		localDate = localDate.minusDays(period);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DateCalculator dc = new DateCalculator(2);
		System.out.println(dc.getStartDate());
		System.out.println(dc.getEndData());
		
		dc.moveBackward();
		
		System.out.println(dc.getStartDate());
		System.out.println(dc.getEndData());
		
	}

}
