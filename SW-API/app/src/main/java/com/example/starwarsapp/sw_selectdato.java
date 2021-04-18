package com.example.starwarsapp;

public class sw_selectdato {
    public Integer id;
    public String datos;

    public sw_selectdato() {
    }

    public sw_selectdato(Integer id, String datos) {
        this.id = id;
        this.datos = datos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }


}
