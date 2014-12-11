package com.example.dgranadeabreu.nombretelefono;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class ActividadBorrar extends Activity
{
    ArrayList<Agenda> arrayNombres;
    ListView lista;
    EditText texto;
    Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_borrar);

        texto=(EditText)findViewById(R.id.texto);
        boton=(Button)findViewById(R.id.botonVuelvo);

        final Agenda objetoAgenda;
        objetoAgenda=(Agenda)getIntent().getSerializableExtra("idNombre");
        texto.setText(objetoAgenda.getNombre().toString());
        boton.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                Intent in = new Intent(ActividadBorrar.this,PrimerActivity.class);
                setResult(RESULT_CANCELED,in);
                finish();
            }

        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_actividad_borrar, menu);
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
