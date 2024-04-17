
import java.io.BufferedReader; 
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CharacterFrequencyCounter {
    public static void main(String[] args) {
        String inputFile = "/Users/chris/Desktop/cano.txt"; //Define variables for Input/Output
        String outputFile = "frequency.txt";
//Create a BufferedReader called reader. It uses a FileReader object to connet the file to the BufferedReader.
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            Map<Character, Integer> charFrequencies = new HashMap<>(); //HashMap named charFrequencies to store the character frequencies.
//While loop used to read the file character by character until the end of the file is reached
            int charCode;
            while ((charCode = reader.read()) != -1) { // != -1 signifies end of the file.
                char character = (char) charCode; //Character code is converted to a 'char' type
                if (!Character.isWhitespace(character)) { //checks if character is whitespace, if not it updates the frequency count in the charFrequncies map using charFrequncies.put and 
                	//charFrequencies-getOrDefault methods.
                    charFrequencies.put(character, charFrequencies.getOrDefault(character, 0) + 1);
                }
            }
            //writes frequencies to output file.
            writeFrequenciesToFile(charFrequencies, outputFile);
            System.out.println("Frequency data written to " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//helper method that takes a Map <Character, Integer> named frequencies and a String named outputfile as parameters.
    // It writes the character frequencies to the outputfile.
    //A bufferedWriter named writer is created to write the data to the output fie using a FileWriter. The method then iterates over the entries of the frequencies map with a for each loop.
    //For each entry, it writes a character key and its corresponding frequency value to the file using writer.write().
    //It also writes a newline character using writer.newLine() to separate each entry on a new line.
    private static void writeFrequenciesToFile(Map<Character, Integer> frequencies, String outputFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
            	 char character = entry.getKey();
                 int frequency = entry.getValue();
            	
            	writer.write(character + ": " + createHistogram(frequency));
                writer.newLine();
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static String createHistogram(int frequency) {
        return String.valueOf(frequency); //value of method converts the frequency integer to is corresponding string representation.
    }

    
    /*private static String createHistogram(int frequency) {
		StringBuilder histogram = new StringBuilder();
		for (int i = 0; i < frequency;i++) {
			histogram.append("*"); //after each iteration of the loop an asteriks is added to the histogram string.
		}
		return histogram.toString();//converts the histogram StringBuilder to a regular String, since a String return type is expected.
    	
    }
    */
}
