package com.java.bin;

import java.io.IOException;

public class DummyDNS {

	public DummyDNS(String[] args) {

		if (args.length < 1) {

			DummyGUI dummyGUI = new DummyGUI();

		} else {

			try {

				DummyDNSThread dymmyDNSThread;
				dymmyDNSThread = new DummyDNSThread(args[0]);
				Thread dummyThread = new Thread(dymmyDNSThread);
				dummyThread.start();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
