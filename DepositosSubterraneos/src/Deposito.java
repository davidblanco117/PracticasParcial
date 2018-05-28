
public class Deposito {
	private int superficie;
	private int profundidad;
	//private int cantidadDePetroleoAlmacenado;

	public Deposito(int base, int profundidad) {
		this.superficie = base;
		this.profundidad = profundidad;
	}

	public int getSuperficie() {
		return superficie;
	}

	public int getProfundidad() {
		return profundidad;
	}

	public int getVolumen() {
		return this.superficie * this.profundidad;
	}

	public static int volumenAcumulado(Deposito dep[], int cant) {

		int acum = 0;
		if (cant >= dep.length)
			return -1;
			
		for (int i = 0; i < cant; i++) {
			acum += dep[i].superficie * (dep[i].profundidad- dep[cant].profundidad);

		}
		return acum;
	}

}
