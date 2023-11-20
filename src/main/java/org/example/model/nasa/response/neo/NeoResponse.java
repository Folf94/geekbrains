package org.example.model.nasa.response.neo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class NeoResponse{

	@JsonProperty("near_earth_objects")
	private NearEarthObjects nearEarthObjects;

	@JsonProperty("element_count")
	private Integer elementCount;

	@JsonProperty("links")
	private Links links;

	@JsonProperty("error")
	private Error error;
}