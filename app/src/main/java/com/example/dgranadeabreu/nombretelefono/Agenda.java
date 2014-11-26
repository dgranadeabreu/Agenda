package com.example.dgranadeabreu.nombretelefono;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by dgranadeabreu on 11/7/14.
 */
public class Agenda implements Serializable
{
    String nombre;
    String telefono;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Agenda(String nombre,String telefono)
    {
        this.nombre=nombre;
        this.telefono=telefono;

    }
    public boolean editar(String nombrePasado)
    {
       if(nombrePasado.toString().equalsIgnoreCase(nombre))
          return true;
       else
          return false;
    }
    public void cambiarUsuario(String nombre,String telefono)
    {
        this.nombre=nombre;
        this.telefono=telefono;
    }

    @Override
    public String toString() {
        return nombre+" : "+telefono;
    }
}
