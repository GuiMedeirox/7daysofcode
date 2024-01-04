package ViaCEP;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GravarCEP {

    public void salvarJson(Endereco endereco){
        Gson g = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileWriter f = new FileWriter("cep.json");
            f.write(g.toJson(endereco));
            f.close();
        } catch (IOException e){
            System.out.println("Erro durante o processo de escrita do arquivo");
            System.out.println(e.getMessage());
        }
    }

}
