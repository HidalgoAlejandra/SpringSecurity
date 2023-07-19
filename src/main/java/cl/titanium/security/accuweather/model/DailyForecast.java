package cl.titanium.security.accuweather.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyForecast {
	
	@JsonProperty(value = "Temperature")
	private Temperature temperature;
	@JsonProperty(value = "Day")
	private Day day;
	@JsonProperty(value = "Night")
	private Night night;
	@JsonProperty(value = "Sources")
	private List<String> sources;
	@JsonProperty(value = "MobileLink")
	private String mobileLink;
	@JsonProperty(value = "Link")
	private String link;
	
	public DailyForecast() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DailyForecast(Temperature temperature, Day day, Night night, List<String> sources, String mobileLink,
			String link) {
		super();
		this.temperature = temperature;
		this.day = day;
		this.night = night;
		this.sources = sources;
		this.mobileLink = mobileLink;
		this.link = link;
	}
	
	public Temperature getTemperature() {
		return temperature;
	}
	public void setTemperature(Temperature temperature) {
		this.temperature = temperature;
	}
	public Day getDay() {
		return day;
	}
	public void setDay(Day day) {
		this.day = day;
	}
	public Night getNight() {
		return night;
	}
	public void setNight(Night night) {
		this.night = night;
	}
	public List<String> getSources() {
		return sources;
	}
	public void setSources(List<String> sources) {
		this.sources = sources;
	}
	public String getMobileLink() {
		return mobileLink;
	}
	public void setMobileLink(String mobileLink) {
		this.mobileLink = mobileLink;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}

}
