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
        NTA.setIndice(0);
        NoTerminal NTB = new NoTerminal("<B>");
        NTB.setIndice(1);
        NoTerminal NTC = new NoTerminal("<C>");
        NTC.setIndice(2);
        NoTerminal NTD = new NoTerminal("<D>");
        NTD.setIndice(3);

        ArrayList<NoTerminal> noTerminales = new ArrayList<>();
        noTerminales.add(NTA);
        noTerminales.add(NTB);
        noTerminales.add(NTC);

        Terminal t1 = new Terminal("1");
        Terminal t2 = new Terminal("2");
        Terminal t3 = new Terminal("3");
        Terminal t4 = new Terminal("4");

        ArrayList<Simbolo> ladoDerecho0 = new ArrayList<>();
        ladoDerecho0.add(NTC);
        ladoDerecho0.add(NTA);

        ArrayList<Simbolo> ladoDerecho1 = new ArrayList<>();

        ArrayList<Simbolo> ladoDerecho2 = new ArrayList<>();
        ladoDerecho2.add(NTA);
        ladoDerecho2.add(NTB);

        ArrayList<Simbolo> ladoDerecho3 = new ArrayList<>();

        ArrayList<Simbolo> ladoDerecho4 = new ArrayList<>();
        ladoDerecho4.add(t1);

        ArrayList<Simbolo> ladoDerecho5 = new ArrayList<>();
        ladoDerecho5.add(t2);
        ladoDerecho5.add(NTB);

        Produccion p0 = new Produccion(NTA, ladoDerecho0, 0);
        Produccion p1 = new Produccion(NTA, ladoDerecho1, 1);
        p1.setAnulable(true);
        p1.setAsignado(true);
        NTA.setAnulable(true);
        NTA.setAsignado(true);
        Produccion p2 = new Produccion(NTB, ladoDerecho2, 2);
        Produccion p3 = new Produccion(NTB, ladoDerecho3, 3);
        p3.setAnulable(true);
        p3.setAsignado(true);
        NTB.setAnulable(true);
        NTB.setAsignado(true);
        Produccion p4 = new Produccion(NTC, ladoDerecho4, 4);
        Produccion p5 = new Produccion(NTD, ladoDerecho5, 5);

        ArrayList<Produccion> producciones = new ArrayList<>();
        producciones.add(p0);
        producciones.add(p1);
        producciones.add(p2);
        producciones.add(p3);
        producciones.add(p4);
        producciones.add(p5);

        Gramatica g = new Gramatica(noTerminales, producciones);

        int[] indexNTA = new int[2];
        indexNTA[0] = 0;
        indexNTA[1] = 1;

        int[] indexNTB = new int[2];
        indexNTB[0] = 2;
        indexNTB[1] = 3;

        int[] indexNTC = new int[1];
        indexNTC[0] = 4;

        int[] indexNTD = new int[1];
        indexNTD[0] = 5;

        ArrayList<int[]> aux = new ArrayList<>();
        aux.add(indexNTA);
        aux.add(indexNTB);
        aux.add(indexNTC);
        aux.add(indexNTD);

        g.setPrdNoTerminales(aux);
//        g.reconocerPA(p0);
//        g.reconocerPA(p1);
//        g.reconocerPA(p2);
//        g.reconocerPA(p3);
//        g.reconocerPA(p4);

        g.definirAnulables();

        System.out.println("probado");
    }

}
