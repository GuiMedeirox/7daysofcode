
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        String filmeNome = sc.nextLine();
        try {
            FileWriter f = new FileWriter("filmes.json");
            String enderecoAPI = "https://www.omdbapi.com/?t=" + filmeNome.replace(" ", "+") + "&apikey=93bf45f0";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(enderecoAPI)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();
            MovieOMDB m = gson.fromJson(json, MovieOMDB.class);
            f.write(json);
            f.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("escreveu");

        /*
             A busca pelo filme ocorre de forma padrao, lancando a request para a API.
             O grande diferencial esta na forma que tratamentos a response, isto eh, usando a lib gson com um GsonBuilder
             e padronizando os nossos campos, visando nao haver um choque entre os formatos, por ex: "Filme:SeiLa" e "filme:SeiLa"
         */
//        MovieOMDB movie = gson.fromJson(json, MovieOMDB.class);


//        System.out.println(movie.year());


    }
}