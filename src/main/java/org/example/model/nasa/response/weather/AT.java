package org.example.model.nasa.response.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class AT{

	@JsonProperty("valid")
	private Boolean valid;

	@JsonProperty("sol_hours_with_data")
	private List<Integer> solHoursWithData;
}