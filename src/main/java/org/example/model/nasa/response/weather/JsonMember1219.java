package org.example.model.nasa.response.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class JsonMember1219{

	@JsonProperty("PRE")
	private PRE pRE;

	@JsonProperty("AT")
	private AT aT;

	@JsonProperty("HWS")
	private HWS hWS;

	@JsonProperty("WD")
	private WD wD;
}