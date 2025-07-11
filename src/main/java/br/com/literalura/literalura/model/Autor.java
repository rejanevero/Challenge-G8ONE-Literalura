package br.com.literalura.literalura.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "autores")
public class Autor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  private int dataNascimento;

  private int dataFalecimento;

  @ManyToMany(mappedBy = "autores")
  private List<Livro> livros;

  public Autor() {
  }

  public Autor(DadosAutor dados) {
    this.nome = dados.name();
    this.dataNascimento = dados.birthYear() != null ? dados.birthYear() : 0;
    this.dataFalecimento = dados.deathYear() != null ? dados.deathYear() : 0;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(int dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public int getDataFalecimento() {
    return dataFalecimento;
  }

  public void setDataFalecimento(int dataFalecimento) {
    this.dataFalecimento = dataFalecimento;
  }

  public List<Livro> getLivros() {
    return livros;
  }

  public void setLivros(List<Livro> livros) {
    this.livros = livros;
  }

  @Override
  public String toString() {
    return "Nome=" + nome + ", dataNascimento=" + dataNascimento + ", dataFalecimento=" + dataFalecimento;
  }

}
