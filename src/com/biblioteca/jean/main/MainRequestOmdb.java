package com.biblioteca.jean.main;

import com.biblioteca.jean.resquest.ResquestResponse;
import com.biblioteca.jean.titulo.Title;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Scanner;

public class MainRequestOmdb {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        Gson gson = new Gson();

        Title newTitle = new Title("");
        System.out.println(newTitle.getDisplay());
        int options = sc.nextInt();
        switch (options) {
            case 1:
                ResquestResponse newCall = new ResquestResponse("");
                System.out.println("Consulta de API!!!\n");
                newCall.call("busca");
                break;
            case 2:
                newTitle.addNewTitle(newTitle);
                break;

        }
    }
}