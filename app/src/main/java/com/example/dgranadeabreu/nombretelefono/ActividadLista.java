package com.example.dgranadeabreu.nombretelefono;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class ActividadLista extends ListActivity{
    ArrayList<Agenda> arrayNombres;
    ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_lista);

        //lista=(ListView)findViewById(R.id.android_list);
        arrayNombres= (ArrayList<Agenda>) getIntent().getSerializableExtra("datos");

        setListAdapter(new ArrayAdapter<Agenda>(this, android.R.layout.simple_list_item_1, arrayNombres));

    }

    public void onListItemClick(ListView parent,View v,int position,long id)
    {
        final Intent intento=new Intent(ActividadLista.this,SegundaActivity.class);
        Toast.makeText(this, "Ha elegido --> " + arrayNombres.get(position).toString(), Toast.LENGTH_SHORT).show();
        intento.putExtra("datosArray",arrayNombres.get(position));
        startActivity(intento);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_actividad_lista, menu);
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
