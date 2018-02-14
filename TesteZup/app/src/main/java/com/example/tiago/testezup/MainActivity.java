package com.example.tiago.testezup;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.*;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Filme> filmes;
    TelaPrincipal telaPrincipal;
    TelaCadastro telaCadastro;
    TelaListaFilmes telaListaFilmes;

    //EditText idFilme;
    //Button idCadastrar, idCadastro;
    //Button idAcessarLista, idVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        filmes = new ArrayList<>();
        telaPrincipal = new TelaPrincipal(this);
        telaCadastro = new TelaCadastro(this, telaPrincipal);
        telaListaFilmes = new TelaListaFilmes(this, telaPrincipal);
        telaPrincipal.setTelaCadastro(telaCadastro);
        telaPrincipal.setTelaListaFilmes(telaListaFilmes);

        telaPrincipal.CarregaTela();
        //CarregarTelaPrincipal();
    }

    public void preencheFilmes(ArrayList<Filme> fs){
        this.filmes = fs;
    }

    public ArrayList<Filme> getFilmes(){
        return filmes;
    }

    public void ExibirMensagem(String msg){
        AlertDialog.Builder d = new AlertDialog.Builder(MainActivity.this);
        d.setTitle("Aviso");
        d.setMessage(msg);
        d.setNeutralButton("OK", null);
        d.show();
    }

//    public void CarregarTelaPrincipal(){
//        setContentView(R.layout.activity_main);
//
//        //idFilme = (EditText) findViewById(R.id.textTelaCadastro);
//        idCadastrar = (Button) findViewById(R.id.idCadastro);
//        idAcessarLista = (Button) findViewById(R.id.idAcessarLista);
//
//        idCadastrar.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public  void onClick(View v){
//
//                CarregarTelaCadastro();
//            }
//        });
//
//        idAcessarLista.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v){
//                String filme = idFilme.getText().toString();
//
//                CarregarTelaApresentarLista();
//            }
//        });
//    }
//
//    public void CarregarTelaCadastro(){
//        setContentView(R.layout.tela_cadastro);
//
//        idFilme = (EditText) findViewById(R.id.idFilme);
//        idCadastro = (Button) findViewById(R.id.idCadastro);
//
//        idCadastro.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                String filme = idFilme.getText().toString();
//                //verificar se o filme já está salvo no dispositivo, se não tiver, consumir a API OMDb
//                //e apresentar resultado
//            }
//        });
//    }
//
//    public void CarregarTelaApresentarLista(){
//        setContentView(R.layout.apresentar_lista);
//        idVoltar = (Button) findViewById(R.id.idFechar);
//
//        //apresentar a lista de filmes salvos
//
//        idVoltar.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                CarregarTelaPrincipal();
//            }
//        });
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
