package udu.puj.consumidor_graphql.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import udu.puj.consumidor_graphql.components.CountryDto;
import udu.puj.consumidor_graphql.components.CountryService;

@RestController
@RequestMapping("/country")
public class CountryClientController {

    @Autowired
    private CountryService countryService;

    @GetMapping(value = "/byCode", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCountryByCode() {
        try {
            CountryDto response = countryService.getCountryDetails("US");
            return ResponseEntity.ok(response.getData().getCountry());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al obtener detalles del país: " + e.getMessage());
        }
    }


}
