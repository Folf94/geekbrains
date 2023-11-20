package org.example.model.nasa.response.neo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class JsonMember20231120Item{

	@JsonProperty("estimated_diameter")
	private EstimatedDiameter estimatedDiameter;

	@JsonProperty("neo_reference_id")
	private String neoReferenceId;

	@JsonProperty("nasa_jpl_url")
	private String nasaJplUrl;

	@JsonProperty("is_potentially_hazardous_asteroid")
	private Boolean isPotentiallyHazardousAsteroid;

	@JsonProperty("is_sentry_object")
	private Boolean isSentryObject;

	@JsonProperty("name")
	private String name;

	@JsonProperty("absolute_magnitude_h")
	private Object absoluteMagnitudeH;

	@JsonProperty("links")
	private Links links;

	@JsonProperty("id")
	private String id;

	@JsonProperty("close_approach_data")
	private List<CloseApproachDataItem> closeApproachData;
}