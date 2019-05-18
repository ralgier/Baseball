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
		String marioFile = "MarioBatters.csv";
		marioFile = args[0];
		String peachFile = "PeachBatters.csv";
		peachFile = args[1];
		String yoshiFile = "YoshiBatters.csv";
		yoshiFile = args[2];
		String dkFile = "DKBatters.csv";
		dkFile = args[3];
		String warioFile = "WarioBatters.csv";
		warioFile = args[4];
		String bowserFile = "BowserBatters.csv";
		bowserFile = args[5];
		int x = 0;

		try {
			Scanner scanner = new Scanner(new File(args[x]));
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
