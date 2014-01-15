package com.java.lib;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

import sun.util.logging.resources.logging;

public class ConfigLoad {

	private Hashtable names = new Hashtable();

	public int loadname(String fileConfig) {

		BufferedReader bf;
		String line;
		int items = -1;
		try {
			
			// read config file
			bf = new BufferedReader(new FileReader(fileConfig));
			items = 0;

			// read line by line
			try {
				while ((line = bf.readLine()) != null) {
					String name = null;
					String ip = null;
					InetAddress addr;

					// parse line by line
					try {

						// empty line
						if (line.length() <= 0) {
							continue;
						}

						// comment start with #
						if (line.charAt(0) == '#') {
							continue;
						}

						/*
						 * get name and IP i.e PC1 192.168.1.1 PC2 192.168.1.2
						 */

						StringTokenizer labels = new StringTokenizer(line, "\t");
						if (labels.hasMoreTokens()) {
							name = labels.nextToken();
							new Log().log("name " + name);
						}
						if (labels.hasMoreTokens()) {
							ip = labels.nextToken();
							new Log().log("ip " + ip);
						}

					} catch (Exception e) {
						new Log().log("Cannot parse " + fileConfig + " : " + e);
					}

					// got the right line, i.e PC1 192.168.0.1
					// put it into the address memory
					if ((name != null) && (ip != null)) {

						try {

							addr = InetAddress.getByName(ip);
							names.put(name, addr.getAddress());
							items++;

						} catch (UnknownHostException e) {
							new Log().log("Cannot get " + line + " : " + e);
						}

					} else {

						new Log().log("Cannot get null line of : " + line);
					}

				} // end while

				// Add the localhost
				try {
					InetAddress addr = InetAddress.getByName("127.0.0.1");
					names.put("localhost", addr.getAddress());
					items++;

				} catch (UnknownHostException e) {
					new Log().log("Cannot get localhost: " + e);
				}

				// close the buffer
				bf.close();

			} catch (IOException e) {
				new Log().log("Cannot read " + fileConfig + " : " + e);
			}
		} catch (FileNotFoundException e) {
			new Log().log("Cannot open " + fileConfig + " : " + e);
		}

		return items;
	}
}
