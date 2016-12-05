import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Set;

import twitter4j.GeoLocation;

public class LocationGetter {

	private HashMap<String,GeoLocation> map;
	private String path;
	
	public LocationGetter(String path) throws FileNotFoundException {
		
		this.path = path;
		map = new HashMap<>();
		mapInit();
		
	}
	
	private void mapInit() throws FileNotFoundException{
		FileReader in = new FileReader(path);
		String line;
		String[] temp;
		GeoLocation location;
		
		while (in.hasNextLine()) {
			line = in.nextLine();
			temp = line.split(",");
			location = new GeoLocation(Double.parseDouble(temp[1]),Double.parseDouble(temp[2]));
			map.put(temp[0], location);
		}
	}
	
	public GeoLocation getLocation(String state) {
		return map.get(state);
	}
	
	public Set<String> getStates(){
		return map.keySet();	
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		LocationGetter lg = new LocationGetter("Locations.csv");
		System.out.println(lg.getStates());
	}
}
