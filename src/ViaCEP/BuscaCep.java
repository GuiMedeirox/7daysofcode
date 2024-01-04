package ViaCEP;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscaCep {
    public Endereco buscaEndereco(String cep) {
        URI enderecoAPI = URI.create("https://viacep.com.br/ws/" + cep + "/json");
        HttpResponse<String> response = null;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(enderecoAPI).build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Endereco.class);
        } catch (IOException | InterruptedException e) {
            System.out.println("Nao foi possivel buscar as informacoes do CEP informado.");
            System.out.println(e.getMessage());

        }
        throw new RuntimeException("Nao foi possivel buscar as informacoes ao cep informado");
    }
}