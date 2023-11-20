package org.example.model.nasa.response.neo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class EstimatedDiameter{

	@JsonProperty("feet")
	private Feet feet;

	@JsonProperty("kilometers")
	private Kilometers kilometers;

	@JsonProperty("meters")
	private Meters meters;

	@JsonProperty("miles")
	private Miles miles;
}