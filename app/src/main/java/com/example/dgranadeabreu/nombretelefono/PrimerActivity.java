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

import java.util.ArrayList;


public class PrimerActivity extends Activity {
    Button btnAñadir;
    Button btnEditar;
    Button btnListar;
    EditText textoNombre;
    EditText textoTelefono;
    EditText textoEditarNombre;

    Agenda objAgenda;

    ArrayList<Agenda> arrayNombres=new ArrayList<Agenda>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primer);

        btnAñadir=(Button)findViewById(R.id.idBotonAñadir);
        btnEditar=(Button)findViewById(R.id.idBotonEditar);
        btnListar=(Button)findViewById(R.id.idbotonListar);
        textoNombre=(EditText)findViewById(R.id.idNombre);
        textoTelefono=(EditText)findViewById(R.id.idTelefono);
        textoEditarNombre=(EditText)findViewById(R.id.idEditarNombre);
        //si nos devuelve datos la clase Segunda

        //llamar a la segunda clase
        final Intent intento=new Intent(PrimerActivity.this,SegundaActivity.class);
        final Intent intento2=new Intent(PrimerActivity.this,ActividadLista.class);

        //meter nombre y telefono en el array
        btnAñadir.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                objAgenda=new Agenda(textoNombre.getText().toString(),textoTelefono.getText().toString());
                arrayNombres.add(objAgenda);
                showToast("Añadido el usuario "+textoNombre.getText().toString());
            }
        });

        //comprobar si existe la persona a editar
        btnEditar.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                boolean bandera=false;

                    for(Agenda a:arrayNombres) //por cada posicion del arraynombres ,buscamos en cada objeto agenda
                    {

                            if (a.editar(textoEditarNombre.getText().toString().trim()))
                            {

                                showToast("La persona que busca existe");
                                //asi le pasas variables y llamas a la clase2
                                intento.putExtra("idNombre",a.getNombre().toString());
                                intento.putExtra("idTelefono",a.getTelefono().toString());
                                startActivityForResult(intento,1);
                                bandera=true;
                                //esto seria mandandolo con bundle
                               /* Bundle on=new Bundle();
                                on.putSerializable("dfad",nombreClase); //tiene que ser serializable la clase
                                intento.putExtras(on)
                                -------para recogerlo en la otra clase
                                Bundle objeto=getiNtent.getExtras()
                                */
                            }
                    }
                if (bandera==false)
                {
                    showToast("La persona que busca no existe");
                }
            }

        });
        btnListar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                intento2.putExtra("datos",arrayNombres);
                startActivityForResult(intento2,1);
            }
        });

    }
    //muestra una ventana de android
    public void showToast(String mensaje)
    {
        Context contexto=getApplicationContext();
        int duracion= Toast.LENGTH_SHORT;
        Toast tostada=Toast.makeText(contexto,mensaje,duracion);
        tostada.show();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_primer, menu);
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

    public void onActivityResult(int reqC,int resC,Intent data)
    {
        if (reqC==1)//reqc es el valor que le pasamos al starActivytyForresult
        {

        }
        if (resC==RESULT_OK)//es la constante que le pasamos
        {

        }
        /*para el editar antiguo
        String MiRespuesta=data.getExtras().getString("nombre");
        String MiRespuesta2=data.getExtras().getString("telefono");

        //para el segundo
        int contador=0;
        boolean bandera2=false;

        for(Agenda a:arrayNombres) //por cada posicion del arraynombres ,buscamos en cada objeto agenda
        {

                if (a.editar(textoEditarNombre.getText().toString().trim()))
                {
                    arrayNombres.set(contador,new Agenda(MiRespuesta,MiRespuesta2));
                    bandera2=true;
                    showToast("se ha modificado el usuario");
                }
                contador++;
        */
        Toast.makeText(this, "Entro aqui " , Toast.LENGTH_SHORT).show();
        objAgenda=(Agenda)data.getSerializableExtra("datosArray");
        //para el segundo
        int contador=0;
        boolean bandera2=false;

        for(Agenda a:arrayNombres) //por cada posicion del arraynombres ,buscamos en cada objeto agenda
        {

            if (a.editar(objAgenda.getNombre()))
            {
                arrayNombres.set(contador,new Agenda(objAgenda.getNombre(),objAgenda.getTelefono()));
                bandera2=true;
                showToast("se ha modificado el usuario");
            }
            contador++;
        }

    }
}
