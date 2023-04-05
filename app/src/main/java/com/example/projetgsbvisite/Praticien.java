package com.example.projetgsbvisite;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Praticien implements Serializable {
    @SerializedName("nom")
    public String nom;
    @SerializedName("prenom")
    public String prenom;
    @SerializedName("mail")
    public String mail;
    @SerializedName("tel")
    public int tel;

    public Praticien(String nom, String prenom, String mail,int tel){
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.tel = tel;
    }

    public String getNom(){ return nom; }
    public String getPrenom(){ return prenom;}
    public String getMail(){ return mail;}
}
