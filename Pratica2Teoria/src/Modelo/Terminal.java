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

    public Terminal() {
    }

    public Terminal(String nombreTermila) {
        this.nombreTermila = nombreTermila;
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
    
    
    
}
