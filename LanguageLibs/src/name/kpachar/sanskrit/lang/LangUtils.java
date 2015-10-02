package name.kpachar.sanskrit.lang;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.IntConsumer;

public class LangUtils {
	private static List<SandhiRule> sandhiRules = null;
	private static synchronized void loadSandhiRules(){
		if(sandhiRules!=null)return;
		sandhiRules = new ArrayList<SandhiRule>();
		InputStream is = LangUtils.class.getResourceAsStream("sandhi.txt");
		try{
			LineNumberReader reader = new LineNumberReader(new InputStreamReader(is));
			String line = null;
			while((line = reader.readLine())!=null){
				line = cleanWhitepsaces(line);
				if(line.matches("^\\s*#")){
					continue;
				}
				line=line.replaceAll("\\s+"," ");
				line=line.trim();
				if(line.indexOf("=")<0){
					continue;
				}
				String input = line.split("=")[0].trim();
				String output = line.split("=")[1].trim();
				sandhiRules.add(
						new SandhiRule(
									input.split("\\+")[0].trim().codePointAt(0),
									input.split("\\+")[1].trim().codePointAt(0),
									output.codePoints().toArray()
								)
						);
			}
		}catch(Exception x){
			x.printStackTrace();
		}
	}
	static{
		loadSandhiRules();//TODO: de-uglify this
	}
	/**
	 * 
	 * @param a A word
	 * @param b Another word
	 * @return The sandhi of a and b
	 * <br />Eg: If a=प्राणी , b=ईश, sandhi(a,b)=प्राणेश
	 */
	public static String sandhi(String a, String b){
		int[] codePointsA = new SanskritString(a).getCodepoints();
		int[] codePointsB = new SanskritString(b).getCodepoints();;
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<codePointsA.length - 1; i++){
			sb.append(Character.toChars(codePointsA[i]));
		}
		sb.append(sandhi(codePointsA[codePointsA.length-1], codePointsB[0]));
		for(int i=1; i<codePointsB.length; i++){
			sb.append(Character.toChars(codePointsB[i]));
		}
		String result = SanskritString.toString(sb.toString().codePoints().toArray());
		System.out.println(result);
		return result;
	}
	private static String sandhi(int a, int b){
		int[] result = null;
		for(SandhiRule sr : sandhiRules){
			result = sr.apply(a, b);
			if(result!=null)break;
		}
		if(result==null)return "";
		return new String(result, 0, result.length);
	}
	
	public static String cleanWhitepsaces(String s){
		final StringBuffer sb = new StringBuffer();
		
		s.codePoints().forEach(new IntConsumer(){
			@Override
			public void accept(int arg0) {
				if(arg0 < 255){
					sb.append(Character.toChars(arg0));
					return;
				}
				if(Character.isSpaceChar(arg0) || arg0 > 8000){ //TODO: This is ugly. unicode has non-printable stuff spread out here and there. Fix it
					sb.append(" ");
				}else{
					sb.append(Character.toChars(arg0));
				}
			}
		});
		return sb.toString();
	}
}

