package com.java.bin;

import junit.framework.TestCase;

import org.junit.*;

public class DummyDNSThreadTest extends TestCase {

	/**
	 * @throws Exception
	 */
	@Test
	public void testDummyDNSThread() throws Exception {

		DummyDNSThread dummyDNSThread = new DummyDNSThread("test");
		Thread t = new Thread(dummyDNSThread);
		t.start();
		
		assertNotNull(dummyDNSThread);
		assertNotNull(t);
		// assertEquals("RUNNABLE", dummyDNSThread.toString());
	}

}
