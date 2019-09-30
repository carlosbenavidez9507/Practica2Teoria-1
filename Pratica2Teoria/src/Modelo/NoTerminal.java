/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Carlos Benavidez
 */
public class NoTerminal implements Simbolo {

    private String nombreNoTerminal;
    private boolean anulable;
    private Primeros conjuntoPrimeros;
    private ArrayList<Terminal> conjuntoSiguientes;
    private int indice;
    private boolean asignado;

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public boolean isAsignado() {
        return asignado;
    }

    public void setAsignado(boolean asignado) {
        this.asignado = asignado;
    }
    
    

    public NoTerminal() {
    }

    public NoTerminal(String nombreNoTerminal) {
        this.nombreNoTerminal = nombreNoTerminal;
        this.anulable=false;
        this.asignado=false;
    }
    
    

    public String getNombreNoTerminal() {
        return nombreNoTerminal;
    }

    public void setNombreNoTerminal(String nombreNoTerminal) {
        this.nombreNoTerminal = nombreNoTerminal;
    }
//
//    public boolean isEsSimoboloInicial() {
//        return esSimoboloInicial;
//    }
//
//    public void setEsSimoboloInicial(boolean esSimoboloInicial) {
//        this.esSimoboloInicial = esSimoboloInicial;
//    }

    @Override
    public String obtenerSimbolo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean esTerminal() {
        return false;
    }

    public boolean isAnulable() {
        return anulable;
    }

    public void setAnulable(boolean anulable) {
        this.anulable = anulable;
    }
    
    public void esAnulable(){
        
    }
    
    

}
