import java.util.ArrayList;
/**
 * This class contains a list of keywords
 * @author muyiyimiss
 *
 */
public class KeyWords {
	
	private ArrayList<String> keyWords;
	
	public KeyWords(){
		keyWords = new ArrayList<String>();
		addKeyWords();
	}
	
	public void addKeyWords(){
		keyWords.add("flu symptoms");
		keyWords.add("influenza");
		keyWords.add("fever flu");
		keyWords.add("fever cough");
		keyWords.add("cold flu");
	}
	
	public String getAKeyWord(int i){
		return keyWords.get(i);
	}
	
	public ArrayList<String> getkeyWords(){
		return keyWords;
	}
	
}
