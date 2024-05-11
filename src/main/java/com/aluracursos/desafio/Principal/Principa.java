package com.aluracursos.desafio.Principal;

import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;

import com.aluracursos.desafio.Model.Datos;
import com.aluracursos.desafio.Model.DatosLibros;
import com.aluracursos.desafio.Service.ConsumoApi;
import com.aluracursos.desafio.Service.ConvierteDatos;

public class Principa {


    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConvierteDatos convierteDatos = new ConvierteDatos();
    private Scanner teclado = new Scanner (System.in);

    public void mostrarMenu(){
        var json = consumoApi.obtenerDatos(URL_BASE);
        //System.out.println(json);
        var datos = convierteDatos.obtenerDatos(json, Datos.class);
        System.out.println(datos);
        
        //Libros mas descargados
        System.out.println("\n Top 10 libros mas descargados \n");
        datos.resultados().stream()
            .sorted(Comparator.comparing(DatosLibros::numeroDeDescargas).reversed())
            .limit(10)
            .map(l -> l.titulo().toUpperCase())
            .forEach(System.out::println);


        //Buscar libro
        System.out.println("Escriba el libro que esta buscando");
        var tituloLibro = teclado.nextLine();
        var json2 = consumoApi.obtenerDatos(URL_BASE + "?search=" + tituloLibro.replace(" ", "+"));
        var datosBusquedad = convierteDatos.obtenerDatos(json2, Datos.class);
        Optional<DatosLibros> libroBuscado = datosBusquedad.resultados().stream()
            .filter(l -> l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
            .findFirst();

            if (libroBuscado.isPresent()) {

                System.out.println(" \n Libro Encontrado");
                System.out.println(libroBuscado.get());               
            }else{
                System.out.println("Libro no encontrado");
            }

    }
    
}
