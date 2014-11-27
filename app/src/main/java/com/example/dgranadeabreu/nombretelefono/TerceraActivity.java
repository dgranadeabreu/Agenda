package com.example.dgranadeabreu.nombretelefono;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class TerceraActivity extends Activity {
    EditText nombre2;
    EditText telefono2;
    Button botonListo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        nombre2=(EditText)findViewById(R.id.idNombre2);
        telefono2=(EditText)findViewById(R.id.idTelefono2);
        botonListo=(Button)findViewById(R.id.botonListo);
        //para el primer editar
        /*
        nombre2.setText(getIntent().getExtras().getString("idNombre"));
        telefono2.setText(getIntent().getExtras().getString("idTelefono"));
        */
        //para el segundo
        final Agenda objetoAgenda;
        objetoAgenda=(Agenda)getIntent().getSerializableExtra("datosArray");
        nombre2.setText(objetoAgenda.getNombre());
        telefono2.setText(objetoAgenda.getTelefono());

        botonListo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                /*
                i.putExtra("nombre", nombre2.getText().toString());
                i.putExtra("telefono", telefono2.getText().toString());
                setResult(RESULT_OK, i);
                */
                Intent i = new Intent(TerceraActivity.this,SegundaActivity.class);
                Agenda objetoAgenda2=new Agenda(nombre2.getText().toString(),telefono2.getText().toString());

                i.putExtra("datosDevueltos", objetoAgenda2);
                i.putExtra("antiguoNombre",objetoAgenda.getNombre());
                setResult(RESULT_OK,i);
                finish();

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_segunda, menu);
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


    public void showToast(String mensaje)
    {
        Context contexto=getApplicationContext();
        int duracion= Toast.LENGTH_SHORT;
        Toast tostada=Toast.makeText(contexto,mensaje,duracion);
        tostada.show();

    }

    }

