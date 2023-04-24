package com.example.projetgsbvisite;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.example.projetgsbvisite.databinding.ActivityMainBinding;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private String userName;
    private Token token;
    private String password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userName = binding.editTextTextPersonName.getText().toString();
                password = binding.editTextTextPassword.getText().toString();


                GsbVisiteService service =
                        RetrofitClientInstance.getRetrofitInstance().create(GsbVisiteService.class);
                Call<Token> call = service.getToken(new Visiteur(password, userName));
                call.enqueue(new Callback<Token>(){
                    @Override
                    public void onResponse(Call<Token> call, Response<Token> response){
                        token = response.body();
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
        });
    }





}