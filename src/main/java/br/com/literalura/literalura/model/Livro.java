package br.com.literalura.literalura.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "livros")
public class Livro {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  private Long gutendexId;

  @Column(unique = true)
  private String titulo;

  @ManyToMany(cascade = CascadeType.PERSIST)
  @JoinTable(name = "livro_autor", joinColumns = @JoinColumn(name = "livro_id"), inverseJoinColumns = @JoinColumn(name = "autor_id"))
  private List<Autor> autores;

  @Column(columnDefinition = "TEXT")
  private String resumos;

  private String idioma;

  private Long contagemDownloads;

  public Livro() {
  }

  public Livro(DadosLivro dadosLivro) {
    this.gutendexId = dadosLivro.gutendexId();
    this.titulo = dadosLivro.title();
    this.resumos = (dadosLivro.summaries() != null && dadosLivro.summaries().length > 0)
        ? dadosLivro.summaries()[0]
        : "";
    this.idioma = dadosLivro.languages()[0];
    this.contagemDownloads = dadosLivro.downloadCount();
    this.autores = new ArrayList<>();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getGutendexId() {
    return gutendexId;
  }

  public void setGutendexId(Long gutendexId) {
    this.gutendexId = gutendexId;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public List<Autor> getAutores() {
    return autores;
  }

  public void setAutores(List<Autor> autores) {
    this.autores = autores;
  }

  public String getIdioma() {
    return idioma;
  }

  public void setIdiomas(String idioma) {
    this.idioma = idioma;
  }

  public Long getContagemDownloads() {
    return contagemDownloads;
  }

  public void setContagemDownloads(Long contagemDownloads) {
    this.contagemDownloads = contagemDownloads;
  }

  public String getResumos() {
    return resumos;
  }

  public void setResumos(String resumos) {
    this.resumos = resumos;
  }

  @Override
  public String toString() {
    return "Titulo='" + titulo + '\'' +
        ", id=" + id +
        ", gutendexId=" + gutendexId +
        ", autores=" + autores +
        ", resumos='" + resumos + '\'' +
        ", idioma=" + idioma +
        ", contagemDownloads=" + contagemDownloads;
  }

}
