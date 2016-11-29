import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/** 
 * FileServices
 * Provides readFile and searchInFile services
 * @author Audchadaporn
 *
 */
public class FileServices {
	
	/**
	 * readFile function
	 * Read a text file and return the content of the file.
	 * @param file File to be read.
	 * @return HashMap<word, count> of the content in the file f,
	 * 			word  : a word in the file.
	 * 			count : the number of the word found in the file.
	 */
	public static Map<String, Integer> readFile(File file) {
		
		String line = null;
		Map<String, Integer> dict = new HashMap<String, Integer>();
		
		try {
            FileReader fileReader = new FileReader(file.getAbsolutePath());
            
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
            	String[] words = line.split("\\W");		// split by A non-word character regex
            	for(String wd : words) {
            		Integer count = 1;
            		if(dict.containsKey(wd)) count = Integer.sum(1, dict.get(wd));	// if the word is already exist, count++
            		
            		dict.put(wd.toLowerCase(), count);	// support case insensitive search
            	}
            	
            }   

            bufferedReader.close();
		}
		catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                file.getName() + "'");    
//            ex.printStackTrace();
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + file.getName() + "'");
//            ex.printStackTrace();
        }
		
		return dict;
	}
	
	/**
	 * searchInFile function
	 * Search words in the file and return the percent the words are found.
	 * @param file File to be searched in.
	 * @param line Words to be searched in the file.
	 * @return the int percent the words are found.
	 */
	public static int searchInFile(File file, String line) {
		
		Map<String, Integer> dict = file.getContent();
		
		String[] words = line.split("\\W");
		float found = 0;
		float wordsNum = words.length;
		if(wordsNum != 0) {
			for (String wd : words) {
				if(dict.containsKey(wd.toLowerCase())) found++;	// support case insensitive search
			}
			
			return (int)((found * 100.0f) / wordsNum);
		}
		
		return (int)found;
	}
}
