package org.example.model.nasa.response.apod;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ApodResponse{

	@JsonProperty("date")
	private String date;

	@JsonProperty("copyright")
	private String copyright;

	@JsonProperty("media_type")
	private String mediaType;

	@JsonProperty("hdurl")
	private String hdurl;

	@JsonProperty("service_version")
	private String serviceVersion;

	@JsonProperty("explanation")
	private String explanation;

	@JsonProperty("title")
	private String title;

	@JsonProperty("url")
	private String url;
}