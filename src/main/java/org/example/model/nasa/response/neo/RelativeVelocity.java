package org.example.model.nasa.response.neo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class RelativeVelocity{

	@JsonProperty("kilometers_per_hour")
	private String kilometersPerHour;

	@JsonProperty("kilometers_per_second")
	private String kilometersPerSecond;

	@JsonProperty("miles_per_hour")
	private String milesPerHour;
}