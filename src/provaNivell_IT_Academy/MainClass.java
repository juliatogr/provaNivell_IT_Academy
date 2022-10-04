package provaNivell_IT_Academy;

import java.util.ArrayList;
import java.util.Scanner;

/*
Crea una aplicació que serveixi per gestionar carrets de la compra dels usuaris d'un e-comerce.

Tenim productes, dels quals volem saber:
    - nom
    - marca
    - preu
    - quantitat de productes d'aquell tipus que compra l'usuari en el seu carret (no és l'Stock)

L'aplicació ha de ser capaç de:
		
1. Afegir productes al carret de cada usuari. Si el producte ja existeix al carret, se li suma la quantitat.
2. Calcular l'import total de tots els productes d'un carret
3. Mostrar el número de productes d'una marca en concret en un carret (Amb lambda)
*/

public class MainClass {

	private static CarretCompra carretActual = null;
	private static ArrayList<CarretCompra> carrets;
	
	public static void main(String[] args) {

		carrets = new ArrayList<CarretCompra>();
		boolean exit = false;
		byte opt;
		
		while (!exit) {
			
			if (carrets.size() == 0) {
				System.out.println("Actualment no hi ha cap carret. Afegeix un carret, siusplau.");
				opt = noCarretsMenu();
				switch (opt) {
					case 0: 
						exit = true; 
						System.out.println("Adéu!"); 
						break;
					case 1: 
						afegirCarret();
				}
			}
			else {
				
				if (carrets.size() == 1) {
					carretActual = carrets.get(0);
				}
				opt = mainMenu();
				switch (opt) {
					case 0: 
						exit = true; 
						System.out.println("Adéu!"); 
						break;
					case 1: 
						afegirProducteCarret(); 
						break;
					case 2: 
						calcularImportCarret(); 
						break;
					case 3: 
						mostrarProductesCarret(); 
						break;
					case 4: 
						mostrarNumProductesMarcaCarret(); 
						break;
					case 5: 
						afegirCarret(); 
						break;
					case 6: 
						canviarCarret(); 
						break;
				}
			}
		}
	}
	
	
	public static byte mainMenu() {
		
		Scanner sc = new Scanner(System.in);
		
		byte opt = -1;
		
		while (opt < 0 || opt > 6) {
			
			System.out.println("Selecciona la opció desitjada:");
			System.out.println("    1. Afegir un producte al carret.");
			System.out.println("    2. Calcular l'import total del carret.");
			System.out.println("    3. Mostrar tots els productes del carret.");
			System.out.println("    4. Mostrar el número de productes d'una marca en concret del carret.");
			System.out.println("    5. Afegir un carret.");
			System.out.println("    6. Canviar de carret.");
			System.out.println("    0. Sortir.");
			
			opt = sc.nextByte();
			
			if (opt < 0 || opt > 6) {
				System.out.println("Introdueix una opció vàlida 0-6.");
			}
		}
		
		return opt;
	}
	
	public static byte noCarretsMenu() {
		
		Scanner sc = new Scanner(System.in);
		
		byte opt = -1;
		
		while (opt < 0 || opt > 1) {
			
			System.out.println("Selecciona la opció desitjada:");
			System.out.println("    1. Afegir un carret.");
			System.out.println("    0. Sortir.");
			
			opt = sc.nextByte();
			
			if (opt < 0 || opt > 1) {
				System.out.println("Introdueix una opció vàlida 0-1.");
			}
		}
		
		return opt;
	}

	
	public static void afegirProducteCarret() {
		System.out.println("Afegint un producte al carret de l'usuari " + carretActual.getUsuari());
		
		carretActual.afegirProducte();
	}
	
	public static void calcularImportCarret() {
		System.out.println("Calculant l'import del carret de l'usuari " + carretActual.getUsuari());
		
		carretActual.calcularPreuTotal();
	}
	
	public static void mostrarProductesCarret() {
		System.out.println("Mostrant els productes del carret de l'usuari " + carretActual.getUsuari());
		
		carretActual.mostrarProductes();
	}
	
	
	public static void mostrarNumProductesMarcaCarret() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introdueix la marca: ");
		String marca = sc.nextLine();

		carretActual.mostrarNumProductesMarca(marca);
	}
	
	public static void afegirCarret() {
		System.out.println("Afegint un carret.");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduiu el nom de l'usuari:");
		
		String usuari = sc.nextLine();
		CarretCompra c = new CarretCompra(usuari);
		
		carrets.add(c);
		
		
		System.out.println("Carret de compra de l'usuari " + c.getUsuari() + " afegit.");
	}
	
	public static void canviarCarret() {
		
		if (carrets.size() == 1 ) {
			System.out.println("Només hi ha un carret. No pots canviar per un altre.");
		} else {
			System.out.println("Canviant de carret.");
			System.out.println("Carret actual: " + carretActual);
			
			Scanner sc = new Scanner(System.in);
			mostrarCarrets();
			
			CarretCompra c = null;
			
			while (c == null) {
						
				System.out.println("Escriu el nom de l'usuari del carret desitjat");
				String usuari = sc.nextLine();
				
				c = buscarCarret(usuari);
				
				if (c == null) {
					System.out.println("no existeix un carret per un usuari amb el nom " + usuari);
				} else {
					carretActual = c;
					System.out.println("Carret canviat");
				}
			}
		}
	}
	
	public static void mostrarCarrets() {
		
		System.out.println("Carrets:");
		for (CarretCompra c : carrets) {
			System.out.println(c);
		}
	}
	
	public static CarretCompra buscarCarret(String usuari) {
		
		CarretCompra carret = null;
		for (CarretCompra c : carrets) {
			if (c.getUsuari().equalsIgnoreCase(usuari)) {
				carret = c;
			}
		}
		return carret;
	}
}
