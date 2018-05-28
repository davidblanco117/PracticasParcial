
public class NombresRepetidos implements Comparable<Object> {

	private String nombre;
	private int cantApariciones=0;
	
	
	public NombresRepetidos() {
		// TODO Auto-generated constructor stub
	}
	
	public NombresRepetidos(String nombre){
		this.nombre= nombre;
	}
	
	
	public String toString(){
		return this.nombre;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	public int getCantApariciones() {
		return cantApariciones;
	}
	
	@Override
	public int compareTo(Object o) {
		return ((NombresRepetidos)o).cantApariciones-this.cantApariciones;	
	}
	
	public int aumentarCantApariciones(){
		return (++this.cantApariciones);
	}
	
}
