
package pkg8puzzle;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    
    int [] estadoObjetivo = {1, 2, 3, 4, 5, 6, 7, 8, 0};
    
    public Main(){
        //                      0, 1, 2, /**/  3, 4, 5, /**/  6, 7, 8
        int [] estadoInicial = {3, 2, 5, /**/  8, 0, 6, /**/  1, 4, 7};
        
        ArrayList<Nodo> visitados = new ArrayList();
        
        ArrayList<Nodo> siguientesEstados = generaEstados(estadoInicial);
        
//        for(int i=0; i < siguientesEstados.size(); i++){
//            System.out.println(Arrays.toString(siguientesEstados.get(i).getPuzzle()));
//        }
        
        Nodo nodoEstadoInicial = new Nodo(estadoInicial);
        
        visitados.add(nodoEstadoInicial);
        nodoEstadoInicial.asignarSiguientesEstados(siguientesEstados);
        
        buscaEstadoObjetivo(nodoEstadoInicial);
    }
    
    public Nodo buscaEstadoObjetivo(Nodo Raiz){
        
        if(Arrays.toString(estadoObjetivo).equals(Arrays.toString(Raiz.getPuzzle()))){
            return Raiz;
        }
        
        for(int i = 0; i < Raiz.getSiguientesEstados().size(); i++){
            buscaEstadoObjetivo(Raiz.getSiguientesEstados().get(i));
        }
        
    }
    
    public ArrayList<Nodo> generaEstados(int [] puzzle){
        
        int cuadroVacio = searchIndex(puzzle, 0);
        ArrayList<Nodo> siguientesEstados = new ArrayList();
        
        switch(cuadroVacio){
            case 0:{
                int [] estado1 = {puzzle[1], 0, puzzle[2], puzzle[3], puzzle[4], puzzle[5], puzzle[6], puzzle[7], puzzle[8]};
                int [] estado2 = {puzzle[3], puzzle[2], puzzle[3], 0, puzzle[4], puzzle[5], puzzle[6], puzzle[7], puzzle[8]};
                Nodo nodo1 = new Nodo(estado1);
                Nodo nodo2 = new Nodo(estado2);
                siguientesEstados.add(nodo1);
                siguientesEstados.add(nodo2);
                break;
            }
            case 1:{
                int [] estado1 = {0, puzzle[0], puzzle[2], puzzle[3], puzzle[4], puzzle[5], puzzle[6], puzzle[7], puzzle[8]};
                int [] estado2 = {puzzle[0], puzzle[2], 0, puzzle[3], puzzle[4], puzzle[5], puzzle[6], puzzle[7], puzzle[8]};
                int [] estado3 = {puzzle[0], puzzle[4], puzzle[2], puzzle[3], 0, puzzle[5], puzzle[6], puzzle[7], puzzle[8]};
                Nodo nodo1 = new Nodo(estado1);
                Nodo nodo2 = new Nodo(estado2);
                Nodo nodo3 = new Nodo(estado3);
                siguientesEstados.add(nodo1);
                siguientesEstados.add(nodo2);
                siguientesEstados.add(nodo3);
                break;
            }
            case 2:{
                int [] estado1 = {puzzle[0], 0, puzzle[1], puzzle[3], puzzle[4], puzzle[5], puzzle[6], puzzle[7], puzzle[8]};
                int [] estado2 = {puzzle[0], puzzle[1], puzzle[5], puzzle[3], puzzle[4], 0, puzzle[6], puzzle[7], puzzle[8]};
                Nodo nodo1 = new Nodo(estado1);
                Nodo nodo2 = new Nodo(estado2);
                siguientesEstados.add(nodo1);
                siguientesEstados.add(nodo2);
                break;
            }
            case 3:{
                int [] estado1 = {0, puzzle[1], puzzle[2], puzzle[0], puzzle[4], puzzle[5], puzzle[6], puzzle[7], puzzle[8]};
                int [] estado2 = {puzzle[0], puzzle[1], puzzle[2], puzzle[4], 0, puzzle[5], puzzle[6], puzzle[7], puzzle[8]};
                int [] estado3 = {puzzle[0], puzzle[1], puzzle[2], puzzle[6], puzzle[4], puzzle[5], 0, puzzle[7], puzzle[8]};
                Nodo nodo1 = new Nodo(estado1);
                Nodo nodo2 = new Nodo(estado2);
                Nodo nodo3 = new Nodo(estado3);
                siguientesEstados.add(nodo1);
                siguientesEstados.add(nodo2);
                siguientesEstados.add(nodo3);
                break;
            }
            case 4:{
                int [] estado1 = {puzzle[0], 0, puzzle[2], puzzle[3], puzzle[1], puzzle[5], puzzle[6], puzzle[7], puzzle[8]};
                int [] estado2 = {puzzle[0], puzzle[1], puzzle[2], 0, puzzle[3], puzzle[5], puzzle[6], puzzle[7], puzzle[8]};
                int [] estado3 = {puzzle[0], puzzle[1], puzzle[2], puzzle[3], puzzle[5], 0, puzzle[6], puzzle[7], puzzle[8]};
                int [] estado4 = {puzzle[0], puzzle[1], puzzle[2], puzzle[3], puzzle[7], puzzle[5], puzzle[6], 0, puzzle[8]};
                Nodo nodo1 = new Nodo(estado1);
                Nodo nodo2 = new Nodo(estado2);
                Nodo nodo3 = new Nodo(estado3);
                Nodo nodo4 = new Nodo(estado4);
                siguientesEstados.add(nodo1);
                siguientesEstados.add(nodo2);
                siguientesEstados.add(nodo3);
                siguientesEstados.add(nodo4);
                break;
            }
            case 5:{
                int [] estado1 = {puzzle[0], puzzle[1], 0, puzzle[3], puzzle[4], puzzle[2], puzzle[6], puzzle[7], puzzle[8]};
                int [] estado2 = {puzzle[0], puzzle[1], puzzle[2], puzzle[3], 0, puzzle[4], puzzle[6], puzzle[7], puzzle[8]};
                int [] estado3 = {puzzle[0], puzzle[1], puzzle[2], puzzle[3], puzzle[4], puzzle[8], puzzle[6], puzzle[7], 0};
                Nodo nodo1 = new Nodo(estado1);
                Nodo nodo2 = new Nodo(estado2);
                Nodo nodo3 = new Nodo(estado3);
                siguientesEstados.add(nodo1);
                siguientesEstados.add(nodo2);
                siguientesEstados.add(nodo3);
                break;
            }
            case 6:{
                int [] estado1 = {puzzle[0], puzzle[1], puzzle[2], 0, puzzle[4], puzzle[5], puzzle[3], puzzle[7], puzzle[8]};
                int [] estado2 = {puzzle[0], puzzle[1], puzzle[2], puzzle[3], puzzle[4], puzzle[5], puzzle[7], 0, puzzle[8]};
                Nodo nodo1 = new Nodo(estado1);
                Nodo nodo2 = new Nodo(estado2);
                siguientesEstados.add(nodo1);
                siguientesEstados.add(nodo2);
                break;
            }
            case 7:{
                int [] estado1 = {puzzle[0], puzzle[1], puzzle[2], puzzle[3], 0, puzzle[5], puzzle[6], puzzle[4], puzzle[8]};
                int [] estado2 = {puzzle[0], puzzle[1], puzzle[2], puzzle[3], puzzle[4], puzzle[5], 0, puzzle[6], puzzle[8]};
                int [] estado3 = {puzzle[0], puzzle[1], puzzle[2], puzzle[3], puzzle[4], puzzle[5], puzzle[6], puzzle[8], 0};
                Nodo nodo1 = new Nodo(estado1);
                Nodo nodo2 = new Nodo(estado2);
                Nodo nodo3 = new Nodo(estado3);
                siguientesEstados.add(nodo1);
                siguientesEstados.add(nodo2);
                siguientesEstados.add(nodo3);
                break;
            }
            case 8:{
                int [] estado1 = {puzzle[0], puzzle[1], puzzle[2], puzzle[3], puzzle[4], 0, puzzle[6], puzzle[7], puzzle[5]};
                int [] estado2 = {puzzle[0], puzzle[1], puzzle[2], puzzle[3], puzzle[4], puzzle[5], puzzle[6], 0, puzzle[7]};
                Nodo nodo1 = new Nodo(estado1);
                Nodo nodo2 = new Nodo(estado2);
                siguientesEstados.add(nodo1);
                siguientesEstados.add(nodo2);
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
