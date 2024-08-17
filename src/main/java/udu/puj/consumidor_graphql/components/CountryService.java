package udu.puj.consumidor_graphql.components;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

@Service
public class CountryService {

    public CountryDto getCountryDetails(final String countryCode) throws IOException {
        WebClient webClient = WebClient.builder().build();
        GraphqlRequestBody graphqlRequestBody = new GraphqlRequestBody();

        String query = new String(Files.readAllBytes(Paths.get("src/main/resources/queries/getCountryDetails.graphql")));
        String variables = new String(Files.readAllBytes(Paths.get("src/main/resources/queries/variables.graphql")));

        graphqlRequestBody.setQuery(query);
        graphqlRequestBody.setVariables(Map.of("code", countryCode));

        return webClient.post()
                .uri("https://countries.trevorblades.com/")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(graphqlRequestBody)
                .retrieve()
                .bodyToMono(CountryDto.class)
                .block();
    }
}
