package ViaCEP;


import com.google.gson.JsonSyntaxException;
import netscape.javascript.JSException;

import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
       Scanner s = new Scanner(System.in);

       System.out.println("CEP: ");
       String cep = s.nextLine();
       BuscaCep buscaCep = new BuscaCep();
        Endereco endereco = null;
       try {
           endereco = buscaCep.buscaEndereco(cep);
           GravarCEP g = new GravarCEP();
           g.salvarJson(endereco);
       } catch(JsonSyntaxException | NullPointerException e){
           System.out.println(e.getMessage());
       }

       System.out.println(endereco);


    }
}
