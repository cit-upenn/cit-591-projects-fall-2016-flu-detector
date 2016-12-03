import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Set;


public class KeywordsGetter {
	
	private HashMap<String,Double> keywordsmap;
	private String path;
	
	public KeywordsGetter(String path) throws FileNotFoundException {
		
		this.path = path;
		keywordsmap = new HashMap<>();
		mapInit();
		
	}
	
	private void mapInit() throws FileNotFoundException{
		FileReader in = new FileReader(path);
		String line;
		String[] temp;
		
		while (in.hasNextLine()) {
			line = in.nextLine();
			temp = line.split(",");
			keywordsmap.put(temp[0],Double.parseDouble(temp[1]));
		}
	}
	
	public Double getKeywordWeight(String keyword) {
		return keywordsmap.get(keyword);
	}
	
	public Set<String> getKeywords(){
		return keywordsmap.keySet();	
	}
	
	public int getKeywordsSize(){
		return keywordsmap.keySet().size();	
	}
	
	public HashMap<String,Double> getKeywordsMap(){
		return keywordsmap;
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		KeywordsGetter kg = new KeywordsGetter("keywords.csv");
		
		System.out.println(kg.getKeywords());
	}
	
	
}
