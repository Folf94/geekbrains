package org.example.model.rickAndMorty.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class RickAndMortyResponse{

	@JsonProperty("image")
	private String image;

	@JsonProperty("gender")
	private String gender;

	@JsonProperty("species")
	private String species;

	@JsonProperty("created")
	private String created;

	@JsonProperty("origin")
	private Origin origin;

	@JsonProperty("name")
	private String name;

	@JsonProperty("location")
	private Location location;

	@JsonProperty("episode")
	private List<String> episode;

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("type")
	private String type;

	@JsonProperty("url")
	private String url;

	@JsonProperty("status")
	private String status;
}