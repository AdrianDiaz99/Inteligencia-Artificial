
public class ArbolBinarioBusqueda <T> {
    
	private NodoABB<T> Raiz;
	public  T          Dr;
        
	public ArbolBinarioBusqueda(){
		Raiz=null;
	}
        
        public boolean vacio(){
            return Raiz == null;
        }
	
	public NodoABB<T> buscar(String datoBuscar){
		if(Raiz == null)
			return null;
                
                return buscar(Raiz, datoBuscar);
	}
        
	public NodoABB<T> buscar(NodoABB<T> Raiz, String buscar){
            
		if(Raiz.Info.toString().equals(buscar.toString()))
			return Raiz;
                
                if(Raiz == null)
                    return null;
                
		NodoABB<T> resultado = buscar(Raiz.getSubIzq(), buscar);
                
                if(resultado.Info.toString().equals(buscar.toString())){
                    return resultado;
                }
                
		return buscar(Raiz.getSubDer(), buscar);
	}
        
	public void InOrden(NodoABB<T> Raiz){
		if(Raiz==null)
			return;
		InOrden(Raiz.getSubIzq());
		System.out.println(Raiz.Info);
		InOrden(Raiz.getSubDer());
	}
	public void PreOrden(NodoABB<T> Raiz){
		if(Raiz==null)
			return;
		System.out.println(Raiz.Info);
		PreOrden(Raiz.getSubIzq());
		PreOrden(Raiz.getSubDer());
	}
	public void PostOrden(NodoABB<T> Raiz){
		if(Raiz==null)
			return;
		PostOrden(Raiz.getSubIzq());
		PostOrden(Raiz.getSubDer());
		System.out.println(Raiz.Info);
	}
        
}	
