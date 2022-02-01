package com.pumaray.lib.tools.generators.country;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.stream.Stream;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.neovisionaries.i18n.CountryCode;
import com.pumaray.lib.tools.generators.country.model.PumCity;
import com.pumaray.lib.tools.generators.country.model.PumCountry;

public class PumCountryMapDBGenerator {

	/**private final static Logger logger = LoggerFactory.getLogger(PumCountryMapDBGenerator.class);
	private final String SPLITTER = "\t";
	private final Integer MAX_BEFORE_COMMIT = 250;

	private PumCountry current;
	private File inFile;
	private File outFile;
	private DB database;
	private ConcurrentNavigableMap <String, PumCountry> countries;
	private Integer counter = 0;

	public PumCountryMapDBGenerator(File inFile, File outFile) {
		this.inFile = inFile;
		this.outFile = outFile;

		current = new PumCountry();
		current.setCode("");
		// bo a kambia e version dus wak kwa methode tin awo
		database = DBMaker
				.fileDB(outFile)
			//	.transactionEnable()
				.closeOnJvmShutdown()
			//	.compressionEnable()
				.make();
		countries =  database.treeMap("Countries");
		//*/
//		countries = database
//				.treeMap("Countries",Serializer.STRING,	Serializer.GroupSerializerObjectArray<PumCountry> )
//				.createOrOpen();
/**	}

	private void manageCountry(String code) {
		if (!current.getCode().equals(code)) {
			if (countries.containsKey(code)) {
				current = countries.get(code);
			}
			else {
				CountryCode cc = CountryCode.getByCode(code.toUpperCase());
				String name;
				String countryName;
				if ((countryName = cc.getName()) != null) {
					name = countryName;
				}
				else {
					name = code;
				}
				current = new PumCountry();
				current.setName(name);
				current.setCode(code.toUpperCase());
				countries.put(code, current);
				logger.debug("New Country with code " + current.getCode());
			}
		}

	}

	private void commitDatabase() {
		if (counter > MAX_BEFORE_COMMIT) {
			logger.debug("Start commiting the database");
			database.commit();
			logger.debug("Database committed.");
			logger.debug("Resetting counter tp 1");
			counter = 1;
		}
	}

	private void parse(String line) {
		String[] params = line.split(SPLITTER);
		String code = params[8];
		if (!code.trim().equals("")) {
			manageCountry(code);
			PumCity city = new PumCity();
			city.setGeoNameId(Integer.parseInt(params[0]));
			city.setName(params[1]);
			city.setAciiName(params[2]);
			city.setAlternateNames(Arrays.asList(params[3].split(",")));
			city.setLatitude(Double.parseDouble(params[4]));
			city.setLongitude(Double.parseDouble(params[5]));
			if (params[6].length() > 0) {
				city.setFeatureClass(new Character(params[6].charAt(0)));
			}
			city.setFeatureCode(params[7]);
			city.setPopulation(new BigInteger(params[14]));
			if (!current.getCities().contains(city)) {
				current.getCities().add(city);
				counter++;
				logger.debug("counter = " + counter + " -> " + current.getCode() + " ====> " + city.getName());
			}
			else {
				logger.debug("counter = " + counter + " -> " + current.getCode() + " XXX=> " + city.getName());
			}
			commitDatabase();
		}
	}

	private void readFromInFile() throws IOException {
		Stream<String> lines = Files.lines(Paths.get(inFile.getParentFile().getAbsolutePath(), inFile.getName()));
		lines.forEach(this::parse);
		lines.close();

	}

	private void writeToOutFile() throws IOException {
		database.commit();
	}

	public void generate() throws IOException {
		readFromInFile();
		writeToOutFile();
	}
	
	**/

}
