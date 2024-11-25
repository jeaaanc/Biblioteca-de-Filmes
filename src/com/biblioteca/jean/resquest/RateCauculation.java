package com.biblioteca.jean.resquest;

public class RateCauculation {
    private String recomedetion;
//take notes and turn them into analysis
    public void sendReview(Rated rated){
        if (rated.getRated() >= 4){
        System.out.println("(Análises extremamente positivas)\n");
    }else {
            System.out.println("(Recomendado)\n");
        }
    }
}
