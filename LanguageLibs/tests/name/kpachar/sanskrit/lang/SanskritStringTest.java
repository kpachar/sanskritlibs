package name.kpachar.sanskrit.lang;

import static org.junit.Assert.*;

import org.junit.Test;

public class SanskritStringTest {

	@Test
	public void test() {
		String str=new SanskritString("कृष्ण").toCanonicalString();
		System.out.println(str);
		assertEquals(str, "क्ऋष्ण्अ");
		
	}

}
