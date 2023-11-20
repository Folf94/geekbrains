package org.example.model.nasa.response.neo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class NearEarthObjects{

	@JsonProperty("2023-11-20")
	private List<JsonMember20231120Item> jsonMember20231120;
}