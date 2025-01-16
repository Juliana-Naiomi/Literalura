package br.com.alura.alura_literalura.repository;

import br.com.alura.alura_literalura.model.Autor;
import br.com.alura.alura_literalura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LivroRepository extends JpaRepository <Livro, Long>{

    List<Livro> findByTituloContainingIgnoreCase(String titulo);
}
