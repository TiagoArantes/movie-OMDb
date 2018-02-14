package com.example.tiago.testezup;

import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by Tiago on 11/02/2018.
 */

public class TelaPrincipal {

    MainActivity act;

    Button btIdCadastro;
    Button btIdAcessarLista;
    TelaCadastro telaCadastro;
    TelaListaFilmes telaListaFilmes;

    public TelaPrincipal(MainActivity act){
        this.act = act;
    }

    public void CarregaTela(){

        act.setContentView(R.layout.activity_main);
        btIdCadastro = (Button) act.findViewById(R.id.idCadastrar);
        btIdAcessarLista = (Button) act.findViewById(R.id.idAcessarLista);

        btIdCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                telaCadastro.CarregaTela();
            }
        });

        btIdAcessarLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BancoController banco = new BancoController(act.getBaseContext());
                ArrayList<Filme> filmes = new ArrayList<>();
                filmes = banco.carregaDados();
                act.preencheFilmes(filmes);
                telaListaFilmes.CarregaTela();
            }
        });
    }

    public void setTelaCadastro(TelaCadastro tc){
        this.telaCadastro = tc;
    }

    public void setTelaListaFilmes(TelaListaFilmes tlf){
        this.telaListaFilmes = tlf;
    }
}
