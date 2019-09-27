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
public class Gramatica {

    private ArrayList<NoTerminal> noTerminales;
    private ArrayList<int[]> prdNoTerminales; // Indice de produccionesn por cada no terminal
    private ArrayList<Terminal> terminales;
    private ArrayList<Produccion> producciones;
    private ArrayList<NoTerminal> noTerminalesAnulables;
    private ArrayList<Integer> produccionesAnulables;

    public void agregarNoterminal(ArrayList<NoTerminal> noTerminales) {
        this.noTerminales = noTerminales;
    }

    public void agregarProducciones(ArrayList<Produccion> producciones) {
        this.producciones = producciones;
    }
//    public void imprimirNoTerminales()
//    {
//          for (NoTerminal s : this.noTerminales)
//          {
//              System.out.println("No Terminal:"+s.getNombreNoTerminal()+" es simobolo Inicial"+s.isEsSimoboloInicial());
//          }
//    }

//    public void imprimirProducciones()
//    {   int i=0;
//        for(Produccion p: this.producciones)
//        {
//            System.out.println("Produccion #"+i+p.getLefSide()+"="+p.getRightSide());
//            i++;
//        }
//    }
    public ArrayList<Object> cacularTerminalesAnulables() {
        return null;
    }

    public ArrayList<Integer> calcularProduccionesAnulables() {
        return null;
    }

    public ArrayList<Terminal> calcularPrimerosTerminal(NoTerminal noTerminal) {
        return null;
    }

    public ArrayList<Terminal> calcularPrimerosProduccion(Produccion produccion) {
        return null;
    }

    public ArrayList<Object> calcularSiguienteTerminal(NoTerminal notoTerminal) {
        return null;
    }

    public ArrayList<Object> calcularSeleccionProduccion(Produccion produccion) {
        return null;
    }

    //************************************
    boolean esFormaEspecial() {
        int n = this.producciones.size();
        for (int i = 0; i < n; i++) {
            Produccion p = this.producciones.get(i);
            if (p.getLadoDerecho().size() == 2) {
                if (!p.getIndex(0).esTerminal() || p.getIndex(1).esTerminal()) {
                    return false;
                }
            } else if (p.getLadoDerecho().size() > 2 || p.getLadoDerecho().size() == 1) {
                return false;
            }
        }
        return true;
    }

    boolean esLinealPorDerecha() {
        int n = this.producciones.size();
        for (int i = 0; i < n; i++) {
            Produccion p = this.producciones.get(i);
            int m = p.getLadoDerecho().size();
            int j = 0;
            while (j < m - 1) {
                if (p.getLadoDerecho().size() > 0) {//Pregunta si no es nulo
                    if (!p.getLadoDerecho().get(j).esTerminal()) {//Si los primreos m-1 simbolos no son temrinales retorne false
                        return false;
                    }
                }
                j++;
            }

            if (p.getLadoDerecho().get(j).esTerminal()) { //Si el ultimo simbolo es terminal retorne false
                return false;
            }
        }
        return true;
    }

    boolean esGramaticaSQ() { //Si pregunta por tipo S envie true, para tipo Q false;
        //Determinar 
        int n = this.noTerminales.size();
        for (int j = 0; j < n; j++) {
            int[] producciones = this.prdNoTerminales.get(j);//producciones por el No terminal j
            int k = producciones.length; //Cantidad de producciones
            int m = 0;
            int iP = producciones[0];//Indice del primera produccion en la lita
            Produccion produccion = this.producciones.get(iP);
            while (m < k) {
                iP = producciones[k];//Indice de la produccion k en la lista 
                produccion = this.producciones.get(iP);
                

                k++;
            }

        }

        return true;
    }

}
