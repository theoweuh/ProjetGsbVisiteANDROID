package com.example.projetgsbvisite;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.example.projetgsbvisite.databinding.ActivityVisiteurBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VisiteurActivity extends AppCompatActivity {

    private ActivityVisiteurBinding binding;
    private Token token;
    private String userName;
    private Visiteurs visiteurs;
    private Visiteur visiteur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVisiteurBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Intent myIntent = getIntent();
        token = (Token) myIntent.getSerializableExtra("token");
        userName = (String) myIntent.getSerializableExtra("userName");
        GsbVisiteService service =
                RetrofitClientInstance.getRetrofitInstance().create(GsbVisiteService.class);
        binding.nameEdit.setText("Bonjour, vous etes connécté en tant que : " + userName);



        Call<Visiteurs> call = service.getVisiteurs(token.getBearerToken());
        call.enqueue(new Callback<Visiteurs>(){
            @Override
            public void onResponse(Call<Visiteurs> call, Response<Visiteurs> response){
                visiteurs = response.body();
            }
            @Override
            public void onFailure(Call<Visiteurs> call, Throwable t) {
                Toast.makeText(VisiteurActivity.this, "Une erreur est survenue !",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}