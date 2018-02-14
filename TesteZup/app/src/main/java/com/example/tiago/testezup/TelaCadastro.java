package com.example.tiago.testezup;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Context;

/**
 * Created by Tiago on 11/02/2018.
 */

public class TelaCadastro {

    private static String chave = "76db4364";

    MainActivity act;
    EditText etFilme;
    Button btCadastrar, btCancelar;
    TelaPrincipal telaPrincipal;

    public TelaCadastro(MainActivity act, TelaPrincipal tp){
        this.act = act;
        this.telaPrincipal = tp;
    }

    public void CarregaTela(){
        act.setContentView(R.layout.tela_cadastro);
        etFilme = (EditText) act.findViewById(R.id.idFilme);
        btCadastrar = (Button) act.findViewById(R.id.idCadastrar);
        btCancelar = (Button) act.findViewById(R.id.idCancelar);

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogo = new AlertDialog.Builder(act);
                dialogo.setTitle("Aviso");
                dialogo.setMessage("Cadastrar filme?");
                dialogo.setNegativeButton("Não", null);
                dialogo.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String filme = etFilme.getText().toString();
                        //add apenas pra teste, posteriormente será consumido api e realizar
                        //cadastro com o retorno da api
                        //também será alterado a forma de salvar os dados(salvando no dispositivo).
                        GetJson download = new GetJson();

                        download.execute();

                        //BancoController crud = new BancoController(act.getBaseContext());
                        //String msg = crud.insereDado(filme, null, null);

                        //act.getFilmes().add(new Filme(filme, null, null));

                       // act.ExibirMensagem(msg);
                        telaPrincipal.CarregaTela();
                    }
                });
                dialogo.show();
            }
        });

        btCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogo = new AlertDialog.Builder(act);
                dialogo.setTitle("Aviso");
                dialogo.setMessage("Sair do cadastro?");
                dialogo.setNegativeButton("Não", null);
                dialogo.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        telaPrincipal.CarregaTela();
                    }
                });
                dialogo.show();
            }
        });
    }

    private  class GetJson extends AsyncTask<Void, Void, Filme> {

        @Override
        protected Filme doInBackground(Void... voids) {
            Utils util = new Utils();
            String filme = etFilme.getText().toString();
            return util.getInformacao("http://www.omdbapi.com/?t="+filme+"&apikey="+chave);
        }

        @Override
        protected void onPostExecute(Filme filme){

            if (filme.getResposta().equalsIgnoreCase("True")) {
                BancoController crud = new BancoController(act.getBaseContext());

                String msg = crud.insereDado(filme);
                act.ExibirMensagem(msg);
            }else{
                act.ExibirMensagem(filme.getErro());
            }
        }
    }
}
