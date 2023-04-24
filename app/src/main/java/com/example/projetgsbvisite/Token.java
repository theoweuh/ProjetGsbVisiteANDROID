package com.example.projetgsbvisite;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Token implements Serializable {
    @SerializedName("token")
    String token;
    public Token(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public String getBearerToken() {return "Bearer " + token;}
}

