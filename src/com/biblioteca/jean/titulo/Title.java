package com.biblioteca.jean.titulo;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Title implements Comparable<Title>{


    private String myTitle;
    private int timeMovie;
    private String yearOfRelease;

    private String genre;
    private double sumRating;
    private int overallRating;

    List<String> listTitle = new ArrayList<>();
    Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();

    public String getGenre() {
        return genre;
    }

    private String artistName;

    public Title(String title){
        this.myTitle = title;
    }

    public Title(TitleOMDB titleOMDB) {
        this.myTitle = titleOMDB.title();
        this.yearOfRelease = String.valueOf(Integer.valueOf(titleOMDB.year()));
        this.timeMovie = Integer.valueOf(titleOMDB.runtime().substring(0,2));
    }

    public String getNewCatalogo(){
        return " { Titulo " + myTitle + " } Lançamento  { " + yearOfRelease +
                " } Duração  { " + timeMovie + " } Gênero  { " + genre +" }";
    }
    public String getDisplay(){
        return """
                1- Consultar Api.
                2- Criar novo catalogo.
                Escolha uma opção >
                """;
    }


    public void setTime(int timeMovie) {
        this.timeMovie = timeMovie;
    }

    public String getYearOfRelease() {
        return yearOfRelease;
    }

    public int getTime() {
        return timeMovie;
    }

    public double getSumRating() {
        return sumRating;
    }


    public int getOverallRating() {
        return overallRating;
    }

    public String getMyTitle() {
        return myTitle;
    }

    public String getArtistName() {
        return artistName;
    }

    public int getTimeMovie() {
        return timeMovie;
    }

    //creating tlitle review
    public void sendRated(double value) {
        sumRating += value;
        overallRating ++;
    }
    public double catchRating(){
        return sumRating / overallRating;
    }

//    creating new title in catalog
    public void addNewTitle(Title newTitle) throws IOException {
        int options = 0;
        while (options != 4) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Criaçao de catalogos!!!! \n\n");
            System.out.println("Digite um Titulo > ");
            myTitle = sc.nextLine();
            System.out.println("Digite seu Ano de lançamento > ");
            yearOfRelease = sc.nextLine();
            System.out.println("Digite sua duração > ");
            timeMovie = sc.nextInt();
            sc.nextLine();
            listTitle.add(toString());

            FileWriter writing = new FileWriter("newTitle.json");
            writing.write(gson.toJson(listTitle));
            writing.close();

            System.out.println("4 para sair ou 1 para continuar.");
            options = sc.nextInt();
        }
        System.out.println("\nLista de titulos:\n " + listTitle);
    }
    @Override
    public int compareTo(Title o) {
        return this.getMyTitle().compareTo(o.getMyTitle());
    }

    @Override
    public String toString() {
        return "( nome: " + myTitle + ", " + "ano de lançamento: " +
                yearOfRelease + ", " + "duração: " + timeMovie + " min " + ")";
    }

}
