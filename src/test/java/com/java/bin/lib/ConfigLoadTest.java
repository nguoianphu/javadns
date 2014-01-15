package com.java.bin.lib;

import org.junit.Test;

import com.java.lib.ConfigLoad;

import junit.framework.TestCase;

public class ConfigLoadTest extends TestCase {

	@Test
	public void testLoadName() {
		ConfigLoad config = new ConfigLoad();
		int items = config.loadname("src\\config.txt");
		assertEquals(4, items);
	}

}
