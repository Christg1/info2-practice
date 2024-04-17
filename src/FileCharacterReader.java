import java.io.FileReader;
import java.io.IOException;


public class FileCharacterReader {

	private FileReader fileReader;
	
	public FileCharacterReader (String filePath) throws IOException {
		fileReader = new FileReader(filePath);
	}
	
	public int readNextCharacter() throws IOException{
		int character;
		while((character = fileReader.read())!= -1) {
			if (character != '\r') {
				return character;
			}
	}
		return -1;
	}
	
	public void close() throws IOException{
		fileReader.close();
	}
	
	public static void main (String[] args) {
		try {
			FileCharacterReader reader = new FileCharacterReader("/Users/chris/Desktop/cano.txt");
			int nextChar;
			while((nextChar = reader.readNextCharacter()) != -1) {
				System.out.print((char) nextChar);
			}
			reader.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}