package name.kpachar.sanskrit.lang;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.map.MultiKeyMap;

public class LangUtils {
	/**
	 * 
	 * @param a A word
	 * @param b Another word
	 * @return The sandhi of a and b
	 * <br />Eg: If a=प्राणी , b=ईश, sandhi(a,b)=प्राणेश
	 */
	public static String sandhi(String a, String b){
		String str = "अ आ इ ई उ ऊ ऋ ॠ ए ऎ ऐ  ओ औ अं अम् अः"
				+ "कमा कमि कमी कमु कमू कमृ कमॄ कमे कमॆ कमै कमो कमौ कमं कमम् कमः";
		int[] cp = str.codePoints().toArray();
		for(int c : cp){
			System.out.println(String.valueOf(Character.toChars(c)));
		}
		int[] codePointsA = a.codePoints().toArray();
		int[] codePointsB = b.codePoints().toArray();
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<codePointsA.length - 1; i++){
			sb.append(Character.toChars(codePointsA[i]));
		}
		System.out.println(sb);
		sb.append(sandhi(codePointsA[codePointsA.length-1], codePointsB[0]));
		System.out.println(sb);
		for(int i=1; i<codePointsB.length; i++){
			sb.append(Character.toChars(codePointsB[i]));
		}
		System.out.println(sb);
		return sb.toString();
	}
	private static String sandhi(int a, int b){
		System.out.println("sandhi of "+String.valueOf(Character.toChars(a))+" and "+String.valueOf(Character.toChars(b)));
		//do this next.
		return String.valueOf(Character.toChars(a))+String.valueOf(Character.toChars(b));
	}
	private static boolean isSvara(String a){
		return(svaras.keySet().contains(a) || svaras.values().contains(a));
	}
	private static Map<String, String> svaras = new HashMap<String, String>();
	static{
		svaras.put("अ", "अ");
		svaras.put("आ", "ा");
		svaras.put("इ", "ि");
		svaras.put("ई", "ी");
		svaras.put("उ", "ु");
		svaras.put("ऊ", "ू");
		svaras.put("ऋ", "ृ");
		svaras.put("ॠ","ॄ");
		svaras.put("ए","े");
		svaras.put("ऐ","ै");
		svaras.put("ओ","ो");
		svaras.put("औ","ौ");
	}
	private static MultiKeyMap<String, String> sandhiMap = new MultiKeyMap<String, String>();
	private static final String VARNA = "VARNA";
	private static final String SVARA_A = "अ";
	static{
		sandhiMap.put(new MultiKey<String>("अ", "अ"), "ा");
		sandhiMap.put(new MultiKey<String>("ि", "ि"), "ी");
		sandhiMap.put(new MultiKey<String>("ु", "ु"), "ू");
		sandhiMap.put(new MultiKey<String>("ृ", "ृ"), "ॄ");
		sandhiMap.put(new MultiKey<String>("ो", "ो"), "ौ");
	}
}
