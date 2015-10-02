package name.kpachar.sanskrit.lang;

import java.util.ArrayList;
import java.util.List;

public class JavaStringUtils {
	public static final int[] codePoints(String s){
		int length = s.length();
		List<Integer> codePoints = new ArrayList<Integer>();
		for(int i=0; i<length;){
			int cp = s.codePointAt(i);
			i+=Character.charCount(cp);
			codePoints.add(cp);
		}
		int[] result = new int[codePoints.size()];
		for(int i=0; i<result.length; i++){
			result[i] = codePoints.get(i);
		}
		return result;
	}
}
