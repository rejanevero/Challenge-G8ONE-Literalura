package br.com.literalura.literalura.client;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

import br.com.literalura.literalura.model.Autor;
import br.com.literalura.literalura.model.DadosLivro;
import br.com.literalura.literalura.model.DadosResultados;
import br.com.literalura.literalura.model.Livro;
import br.com.literalura.literalura.repository.AutorRepository;
import br.com.literalura.literalura.repository.LivroRepository;
import br.com.literalura.literalura.service.ConsumoApi;
import br.com.literalura.literalura.service.ConverteDados;
import br.com.literalura.literalura.service.LivroService;

public class Principal {
  private static final Scanner scan = new Scanner(System.in);
  private ConsumoApi consumoApi = new ConsumoApi();
  private ConverteDados converteDados = new ConverteDados();
  private LivroRepository livroRepository;
  private AutorRepository autorRepository;
  private LivroService livroService;

  private final String URL_BASE = "https://gutendex.com/books?search=";

  public Principal(LivroRepository livroRepository, AutorRepository autorRepository) {
    this.livroRepository = livroRepository;
    this.autorRepository = autorRepository;
    this.livroService = new LivroService(livroRepository, autorRepository);
  }

  public void exibeMenu() {
    var opcao = -1;
    var menu = """
        ========= Literalura =========
        Escolha o número de sua opção
        1 - Buscar livro pelo título
        2 - Listar livros registrados
        3 - Listar autores registrados
        4 - Listar autores vivos em um determinado ano
        5 - Listar livros em um determinado idioma
        0 - Sair
        ==============================
        Digite sua opção:  """;

    while (opcao != 0) {
      try {
        System.out.println(menu);
        opcao = scan.nextInt();
        scan.nextLine();
      } catch (Exception e) {
        System.out.println("Opção inválida. Tente novamente.");
        scan.nextLine();
        continue;
      }
      switch (opcao) {
        case 1 -> buscarLivroPorTitulo();
        case 2 -> listarLivros();
        case 3 -> listarAutores();
        case 4 -> listarAutoresVivosEmAno();
        case 5 -> listarLivrosPorIdioma();
        case 0 -> System.out.println("Saindo...");
        default -> System.out.println("Opção inválida. Tente novamente.");
      }
    }

  }

  private void buscarLivroPorTitulo() {
    DadosLivro dadosLivro = obterDadosLivro();
    Livro livro = livroService.criarLivro(dadosLivro);
    if (livro != null) {
      livroRepository.save(livro);
      System.out.println("Livro salvo com sucesso: " + livro);
    } else {
      System.out.println("Livro não encontrado ou já registrado.");
    }
  }

  private DadosLivro obterDadosLivro() {
    System.out.println("==========================");
    System.out.println("Digite o nome do livro para busca:");
    var nomeLivro = scan.nextLine();
    String nomeFormatado = URLEncoder.encode(nomeLivro, StandardCharsets.UTF_8);
    String url = URL_BASE + nomeFormatado;

    var json = consumoApi.obterDados(url);
    DadosResultados resultado = converteDados.obterDados(json, DadosResultados.class);

    if (resultado.results().isEmpty()) {
      System.out.println("Nenhum livro encontrado.");
      return null;
    }

    return resultado.results().get(0);
  }

  private void listarLivros() {
    List<Livro> livros = livroRepository.findAll();
    livros.forEach(System.out::println);
  }

  private void listarAutores() {
    List<Autor> autores = autorRepository.findAll();
    autores.stream().forEach(System.out::println);
  }

  private void listarAutoresVivosEmAno() {
    System.out.println("Digite o ano para listar autores vivos:");
    int ano = scan.nextInt();
    scan.nextLine();

    List<Autor> autoresVivos = autorRepository.findAutoresVivosEmAno(ano);
    if (autoresVivos.isEmpty()) {
      System.out.println("Nenhum autor vivo encontrado para o ano " + ano);
    } else {
      autoresVivos.stream().forEach(System.out::println);
    }
  }

  private void listarLivrosPorIdioma() {
    System.out.println("Digite o idioma para listar livros:");
    String idioma = scan.nextLine();

    List<Livro> livrosPorIdioma = livroRepository.findByIdioma(idioma);
    if (livrosPorIdioma.isEmpty()) {
      System.out.println("Nenhum livro encontrado no idioma " + idioma);
    } else {
      livrosPorIdioma.stream().forEach(System.out::println);
    }
  }
}
