import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/** 
 * SearchEngine, the main class
 * A program allows users to search any words in text files in a given directory.
 * It receives a directory path as a program argument.
 * 
 * @author Audchadaporn
 *
 */
public class SearchEngine {
	
	/**
	 * main function
	 * Read text files in a given directory and create 'File' objects to store the content of each file.
	 * Prompt to receive input from keyboard, used to search.
	 * Print top ten matching filenames and percent the words are found in each file, in descending order. 
	 * @param args[0] a directory path
	 */
	public static void main(String[] args) {
		
		if (args.length == 0 ) {
			throw new IllegalArgumentException( "No directory given to index." );
		}
		
		System.out.println("Loading...");
		
		ArrayList<File> dir = new ArrayList<File>();	// A directory
		Path dirPath = Paths.get(args[0]);
		int fileNum = 0;
		
		try(DirectoryStream<Path> stream = Files.newDirectoryStream(dirPath, "*.{txt}")){	// read only text files.
		    for (Path entry: stream) {
		        
		        // save this file into memory
		        File tmpFile = new File(entry.toString());
		        
		        // read and save the content
		        tmpFile.setContent(FileServices.readFile(tmpFile));
		        
		        dir.add(tmpFile);
		        fileNum++;
		    }
		} catch (IOException ex) {
		    System.err.println(ex);
		}
		
		// Print the number of text files in the directory
		System.out.printf("%d file(s) read in directory %s \n", fileNum, dirPath.toString());
		
		Scanner keyboard = new Scanner(System.in);			
		while (true) {
			System.out.print("search> ");
			final String line = keyboard.nextLine();
			if(line.equalsIgnoreCase(":quit")) {
				keyboard.close();
				System.exit(0);
			}
			
			long startTime = System.currentTimeMillis();
			ArrayList<File> fileList = new ArrayList<File>();	// a list of files sorted by score.
			
			for(File file : dir) {
				int percent = FileServices.searchInFile(file, line);
				if(percent != 0) {	// Not print files excludes the line
					file.setScore(percent);
					fileList.add(file);
				}
			}
			
			if(fileList.isEmpty()) {
				System.out.print("no matches found \n");
			}
			else {
				// sort by score
				Collections.sort(fileList, new Comparator<File>() {
					@Override
					public int compare(File f1, File f2) {
						return f2.getScore() - f1.getScore();
					}
				});
				
				// print top ten matching files
				fileList.stream()
						.filter(f -> f != null)
						.limit(10)
						.forEach(f -> System.out.printf("%s : %d%%\n", f.getName(), f.getScore()));
				
				// reset score of each file
				for(File file : dir) file.setScore(0);
			}
			
			System.out.printf("This search took %d milliseconds. \n", System.currentTimeMillis() - startTime);
		}
	}
}