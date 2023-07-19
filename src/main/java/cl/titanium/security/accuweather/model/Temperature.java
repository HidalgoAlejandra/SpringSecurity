package cl.titanium.security.accuweather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperature {
	
	@JsonProperty(value = "Minimum")
	private Minimum minimum;
	@JsonProperty(value = "Maximum")
	private Maximum maximum;
	
	
	public Temperature() {
		super();
	}

	public Temperature(Minimum minimum, Maximum maximum) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	}

	public Minimum getMinimum() {
		return minimum;
	}

	public void setMinimum(Minimum minimum) {
		this.minimum = minimum;
	}

	public Maximum getMaximum() {
		return maximum;
	}

	public void setMaximum(Maximum maximum) {
		this.maximum = maximum;
	}
	


}
