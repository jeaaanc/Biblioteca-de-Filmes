package com.biblioteca.jean.main;
import com.biblioteca.jean.resquest.RateCauculation;
import com.biblioteca.jean.titulo.Movie;

import java.util.Scanner;

public class MainMovie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Movie dragonBallz = new Movie("Dragon Ball Z");
        dragonBallz.sendRated(10);
        dragonBallz.sendRated(7);
        dragonBallz.sendRated(9);
        dragonBallz.sendRated(9);
        System.out.println("\nPassando nota\n");
        System.out.println(dragonBallz.getMyTitle() + " > Nota: " + dragonBallz.catchRating());

        RateCauculation rateCauculation = new RateCauculation();
        rateCauculation.sendReview(dragonBallz);

    }
}
