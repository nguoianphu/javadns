package com.java;

import com.java.bin.DummyDNS;

/**
 * Hello world!
 *
 */
public class App 
{
//    public App() {
//	}

	public static void main( String[] args )
    {
    	DummyDNS dummyDNS = new DummyDNS();
    	dummyDNS.init(args);
        System.out.println( "Hello World!" );
    }
}
