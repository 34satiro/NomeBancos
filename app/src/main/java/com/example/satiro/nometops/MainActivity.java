package com.example.satiro.nometops;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    Button cadastrar,nomes;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cadastrar = (Button) findViewById( R.id.btentrarCad );
        nomes = (Button) findViewById( R.id.btentrarListar );

            cadastrar.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent irTelaCadastro = new Intent( MainActivity.this , TelaCadastro.class );
                    startActivity( irTelaCadastro );
                }
            });


            nomes.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                  Intent irTelaNomes= new Intent( MainActivity.this , TelaNomes.class );
                    startActivity( irTelaNomes );
                }
            });




    }


}
