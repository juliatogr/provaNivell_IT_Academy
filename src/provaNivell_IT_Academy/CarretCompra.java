package provaNivell_IT_Academy;

import java.util.ArrayList;
import java.util.Scanner;

public class CarretCompra {
	private String usuari;
	private ArrayList<Producte> productes;
	private float preuTotal;
	
	public CarretCompra(String u) {
		usuari = u;
		productes = new ArrayList<Producte>();
		preuTotal = 0;
	}
	
	public String getUsuari() {
		return usuari;
	}
	
	public ArrayList<Producte> getProductes() {
		return productes;
	}
	
	public void setUsuari(String usuari) {
		this.usuari = usuari;
	}

	@Deprecated
	public void calcularPreuTotal() {
		System.out.println("Mètode deprecat");
		preuTotal = 0;
		for (Producte p: productes) {
			preuTotal += p.getPreu();
		}
		System.out.println("El preu total del carret és de " + preuTotal);
	}
	
	public void mostrarProductes() throws NoProductes {
		
		if (this.productes.size() == 0) {
			throw new NoProductes();
		}
		System.out.println("Productes: ");
		for (Producte p: productes) {
			System.out.println(p);
		}
	}
	
	public void mostrarNumProductesMarca(String marca) {
		//AMB LAMBDES!!!
		this.productes.forEach(p->
		
			{
				boolean exists = false;
				if (p.getMarca().equalsIgnoreCase(marca)) {
					System.out.println(p.getNom() + p.getMarca());
					exists = true;
				}
				
				if (!exists ) {
					System.out.println("No hi ha productes de la marca " + marca + " al carret.");
				}
		
		});	
	}

	
	public void afegirProducte() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduiu el nom del producte :");
		String nom = sc.nextLine();
		
		Producte p = buscarProducte(nom);
		
		if (p == null) {
			System.out.println("Introduiu la marca del producte :");
			String marca = sc.nextLine();
			
			System.out.println("Introduiu el preu del producte :");
			Float preu = sc.nextFloat();
			
			sc.nextLine();
			
			System.out.println("Introduiu la quantitat del producte :");
			int quantitat = sc.nextInt();
			
			p = new Producte(nom, marca, preu, quantitat);
			
			productes.add(p);
		} else {
			System.out.println("Introduiu la quantitat del producte :");
			int quantitat = sc.nextInt();
			
			p.setQuantitat(p.getQuantitat()+quantitat);
		}

		
		
		System.out.println("Producte " + p.getNom() + " afegit al carret de compra de l'usuari " + this.usuari);
	}
	
	public Producte buscarProducte(String nom) {
		Producte producte = null;
		for (Producte p : productes) {
			if (p.getNom().equalsIgnoreCase(nom)) {
				producte = p;
			}
		}
		return producte;
	}
	
	@Override
	public String toString() {
		
		String txt = "Carret de Compra de l'usuari " + usuari + ".";
		
		if (productes.size() > 0) {
			txt += "Productes: ";
			for (Producte p : productes) {
				txt += "\n " + p;
			}
		}

		txt += "\n";
		return  txt;
	}
	
	
}
