package com.pumaray.lib.tools.generators.country;

import static org.junit.Assert.fail;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PumCountryMapDBGeneratorTest {

	private static final Logger logger = LoggerFactory.getLogger(PumCountryMapDBGeneratorTest.class);
	//private static final File inFile = new File("/home/randy/Projects/Chepaki/Development Files/small-country.txt");
	//private static final File outFile = new File("/home/randy/Projects/Chepaki/Development Files/small-country.db");
	private static final File inFile = new File("/home/randy/Projects/Chepaki/Development Files/allCountries.txt");
	private static final File outFile = new File("/tmp/allCountries.db");
	
	private static PumCountryMapDBGenerator generator;

	@BeforeClass
	public static void startUp() {
		generator = new PumCountryMapDBGenerator(inFile, outFile);
	}

	@Test
	public void testGenerate() {
		try {
			generator.generate();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			logger.debug("Error in Generate Test", ex);
			fail(ex.getMessage());
		}
	}

}
