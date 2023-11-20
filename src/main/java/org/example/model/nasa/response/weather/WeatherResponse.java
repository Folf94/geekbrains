package org.example.model.nasa.response.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class WeatherResponse{

	@JsonProperty("sol_keys")
	private List<Object> solKeys;

	@JsonProperty("validity_checks")
	private ValidityChecks validityChecks;
}