package com.example.starwarsapp.BBDD_SW;

import java.sql.Array;
import java.sql.Date;

public class swFilms {
    public String title;
    public int  episode_id;
    public String opening_crawl;
    public String director;
    public Date release_date;
    public Array species;
    public Array starships;
    public Array vehicles;
    public Array characters;
    public Array planets;
    public String url;
    public String created;
    public String edited;

    public swFilms() {
    }

    public swFilms(String title, int episode_id, String opening_crawl, String director, Date release_date, Array species, Array starships, Array vehicles, Array characters, Array planets, String url, String created, String edited) {
        this.title = title;
        this.episode_id = episode_id;
        this.opening_crawl = opening_crawl;
        this.director = director;
        this.release_date = release_date;
        this.species = species;
        this.starships = starships;
        this.vehicles = vehicles;
        this.characters = characters;
        this.planets = planets;
        this.url = url;
        this.created = created;
        this.edited = edited;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEpisode_id() {
        return episode_id;
    }

    public void setEpisode_id(int episode_id) {
        this.episode_id = episode_id;
    }

    public String getOpening_crawl() {
        return opening_crawl;
    }

    public void setOpening_crawl(String opening_crawl) {
        this.opening_crawl = opening_crawl;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public Array getSpecies() {
        return species;
    }

    public void setSpecies(Array species) {
        this.species = species;
    }

    public Array getStarships() {
        return starships;
    }

    public void setStarships(Array starships) {
        this.starships = starships;
    }

    public Array getVehicles() {
        return vehicles;
    }

    public void setVehicles(Array vehicles) {
        this.vehicles = vehicles;
    }

    public Array getCharacters() {
        return characters;
    }

    public void setCharacters(Array characters) {
        this.characters = characters;
    }

    public Array getPlanets() {
        return planets;
    }

    public void setPlanets(Array planets) {
        this.planets = planets;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }
}
