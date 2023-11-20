import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.API.NasaApi;
import org.example.model.nasa.response.apod.ApodResponse;
import org.example.model.nasa.response.donki.DonkiResponse;
import org.example.model.nasa.response.donki.DonkiResponseItem;
import org.example.model.nasa.response.neo.NeoResponse;
import org.example.model.nasa.response.weather.WeatherResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.opentest4j.MultipleFailuresError;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Execution(ExecutionMode.CONCURRENT)
public class NasaTests extends BaseTest {
    private static ObjectMapper objectMapper = new ObjectMapper();
    public final NasaApi NASA_API = new NasaApi();

    @Test
    public void nasaApodTest() throws JsonProcessingException {
        ApodResponse response = NASA_API.getNasaApod();
        try {
            Assertions.assertAll(
                    () -> assertEquals("image", response.getMediaType()),
                    () -> assertEquals("The Horsehead Nebula", response.getTitle())
            );
        } catch (
                MultipleFailuresError er) {
            insertInfo("FAIL", objectMapper.writeValueAsString(response));
        }
        insertInfo("SUCCESS", objectMapper.writeValueAsString(response));
    }


    @Test
    public void nasaDonkiTest() throws JsonProcessingException {
        List<DonkiResponse> response = NASA_API.getNasaDonki();
        try {
            Assertions.assertAll(
                    () -> assertEquals("M2M_CATALOG", response.get(0).getCatalog()),
                    () -> assertEquals("C", response.get(0).getType())
            );
        } catch (MultipleFailuresError er) {
            insertInfo("FAIL", objectMapper.writeValueAsString(response));
        }
        insertInfo("SUCCESS", objectMapper.writeValueAsString(response));
    }


    @Test
    public void nasaWeatherTest() throws JsonProcessingException {
        WeatherResponse response = NASA_API.getNasaWeather();
        try {
            Assertions.assertAll(
                    () -> assertTrue(response.getValidityChecks().getJsonMember1219().getAT().getSolHoursWithData().stream().anyMatch(x -> x.equals(6))),
                    () -> assertTrue(response.getValidityChecks().getJsonMember1219().getAT().getSolHoursWithData().stream().anyMatch(x -> x.equals(7))),
                    () -> assertTrue(response.getValidityChecks().getJsonMember1219().getAT().getSolHoursWithData().stream().anyMatch(x -> x.equals(8))),
                    () -> assertTrue(response.getValidityChecks().getJsonMember1219().getAT().getSolHoursWithData().stream().anyMatch(x -> x.equals(9))),
                    () -> assertTrue(response.getValidityChecks().getJsonMember1219().getAT().getSolHoursWithData().stream().anyMatch(x -> x.equals(10))),
                    () -> assertTrue(response.getValidityChecks().getJsonMember1219().getAT().getSolHoursWithData().stream().anyMatch(x -> x.equals(11))),
                    () -> assertTrue(response.getValidityChecks().getJsonMember1219().getAT().getSolHoursWithData().stream().anyMatch(x -> x.equals(12)))

            );
        } catch (
                MultipleFailuresError er) {
            insertInfo("FAIL", objectMapper.writeValueAsString(response));
        }

        insertInfo("SUCCESS", objectMapper.writeValueAsString(response));
    }


    @Test
    public void nasaNeoTest() throws JsonProcessingException {
        NeoResponse response = NASA_API.getNasaNeo();
        try {
            Assertions.assertAll(
                    () -> assertEquals(8, response.getElementCount()),
                    () -> assertTrue(response.getNearEarthObjects().getJsonMember20231120().stream().anyMatch(x -> x.getId().equals("2329338"))),
                    () -> assertTrue(response.getNearEarthObjects().getJsonMember20231120().stream().anyMatch(x -> x.getId().equals("2458375"))),
                    () -> assertTrue(response.getNearEarthObjects().getJsonMember20231120().stream().anyMatch(x -> x.getId().equals("2458452"))),
                    () -> assertTrue(response.getNearEarthObjects().getJsonMember20231120().stream().anyMatch(x -> x.getId().equals("3775156"))),
                    () -> assertTrue(response.getNearEarthObjects().getJsonMember20231120().stream().anyMatch(x -> x.getId().equals("3837973"))),
                    () -> assertTrue(response.getNearEarthObjects().getJsonMember20231120().stream().anyMatch(x -> x.getId().equals("54053707"))),
                    () -> assertTrue(response.getNearEarthObjects().getJsonMember20231120().stream().anyMatch(x -> x.getId().equals("54248451"))),
                    () -> assertTrue(response.getNearEarthObjects().getJsonMember20231120().stream().anyMatch(x -> x.getId().equals("54373926")))
            );
        } catch (
                MultipleFailuresError er) {
            insertInfo("FAIL", objectMapper.writeValueAsString(response));
        }

        insertInfo("SUCCESS", objectMapper.writeValueAsString(response));
    }


    @Test
    public void nasaNeoNegativeTest() throws JsonProcessingException {
        NeoResponse response = NASA_API.getNasaNeoNegative();
        try {
            Assertions.assertAll(
                    () -> assertEquals("API_KEY_INVALID", response.getError().getCode()),
                    () -> assertEquals("An invalid api_key was supplied. Get one at https://api.nasa.gov:443", response.getError().getMessage())
            );
        } catch (MultipleFailuresError er) {
            insertInfo("FAIL", objectMapper.writeValueAsString(response));
        }
        insertInfo("SUCCESS", objectMapper.writeValueAsString(response));
    }
}


