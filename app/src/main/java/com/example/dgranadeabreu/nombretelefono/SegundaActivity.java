package com.example.dgranadeabreu.nombretelefono;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class SegundaActivity extends ListActivity{
    ArrayList<Agenda> arrayNombres;
    ListView lista;
    Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_lista);
        boton=(Button)findViewById(R.id.botonVolverOpciones);
        boton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final Intent intento=new Intent(SegundaActivity.this,PrimerActivity.class);
                setResult(RESULT_CANCELED);
                finish();
            }
        });
        //lista=(ListView)findViewById(R.id.android_list);
        arrayNombres= (ArrayList<Agenda>) getIntent().getSerializableExtra("datos");
        setListAdapter(new ArrayAdapter<Agenda>(this, android.R.layout.simple_list_item_1, arrayNombres));

    }

    public void onListItemClick(ListView parent,View v,int position,long id)
    {
        final Intent intento=new Intent(SegundaActivity.this,TerceraActivity.class);
        Toast.makeText(this, "Ha elegido --> " + arrayNombres.get(position).toString(), Toast.LENGTH_SHORT).show();
        intento.putExtra("datosArray",arrayNombres.get(position));
        startActivityForResult(intento, 1);
    }
    public void onActivityResult(int reqC,int resC,Intent data)
    {
        //aqui entrara cuando le de al boton Listo de la tercera pantalla
        Toast.makeText(this, "valores --> " + data.getSerializableExtra("datosDevueltos"), Toast.LENGTH_SHORT).show();
        Agenda objAgenda=(Agenda)data.getSerializableExtra("datosDevueltos");
        String antiguoNombre=data.getStringExtra("antiguoNombre");

        Intent intento2=new Intent(SegundaActivity.this,PrimerActivity.class);

        intento2.putExtra("datosDevueltos",objAgenda);
        intento2.putExtra("antiguoNombre",antiguoNombre);
        setResult(RESULT_OK,intento2);
        finish();
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
