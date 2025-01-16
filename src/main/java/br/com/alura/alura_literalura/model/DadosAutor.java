package br.com.alura.alura_literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAutor (
        @JsonAlias("name") String autor,
        @JsonAlias("birth_year") Double anoNascimento,
        @JsonAlias("death_year") Double anoFalecimento) {
    @Override
    public String toString() {
        return "Autor: " + autor;
    }
}
