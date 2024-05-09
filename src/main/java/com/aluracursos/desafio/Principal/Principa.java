package com.aluracursos.desafio.Principal;

import com.aluracursos.desafio.Model.Datos;
import com.aluracursos.desafio.Service.ConsumoApi;
import com.aluracursos.desafio.Service.ConvierteDatos;

public class Principa {


    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConvierteDatos convierteDatos = new ConvierteDatos();

    public void mostrarMenu(){
        var json = consumoApi.obtenerDatos(URL_BASE);
        //System.out.println(json);
        var datos = convierteDatos.obtenerDatos(json, Datos.class);
        System.out.println(datos);
    }
    
}
