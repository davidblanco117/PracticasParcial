import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int cantidadDeChicos;
		int nMasFrecuentes;
		int cantGuardados = 0;
		String nombre;
		boolean existe = false;
		ArrayList<NombresRepetidos> n;
		try {
			Scanner s = new Scanner(new File("nombres.in"));
			PrintWriter p = new PrintWriter(new File("nombres.out"));

			cantidadDeChicos = s.nextInt();
			n = new ArrayList<NombresRepetidos>();
			nMasFrecuentes = s.nextInt();
			s.nextLine();
			for (int i = 0; i < cantidadDeChicos; i++) {
				nombre = s.nextLine();
				for (int j = 0; j < cantGuardados; j++) {
					if (nombre.equals(n.get(j).getNombre())) {
						n.get(j).aumentarCantApariciones();
						existe = true;
						break;
					}
				}
				if (!existe) {
					n.add(new NombresRepetidos(nombre));

					cantGuardados++;
				}
				existe = false;
			}

			Collections.sort(n);
			for (int i = 0; i < nMasFrecuentes; i++) {

				p.println(n.get(i).getNombre() + " " + (n.get(i).getCantApariciones() + 1));
			}
			p.close();
			
			s.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
