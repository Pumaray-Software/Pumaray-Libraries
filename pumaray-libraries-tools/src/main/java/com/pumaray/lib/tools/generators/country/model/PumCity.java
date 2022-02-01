package com.pumaray.lib.tools.generators.country.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "city")
@XmlAccessorType(XmlAccessType.FIELD)
public class PumCity implements Serializable {

	private static final long serialVersionUID = -7889628784268178476L;

	private Integer geoNameId;
	
	private String name;
	
	private String aciiName;
	
	private List<String> alternateNames;
		
	private Double latitude;
	
	private Double longitude;
	
	private Character featureClass;
	
	private String featureCode;
	
	private BigInteger population;
	
	public PumCity() {}

	public Integer getGeoNameId() {
		return geoNameId;
	}

	public void setGeoNameId(Integer geoNameId) {
		this.geoNameId = geoNameId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAciiName() {
		return aciiName;
	}

	public void setAciiName(String aciiName) {
		this.aciiName = aciiName;
	}

	public List<String> getAlternateNames() {
		return alternateNames;
	}

	public void setAlternateNames(List<String> alternateNames) {
		this.alternateNames = alternateNames;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Character getFeatureClass() {
		return featureClass;
	}

	public void setFeatureClass(Character featureClass) {
		this.featureClass = featureClass;
	}

	public String getFeatureCode() {
		return featureCode;
	}

	public void setFeatureCode(String featureCode) {
		this.featureCode = featureCode;
	}

	public BigInteger getPopulation() {
		return population;
	}

	public void setPopulation(BigInteger population) {
		this.population = population;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aciiName == null) ? 0 : aciiName.hashCode());
		result = prime * result + ((alternateNames == null) ? 0 : alternateNames.hashCode());
		result = prime * result + ((featureClass == null) ? 0 : featureClass.hashCode());
		result = prime * result + ((featureCode == null) ? 0 : featureCode.hashCode());
		result = prime * result + ((geoNameId == null) ? 0 : geoNameId.hashCode());
		result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((population == null) ? 0 : population.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PumCity other = (PumCity) obj;
		if (aciiName == null) {
			if (other.aciiName != null)
				return false;
		}
		else if (!aciiName.equals(other.aciiName))
			return false;
		if (alternateNames == null) {
			if (other.alternateNames != null)
				return false;
		}
		else if (!alternateNames.equals(other.alternateNames))
			return false;
		if (featureClass == null) {
			if (other.featureClass != null)
				return false;
		}
		else if (!featureClass.equals(other.featureClass))
			return false;
		if (featureCode == null) {
			if (other.featureCode != null)
				return false;
		}
		else if (!featureCode.equals(other.featureCode))
			return false;
		if (geoNameId == null) {
			if (other.geoNameId != null)
				return false;
		}
		else if (!geoNameId.equals(other.geoNameId))
			return false;
		if (latitude == null) {
			if (other.latitude != null)
				return false;
		}
		else if (!latitude.equals(other.latitude))
			return false;
		if (longitude == null) {
			if (other.longitude != null)
				return false;
		}
		else if (!longitude.equals(other.longitude))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		}
		else if (!name.equals(other.name))
			return false;
		if (population == null) {
			if (other.population != null)
				return false;
		}
		else if (!population.equals(other.population))
			return false;
		return true;
	}
}