//FileReader.java

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * read a ascii file line by line
 * @author CJC
 *
 */
class FileReader {
	private File input;
	private Scanner in;
	
	/**
	 * create a new file reader object
	 * @param path the path of the input file
	 * @throws FileNotFoundException
	 */
	public FileReader(String path) throws FileNotFoundException{

		input = new File(path);
		in = new Scanner(input);

	}
	
	/**
	 * check if the input fine has more line
	 * @return true if the the input file has next line
	 */
	public boolean hasNextLine() {
		return in.hasNextLine();
	}

	/**
	 * return the next line of the input file.
	 * @return
	 */
	public String nextLine() {
		return in.nextLine();
	}

	public static void main(String[] args) {
		String path = "files/alice-in-wonderland.txt";
		try {
			FileReader in = new FileReader(path);
			System.out.println(in.nextLine());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

