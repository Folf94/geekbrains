package org.example.model.numbers.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class NumberResponse{

	@JsonProperty("number")
	private int number;

	@JsonProperty("found")
	private Boolean found;

	@JsonProperty("text")
	private String text;

	@JsonProperty("type")
	private String type;

	@JsonProperty("date")
	private String date;

	@JsonProperty("year")
	private int year;
}