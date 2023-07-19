package cl.titanium.security.accuweather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Maximum {

	@JsonProperty(value = "Value")
	private String value;
	@JsonProperty(value = "Unit")
	private String unit;
	@JsonProperty(value = "UnitType")
	private String unitType;
	
	public Maximum() {
		super();
	}
	
	public Maximum(String value, String unit, String unitType) {
		super();
		this.value = value;
		this.unit = unit;
		this.unitType = unitType;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getUnitType() {
		return unitType;
	}
	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}
	
	
}
