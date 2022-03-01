
package pkg8puzzle;

import java.util.ArrayList;

public class Nodo {
    private int [] puzzle;
    private ArrayList<Nodo> siguientesEstados;
    
    public Nodo(int [] puzzle){
        this.puzzle = puzzle;
        visitado = false;
    }
    
    public int [] getPuzzle(){
        return puzzle;
    }
    
    public void setPuzzle(int [] puzzle){
        this.puzzle = puzzle;
    }
    
    public void asignarSiguientesEstados(ArrayList<Nodo> puzzles){
        siguientesEstados = puzzles;
    }
    
    public boolean agregarNuevoEstado(Nodo puzzle){
        return siguientesEstados.add(puzzle);
    }
    
    public ArrayList<Nodo> getSiguientesEstados(){
        return siguientesEstados;
    }
    
}
