package udu.puj.consumidor_graphql.components;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountryDto {

    @JsonProperty("data")
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {

        @JsonProperty("country")
        private Country country;

        public Country getCountry() {
            return country;
        }

        public void setCountry(Country country) {
            this.country = country;
        }
    }

    public static class Country {

        @JsonProperty("name")
        private String name;

        @JsonProperty("capital")
        private String capital;

        @JsonProperty("currency")
        private String currency;

        // Getters and Setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCapital() {
            return capital;
        }

        public void setCapital(String capital) {
            this.capital = capital;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }
    }
}
