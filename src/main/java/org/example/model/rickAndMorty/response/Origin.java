package org.example.model.rickAndMorty.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Origin{

	@JsonProperty("name")
	private String name;

	@JsonProperty("url")
	private String url;
}