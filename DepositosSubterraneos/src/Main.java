import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Deposito[] dep;
		int cantidadDeDepositos = 0;
		int petroleo;
		int i;
		int acum=0;
		try {
			Scanner sc = new Scanner(new File("depositos.in"));
			PrintWriter pw = new PrintWriter(new File("depositos.out"));
			cantidadDeDepositos = sc.nextInt();

			dep = new Deposito[cantidadDeDepositos+1];
			
			for (i = 0; i < cantidadDeDepositos; i++) {
				dep[i] = new Deposito(sc.nextInt(), sc.nextInt());
			}
			dep[cantidadDeDepositos]= new Deposito(0,0);
			petroleo = sc.nextInt();
			
			
			for (i=1; i < dep.length; i++) {
				acum = Deposito.volumenAcumulado(dep, i);
				if (petroleo <= acum) {
					break;
				}
				
			}
			
			if(i>=dep.length)
				pw.println("Rebasan: "+(petroleo-acum));
			else{
				
				pw.println(i);
				int res= dep[i-1].getProfundidad()-((petroleo-Deposito.volumenAcumulado(dep, i-1))/i)/dep[i-1].getSuperficie();
				pw.println(res);
			}
			sc.close();
			pw.close();

		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
		
}
