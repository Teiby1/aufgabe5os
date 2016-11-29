package de.teiby.os.a6;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilTest {
	
	@Test
	public void testistErstesHalbjahr() {
		assertTrue(Util.istErstesHalbjahr(1));
		assertTrue(Util.istErstesHalbjahr(6));
		assertTrue(!Util.istErstesHalbjahr(7));
		assertTrue(!Util.istErstesHalbjahr(12));
	}
	
}
