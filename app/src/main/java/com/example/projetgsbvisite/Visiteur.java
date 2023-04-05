package com.example.projetgsbvisite;

import android.widget.Toast;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Visiteur implements Serializable {
    @SerializedName("password")
    public String password;
    @SerializedName("username")
    public String username;
    @SerializedName("email")
    public String email;
    @SerializedName("tel")
    public int tel;
//

    public Visiteur(String password, String username){
        this.password = password;
        this.username = username;

    }
}