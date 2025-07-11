package br.com.literalura.literalura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.literalura.literalura.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {
  Autor findByNome(String nome);

  @Query("SELECT a FROM Autor a WHERE a.dataNascimento <= :ano AND (a.dataFalecimento IS NULL OR a.dataFalecimento > :ano)")
  List<Autor> findAutoresVivosEmAno(@Param("ano") int ano);
}
