package com.example.satiro.nometops;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.List;
import java.util.Map;

public class TelaNomes extends AppCompatActivity {
    private final String TAG = "usuario";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_nomes);
        Log.i(TAG, "teste1");


        BD_Usuario banco = new BD_Usuario(this);
        String[] nomes = { "nome" };
        Log.i(TAG, "teste2");
        int layout = android.R.layout.simple_list_item_1;
        int [] para = { android.R.id.text1};
        List< Map < String , Object >> lista_usuarios = banco.listarUsuario( banco );

        //ArrayAdapter adapter = new ArrayAdapter<String>( this , layout , nomes );
        SimpleAdapter adapter = new SimpleAdapter( this, lista_usuarios , layout , nomes , para );

        Log.i(TAG, "teste3");

        ListView lv =  (ListView) findViewById(R.id.lv);
        lv.setAdapter( adapter );
        Log.i(TAG, "teste4");

    }
}
