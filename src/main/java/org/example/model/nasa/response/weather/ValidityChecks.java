package org.example.model.nasa.response.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class ValidityChecks{

	@JsonProperty("sol_hours_required")
	private Integer solHoursRequired;

	@JsonProperty("sols_checked")
	private List<String> solsChecked;

	@JsonProperty("1219")
	private JsonMember1219 jsonMember1219;
}