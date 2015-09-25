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

		//assertEquals(LangUtils.sandhi("विष्णु", "पदे"), "विष्णुपदे");
		//assertEquals(LangUtils.sandhi("ईश", "पदे"), "ईशपदे");
		//assertEquals(LangUtils.sandhi("प्राणी", "ईश"), "प्राणेश");
		
	}

}
