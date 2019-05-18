import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadInFiles {

	// read in the files?
	public static void main(String args[]) {

		// create an array list to add the names to
		List<String> namesArray = new ArrayList<>();

		// filename to read
		String fileName = "BowserBatters.csv";
		//String fileName = args[0];

		try {
			Scanner scanner = new Scanner(new File(fileName));
			while (scanner.hasNextLine()) {
				
//				String[] arrayToSeparate = new String[1];
//				List<String> list = new ArrayList<String>(Arrays.asList(arrayToSeparate.split(","))); 
				System.out.println(scanner.nextLine());
				
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}

}
