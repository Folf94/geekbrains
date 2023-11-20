package org.example.model.nasa.response.neo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Error {
    @JsonProperty("code")
    private String code;
    @JsonProperty("message")
    private String message;
}
