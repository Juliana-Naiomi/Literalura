package br.com.alura.alura_literalura.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
