package br.com.literalura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAutor(
    @JsonAlias("name") String name,
    @JsonAlias("birth_year") Integer birthYear,
    @JsonAlias("death_year") Integer deathYear) {
}
