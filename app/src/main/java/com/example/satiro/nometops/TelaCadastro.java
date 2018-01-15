package com.example.satiro.nometops;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaCadastro extends AppCompatActivity
{

    private final String TAG = "usuario";
    EditText edUsuario;
    Button btCadastro;
    BD_Usuario banco;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Log.i(TAG, "Carregando GUI do Cadastro");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

            Log.i( TAG, "Carregando componentes da GUI" );
            edUsuario = ( EditText ) findViewById( R.id.edUsuario );
            btCadastro = ( Button ) findViewById( R.id.btCadastrar );

            banco = new BD_Usuario( this );

                btCadastro.setOnClickListener(new View.OnClickListener()
                {

                    @Override
                    public void onClick(View v)
                    {
                        Log.i(TAG, "Coletando dados informados pelo usuário");
                        String usuario = edUsuario.getText().toString();

                            if (usuario.equals(""))
                            {
                                Toast.makeText(TelaCadastro.this,"Prencha o campo com seu nome",Toast.LENGTH_SHORT).show();
                            }else
                                {
                                    banco.salvarUsuario(usuario,banco);
                                    Toast.makeText(TelaCadastro.this,"Nome cadastrado com sucesso",Toast.LENGTH_SHORT).show();
                                    edUsuario.setText("");

                                }
                    }
                });
    }

    public void listarUsuario ( View v )
    {
        Intent listaUsu = new Intent( TelaCadastro.this , TelaNomes.class );
        startActivity( listaUsu );
    }


}
