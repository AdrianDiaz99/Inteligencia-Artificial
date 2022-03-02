
package pkg8puzzle;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    int [] arrayObjetivo = {1, 2, 3, 4, 5, 6, 7, 8, 0};
    Nodo estadoObjetivo = new Nodo(arrayObjetivo);
    ArrayList<Nodo> visitados = new ArrayList();
    int profundidad = 1;
    
    public Main(){
        //                      0, 1, 2, /**/  3, 4, 5, /**/  6, 7, 8
        int [] estadoInicial = {3, 2, 5, /**/  8, 0, 6, /**/  1, 4, 7};
        
        Nodo nodoEstadoInicial = new Nodo(estadoInicial);
        
        Nodo nodoAux = nodoEstadoInicial;
        PriorityQueue<Nodo> cola = new PriorityQueue();
        cola.add(nodoAux);
        
        int nodosNivel = 1;
        int numeroNodo = 1;
        
        System.out.println("Profundidad: " + profundidad);
        
        while(nodoAux != null){
            
            System.out.println(nodoAux.mostrarCuadrito());
            ArrayList<Nodo> nuevosEstados = generaEstados(nodoAux.getPuzzle());
            
            for(int i = 0; i < nuevosEstados.size(); i++){

                if(estadoObjetivo.equals(nuevosEstados.get(i))){
                    System.out.println("----------------------");
                    System.out.println(nuevosEstados.get(i));
                    System.out.println("ENCONTRADO");
                    System.out.println("----------------------");
                    return;
                }

            }
            
            for(int i = 0; i < nuevosEstados.size(); i++){
                if(visitados.contains(nuevosEstados.get(i))){
                    continue;
                }
                visitados.add(nuevosEstados.get(i));
                cola.add(nuevosEstados.get(i));
            }
            
            
            if(nodosNivel == numeroNodo){
                profundidad++;
                System.out.println("Profundidad: " + profundidad);
                nodosNivel = nuevosEstados.size();
                numeroNodo = 1;
            }else
                numeroNodo++;
            
            nodoAux = cola.poll();
        }
        
//        buscaEstadoObjetivo(nodoEstadoInicial);
    }
    
//    public void buscaEstadoObjetivo(Nodo Raiz){
//        
//        Raiz.asignarSiguientesEstados(generaEstados(Raiz.getPuzzle()));
//        
//        System.out.println("Produndidad: " + profundidad);
//        for(int i = 0; i < Raiz.getSiguientesEstados().size(); i++){
//            
//            
//            if(estadoObjetivo.equals(Raiz.getSiguientesEstados().get(i))){
//                System.out.println("----------------------");
//                System.out.println(Raiz.getSiguientesEstados().get(i));
//                System.out.println("ENCONTRADO");
//                System.out.println("----------------------");
//                return;
//            }
//            
//        }
//        
//        profundidad++;
//        for(int i = 0; i < Raiz.getSiguientesEstados().size(); i++){
//            
//            if(visitados.contains(Raiz.getSiguientesEstados().get(i))){
//                continue;
//            }
//            
//            visitados.add(Raiz.getSiguientesEstados().get(i));
//            System.out.println(Raiz.getSiguientesEstados().get(i));
//            
//            buscaEstadoObjetivo(Raiz.getSiguientesEstados().get(i));
//        }
//        
//    }
    
    public ArrayList<Nodo> generaEstados(int [] puzzle){
        
        int cuadroVacio = searchIndex(puzzle, 0);
        ArrayList<Nodo> siguientesEstados = new ArrayList();
        
        switch(cuadroVacio){
            case 0:{
                int [] estado1 = {puzzle[1], 0, puzzle[2], puzzle[3], puzzle[4], puzzle[5], puzzle[6], puzzle[7], puzzle[8]};
                int [] estado2 = {puzzle[3], puzzle[1], puzzle[2], 0, puzzle[4], puzzle[5], puzzle[6], puzzle[7], puzzle[8]};
                siguientesEstados.add(new Nodo(estado1));
                siguientesEstados.add(new Nodo(estado2));
                break;
            }
            case 1:{
                int [] estado1 = {0, puzzle[0], puzzle[2], puzzle[3], puzzle[4], puzzle[5], puzzle[6], puzzle[7], puzzle[8]};
                int [] estado2 = {puzzle[0], puzzle[2], 0, puzzle[3], puzzle[4], puzzle[5], puzzle[6], puzzle[7], puzzle[8]};
                int [] estado3 = {puzzle[0], puzzle[4], puzzle[2], puzzle[3], 0, puzzle[5], puzzle[6], puzzle[7], puzzle[8]};
                siguientesEstados.add(new Nodo(estado1));
                siguientesEstados.add(new Nodo(estado2));
                siguientesEstados.add(new Nodo(estado3));
                break;
            }
            case 2:{
                int [] estado1 = {puzzle[0], 0, puzzle[1], puzzle[3], puzzle[4], puzzle[5], puzzle[6], puzzle[7], puzzle[8]};
                int [] estado2 = {puzzle[0], puzzle[1], puzzle[5], puzzle[3], puzzle[4], 0, puzzle[6], puzzle[7], puzzle[8]};
                siguientesEstados.add(new Nodo(estado1));
                siguientesEstados.add(new Nodo(estado2));
                break;
            }
            case 3:{
                int [] estado1 = {0, puzzle[1], puzzle[2], puzzle[0], puzzle[4], puzzle[5], puzzle[6], puzzle[7], puzzle[8]};
                int [] estado2 = {puzzle[0], puzzle[1], puzzle[2], puzzle[4], 0, puzzle[5], puzzle[6], puzzle[7], puzzle[8]};
                int [] estado3 = {puzzle[0], puzzle[1], puzzle[2], puzzle[6], puzzle[4], puzzle[5], 0, puzzle[7], puzzle[8]};
                siguientesEstados.add(new Nodo(estado1));
                siguientesEstados.add(new Nodo(estado2));
                siguientesEstados.add(new Nodo(estado3));
                break;
            }
            case 4:{
                int [] estado1 = {puzzle[0], 0, puzzle[2], puzzle[3], puzzle[1], puzzle[5], puzzle[6], puzzle[7], puzzle[8]};
                int [] estado2 = {puzzle[0], puzzle[1], puzzle[2], 0, puzzle[3], puzzle[5], puzzle[6], puzzle[7], puzzle[8]};
                int [] estado3 = {puzzle[0], puzzle[1], puzzle[2], puzzle[3], puzzle[5], 0, puzzle[6], puzzle[7], puzzle[8]};
                int [] estado4 = {puzzle[0], puzzle[1], puzzle[2], puzzle[3], puzzle[7], puzzle[5], puzzle[6], 0, puzzle[8]};
                siguientesEstados.add(new Nodo(estado1));
                siguientesEstados.add(new Nodo(estado2));
                siguientesEstados.add(new Nodo(estado3));
                siguientesEstados.add(new Nodo(estado4));
                break;
            }
            case 5:{
                int [] estado1 = {puzzle[0], puzzle[1], 0, puzzle[3], puzzle[4], puzzle[2], puzzle[6], puzzle[7], puzzle[8]};
                int [] estado2 = {puzzle[0], puzzle[1], puzzle[2], puzzle[3], 0, puzzle[4], puzzle[6], puzzle[7], puzzle[8]};
                int [] estado3 = {puzzle[0], puzzle[1], puzzle[2], puzzle[3], puzzle[4], puzzle[8], puzzle[6], puzzle[7], 0};
                siguientesEstados.add(new Nodo(estado1));
                siguientesEstados.add(new Nodo(estado2));
                siguientesEstados.add(new Nodo(estado3));
                break;
            }
            case 6:{
                int [] estado1 = {puzzle[0], puzzle[1], puzzle[2], 0, puzzle[4], puzzle[5], puzzle[3], puzzle[7], puzzle[8]};
                int [] estado2 = {puzzle[0], puzzle[1], puzzle[2], puzzle[3], puzzle[4], puzzle[5], puzzle[7], 0, puzzle[8]};
                siguientesEstados.add(new Nodo(estado1));
                siguientesEstados.add(new Nodo(estado2));
                break;
            }
            case 7:{
                int [] estado1 = {puzzle[0], puzzle[1], puzzle[2], puzzle[3], 0, puzzle[5], puzzle[6], puzzle[4], puzzle[8]};
                int [] estado2 = {puzzle[0], puzzle[1], puzzle[2], puzzle[3], puzzle[4], puzzle[5], 0, puzzle[6], puzzle[8]};
                int [] estado3 = {puzzle[0], puzzle[1], puzzle[2], puzzle[3], puzzle[4], puzzle[5], puzzle[6], puzzle[8], 0};
                siguientesEstados.add(new Nodo(estado1));
                siguientesEstados.add(new Nodo(estado2));
                siguientesEstados.add(new Nodo(estado3));
                break;
            }
            case 8:{
                int [] estado1 = {puzzle[0], puzzle[1], puzzle[2], puzzle[3], puzzle[4], 0, puzzle[6], puzzle[7], puzzle[5]};
                int [] estado2 = {puzzle[0], puzzle[1], puzzle[2], puzzle[3], puzzle[4], puzzle[5], puzzle[6], 0, puzzle[7]};
                siguientesEstados.add(new Nodo(estado1));
                siguientesEstados.add(new Nodo(estado2));
                break;
            }
        }
        
        return siguientesEstados;
    }
    
    public static void main(String[] args) {
        
        new Main();
        
    }
    
    public int searchIndex(int arr[], int elementoBuscar)
    {
 
        // if array is Null
        if (arr == null) {
            return -1;
        }
 
        // find length of array
        int len = arr.length;
        int i = 0;
 
        // traverse in the array
        while (i < len) {
 
            // if the i-th element is t
            // then return the index
            if (arr[i] == elementoBuscar) {
                return i;
            }
            else {
                i = i + 1;
            }
        }
        return -1;
    }
    
}
