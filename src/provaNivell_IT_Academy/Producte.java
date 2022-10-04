package provaNivell_IT_Academy;

public class Producte {
	private String nom;
	private String marca;
	private float preu;
	private int quantitat;
	
	
	public Producte(String nom, String marca, float preu, int quantitat) {
		this.nom = nom;
		this.marca = marca;
		this.preu = preu;
		this.quantitat = quantitat;
	}


	public String getNom() {
		return nom;
	}


	public String getMarca() {
		return marca;
	}


	public float getPreu() {
		return preu;
	}


	public int getQuantitat() {
		return quantitat;
	}


	public void setPreu(float preu) {
		this.preu = preu;
	}


	public void setQuantitat(int quantitat) {
		this.quantitat = quantitat;
	}


	@Override
	public String toString() {
		return "Producte " + nom + ": \n    - marca: " + marca + "\n    - preu " + preu + "\n    - quantitat: " + quantitat;
	}
	
}
