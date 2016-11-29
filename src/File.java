import java.util.HashMap;
import java.util.Map;

/** 
 * File
 * In memory representation of a file
 * @author Audchadaporn
 *
 */
class File extends java.io.File {

	private static final long serialVersionUID = 1L;
	
	private Map<String, Integer> dict = new HashMap<String, Integer>(); // save words and the times the words are found in the file.
	private int score = 0;	// ranking score, indicates the percent the searched words are found in this file.

	public File(String pathName) {
		super(pathName);
	}

	public Map<String, Integer> getContent() {
		return dict;
	}

	public void setContent(Map<String, Integer> dict) {
		this.dict = dict;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}
