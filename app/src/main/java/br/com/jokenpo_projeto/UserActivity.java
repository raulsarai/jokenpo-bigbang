package br.com.jokenpo_projeto;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class UserActivity extends AppCompatActivity {
    public TextView nomeUsuario;
    String nomeVar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        getSupportActionBar().hide();

    }

    public void btn_Jogar(View view){
        nomeUsuario     = findViewById(R.id.inputNome);
        nomeVar         = nomeUsuario.getText().toString();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = (new Intent(getApplicationContext(), MainActivity.class));
                intent.putExtra("userName", nomeVar);
                startActivity(intent);
            }
        }, 0);
    }

}


