/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Carlos Benavidez
 */
public class Archivo {

    public String cargarGramatica(String ruta) throws FileNotFoundException, IOException {
        String cadena = "";

        try (FileReader fr = new FileReader(ruta)) {

            int valor = fr.read();
            while (valor != -1) {
                cadena = cadena + (char) valor;
                valor = fr.read();

            }

            return cadena;
        }
    }

    public Gramatica convertirCadenaGramatica(String cadena) {
        Gramatica gramatica = new Gramatica();

        String[] x = cadena.split("\n");

        ArrayList<String> listadoNoterminales = new ArrayList<>();
        ArrayList<String> listadoProducciones=new ArrayList<>();
        ArrayList<NoTerminal> listadoSimbolos = new ArrayList<>();
        ArrayList<Produccion> lp=new ArrayList<>();

        for (int i = 0; i < x.length; i++) {
           
            Produccion produccion=new Produccion();
            listadoProducciones.add(x[i]);
            String hilera[] = x[i].split(":");
            listadoNoterminales.add(hilera[0]);
            produccion.setLefSide(hilera[0]);
            produccion.setRightSide(hilera[1]);
            lp.add(produccion);
           

        }

        Set<String> hashSet = new HashSet<String>(listadoNoterminales);

        listadoNoterminales.clear();
        listadoNoterminales.addAll(hashSet);
        int i = 0;
        for (String s : listadoNoterminales) {

            NoTerminal simbolo = new NoTerminal();

            if (i == 0) {
                simbolo.setNombreNoTerminal(s);
                simbolo.setEsSimoboloInicial(true);
            } else {
                simbolo.setNombreNoTerminal(s);
                simbolo.setEsSimoboloInicial(false);
            }
            i++;

            listadoSimbolos.add(simbolo);
        }

        gramatica.agregarNoterminal(listadoSimbolos);
        gramatica.agregarProducciones(lp);

        return gramatica;
    }
    
    
    
}
