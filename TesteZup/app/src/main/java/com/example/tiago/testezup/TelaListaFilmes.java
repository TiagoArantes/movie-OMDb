package com.example.tiago.testezup;

import android.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Tiago on 11/02/2018.
 */

public class TelaListaFilmes {

    MainActivity act;
    TelaPrincipal telaPrincipal;

    Button btAnterior, btProximo, btFechar;
    TextView tvFilme, tvAno, tvDescricao, tvStatus, tvAtores, tvIMDB, tvGenero;

    int index;

    public TelaListaFilmes(MainActivity act, TelaPrincipal tp){
        this.act = act;
        this.telaPrincipal = tp;
        index = 0;
    }

    public void CarregaTela() {
        //verificando se existe registro
        if (act.getFilmes().size() == 0) {
            (new AlertDialog.Builder(act))
                    .setTitle("Aviso")
                    .setMessage("Não existe nenhum filme cadastrado")
                    .setNeutralButton("OK", null)
                    .show();

            return;
        }

        act.setContentView(R.layout.apresentar_lista);
        btAnterior = (Button) act.findViewById(R.id.idAnterior);
        btProximo = (Button) act.findViewById(R.id.idProximo);
        btFechar = (Button) act.findViewById(R.id.idFechar);

        tvFilme = (TextView) act.findViewById(R.id.idFilmeLista);
        tvAno = (TextView) act.findViewById(R.id.anoLista);
        tvDescricao = (TextView) act.findViewById(R.id.descricao);
        tvStatus = (TextView) act.findViewById(R.id.idStatus);
        tvAtores = (TextView) act.findViewById(R.id.idAtores);
        tvGenero = (TextView) act.findViewById(R.id.idGenero);
        tvIMDB = (TextView) act.findViewById(R.id.idNotaDuracao);

        PreencheCampos(index);
        AtualizaStatus(index);

        btAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index > 0) {
                    index--;
                    PreencheCampos(index);
                    AtualizaStatus(index);
                }
            }
        });

        btProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index < act.getFilmes().size() - 1) {
                    index++;
                    PreencheCampos(index);
                    AtualizaStatus(index);
                }
            }
        });

        btFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                telaPrincipal.CarregaTela();
            }
        });
    }

    public void PreencheCampos(int idx){
        tvFilme.setText(act.getFilmes().get(idx).getFilme());
        tvAno.setText(act.getFilmes().get(idx).getAno());
        tvAtores.setText(act.getFilmes().get(idx).getAtores());
        tvGenero.setText(act.getFilmes().get(idx).getGenero());
        tvIMDB.setText("IMDB: "+act.getFilmes().get(idx).getImdb()+"    Duração: "+act.getFilmes().get(idx).getTempo());
        tvDescricao.setText(act.getFilmes().get(idx).getDescricao());
    }

    public void AtualizaStatus(int idx){
        int total = act.getFilmes().size();
        tvStatus.setText("Filmes: " + (idx+1) + "/" + total);
    }
}
