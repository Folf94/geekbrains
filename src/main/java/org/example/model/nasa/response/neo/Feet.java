package org.example.model.nasa.response.neo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Feet{

	@JsonProperty("estimated_diameter_max")
	private Object estimatedDiameterMax;

	@JsonProperty("estimated_diameter_min")
	private Object estimatedDiameterMin;
}