package com.example.projetgsbvisite;

import android.media.session.MediaSession;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface GsbVisiteService {
    @POST("login_check")
    Call<Token> getToken(@Body Visiteur visiteur);
}



