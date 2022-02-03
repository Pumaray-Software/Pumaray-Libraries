package com.pumaray.lib.tools.generators.country;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentNavigableMap;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mapdb.DB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pumaray.lib.tools.generators.country.model.PumCountry;

public class PumCountryXMLGeneratorTest {

	/**private final static Logger logger = LoggerFactory.getLogger(PumCountryXMLGeneratorTest.class);
	// private final static File inFile = new
	// File("/home/randy/Projects/Chepaki/Development Files/small-country.txt");
	private final static File inFile = new File("/pumaray/PogramResources/allCountries.txt");
	// private final static File inFile = new
	// File("/home/randy/Downloads/incountry.txt");
	private final static File outFile = new File("/home/randy/Downloads/outcountries.xml");
	private final static File dbFile = new File("/home/randy/Downloads/countries.db");
	private static PumCountryXMLGenerator generator;
	private static DB database;
	private static ConcurrentNavigableMap<String, PumCountry> map;

	@BeforeAll
	public static void startup() {
		generator = new PumCountryXMLGenerator(inFile, outFile);
		/*
		 * database =
		 * DBMaker.fileDB(dbFile).closeOnJvmShutdown().compressionEnable().make();
		 * map = database.treeMap("Countries");
		 */

	/**}

	@Test
	public void testGenerate() {
		try {
			generator.generate();
			System.out.println(generator.getCountries().size());
		}
		catch (Exception ex) {
			ex.printStackTrace();
			logger.debug("Error in Generate Test", ex);
			fail(ex.getMessage());
		}
	}

	// @Test
	public void testPopulateDatabase() {
		try {
			generator.generate();
			Map<String, PumCountry> countries = generator.getCountries();
			for (Map.Entry<String, PumCountry> entry : countries.entrySet()) {
				map.put(entry.getValue().getName(), entry.getValue());
				logger.debug("Adding ... ==> " + entry.getValue().getName());
			}
			database.commit();
			// database.close();

		}
		catch (Exception ex) {
			ex.printStackTrace();
			logger.debug("Error in Generate Test", ex);
			fail(ex.getMessage());
		}
	}

	// @Test
	public void testDatabaseIsPopulated() {
		try {
			System.out.println(map.size());
		}
		catch (Exception ex) {
			ex.printStackTrace();
			logger.debug("Error in Generate Test", ex);
			fail(ex.getMessage());
		}
	}
	\**/
}
