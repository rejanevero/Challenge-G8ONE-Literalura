package br.com.literalura.literalura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.literalura.literalura.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
  @EntityGraph(attributePaths = "autores")
  List<Livro> findAll();

  @EntityGraph(attributePaths = "autores")
  List<Livro> findByIdioma(String idioma);

}
