package com.pumaray.lib.tools.generators.country;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.neovisionaries.i18n.CountryCode;
import com.pumaray.lib.tools.generators.country.model.PumCity;
import com.pumaray.lib.tools.generators.country.model.PumCountry;

public class PumCountryXMLGenerator {

	private final static Logger logger = LoggerFactory.getLogger(PumCountryXMLGenerator.class);
	private final String SPLITTER = "\t";

	private PumCountry current;
	private File inFile;
	private File outFile;
	private Map<String, PumCountry> countries = new Hashtable<String, PumCountry>();
	// private List<PumCountry> countries = new ArrayList<PumCountry>();

	public PumCountryXMLGenerator(File inFile, File outFile) {
		this.inFile = inFile;
		this.outFile = outFile;

		current = new PumCountry();
		current.setCode("");

	}

	/*
	 * private void populateLocales() { String[] localeString =
	 * Locale.getISOLanguages(); for (String str : localeString) { Locale locale
	 * = new Locale("", str); locales.put(str, locale); System.out.println(str +
	 * ", " + locale); } }
	 */

	private void manageCountry(String code) {
		if (current != null || !current.getCode().equals(code)) {
			if (countries.containsKey(code)) {
				current = countries.get(code);
			}
			else {
				CountryCode cc = CountryCode.getByCode(code.toUpperCase());
				String name;
				String countryName = cc.getName();
				current = new PumCountry();
				if (countryName != null) {
					name = countryName;
				}
				else {
					name = code;
				}
				current.setName(name);
				current.setCode(code.toUpperCase());
				countries.put(code, current);
			}
		}

	}

	private void parse(String line) {
		String[] params = line.split(SPLITTER);
		String code = params[8];
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
		current.getCities().add(city);
		// logger.debug("Adding city : " + city.getName());

	}

	/*
	 * private void readFromInFile() throws IOException { BufferedReader reader
	 * = new BufferedReader(new FileReader(inFile)); String line; int index = 0;
	 * while ((line = reader.readLine()) != null) { parse(line); index++;
	 * if(index < 50) { System.out.append("."); } else {
	 * System.out.println("."); index = 0; } } reader.close(); }
	 */

	private void readFromInFile() throws IOException {
		Stream<String> lines = Files
				.lines(Paths.get(inFile.getParentFile().getAbsolutePath(), inFile.getName()));
		lines.forEach(this::parse);
		
	}

	public void generate() throws IOException {
		readFromInFile();
	}

	public Map<String, PumCountry> getCountries() {
		return countries;
	}

	public void setCountries(Map<String, PumCountry> countries) {
		this.countries = countries;
	}

}
