package com.example.projetgsbvisite;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Praticien implements Serializable {
    @SerializedName("nom")
    public String nom;

    @SerializedName("username")
    public String username;

    public Praticien(String nom, String username){
        this.nom = nom;
        this.username = username;
    }
}


/******************************************
 * PAS SUR POUR CA ( NOM ET AUTRE )
 * A REVOIR AU CAS OU C'EST JUSTE UN DEBUT
 ******************************************/