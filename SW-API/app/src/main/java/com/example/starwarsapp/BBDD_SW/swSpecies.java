package com.example.starwarsapp.BBDD_SW;

import java.sql.Array;

public class swSpecies {
    public String name;
    public String classification;
    public String designation;
    public String average_height;
    public String average_lifespan;
    public String eye_colors;
    public String hair_colors;
    public String skin_colors;
    public String language;
    public String homeworld;
    public Array people;
    public Array films;
    public String url;
    public String created;
    public String edited;

    public swSpecies() {
    }

    public swSpecies(String name, String classification, String designation, String average_height, String average_lifespan, String eye_colors, String hair_colors, String skin_colors, String language, String homeworld, Array people, Array films, String url, String created, String edited) {
        this.name = name;
        this.classification = classification;
        this.designation = designation;
        this.average_height = average_height;
        this.average_lifespan = average_lifespan;
        this.eye_colors = eye_colors;
        this.hair_colors = hair_colors;
        this.skin_colors = skin_colors;
        this.language = language;
        this.homeworld = homeworld;
        this.people = people;
        this.films = films;
        this.url = url;
        this.created = created;
        this.edited = edited;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getAverage_height() {
        return average_height;
    }

    public void setAverage_height(String average_height) {
        this.average_height = average_height;
    }

    public String getAverage_lifespan() {
        return average_lifespan;
    }

    public void setAverage_lifespan(String average_lifespan) {
        this.average_lifespan = average_lifespan;
    }

    public String getEye_colors() {
        return eye_colors;
    }

    public void setEye_colors(String eye_colors) {
        this.eye_colors = eye_colors;
    }

    public String getHair_colors() {
        return hair_colors;
    }

    public void setHair_colors(String hair_colors) {
        this.hair_colors = hair_colors;
    }

    public String getSkin_colors() {
        return skin_colors;
    }

    public void setSkin_colors(String skin_colors) {
        this.skin_colors = skin_colors;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public Array getPeople() {
        return people;
    }

    public void setPeople(Array people) {
        this.people = people;
    }

    public Array getFilms() {
        return films;
    }

    public void setFilms(Array films) {
        this.films = films;
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
