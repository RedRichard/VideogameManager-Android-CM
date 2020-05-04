package com.ricardohg.ejercicio2;

import java.io.Serializable;

public class Videogame implements Serializable {
    int id;
    String title;
    String publisher;
    String platform;
    String releaseDate;

    public Videogame(String title, String publisher, String platform, String releaseDate) {
        this.id = 0;
        this.title = title;
        this.publisher = publisher;
        this.platform = platform;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
