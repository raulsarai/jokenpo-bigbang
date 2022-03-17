package br.com.jokenpo_projeto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public TextView tituloApp, escolhaUser, labelResultado, pontoApp, pontoUser, nomeUser;
    private ImageView imgResultado;
    public int contPontuacaoApp, contPontuacaoUser = 0;
    private int estrutura_decisao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nomeUser = findViewById(R.id.nomeUser);
        tituloApp = findViewById(R.id.appTitle2);
        escolhaUser = findViewById(R.id.escolhaUser);
        labelResultado = findViewById(R.id.label_resultado);
        imgResultado = findViewById(R.id.img_resultado);
        pontoApp = findViewById(R.id.txtPontoApp);
        pontoUser = findViewById(R.id.txtPontoUser);

        Bundle dados = getIntent().getExtras();
        String nomeUsuario = dados.getString("userName");
        nomeUser.setText(nomeUsuario);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("PEDRA");
    }

    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("TESOURA");
    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("PAPEL");
    }

    public void selecionadoLagarto(View view) {
        this.opcaoSelecionada("LAGARTO");
    }

    public void selecionadoSpock(View view) {
        this.opcaoSelecionada("SPOCK");
    }

    public int pontuacaoUser () {
        this.contPontuacaoUser++;
        String ContPontuacaoApp = String.valueOf(contPontuacaoApp);
        String ContPontuacaoUser = String.valueOf(this.contPontuacaoUser);
        pontoUser.setText(String.valueOf(this.contPontuacaoUser));
        if (this.contPontuacaoUser == 10) {
            Intent intent = (new Intent(getApplicationContext(), FinishActivity.class));
            intent.putExtra("userVence", 0);
            intent.putExtra("placarApp", ContPontuacaoApp);
            intent.putExtra("placarUser", ContPontuacaoUser);
            startActivity(intent);
        }
        return 0;
    }

    public int pontuacaoApp () {
        contPontuacaoApp++;
        String ContPontuacaoApp = String.valueOf(contPontuacaoApp);
        String ContPontuacaoUser = String.valueOf(this.contPontuacaoUser);
        pontoApp.setText(String.valueOf(contPontuacaoApp));
        if (contPontuacaoApp == 10) {
            Intent intent = (new Intent(getApplicationContext(), FinishActivity.class));
            intent.putExtra("appVence", 1);
            intent.putExtra("placarUser", ContPontuacaoUser);
            intent.putExtra("placarApp", ContPontuacaoApp);
            startActivity(intent);
        }
        return 0;
    }


    public int opcaoSelecionada(String opcaoSelecionada) {

        String opcaoApp = geraOpcoesAleatorias();
        tituloApp.setText(opcaoApp);
        escolhaUser.setText("VOCÊ SELECIONOU " + opcaoSelecionada);
        switchOpcaoApp(imgResultado, opcaoApp);



            if (opcaoSelecionada.equals(getString(R.string.pedra)) && opcaoApp.equals(getString(R.string.tesoura))) {
                labelResultado.setText(getString(R.string.pedra_Tesoura) + getString(R.string.voceGanhou));
                pontuacaoUser();
            } else if (opcaoApp.equals(getString(R.string.pedra)) && opcaoSelecionada.equals(getString(R.string.tesoura))) {
                labelResultado.setText(getString(R.string.pedra_Tesoura) + getString(R.string.vocePerdeu));
                pontuacaoApp();
            } else if (opcaoSelecionada.equals(getString(R.string.tesoura)) && opcaoApp.equals(getString(R.string.papel))) {
                labelResultado.setText(getString(R.string.tesoura_Papel) + getString(R.string.voceGanhou));
                pontuacaoUser();
            } else if (opcaoApp.equals(getString(R.string.tesoura)) && opcaoSelecionada.equals(getString(R.string.papel))) {
                labelResultado.setText(getString(R.string.tesoura_Papel) + getString(R.string.vocePerdeu));
                pontuacaoApp();
            } else if (opcaoSelecionada.equals(getString(R.string.papel)) && opcaoApp.equals(getString(R.string.pedra))) {
                labelResultado.setText(getString(R.string.papel_pedra) + getString(R.string.voceGanhou));
                pontuacaoUser();
            } else if (opcaoApp.equals(getString(R.string.papel)) && opcaoSelecionada.equals(getString(R.string.pedra))) {
                labelResultado.setText(getString(R.string.papel_pedra) + getString(R.string.vocePerdeu));
                pontuacaoApp();
            } else if (opcaoSelecionada.equals(getString(R.string.pedra)) && opcaoApp.equals(getString(R.string.lagarto))) {
                labelResultado.setText(getString(R.string.pedra_lagarto) + getString(R.string.voceGanhou));
                pontuacaoUser();
            } else if (opcaoApp.equals(getString(R.string.pedra)) && opcaoSelecionada.equals(getString(R.string.lagarto))) {
                labelResultado.setText(getString(R.string.pedra_lagarto) + getString(R.string.vocePerdeu));
                pontuacaoApp();
            } else if (opcaoSelecionada.equals(getString(R.string.lagarto)) && opcaoApp.equals(getString(R.string.spock))) {
                labelResultado.setText(getString(R.string.lagarto_spok) + getString(R.string.voceGanhou));
                pontuacaoUser();
            } else if (opcaoApp.equals(getString(R.string.lagarto)) && opcaoSelecionada.equals(getString(R.string.spock))) {
                labelResultado.setText(getString(R.string.lagarto_spok) + getString(R.string.vocePerdeu));
                pontuacaoApp();
            } else if (opcaoSelecionada.equals(getString(R.string.spock)) && opcaoApp.equals(getString(R.string.tesoura))) {
                labelResultado.setText(getString(R.string.spock_tesoura) + getString(R.string.voceGanhou));
                pontuacaoUser();
            } else if (opcaoApp.equals(getString(R.string.spock)) && opcaoSelecionada.equals(getString(R.string.tesoura))) {
                labelResultado.setText(getString(R.string.spock_tesoura) + getString(R.string.vocePerdeu));
                pontuacaoApp();
            } else if (opcaoSelecionada.equals(getString(R.string.tesoura)) && opcaoApp.equals(getString(R.string.lagarto))) {
                labelResultado.setText(getString(R.string.tesoura_lagarto) + getString(R.string.voceGanhou));
                pontuacaoUser();
            } else if (opcaoApp.equals(getString(R.string.tesoura)) && opcaoSelecionada.equals(getString(R.string.lagarto))) {
                labelResultado.setText(getString(R.string.tesoura_lagarto) + getString(R.string.vocePerdeu));
                pontuacaoApp();
            } else if (opcaoSelecionada.equals(getString(R.string.lagarto)) && opcaoApp.equals(getString(R.string.papel))) {
                labelResultado.setText(getString(R.string.lagarto_papel) + getString(R.string.voceGanhou));
                pontuacaoUser();
            } else if (opcaoApp.equals(getString(R.string.lagarto)) && opcaoSelecionada.equals(getString(R.string.papel))) {
                labelResultado.setText(getString(R.string.lagarto_papel) + getString(R.string.vocePerdeu));
                pontuacaoApp();
            } else if (opcaoSelecionada.equals(getString(R.string.papel)) && opcaoApp.equals(getString(R.string.spock))) {
                labelResultado.setText(getString(R.string.papel_spock) + getString(R.string.voceGanhou));
                pontuacaoUser();
            } else if (opcaoApp.equals(getString(R.string.papel)) && opcaoSelecionada.equals(getString(R.string.spock))) {
                labelResultado.setText(getString(R.string.papel_spock) + getString(R.string.vocePerdeu));
                pontuacaoApp();
            } else if (opcaoSelecionada.equals(getString(R.string.spock)) && opcaoApp.equals(getString(R.string.pedra))) {
                labelResultado.setText(getString(R.string.spock_pedra) + getString(R.string.voceGanhou));
                pontuacaoUser();
            } else if (opcaoApp.equals(getString(R.string.spock)) && opcaoSelecionada.equals(getString(R.string.pedra))) {
                labelResultado.setText(getString(R.string.spock_pedra) + getString(R.string.vocePerdeu));
                pontuacaoApp();
            } else {
                labelResultado.setText(R.string.empate);
            }
            return 0;
        }





    @NonNull
    private String geraOpcoesAleatorias() {
        int numero = new Random().nextInt(5);
        String[] opcoes = {"PEDRA", "PAPEL", "TESOURA", "LAGARTO", "SPOCK"};
        String opcaoApp = opcoes[numero];
        return opcaoApp;
    }

    private void switchOpcaoApp(ImageView imgResultado, @NonNull String opcaoApp) {
        switch (opcaoApp) {
            case "PEDRA":
                imgResultado.setImageResource(R.drawable.pedra);
                break;
            case "PAPEL":
                imgResultado.setImageResource(R.drawable.papel);
                break;
            case "TESOURA":
                imgResultado.setImageResource(R.drawable.tesoura);
                break;
            case "LAGARTO":
                imgResultado.setImageResource(R.drawable.lagarto);
                break;
            case "SPOCK":
                imgResultado.setImageResource(R.drawable.spock);
                break;
        }
    }

}