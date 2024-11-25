package com.biblioteca.jean.resquest;

import com.biblioteca.jean.titulo.Title;
import com.biblioteca.jean.titulo.TitleOMDB;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ResquestResponse extends Title {

    Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();
    List<Title> listOMDB = new ArrayList<Title>();

    Scanner sc = new Scanner(System.in);
    //api key required
    private String apikey = "Digite Sua APIKEY AKI";

    public ResquestResponse(String title) {
        super(title);
    }

    // make the call to OMDB
    public void call(String search) throws IOException, InterruptedException {
        int contador = 0;
        do {

            System.out.println("\ndigite sair para finalizar\n");

            try {
                System.out.println("Digite um titulo > ");
                search = sc.next();
                if (contador == 3 || search.equalsIgnoreCase("sair")) {
                    break;
                }
                String link = "https://www.omdbapi.com/?t=" + search + "&apikey=" + apikey;
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(link)).build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                //Resposta em json
                String json = response.body();
                TitleOMDB titleOMDB = gson.fromJson(json, TitleOMDB.class);
                System.out.println(json);
                //Fim da resposta


                Title title = new Title(titleOMDB);
                System.out.println("\nTitulo Convertido\n");
                System.out.println(title);
                listOMDB.add(title);

                FileWriter wriTer = new FileWriter("filmes.json");
                wriTer.write(gson.toJson(listOMDB));
                wriTer.close();
            } catch (NumberFormatException e) {
                System.out.println("ERRO");
                System.out.println(e.getMessage());
            } catch (NullPointerException e) {
                System.out.println("ERRÃO Arrume!!!!!!");
                System.out.println(e.getMessage());
            }
            contador++;
        }while (!search.equalsIgnoreCase("sair"));
        System.out.println("Minha lista: " + listOMDB);
    }

    @Override
    public String getDisplay() {
        return super.getDisplay();
    }
}



