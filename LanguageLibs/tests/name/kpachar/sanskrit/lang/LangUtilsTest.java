package name.kpachar.sanskrit.lang;

import static org.junit.Assert.*;

import org.junit.Test;

public class LangUtilsTest {

	@Test
	public void testSandhi() {
		assertEquals(LangUtils.sandhi("देव", "अधिदेव"), "देवाधिदेव");
		assertEquals(LangUtils.sandhi("भ्रमति", "इव"), "भ्रमतीव");
		assertEquals(LangUtils.sandhi("गुरु", "उपदेशः"), "गुरूपदेशः");
		assertEquals(LangUtils.sandhi("पितृ", "ऋणम्"), "पितॄणम्");
		
		assertEquals(LangUtils.sandhi("स्व", "इच्छा"), "स्वेच्छा");
		assertEquals(LangUtils.sandhi("रमा", "ईश"), "रमेश");
		assertEquals(LangUtils.sandhi("युध्य", "इति"), "युध्येति");
		
		assertEquals(LangUtils.sandhi("शीत", "उष्ण"), "शीतोष्ण");
		assertEquals(LangUtils.sandhi("महा", "ऋषि"), "महर्षि");
		assertEquals(LangUtils.sandhi("देव", "ऋषि"), "देवर्षि");
		
		assertEquals(LangUtils.sandhi("ब्रह्म", "ऎश्वर्यम्"), "ब्रह्मैश्वर्यम्");
		assertEquals(LangUtils.sandhi("महा", "औजस"), "महौजस");
		
	}

}
