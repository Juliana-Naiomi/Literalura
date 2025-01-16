package br.com.alura.alura_literalura.service;

import br.com.alura.alura_literalura.model.Autor;
import br.com.alura.alura_literalura.model.DadosAutor;
import br.com.alura.alura_literalura.model.DadosLivro;
import br.com.alura.alura_literalura.model.Livro;
import br.com.alura.alura_literalura.repository.AutorRepository;
import br.com.alura.alura_literalura.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepositorio;

    @Autowired
    private AutorRepository autorRepositorio;

    public void salvarOuAtualizarAutor(Autor autor) {
        autorRepositorio.save(autor);

    }

    public void processarLivro(DadosLivro dadosLivro) {
        System.out.println("Título: " + dadosLivro.titulo());
        if (dadosLivro.autores() != null && !dadosLivro.autores().isEmpty()) {
            DadosAutor dadosAutor = dadosLivro.autores().get(0);
            System.out.println("Autor recebido: " + dadosAutor.autor());
            Autor autor = obterAutor(dadosAutor);
            persistirLivro(dadosLivro, autor);
        } else {
            System.out.println("Autor: Não informado.");
        }

        System.out.println("Idioma: " + (dadosLivro.idioma() != null && !dadosLivro.idioma().isEmpty()
                ? dadosLivro.idioma().get(0)
                : "Não informado"));
        System.out.println("Número de Downloads: " + (dadosLivro.numeroDownload() != null
                ? dadosLivro.numeroDownload()
                : "Não informado"));
        System.out.println("=======================================LITER ALURA=========================================");
    }

    public Autor obterAutor(DadosAutor dadosAutor) {
        // Tenta encontrar o autor no banco de dados usando o nome
        Autor autorExistente = autorRepositorio.findByAutor(dadosAutor.autor());

        if (autorExistente == null) {
            // Se o autor não existir, cria um novo autor
            autorExistente = new Autor(dadosAutor.autor(), dadosAutor.anoNascimento(), dadosAutor.anoFalecimento());

            salvarOuAtualizarAutor(autorExistente);
        } else {
            // Se o autor já existir, apenas retorna o autor existente
            // Não há necessidade de salvar novamente
            System.out.println("Autor já existente: " + autorExistente.getAutor());
        }

        return autorExistente;
    }

    private void persistirLivro(DadosLivro dadosLivro, Autor autor) {
        Livro livro = new Livro(dadosLivro);
        livro.setAutor(autor);
        livroRepositorio.save(livro);  // Salva o livro no banco
    }

    public List<Livro> buscarLivrosPorIdioma(String idioma) {
        return livroRepositorio.findByTituloContainingIgnoreCase(idioma);
    }

}
