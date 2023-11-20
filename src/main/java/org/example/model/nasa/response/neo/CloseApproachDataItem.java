package org.example.model.nasa.response.neo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CloseApproachDataItem{

	@JsonProperty("relative_velocity")
	private RelativeVelocity relativeVelocity;

	@JsonProperty("orbiting_body")
	private String orbitingBody;

	@JsonProperty("close_approach_date")
	private String closeApproachDate;

	@JsonProperty("epoch_date_close_approach")
	private Long epochDateCloseApproach;

	@JsonProperty("close_approach_date_full")
	private String closeApproachDateFull;

	@JsonProperty("miss_distance")
	private MissDistance missDistance;
}