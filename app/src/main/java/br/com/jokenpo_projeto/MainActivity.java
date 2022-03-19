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

    public void pontuacaoUser () {
        this.contPontuacaoUser++;
        String ContPontuacaoApp = String.valueOf(contPontuacaoApp);
        String ContPontuacaoUser = String.valueOf(this.contPontuacaoUser);
        pontoUser.setText(String.valueOf(this.contPontuacaoUser));
        if (this.contPontuacaoUser == 2) {
            Intent intent = (new Intent(getApplicationContext(), FinishActivity.class));
            intent.putExtra("userVence", 0);
            intent.putExtra("placarApp", ContPontuacaoApp);
            intent.putExtra("placarUser", ContPontuacaoUser);
            startActivity(intent);
            //finish();
        }
    }

    public void pontuacaoApp () {
        contPontuacaoApp++;
        String ContPontuacaoApp = String.valueOf(contPontuacaoApp);
        String ContPontuacaoUser = String.valueOf(this.contPontuacaoUser);
        pontoApp.setText(String.valueOf(contPontuacaoApp));
        if (contPontuacaoApp == 2) {
            Intent intent = (new Intent(getApplicationContext(), FinishActivity.class));
            intent.putExtra("appVence", 1);
            intent.putExtra("placarUser", ContPontuacaoUser);
            intent.putExtra("placarApp", ContPontuacaoApp);
            startActivity(intent);
            //finish();
        }
    }


    public void opcaoSelecionada(String opcaoSelecionada) {

        String opcaoApp = geraOpcoesAleatorias();
        tituloApp.setText(opcaoApp);
        escolhaUser.setText(String.format("%s%s", getString(R.string.userSelect), opcaoSelecionada));
        switchOpcaoApp(imgResultado, opcaoApp);

        switch (opcaoSelecionada) {
            case "PEDRA":
                switch (opcaoApp) {
                    case "TESOURA":
                        labelResultado.setText(String.format("%s%s", getString(R.string.pedra_Tesoura), getString(R.string.voceGanhou)));
                        pontuacaoUser();
                        break;
                    case "lagarto":
                        labelResultado.setText(String.format("%s%s", getString(R.string.pedra_lagarto), getString(R.string.voceGanhou)));
                        pontuacaoUser();
                        break;
                    case "PEDRA":
                        labelResultado.setText(R.string.empate);
                        break;
                    default:
                        pontuacaoApp();
                }
                break;
            case "PAPEL":
                switch (opcaoApp) {
                    case "PEDRA":
                        labelResultado.setText(String.format("%s%s", getString(R.string.papel_pedra), getString(R.string.voceGanhou)));
                        pontuacaoUser();
                        break;
                    case "SPOCK":
                        labelResultado.setText(String.format("%s%s", getString(R.string.papel_spock), getString(R.string.voceGanhou)));
                        pontuacaoUser();
                        break;
                    case "PAPEL":
                        labelResultado.setText(R.string.empate);
                        break;
                    default:
                        pontuacaoApp();
                }
                break;
            case "TESOURA":
                switch (opcaoApp) {
                    case "PAPEL":
                        labelResultado.setText(String.format("%s%s", getString(R.string.tesoura_Papel), getString(R.string.voceGanhou)));
                        pontuacaoUser();
                        break;
                    case "LAGARTO":
                        labelResultado.setText(String.format("%s%s", getString(R.string.tesoura_lagarto), getString(R.string.voceGanhou)));
                        pontuacaoUser();
                        break;
                    case "TESOURA":
                        labelResultado.setText(R.string.empate);
                        break;
                    default:
                        pontuacaoApp();
                }
                break;
            case "LAGARTO":
                switch (opcaoApp) {
                    case "SPOCK":
                        labelResultado.setText(String.format("%s%s", getString(R.string.lagarto_spok), getString(R.string.voceGanhou)));
                        pontuacaoUser();
                        break;
                    case "PAPEL":
                        labelResultado.setText(String.format("%s%s", getString(R.string.lagarto_papel), getString(R.string.voceGanhou)));
                        pontuacaoUser();
                        break;
                    case "LAGARTO":
                        labelResultado.setText(R.string.empate);
                        break;
                    default:
                        pontuacaoApp();
                }
                break;
            case "SPOCK":
                switch (opcaoApp) {
                    case "TESOURA":
                        labelResultado.setText(String.format("%s%s", getString(R.string.spock_tesoura), getString(R.string.voceGanhou)));
                        pontuacaoUser();
                        break;
                    case "PEDRA":
                        labelResultado.setText(String.format("%s%s", getString(R.string.spock_pedra), getString(R.string.voceGanhou)));
                        pontuacaoUser();
                        break;
                    case "SPOCK":
                        labelResultado.setText(R.string.empate);
                        break;
                    default:
                        pontuacaoApp();
                }
                break;
        }
    }

    @NonNull
    private String geraOpcoesAleatorias() {
        int numero = new Random().nextInt(5);
        String[] opcoes = {"PEDRA", "PAPEL", "TESOURA", "LAGARTO", "SPOCK"};
        return opcoes[numero];
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