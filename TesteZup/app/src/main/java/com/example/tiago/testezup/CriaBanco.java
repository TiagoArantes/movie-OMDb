package com.example.tiago.testezup;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.ImageFormat;

/**
 * Created by Tiago on 11/02/2018.
 */

public class CriaBanco extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "banco.db";
    static final String TABELA = "filmeseries";
    private static final String ID = "_id";
    static final String FILME = "filme";
    static final String ANO = "ano";
    static final String TEMPO = "tempo";
    static final String GENERO = "genero";
    static final String DIRETOR = "diretor";
    static final String ESCRITOR = "escritor";
    static final String ATORES = "atores";
    static final String DESCRICAO = "descricao";
    static final String LINGUAGEM = "linguagem";
    static final String PAIS = "pais";
    static final String PREMIOS = "premios";
    static final String URL = "urlImagem";
    static final String IMDB = "imdb";
    static final String TIPO = "tipo";
    //static final String POSTER = "poster";

    private static final int VERSAO = 1;

    public CriaBanco(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sql = "CREATE TABLE "+TABELA+"("+ID+" integer primary key autoincrement,"
                +FILME+" text,"
                +ANO+" text,"
                +TEMPO+" text,"
                +GENERO+" text,"
                +DIRETOR+" text,"
                +ESCRITOR+" text,"
                +ATORES+" text,"
                +DESCRICAO+" text,"
                +LINGUAGEM+" text,"
                +PAIS+" text,"
                +PREMIOS+" text,"
                +URL+" text,"
                +IMDB+" text,"
                +TIPO+" text)";
                //+POSTER+" BLOB)";

        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABELA);
    }
}
