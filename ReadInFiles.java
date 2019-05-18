import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ReadInFiles {

	public static void main(String args[]) {

		// create an array list to add the names to
		List<String> namesArray = new ArrayList<>();

		String team1 = args[0];
//		String team2 = args[1];

		try {
//			Scanner scanner = new Scanner(new File(args[x]));
			Scanner scanner = new Scanner(new File(team1));
			//skip the first line
			scanner.next();
			while (scanner.hasNextLine()) {
				//set the String to 
				String toSeparate = scanner.next();
				String[] values = toSeparate.split(",");
			    System.out.println(Arrays.toString(values));
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		
	}//end of main
}//end of class
