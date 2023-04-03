package com.example.projetgsbvisite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GsbVisiteService service =
                RetrofitClientInstance.getRetrofitInstance().create(GsbVisiteService.class);
        Call<Token> call = service.getToken(new Visiteur("azerty", "Tamia40@hotmail.com","Tamia40@hotmail.com",45435
        ));
        call.enqueue(new Callback<Token>(){
            @Override
            public void onResponse(Call<Token> call, Response<Token> response){
                response.body();
            }
            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Une erreur est survenue !",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }


}