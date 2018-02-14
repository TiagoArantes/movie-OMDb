package com.example.tiago.testezup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tiago on 12/02/2018.
 */

public class BancoController {

    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context context){
        banco = new CriaBanco(context);
    }

    public String insereDado(Filme filme){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.FILME, filme.getFilme());
        valores.put(CriaBanco.ANO, filme.getAno());
        valores.put(CriaBanco.TEMPO, filme.getTempo());
        valores.put(CriaBanco.GENERO, filme.getGenero());
        valores.put(CriaBanco.DIRETOR, filme.getDiretor());
        valores.put(CriaBanco.ESCRITOR, filme.getEscritor());
        valores.put(CriaBanco.ATORES, filme.getAtores());
        valores.put(CriaBanco.DESCRICAO, filme.getDescricao());
        valores.put(CriaBanco.LINGUAGEM, filme.getLinguagem());
        valores.put(CriaBanco.PAIS, filme.getPais());
        valores.put(CriaBanco.PREMIOS, filme.getPremios());
        valores.put(CriaBanco.URL, filme.getUrlImagem());
        valores.put(CriaBanco.IMDB, filme.getImdb());
        valores.put(CriaBanco.TIPO, filme.getTipo());


        resultado = db.insert(CriaBanco.TABELA, null, valores);
        db.close();
        if (resultado ==-1){
            return "Erro ao cadastrar filme";
        }
        else{
            return "Filme cadastrado com sucesso";
        }
    }

    public ArrayList<Filme> carregaDados(){
        Cursor cursor;
        ArrayList<Filme> list = new ArrayList<>();
        String[] campos = {banco.FILME, banco.ANO,
                banco.TEMPO, banco.GENERO,
                banco.DIRETOR, banco.ESCRITOR, banco.ATORES,
                banco.DESCRICAO,
                banco.LINGUAGEM, banco.PAIS, banco.PREMIOS, banco.URL,
                banco.IMDB, banco.TIPO};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA, campos, null, null, null, null, "filme ASC", null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                Filme filme = new Filme();
                filme.setFilme(cursor.getString(0));
                filme.setAno(cursor.getString(1));
                filme.setTempo(cursor.getString(2));
                filme.setGenero(cursor.getString(3));
                filme.setDiretor(cursor.getString(4));
                filme.setEscritor(cursor.getString(5));
                filme.setAtores(cursor.getString(6));
                filme.setDescricao(cursor.getString(7));
                filme.setLinguagem(cursor.getString(8));
                filme.setPais(cursor.getString(9));
                filme.setPremios(cursor.getString(10));
                filme.setUrlImagem(cursor.getString(11));
                filme.setImdb(cursor.getString(12));
                filme.setTipo(cursor.getString(13));
                list.add(filme);
            }while (cursor.moveToNext());
        }

        return (list);
    }
}
