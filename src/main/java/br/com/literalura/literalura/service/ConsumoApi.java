package br.com.literalura.literalura.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {

  public String obterDados(String endereco) {
    System.out.println("Requisição para URL: " + endereco);

    HttpClient client = HttpClient.newBuilder()
        .followRedirects(HttpClient.Redirect.ALWAYS)
        .build();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(endereco))
        .build();
    HttpResponse<String> response = null;
    try {
      response = client.send(request, HttpResponse.BodyHandlers.ofString());
    } catch (IOException | InterruptedException e) {
      throw new RuntimeException(e);
    }

    System.out.println("Status HTTP: " + response.statusCode());

    String json = response.body();
    return json;
  }

}
