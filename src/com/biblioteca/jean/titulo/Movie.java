package com.biblioteca.jean.titulo;

import com.biblioteca.jean.resquest.Rated;

public class Movie extends Title implements Rated {
    public Movie(String title) {
        super(title);
    }

    @Override
    public int getRated() {
        return (int) (catchRating() / 2);
    }
}