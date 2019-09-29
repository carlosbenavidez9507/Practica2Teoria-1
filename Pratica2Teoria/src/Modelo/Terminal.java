/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Carlos Benavidez
 */
public class Terminal implements Simbolo{
    
    private String nombreTermila;
    private boolean anulable; 
    private boolean actualizado;
    
    

    public Terminal() {
        this.actualizado=false;
    }

    public Terminal(String nombreTermila) {
        this.nombreTermila = nombreTermila;
        this.actualizado=false;
    }
    
    

    public String getNombreTermila() {
        return nombreTermila;
    }

    public void setNombreTermila(String nombreTermila) {
        this.nombreTermila = nombreTermila;
    }

    @Override
    public String obtenerSimbolo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean esTerminal() {
        return true;
    }

    public boolean isAnulable() {
        return anulable;
    }

    public void setAnulable(boolean anulable) {
        this.anulable = anulable;
    }
    
    
    
    
    
}
