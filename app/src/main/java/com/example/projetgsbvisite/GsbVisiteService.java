package com.example.projetgsbvisite;

import android.media.session.MediaSession;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;


public interface GsbVisiteService {

    @GET("visiteurs")
    Call<Visiteur> getVisiteurs(@Header("Authorization") String authorization);


    @POST("login_check")
    Call<Token> getToken(@Body Visiteur visiteur);
}



