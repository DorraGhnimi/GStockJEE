package web;

import java.util.ArrayList;
import java.util.List;

import metier.entites.Produit;

public class ProduitModel {
	
	private String motCle;
	private List<Produit> produits = new ArrayList<>();
	
	
	
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String mc) {
		this.motCle = mc;
	}
	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
	
	
	
	

}
