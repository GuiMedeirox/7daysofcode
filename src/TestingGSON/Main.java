package TestingGSON;

import com.google.gson.Gson;
public class Main {
    public static void main(String[] args) {

        String teste = """
            {
                nome: "guilherme", 
                idade: 17
            }
            """;

        Gson g = new Gson();
        Pessoa p = g.fromJson(teste, Pessoa.class);

        System.out.println(p);


    }
}