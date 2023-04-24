package com.example.projetgsbvisite;

import android.widget.Toast;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Visiteur implements Serializable {
    @SerializedName("id")
    public int id;
    @SerializedName("email")
    public String email;
    @SerializedName("password")
    public String password;
    @SerializedName("matricule")
    public int matricule;
    @SerializedName("username")
    public String username;
    @SerializedName("tel")
    public int tel;
    @SerializedName("prenom")
    public String prenom;
    @SerializedName("nom")
    public String nom;
    @SerializedName("motif")
    public String motif;
    @SerializedName("bilan_fournit_visiteur")
    public String bilan_fournit_visiteur;

    public Visiteur(String password, String username){
        this.password = password;
        this.username = username;
    }
}