/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Gramatica;
import Modelo.NoTerminal;
import Modelo.Produccion;
import Modelo.Simbolo;
import Modelo.Terminal;
import java.util.ArrayList;

/**
 *
 * @author Jorge
 */
public class Pratica2Teoria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Prueba de esLineal y FormaEspecial
//        NoTerminal NTA = new NoTerminal("<A>");
//        NoTerminal NTB = new NoTerminal("<B>");
//        NoTerminal NTC = new NoTerminal("<C>");
//
//        ArrayList<NoTerminal> noTerminales = new ArrayList<>();
//        noTerminales.add(NTA);
//        noTerminales.add(NTB);
////        terminales.add(NTC);
//
//        Terminal t1 = new Terminal("1");
//        Terminal t2 = new Terminal("2");
//        Terminal t3 = new Terminal("3");
//
//        ArrayList<Simbolo> ladoDerecho = new ArrayList<>();
//        ladoDerecho.add(t1);
//        ladoDerecho.add(NTB);
//
//        ArrayList<Simbolo> ladoDerecho2 = new ArrayList<>();
//        ladoDerecho2.add(t2);
//        ladoDerecho2.add(t2);
//        ladoDerecho2.add(NTA);
//
//        Produccion p1 = new Produccion(NTA, ladoDerecho);
//        Produccion p2 = new Produccion(NTA, ladoDerecho2);
//
//        ArrayList<Produccion> producciones = new ArrayList<>();
//        producciones.add(p1);
//        producciones.add(p2);
//
//        Gramatica g = new Gramatica(noTerminales, producciones);
//        
//        //Simbolos lado derecho     
//        
//
//        System.out.println(g.esLinealPorDerecha());
//Prueba de es Gramatica LL1
        NoTerminal NTA = new NoTerminal("<A>");
        NoTerminal NTB = new NoTerminal("<B>");

        ArrayList<NoTerminal> noTerminales = new ArrayList<>();
        noTerminales.add(NTA);
        noTerminales.add(NTB);

        Terminal t1 = new Terminal("1");
        Terminal t2 = new Terminal("2");
        Terminal t3 = new Terminal("3");
        Terminal t4 = new Terminal("4");

        ArrayList<Simbolo> ladoDerecho = new ArrayList<>();
        ladoDerecho.add(t4);
        ladoDerecho.add(NTB);

        ArrayList<Simbolo> ladoDerecho3 = new ArrayList<>();
        ladoDerecho3.add(t3);
        ladoDerecho3.add(NTB);

        ArrayList<Simbolo> ladoDerecho2 = new ArrayList<>();
        ladoDerecho2.add(t4);
        ladoDerecho2.add(t2);
        ladoDerecho2.add(NTA);

        ArrayList<Terminal> s1 = new ArrayList<>();
        s1.add(t1);
        s1.add(t2);
        s1.add(null);

        ArrayList<Terminal> s2 = new ArrayList<>();
        s2.add(t3);
        s2.add(t4);
        s1.add(null);

        Produccion p1 = new Produccion(NTA, ladoDerecho);
        Produccion p2 = new Produccion(NTA, ladoDerecho2);
        Produccion p3 = new Produccion(NTB, ladoDerecho);
        Produccion p4 = new Produccion(NTB, ladoDerecho3);
        p1.setConjuntoSeleccion(s1);
        p2.setConjuntoSeleccion(s2);

//        Produccion p3 = new Produccion(NTB, ladoDerecho);
//        Produccion p4 = new Produccion(NTB, ladoDerecho2);
        ArrayList<Produccion> producciones = new ArrayList<>();
        producciones.add(p1);
        producciones.add(p2);
        producciones.add(p3);
        producciones.add(p4);

        Gramatica g = new Gramatica(noTerminales, producciones);

        int[] indexPT = new int[2];
        indexPT[0] = 0;
        indexPT[1] = 1;
     

        int[] indexPT2 = new int[2];
        indexPT2[0] = 2;
        indexPT2[1] = 3;

        ArrayList<int[]> aux = new ArrayList<>();
        aux.add(indexPT);
        aux.add(indexPT2);

        g.setPrdNoTerminales(aux);

//        System.out.println(g.esGramaticaLL1());
        System.out.println(g.esGramaticaS());

    }

}
