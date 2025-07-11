package br.com.literalura.literalura.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

public class ConverteDados implements IConverteDados {
  private ObjectMapper mapper = new ObjectMapper();

  @Override
  public <T> T obterDados(String json, Class<T> classe) {
    try {
      return mapper.readValue(json, classe);
    } catch (JsonMappingException e) {
      throw new RuntimeException("Erro ao mapear JSON: " + e.getMessage(), e);
    } catch (JsonProcessingException e) {
      throw new RuntimeException("Erro ao converter JSON: " + e.getMessage(), e);
    }
  }

  @Override
  public <T> List<T> obterListaDados(String json, Class<T> classe) {
    CollectionType lista = mapper.getTypeFactory()
        .constructCollectionType(List.class, classe);
    try {
      return mapper.readValue(json, lista);
    } catch (JsonMappingException e) {
      throw new RuntimeException("Erro ao mapear JSON para lista: " + e.getMessage(), e);
    } catch (JsonProcessingException e) {
      throw new RuntimeException("Erro ao converter JSON para lista: " + e.getMessage(), e);
    }
  }

}
