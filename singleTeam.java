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

//class to read in single team
//takes in one team as argument ex: "MarioBatters.csv"
//will read in the values into an array and give assign them to players
public class singleTeam {

	public static void main(String args[]) {

		// create an array list to add the names to
		List<String> namesArray = new ArrayList<>();

		//put in "MarioBatters.csv" as argument - or whichever team you would like
		String team1 = args[0];

		try {
			Scanner scanner = new Scanner(new File(team1));
			//skip the first line
			scanner.next();
			while (scanner.hasNextLine()) {
	
				//read in the string and separate it by commas
				String toSeparate = scanner.next();
				String[] values = toSeparate.split(",");
				
				//define variables to store the values from the 
					String playerName = values[0];
					int singleProb = Integer.parseInt(values[1]);
					int doubleProb = Integer.parseInt(values[2]);
					int tripleProb = Integer.parseInt(values[3]);
					int homerunProb = Integer.parseInt(values[4]);
					int walkProb = Integer.parseInt(values[5]);
					//test run to see if everything is reading properly
					System.out.println("Player:" + playerName + " SingleProb:" + singleProb + 
							" Double Prob:" + doubleProb + " TripleProb:"+ tripleProb + " Homerun Prob:"
							+ homerunProb + " Walk Prob:" + walkProb);
				
//				//just prints out all the values from the array
//			    System.out.println(Arrays.toString(values));
			        
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		
		
		
		
		
	}//end of main
}//end of class
