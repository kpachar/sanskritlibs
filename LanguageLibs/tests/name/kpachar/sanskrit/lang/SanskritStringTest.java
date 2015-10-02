package name.kpachar.sanskrit.lang;

import static org.junit.Assert.*;

import org.junit.Test;

public class SanskritStringTest {

	@Test
	public void test() {
		SanskritString str = new SanskritString("श्रीकृष्णः");
		System.out.println(str.toCanonicalString());
		System.out.println(SanskritString.toString(str.getCodepoints()));
		assertEquals(str.toCanonicalString(), "श्"+"र्"+"ई"+"क्ऋष्"+"ण्अः");
		
		str = new SanskritString("इमे रंगरजते");
		System.out.println(str.toCanonicalString());
		System.out.println(SanskritString.toString(str.getCodepoints()));
		assertEquals(str.toCanonicalString(), "इम्ए र्"+"अङ्ग्अर्"+"अज्अत्ए");
	}

}
