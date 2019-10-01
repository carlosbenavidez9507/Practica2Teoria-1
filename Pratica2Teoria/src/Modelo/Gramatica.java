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

    public Gramatica(ArrayList<NoTerminal> noTerminales, ArrayList<Produccion> producciones) {
        this.noTerminales = noTerminales;
        this.producciones = producciones;
    }

    public ArrayList<Terminal> getConjuntoSeleccion(int i) { //Obtener conjunto de seleccion de la produccion i 
        ArrayList<Terminal> conjuntoSeleccion;
        conjuntoSeleccion = this.producciones.get(i).getConjuntoPrimerosProduccion(); //Obtener conjunto seleccion de la produccion "indiceProuccion"
        return conjuntoSeleccion;
    }

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

    public ArrayList<NoTerminal> getNoTerminales() {
        return noTerminales;
    }

    public void setNoTerminales(ArrayList<NoTerminal> noTerminales) {
        this.noTerminales = noTerminales;
    }

    public ArrayList<int[]> getPrdNoTerminales() {
        return prdNoTerminales;
    }

    public void setPrdNoTerminales(ArrayList<int[]> prdNoTerminales) {
        this.prdNoTerminales = prdNoTerminales;
    }

    public ArrayList<Terminal> getTerminales() {
        return terminales;
    }

    public void setTerminales(ArrayList<Terminal> terminales) {
        this.terminales = terminales;
    }

    public ArrayList<Produccion> getProducciones() {
        return producciones;
    }

    public void setProducciones(ArrayList<Produccion> producciones) {
        this.producciones = producciones;
    }

    public ArrayList<NoTerminal> getNoTerminalesAnulables() {
        return noTerminalesAnulables;
    }

    public void setNoTerminalesAnulables(ArrayList<NoTerminal> noTerminalesAnulables) {
        this.noTerminalesAnulables = noTerminalesAnulables;
    }

    public ArrayList<Integer> getProduccionesAnulables() {
        return produccionesAnulables;
    }

    public void setProduccionesAnulables(ArrayList<Integer> produccionesAnulables) {
        this.produccionesAnulables = produccionesAnulables;
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
    public boolean esFormaEspecial() {
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

    //compara conjunto de selección de la producion i, con los demas conjunto de selección de ese Terminal  
    //El indice de esos conjunto de selección así como el de i se encuentra en indexProducciones
    private boolean sonDisyuntosConjuntosSeleccion(int[] indexProducciones) {
        int i = 0;
        int n = indexProducciones.length;
        ArrayList<Terminal> conjuntoSeleccioni;
        boolean comparacion;
        while (i < n) {
            int iProduccion = indexProducciones[i];
            //Ahora hay que comparar cada conjunto de selección
            conjuntoSeleccioni = this.getConjuntoSeleccion(iProduccion);
            int k = 0;
            int aux;
            ArrayList<Terminal> conjuntoK;
            while (k < indexProducciones.length) {
                aux = indexProducciones[k];
                conjuntoK = this.getConjuntoSeleccion(aux);
                if (k != i) {//Solo compara con los conjuntos de seleccion diferentes a el 
                    comparacion = this.tieneTerminalIgual(conjuntoK, conjuntoSeleccioni);
                    if (comparacion) {
                        return false;
                    }
                }
                k++;
            }
            i++;
        }
        return true;
    }

    private boolean tieneTerminalIgual(ArrayList<Terminal> a, ArrayList<Terminal> b) {
        int i = 0;
        int k = 0;
        int n = a.size();
        int m = b.size();
        String terminalA;
        String terminalB;
        while (i < n) {
            if (a.get(i) != null) {//Si el simbolo terminal a comparar no es el vacio 
                terminalA = a.get(i).getNombreTermila();
                k = 0;
                while (k < m) {
                    if (b.get(k) != null) {//Si el simbolo terminal a comparar no es el vacio 
                        terminalB = b.get(k).getNombreTermila();
                        if (terminalA.compareTo(terminalB) == 0) {
                            return true;
                        }
                    }
                    k++;
                }
            }
            i++;
        }
        return false;
    }

    public boolean esLinealPorDerecha() {
        int n = this.producciones.size();
        for (int i = 0; i < n; i++) {
            Produccion p = this.producciones.get(i);
            int m = p.getLadoDerecho().size();
            int j = 0;
            while (j < m - 1) {//Pregunta hasta el penultimo elemento
                if (p.getLadoDerecho().size() > 0) {//Pregunta si no es nulo
                    if (!p.getLadoDerecho().get(j).esTerminal()) {//Si los primreos m-1 simbolos no son temrinales retorne false
                        return false;
                    }
                }
                j++;
            }
            if (m != 0) {
                if (p.getLadoDerecho().get(j).esTerminal()) { //Si el ultimo simbolo es terminal retorne false
                    return false;
                }
            }
        }
        return true;
    }

    public boolean esGramaticaLL1() {
        int n = this.noTerminales.size();
        boolean sonDisyuntos;
        for (int j = 0; j < n; j++) {//recorrer el Array de NoTerminales que en cada posición contiene las producciones de esa terminal
            int[] produccionesTerminalJ = this.prdNoTerminales.get(j);//producciones por el No terminal j
            sonDisyuntos = this.sonDisyuntosConjuntosSeleccion(produccionesTerminalJ);
            if (!sonDisyuntos) {
                return false;
            }
        }
        return true;
    }

    public boolean esGramaticaS(boolean S) {//Si pregunta por S el valor de entrada es true
        int n = this.noTerminales.size();
        boolean sonIguales;
        boolean hayProduccionNula = false;
        Simbolo aux;
        for (int j = 0; j < n; j++) {//recorrer el Array de NoTerminales que en cada posición contiene las producciones de esa terminal
            int[] produccionesTerminalJ = this.prdNoTerminales.get(j);//producciones por el No terminal j
            int m = produccionesTerminalJ.length;
            int i = 0;
            while (i < m) {
                ArrayList<Simbolo> auxp = this.producciones.get(produccionesTerminalJ[i]).getLadoDerecho();
                if (S && auxp.isEmpty()) {//Que aux sea vacio significa que hay una produccion nula
                    return false;
                } else if (!auxp.isEmpty()) {
                    aux = auxp.get(0);//obtiene el primer simbolo de la produccion i que se encuentra en producciones por no terminal j
                    if (!aux.esTerminal()) {
                        return false;
                    }
                    int k = 0;
                    Simbolo y;
                    while (k < m) {
                        if (k != i) {
                            ArrayList<Simbolo> auxy = this.producciones.get(produccionesTerminalJ[k]).getLadoDerecho();
                            if (S && auxy.isEmpty()) {
                                return false;
                            } else if (!auxy.isEmpty()) {
                                y = auxy.get(0);
                                if (!y.esTerminal()) {
                                    return false;
                                }
                                //Machetazo para comparar dos terminales con el metodo existente
                                ArrayList<Terminal> auxT1 = new ArrayList<>();
                                ArrayList<Terminal> auxT2 = new ArrayList<>();
                                auxT1.add((Terminal) aux);
                                auxT2.add((Terminal) y);
                                sonIguales = this.tieneTerminalIgual(auxT1, auxT2);
                                if (sonIguales) {
                                    return false;
                                }
                            } else if (!S && auxp.isEmpty()) {
                                hayProduccionNula = true;
                            }
                        }
                        k++;
                    }
                } else if (!S && auxp.isEmpty()) {
                    hayProduccionNula = true;
                }
                i++;
            }
        }
        if (hayProduccionNula && !S) {//Si hay produccion nula y se pregunta por Q
            return true;
        } else if (!hayProduccionNula && !S) {//Si no hay produccion nula y se pregunta por Q
            return false;
        }
        return true;
    }

    public void actualizarEstado() {
        int n = this.producciones.size();
        Produccion x;
        for (int i = 0; i < n; i++) {
            x = this.producciones.get(i);
            x.actualizarEstadoAnulable();
        }

    }

    public void reconocerPA(Produccion p) {//Reconocer terminales anulables para una Producción a la que no se le ha definido su estado
        ArrayList<Simbolo> s = p.getLadoDerecho();
        NoTerminal Nt;
        boolean x = false;
        int i = 0;
        for (Simbolo item : s) {
            i++;
            if (item.esTerminal()) {//Si el examinado es un terminal
                p.setAnulable(false);//No es anulable
                p.setAsignado(true);//Ya se asigno su estado
                break; //Despues de que encuentre el primer no anulable 

            } else {//Si es un NoTerminal
                Nt = (NoTerminal) item;
                if (Nt.isAsignado()) { //Si a ese Notemrinal ya ha sido asignado su estado de anulable
                    if (!Nt.isAnulable()) {//No es anualbe
                        p.setAnulable(false);//Es anulable
                        p.setAsignado(true);//Ya se asigno su estado
                        break;
                    } else {//Si es anulable
                        //LLAMAR METODO QUE RECORRE TODAS LA PRODUCCIONES DE ESE NOTERMINAL(lado derecho)
//                        this.reconocerNoTA(Nt);
                        if (i == s.size()) { //Si llega al punto de que el ultimo es anulable estonces la producciones es anulable
                            x = true;
                        }
                    }
                } else {
                    this.reconocerNoTA(Nt); //Ya la asigno VUELVA A PREGUNTAR
                    if (!Nt.isAnulable()) {//No es anualbe
                        p.setAnulable(false);//Es anulable
                        p.setAsignado(true);//Ya se asigno su estado
                        break;
                    } else {//Si no  ha sido asignaod
                        //LLAMAR METODO QUE RECORRE TODAS LA PRODUCCIONES DE ESE NOTERMINAL(lado derecho)
                        this.reconocerNoTA(Nt);
                    }//                    if(!Nt.isAnulable()){
                }

            }
        }
        if (x) {
            p.setAnulable(true);
            p.setAsignado(true);
        }

    }

    private void reconocerNoTA(NoTerminal Nt) { //Reconocer no terminal anulable
        int indice = Nt.getIndice(); //Tengo la posición del vector de indices de producciones en el Array de terminales
        int[] posiciones = this.prdNoTerminales.get(indice); // vector con indice de sus producciones
        //Recorrer cada produccion
        int n = posiciones.length; //cantidad de producciones asociadas
        int k; //posicion real de la produccion en la gramatica
        Produccion p; //Produccion k;
        for (int i = 0; i < n; i++) {
            k = posiciones[i]; //Obtengo la posicion produccion k
            p = this.producciones.get(k);
            if (p.isAsignado()) {//Si ya se le ha asignado su estado
                if (p.isAnulable()) {//Si ese estado es anulable
                    p.getLadoIzquierdo().setAnulable(true);
                    p.getLadoIzquierdo().setAsignado(true);
                }
            } else {//No se le ha asignado su estado a esta produccion
                //Asingar estado
                this.reconocerPA(p);//Se asigna su estado
                //volver a preguntar
                if (p.isAnulable()) {//Si ese estado de p es anulable su lado izquierdo tambien
                    p.getLadoIzquierdo().setAnulable(true);
                    p.getLadoIzquierdo().setAsignado(true);
                }
            }
        }
        //Cuando termine el metodo ya habrá actualizado los estados
        Nt.setAsignado(true);

    }

    public void definirAnulables() {
        ArrayList<Produccion> ps = this.producciones;
        for (Produccion p : ps) {
            this.reconocerPA(p);
        }
    }

    public void calcularPrimeros(NoTerminal nt) {
        int x = nt.getIndice(); //ubicación de sus producciones en el Array de producciones por NoTerminal
        int[] indices = this.prdNoTerminales.get(x); //Indices de sus producciones
        int k = 0;
        int ip;
        Produccion p;
        Terminal t;
        NoTerminal auxnt;
        while (k < indices.length) {
            ip = indices[k];//Indice de la produccion en k
            p = this.producciones.get(ip);
            for (Simbolo s : p.getLadoDerecho()) {
                if (s != nt) {
                    if (s.esTerminal()) {//Si es terminal agreguelo y termine
                        t = (Terminal) s;
                        nt.getPrimeros().add(t);
                        nt.setPrimerosEncontrados(true);
                        break;
                    } else {//Si es NoTerminal
                        auxnt = (NoTerminal) s;
                        if (auxnt.isAnulable()) {
                            if (auxnt.isPrimerosEncontrados()) {
                                nt.getPrimeros().addAll(auxnt.getPrimeros());
                            } else {
                                this.calcularPrimeros(auxnt);
                                auxnt.setPrimerosEncontrados(true);
                                nt.getPrimeros().addAll(auxnt.getPrimeros());
                            }
                        } else {//No es anulable
                            if (auxnt.isPrimerosEncontrados()) { //Si los tiene agreguelos
                                nt.getPrimeros().addAll(auxnt.getPrimeros());
                            } else {//Si nos los tiene calculelos y agreguelos
                                this.calcularPrimeros(auxnt);
                                auxnt.setPrimerosEncontrados(true);
                                nt.getPrimeros().addAll(auxnt.getPrimeros());
                            }
                            break;

                        }
                    }
                }
            }
            k++;
        }
    }

    public void calcularPrimeros() {
        ArrayList<NoTerminal> nts = this.noTerminales;
        for (NoTerminal nt : nts) {
            this.calcularPrimeros(nt);
        }
    }

    public void calcularPrimerosProduccion() {
        ArrayList<Simbolo> ladoDerecho;
        Terminal t;
        NoTerminal nt;
        for (Produccion p : this.producciones) {
            ladoDerecho = p.getLadoDerecho();
            for (Simbolo s : ladoDerecho) {
                if (s.esTerminal()) {//Si es terminal agreguelo de inmediato y termine
                    t = (Terminal) s;
                    p.getConjuntoPrimerosProduccion().add(t);
                    break;
                } else { //Si es NoTerminal
                    nt = (NoTerminal) s;
                    p.getConjuntoPrimerosProduccion().addAll(nt.getPrimeros());
                    if (!nt.isAnulable()) {//Si no es anulable añadir todos los primeros de nt y terminar
                        break;
                    }
                    //Si es anulable solo añadir

                }

            }
        }
    }

//    public void calcularSiguientes(){
//        ArrayList<Produccion> ps = this.producciones;
//        ArrayList<Simbolo> ladoDerecho;
//        ArrayList<Terminal> ts;
//        Terminal t;
//        int i;
//        for(Produccion p: ps){
//            ladoDerecho = p.getLadoDerecho();
//            i=0;
//            while(i<ladoDerecho.size()){
//                t= (Terminal) ladoDerecho.get(i);
//                if(i==ladoDerecho.size()-1){//Si es el ultimo
//                    if(){}
//                    
//                    
//                                    
//                }
//            }
//        }
//    }
    public void calcularSiguientes(NoTerminal t) {
        ArrayList<Produccion> ps = this.producciones;
        ArrayList<Simbolo> ladoDerecho;
        NoTerminal ladoIzquierdo;
        ArrayList<Terminal> ts;
        NoTerminal x;
        Simbolo proximo;
        int i;
        for (Produccion p : ps) {
            ladoDerecho = p.getLadoDerecho();
            i = 0;
            while (i < ladoDerecho.size()) {
                if (!ladoDerecho.get(i).esTerminal()) {//Si es un NoTerminal
                    if ((NoTerminal) ladoDerecho.get(i) == t) { //Si es el buscado 
                        ladoIzquierdo = p.getLadoIzquierdo();
                        if (i == ladoDerecho.size() - 1 && ladoIzquierdo != t) {//Si es el ultimo
                            calcularSiguientes(ladoIzquierdo);
                            t.getConjuntoSiguientes().addAll(ladoIzquierdo.getConjuntoSiguientes());
                        }
                        if (ladoIzquierdo != t) {
                            proximo = ladoDerecho.get(i + 1);
                            if (proximo.esTerminal()) { //Si es un terminal agreguelo
                                t.getConjuntoSiguientes().add((Terminal) proximo);
                            } else {//Si no es un NoTerminal
                                x = (NoTerminal) proximo;
                                if (x.isHaySiguientes()) {
                                    t.getConjuntoSiguientes().addAll(x.getConjuntoSiguientes()); //Agregar los siguientes
                                } else {//Si aun no se han calculado, calcularlos
                                    this.calcularSiguientes(x);
                                    t.getConjuntoSiguientes().addAll(x.getConjuntoSiguientes()); //Agregar los siguientes
                                }
                            }
                        }

                    }
                }
                i++;
            }
            t.setHaySiguientes(true);
        }

    }

}
