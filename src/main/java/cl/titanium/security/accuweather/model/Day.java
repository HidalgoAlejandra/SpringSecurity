package cl.titanium.security.accuweather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Day {

	@JsonProperty(value = "Icon")
	private String icon;
	@JsonProperty(value = "IconPhrase")
	private String iconPhrase;
	@JsonProperty(value = "HasPrecipitation")
	private boolean hasPrecipitation;
	@JsonProperty(value = "PrecipitationType")
	private String precipitationType;
	@JsonProperty(value = "PrecipitationIntensity")
	private String precipitationIntensity;
	
	
	public Day() {
		super();
	}


	public Day(String icon, String iconPhrase, boolean hasPrecipitation, String precipitationType,
			String precipitationIntensity) {
		super();
		this.icon = icon;
		this.iconPhrase = iconPhrase;
		this.hasPrecipitation = hasPrecipitation;
		this.precipitationType = precipitationType;
		this.precipitationIntensity = precipitationIntensity;
	}


	public String getIcon() {
		return icon;
	}


	public void setIcon(String icon) {
		this.icon = icon;
	}


	public String getIconPhrase() {
		return iconPhrase;
	}


	public void setIconPhrase(String iconPhrase) {
		this.iconPhrase = iconPhrase;
	}


	public boolean isHasPrecipitation() {
		return hasPrecipitation;
	}


	public void setHasPrecipitation(boolean hasPrecipitation) {
		this.hasPrecipitation = hasPrecipitation;
	}


	public String getPrecipitationType() {
		return precipitationType;
	}


	public void setPrecipitationType(String precipitationType) {
		this.precipitationType = precipitationType;
	}


	public String getPrecipitationIntensity() {
		return precipitationIntensity;
	}


	public void setPrecipitationIntensity(String precipitationIntensity) {
		this.precipitationIntensity = precipitationIntensity;
	}
	
	
	
	
}
