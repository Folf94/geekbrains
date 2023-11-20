package org.example.model.nasa.response.donki;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Date;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DonkiResponseItem{

	@JsonProperty("note")
	private String note;

	@JsonProperty("halfAngle")
	private Object halfAngle;

	@JsonProperty("isMostAccurate")
	private Boolean isMostAccurate;

	@JsonProperty("catalog")
	private String catalog;

	@JsonProperty("latitude")
	private Object latitude;

	@JsonProperty("link")
	private String link;

	@JsonProperty("type")
	private String type;

	@JsonProperty("associatedCMEID")
	private String associatedCMEID;

	@JsonProperty("speed")
	private Object speed;


	@JsonProperty("time21_5")
	private Date time215;

	@JsonProperty("longitude")
	private Object longitude;
}