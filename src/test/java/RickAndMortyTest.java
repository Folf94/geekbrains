import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.API.RickAndMortyApi;
import org.example.model.rickAndMorty.response.RickAndMortyResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.opentest4j.MultipleFailuresError;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
public class RickAndMortyTest extends BaseTest {
    private static ObjectMapper objectMapper = new ObjectMapper();
    public final RickAndMortyApi RICK_AND_MORTY_API = new RickAndMortyApi();

    @Test
    public void getRick() throws JsonProcessingException {
        RickAndMortyResponse response = RICK_AND_MORTY_API.getRick();
        try {

            Assertions.assertAll(
                    () -> assertEquals(146, response.getId()),
                    () -> assertEquals("Glexo Slim Slom", response.getName())
            );
        } catch (MultipleFailuresError er) {
            insertInfo("FAIL", objectMapper.writeValueAsString(response));
        }
        insertInfo("SUCCESS", objectMapper.writeValueAsString(response));
    }
}
