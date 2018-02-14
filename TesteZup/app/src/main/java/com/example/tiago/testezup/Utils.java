package com.example.tiago.testezup;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Tiago on 13/02/2018.
 */

public class Utils {

    public Filme getInformacao(String end){
        String json;
        Filme retorno;
        json = NetworkUtils.getJSONFromAPI(end);
        Log.i("Resultado", json);
        retorno = parseJson(json);

        return retorno;
    }

    private Filme parseJson(String json){
        try {
            Filme filme = new Filme();

            JSONObject jsonObject = new JSONObject(json);

            String response = jsonObject.getString("Response");

            if (response.equalsIgnoreCase("False")){
                filme.setResposta(response);
                filme.setErro(jsonObject.getString("Error"));
                return filme;
            }else{
                filme.setFilme(jsonObject.getString("Title"));
                filme.setAno(jsonObject.getString("Released"));
                filme.setTempo(jsonObject.getString("Runtime"));
                filme.setGenero(jsonObject.getString("Genre"));
                filme.setDiretor(jsonObject.getString("Director"));
                filme.setEscritor(jsonObject.getString("Writer"));
                filme.setAtores(jsonObject.getString("Actors"));
                filme.setDescricao(jsonObject.getString("Plot"));
                filme.setLinguagem(jsonObject.getString("Language"));
                filme.setPais(jsonObject.getString("Country"));
                filme.setPremios(jsonObject.getString("Awards"));
                filme.setUrlImagem(jsonObject.getString("Poster"));
                filme.setImdb(jsonObject.getString("imdbRating"));
                filme.setTipo(jsonObject.getString("Type"));
                filme.setResposta(response);

                filme.setPoster(baixarImagem(filme.getUrlImagem()));
                return filme;
            }

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
    private Bitmap baixarImagem(String url){
        try {
            URL end = new URL(url);
            InputStream is = end.openStream();
            Bitmap imagem = BitmapFactory.decodeStream(is);
            is.close();
            return  imagem;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
