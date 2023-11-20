package org.example.model.nasa.response.neo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Links{

	@JsonProperty("next")
	private String next;

	@JsonProperty("prev")
	private String prev;

	@JsonProperty("self")
	private String self;
}