package br.com.jokenpo_projeto;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class FinishActivity extends AppCompatActivity {

    private Button botaoJogarDenovo;

    public TextView nomeUsuario;
    private TextView header1, header2, placarUser, placarApp;
    String nomeVar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        botaoJogarDenovo = findViewById(R.id.jogar_denovo);
        header1 = findViewById(R.id.congratulations);
        header2 = findViewById(R.id.resultado);
        placarApp = findViewById(R.id.placarApp);
        placarUser = findViewById(R.id.UserPlacar);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Bundle resultado = getIntent().getExtras();
        int resultadoUser = resultado.getInt("userVence");
        int resultadoApp = resultado.getInt("appVence");
        String placarapp = resultado.getString("placarApp");
        String placaruser = resultado.getString("placarUser");

        if (resultadoUser == 0) {
            header1.setText(R.string.congratulations);
            header2.setText(R.string.you_win);
            placarUser.setText(placaruser);
            placarApp.setText(placarapp);

        }
        if (resultadoApp == 1) {
            header1.setText(R.string.sorry);
            header2.setText(R.string.you_lose);
            placarUser.setText(placaruser);
            placarApp.setText(placarapp);
        }



    }
    public void novoJogador(View view){

        startActivity(new Intent(getBaseContext(), UserActivity.class));
        finish();
    }

    public void jogarDenovo(View view){

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
            }


}






