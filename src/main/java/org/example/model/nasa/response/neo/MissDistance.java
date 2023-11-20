package org.example.model.nasa.response.neo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class MissDistance{

	@JsonProperty("astronomical")
	private String astronomical;

	@JsonProperty("kilometers")
	private String kilometers;

	@JsonProperty("lunar")
	private String lunar;

	@JsonProperty("miles")
	private String miles;
}