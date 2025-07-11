package br.com.literalura.literalura.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.literalura.literalura.model.Autor;
import br.com.literalura.literalura.model.DadosAutor;
import br.com.literalura.literalura.model.DadosLivro;
import br.com.literalura.literalura.model.Livro;
import br.com.literalura.literalura.repository.AutorRepository;
import br.com.literalura.literalura.repository.LivroRepository;

@Service
public class LivroService {

  private final LivroRepository livroRepository;
  private final AutorRepository autorRepository;

  public LivroService(LivroRepository livroRepository, AutorRepository autorRepository) {
    this.livroRepository = livroRepository;
    this.autorRepository = autorRepository;
  }

  public Livro criarLivro(DadosLivro dadosLivro) {
    Livro livro = new Livro();
    livro.setGutendexId(dadosLivro.gutendexId());
    livro.setTitulo(dadosLivro.title());

    List<Autor> autores = new ArrayList<>();
    for (DadosAutor dadosAutor : dadosLivro.authors()) {
      Autor autor = autorRepository.findByNome(dadosAutor.name());
      if (autor == null) {
        autor = new Autor();
        autor.setNome(dadosAutor.name());
        autor.setDataNascimento(Optional.ofNullable(dadosAutor.birthYear()).orElse(0));
        autor.setDataFalecimento(Optional.ofNullable(dadosAutor.deathYear()).orElse(0));
      }
      autores.add(autor);
    }

    livro.setAutores(autores);
    livro.setResumos(dadosLivro.summaries().length > 0 ? dadosLivro.summaries()[0] : "");
    livro.setIdiomas(dadosLivro.languages()[0]);
    livro.setContagemDownloads(dadosLivro.downloadCount());

    return livroRepository.save(livro);
  }
}
