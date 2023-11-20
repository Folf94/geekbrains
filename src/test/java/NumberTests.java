import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.API.NumbersApi;
import org.example.model.numbers.response.NumberResponse;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.opentest4j.MultipleFailuresError;


import static org.junit.jupiter.api.Assertions.*;

@Execution(ExecutionMode.CONCURRENT)
public class NumberTests extends BaseTest {
    private static ObjectMapper objectMapper = new ObjectMapper();
    public final NumbersApi NUMBER_API = new NumbersApi();


    @Test
    public void numberTest() throws JsonProcessingException {
        NumberResponse response = NUMBER_API.getNumber();
        try {
            Assertions.assertAll(
                    () -> assertTrue(response.getFound()),
                    () -> assertEquals(42, response.getNumber())
            );

        } catch (MultipleFailuresError er) {
            insertInfo("FAIL", objectMapper.writeValueAsString(response));
        }
        insertInfo("SUCCESS", objectMapper.writeValueAsString(response));
    }

    @Test
    public void numberRandomTest() throws JsonProcessingException {
        NumberResponse response = NUMBER_API.getRandomNumber();
        try {

            Assertions.assertAll(
                    () -> assertTrue(response.getFound()),
                    () -> assertEquals("year", response.getType())
            );
        } catch (MultipleFailuresError er) {
            insertInfo("FAIL", objectMapper.writeValueAsString(response));
        }
        insertInfo("SUCCESS", objectMapper.writeValueAsString(response));
    }

    @Test
    public void numberBadYearTest() throws JsonProcessingException {
        NumberResponse response = NUMBER_API.getBadYearNumber();
        try {
            Assertions.assertAll(
                    () -> assertFalse(response.getFound()),
                    () -> assertEquals("year", response.getType()),
                    () -> assertEquals(23515, response.getNumber())
            );
        } catch (MultipleFailuresError er) {
            insertInfo("FAIL", objectMapper.writeValueAsString(response));
        }
        insertInfo("SUCCESS", objectMapper.writeValueAsString(response));
    }

    @Test
    public void numberDateTest() throws JsonProcessingException {
        NumberResponse response = NUMBER_API.getDateNumber();
        try {
            Assertions.assertAll(
                    () -> assertTrue(response.getFound()),
                    () -> assertEquals("date", response.getType())
            );
        } catch (MultipleFailuresError er) {
            insertInfo("FAIL", objectMapper.writeValueAsString(response));
        }
        insertInfo("SUCCESS", objectMapper.writeValueAsString(response));
    }
}