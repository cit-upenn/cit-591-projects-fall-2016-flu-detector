import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.*;

import twitter4j.GeoLocation;
import twitter4j.TwitterException;
//

public class FluSwing implements ActionListener {

	private JFrame frame;
	private JLabel alertLabel;
	//private JLabel locationLabel;
	private JTextField alertMessage;
	//private JTextField locationMessage;
	private JButton fbutton;
	private JComboBox<String> comboBox; 
	private LocationGetter lg;
	private GeoLocation location;
	
	
	public FluSwing() {
		try {
			lg = new LocationGetter("Locations.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		comboBox = new JComboBox<String>();
		
		for (String stats : lg.getStats()) {
			comboBox.addItem(stats);
		}
		comboBox.setSelectedIndex(0);
		
		frame = new JFrame("Flu Alert");
		alertLabel = new JLabel("Flu alert message: ");
		//locationLabel = new JLabel("Enter your location: ");

		alertMessage = new JTextField(5);
		//locationMessage = new JTextField(5);


		fbutton = new JButton("Click me to see whethere there is a flu or not!");

		frame.setLayout(new GridLayout(4, 1));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(comboBox);
		
		frame.add(alertLabel);
		
		frame.add(alertMessage);
		//frame.add(locationLabel);
		//frame.add(locationMessage);
		
		frame.add(fbutton);
		comboBox.addActionListener(this);
		fbutton.addActionListener(this);

		frame.pack();
		frame.setSize(800, 600);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource().equals(comboBox)) {
			JComboBox<String> cb = (JComboBox)arg0.getSource();
	    	String state = (String) cb.getSelectedItem();
			location = lg.getLocation(state);
			return;
		}
		
		if (arg0.getSource().equals(fbutton)) {

			FluScoreCaculator f = new FluScoreCaculator();
			Collector c = new Collector();
			DateCalculator d = new DateCalculator(2);
			KeyWords keywords = new KeyWords();

			int size = keywords.getkeyWords().size();
			int numberOfPeriods = 2;
			double[] fluScoreArray = new double[numberOfPeriods];

			//locationMessage.getText();
			c.setLocation(location);

			for(int i = 1; i<=numberOfPeriods; i++){
				c.setSince(d.getStartDate());
				c.setUntil(d.getEndData());


				int[] counts = new int[size];

				for(int j = 0; j<size; j++){

					try {
						counts[j] = c.search(keywords.getAKeyWord(j));
					} catch (TwitterException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				fluScoreArray[i-1] = f.calculateFlueScore(counts);

				d.moveBackward();
			}


			FluPredictor fp = new FluPredictor(fluScoreArray[1], fluScoreArray[0]);

			boolean isFlu = fp.alert();

			if(isFlu){
				String s = "It is likely to be a flu soon! Be prepared!";
				alertMessage.setText(s);
			}else{
				String s = "It is not likely to be a flu soon! Relax but pay attention!";
				alertMessage.setText(s);
			}



		}


	}

}
