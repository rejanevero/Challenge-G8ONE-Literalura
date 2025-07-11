package br.com.literalura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro(
    @JsonAlias("id") Long gutendexId,
    @JsonAlias("title") String title,
    @JsonAlias("authors") DadosAutor[] authors,
    @JsonAlias("summaries") String[] summaries,
    @JsonAlias("languages") String[] languages,
    @JsonAlias("download_count") Long downloadCount) {

}
