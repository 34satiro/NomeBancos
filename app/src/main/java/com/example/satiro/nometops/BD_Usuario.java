package com.example.satiro.nometops;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BD_Usuario extends SQLiteOpenHelper
{

    private static final String BANCO_DADOS = "usuario";
    private static final int VERSAO = 1;
    private static final String TAG = "usuario";

    public BD_Usuario(Context context)
    {
        super(context, BANCO_DADOS, null, VERSAO);
        Log.i(TAG, "Criando BD_Usuario");
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        Log.i(TAG, "Criando tabela(s) do Banco de Dados");

        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS usuario(_id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR(50))");
            Log.i(TAG, "Tabela criada com sucesso");
        }catch (SQLException e){
            Log.e(TAG, "Falha durante a criação das tabelas: "+e);
        }

    }

    @Override
    public  void onUpgrade(SQLiteDatabase db, int versao_antiga, int versao_nova)
    {

    }



    public boolean salvarUsuario( String nome_usuario , BD_Usuario usuario )
    {

        Log.i(TAG, "usuario.getWritableDatabase()");
        SQLiteDatabase banco = usuario.getWritableDatabase();


        ContentValues valores = new ContentValues();
        valores.put("nome",nome_usuario);


        try
        {
            long resultado = banco.insert("usuario", null, valores);


            if (resultado<0){
                Log.i(TAG, "Ocorreu um erro durante a inserção dos dados!");
                return false;
            }else{
                Log.i(TAG, "Dados inseridos com sucesso no banco de dados!");
                return  true;
            }
        }
        catch (SQLException e)
        {
            Log.e(TAG, e.toString());
            return false;
        }
    }

    public List<Map< String , Object >> listarUsuario(BD_Usuario usuario)
    {
        Cursor cursor = null;
        try
        {
         Log.i( TAG , "Preparando o acesso!" );
            SQLiteDatabase banco = usuario.getReadableDatabase();
            cursor = banco.rawQuery( "SELECT _id, nome FROM usuario" , null );
        }
          catch ( Exception e )
          {
              Log.e( TAG , "Erro ao consultar o BD:" + e );
          }

        cursor.moveToFirst();

        ArrayList< Map < String , Object > > lista_usuario = new ArrayList< Map <String, Object> >();

                for( int i = 0; i < cursor.getCount(); i++ )
                {
                    Map < String , Object > item = new HashMap < String , Object >();

                    String nome = cursor.getString(1);

                    item.put( "nome" , nome );

                    lista_usuario.add( item );
                    cursor.moveToNext();
                }

        cursor.close();
    return lista_usuario;
    }

}
