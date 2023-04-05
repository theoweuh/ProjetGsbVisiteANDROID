package com.example.projetgsbvisite;

import com.google.gson.annotations.SerializedName;

public class Token {
    @SerializedName("token")
    String token;
    public Token(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}

