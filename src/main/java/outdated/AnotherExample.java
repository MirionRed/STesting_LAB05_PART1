package outdated;

import java.util.StringTokenizer;

public class AnotherExample {

	// Given a String words containing a sequence of smaller strings and
	// an integer x, return a String which contains the smaller strings
	// from words whose length is greater than x.

	public String combineStrings(String words, int x) {
		if(words == null) throw new IllegalArgumentException();
		StringTokenizer st = new StringTokenizer(words);
		String returnStr = "";
	
		while (st.hasMoreElements()) {
			String currentWord = (String) st.nextElement();
			if (currentWord.length() > x)
				returnStr = returnStr + currentWord + " ";
		}
		return returnStr.trim();
	}
}