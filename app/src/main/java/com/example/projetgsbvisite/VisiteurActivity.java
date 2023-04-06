package com.example.projetgsbvisite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import android.content.Intent;
import android.os.Bundle;
import android.text.LoginFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projetgsbvisite.databinding.ActivityVisiteurBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VisiteurActivity extends AppCompatActivity {

    private ActivityVisiteurBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVisiteurBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent myIntent = getIntent();

        String listVisiteur = (String)myIntent.getSerializableExtra("listVisiteur");
        String token = (String)myIntent.getSerializableExtra("token");
        String userName = (String)myIntent.getSerializableExtra("userName");
        binding.nameEdit.setText("bonjour, vous etes connécté en tant que : " + userName + listVisiteur);

        GsbVisiteService service =
                RetrofitClientInstance.getRetrofitInstance().create(GsbVisiteService.class);
        Call<Visiteur> call = service.getVisiteurs(new Visiteur(listVisiteur));
        call.enqueue(new Callback<Visiteur>(){
            @Override
            public void onResponse(Call<Visiteur> call, Response<Token> response){
                Token monToken = response.body();
                token = monToken.getToken();

                Intent myIntent = new Intent(MainActivity.this, VisiteurActivity.class);
                myIntent.putExtra("userName", userName);
                myIntent.putExtra("token", token);
                startActivity(myIntent);
            }
            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Une erreur est survenue !",
                        Toast.LENGTH_SHORT).show();
            }
        });




    }

}