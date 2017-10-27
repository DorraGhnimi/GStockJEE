package dao;

import java.util.List;

import metier.entites.Produit;



//lorsque je cree l'interface je joue le role d'un concepteur :3
public interface IProduitDao {
	
	public Produit addProduit(Produit p);
	public List<Produit> produitsParMC(String mc);
	public List<Produit> produitsAll();
	public Produit getProduit(Long id)	;
	public Produit updateProduit(Produit p);
	public void deleteProduit(Long id);
	

}
