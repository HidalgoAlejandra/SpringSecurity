package cl.titanium.security.accuweather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Headline {

	@JsonProperty(value = "Text")
	private String text;
	private String category;
	private String effectiveDate;
	private String effectiveEpochDate;
	private String severity;
	private String endDate;
	private String endEpochDate;
	private String mobileLink;
	private String link;

	public Headline(String text, String category, String effectiveDate, String effectiveEpochDate, String severity,
			String endDate, String endEpochDate, String mobileLink, String link) {
		super();
		this.text = text;
		this.category = category;
		this.effectiveDate = effectiveDate;
		this.effectiveEpochDate = effectiveEpochDate;
		this.severity = severity;
		this.endDate = endDate;
		this.endEpochDate = endEpochDate;
		this.mobileLink = mobileLink;
		this.link = link;
	}

	public Headline() {
		super();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getEffectiveEpochDate() {
		return effectiveEpochDate;
	}

	public void setEffectiveEpochDate(String effectiveEpochDate) {
		this.effectiveEpochDate = effectiveEpochDate;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getEndEpochDate() {
		return endEpochDate;
	}

	public void setEndEpochDate(String endEpochDate) {
		this.endEpochDate = endEpochDate;
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
