package com.ricardohg.ejercicio2;

import java.io.Serializable;

public class Videogame implements Serializable {
    String title;
    String developer;
    String publisher;
    String platform;
    String releaseDate;

    public Videogame(String title, String developer, String publisher, String platform, String releaseDate) {
        this.title = title;
        this.developer = developer;
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

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
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
}
