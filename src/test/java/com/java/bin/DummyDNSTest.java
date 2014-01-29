package com.java.bin;

import junit.framework.TestCase;

public class DummyDNSTest extends TestCase{
	
	public void testDummyDNSGUI() {
		DummyDNS dummyDNS = new DummyDNS();
		dummyDNS.init(new String[] {"src/config.txt"});
		
		assertNotNull(dummyDNS);
	}

}
