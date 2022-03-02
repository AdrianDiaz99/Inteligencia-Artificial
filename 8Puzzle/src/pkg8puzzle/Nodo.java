
package pkg8puzzle;

import java.util.ArrayList;
import java.util.Arrays;

public class Nodo implements Comparable<Nodo>{
    private int [] puzzle;
    private Nodo padre;
    
    public Nodo(int [] puzzle){
        this.puzzle = puzzle;
    }
   
    public void setPadre(Nodo padre){
        this.padre = padre;
    }
    
    public int [] getPuzzle(){
        return puzzle;
    }
    
    public void setPuzzle(int [] puzzle){
        this.puzzle = puzzle;
    }
    
    public String mostrar(){
        String res = "";
        for(int i = 0; i < puzzle.length ; i++){
            res += puzzle[i];
            
            if( (i + 1) % 3 == 0 ){
                res += "\n";
                continue;
            }
            
            res += " | ";
            
        }
        return res;
    }
    
    public String toString(){
        return Arrays.toString(puzzle);
    }

    @Override
    public boolean equals(Object o) {
        return this.toString().equals(((Nodo)o).toString());
    }

    @Override
    public int compareTo(Nodo o) {
        return this.toString().compareTo(o.toString());
    }
    
}
