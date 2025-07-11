package br.com.literalura.literalura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.literalura.literalura.client.Principal;
import br.com.literalura.literalura.repository.AutorRepository;
import br.com.literalura.literalura.repository.LivroRepository;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(LiteraluraApplication.class, args);
  }

  @Autowired
  private LivroRepository livroRepository;

  @Autowired
  private AutorRepository autorRepository;

  @Override
  public void run(String... args) throws Exception {
    Principal menu = new Principal(livroRepository, autorRepository);
    menu.exibeMenu();
  }

}
