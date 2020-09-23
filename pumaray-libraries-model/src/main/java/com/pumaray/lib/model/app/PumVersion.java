package com.pumaray.lib.model.app;

import java.io.Serializable;
import java.util.regex.Pattern;

import com.pumaray.lib.model.impl.PumDefaultBean;

public class PumVersion extends PumDefaultBean implements Comparable<PumVersion>, Serializable  {

	private static final long serialVersionUID = -5164166495450292767L;
	
	public final Pattern VERSION_PATTERN = Pattern
			.compile("(^\\d+).(\\d+).(\\d+)_(.+)");
	public static final String MAYOR = "mayor";
	public static final String MINOR = "minor";
	public static final String PATCH = "patch";
	public static final String BUILD = "build";

	private Integer mayor;
	private Integer minor;
	private Integer patch;
	private String build;

	public PumVersion() {
	}

	public PumVersion(String version) throws IllegalArgumentException {
		if (!VERSION_PATTERN.matcher(version).matches()) {
			throw new IllegalArgumentException(
					"The version " + version + " does not match the version format." +
					"Version must be format number.number.number_string. F.E 1.2.5_alpha");
		}
		else {
			String[] versionAsArray = version.split("\\.");
			this.mayor = Integer.parseInt(versionAsArray[0]);
			this.minor = Integer.parseInt(versionAsArray[1]);
			String patchAndbuild = versionAsArray[2];
			int underscoreIndex = patchAndbuild.lastIndexOf("_");
			this.patch = Integer.parseInt(patchAndbuild.substring(0, underscoreIndex));
			this.build = patchAndbuild.substring(patchAndbuild.lastIndexOf("_"));

		}
	}

	public Integer getMayor() {
		return mayor;
	}

	public void setMayor(Integer mayor) {
		this.mayor = mayor;
	}

	public Integer getMinor() {
		return minor;
	}

	public void setMinor(Integer minor) {
		this.minor = minor;
	}

	public Integer getPatch() {
		return patch;
	}

	public void setPatch(Integer patch) {
		this.patch = patch;
	}

	public String getBuild() {
		return build;
	}

	public void setBuild(String build) {
		this.build = build;
	}
			

	@Override
	public int compareTo(PumVersion o) {
		int[] array = new int[4];
		array[0] = this.mayor.compareTo(o.mayor);
		array[1] = this.minor.compareTo(o.minor);
		array[2] = this.patch.compareTo(o.patch);
		array[3] = this.build.trim().toLowerCase()
				.compareTo(o.build.trim().toLowerCase());
		for (int i = 0; i < 4; i++) {
			Integer value = array[i];
			if (value == 1) {
				return 1;
			}
			else if (value == -1) {
				return -1;
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		return "PumVersion [mayor=" + mayor + ", minor=" + minor + ", patch=" + patch + ", build=" + build + "]";
	}
}
