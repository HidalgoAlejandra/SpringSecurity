package cl.titanium.security.accuweather.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pronostico {
	
	@JsonProperty(value = "Headline")
	private Headline headline;
	@JsonProperty(value = "DailyForecasts")
	private List<DailyForecast> dailyForecasts;
	
	public Pronostico(Headline headline, List<DailyForecast> dailyForecasts) {
		super();
		this.headline = headline;
		this.dailyForecasts = dailyForecasts;
	}

	public Pronostico() {
		super();
	}

	public Headline getHeadline() {
		return headline;
	}

	public void setHeadline(Headline headline) {
		this.headline = headline;
	}

	public List<DailyForecast> getDailyForecasts() {
		return dailyForecasts;
	}

	public void setDailyForecasts(List<DailyForecast> dailyForecasts) {
		this.dailyForecasts = dailyForecasts;
	}



}
