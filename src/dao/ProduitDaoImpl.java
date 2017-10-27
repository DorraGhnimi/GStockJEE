package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entites.Produit;

//quand je cree une classe je joue le role d'un developpeur 
//dans cette classe on va faire le mapping objet relationnel
public class ProduitDaoImpl implements IProduitDao {

	@Override
	public Produit addProduit(Produit p) {
		// Singleton => une seule instance de Connection est creee
		Connection connection = SingletonConnexion.getConnection();
		try {
			// creer prepareStatement pour inserer le produit
			PreparedStatement ps1 = connection
					.prepareStatement("INSERT INTO PRODUITS (DESIGNATION,PRIX,QUANTITE) VALUES (?,?,?)");
			// set attributes
			ps1.setString(1, p.getDesignation());
			ps1.setDouble(2, p.getPrix());
			ps1.setInt(3, p.getQuantite());
			// execute
			ps1.executeUpdate();

			// creer preparestatement pour get the id du produit qu'on vient d'inserer
			PreparedStatement ps2 = connection.prepareStatement("SELECT MAX(ID) as MAXID FROM PRODUITS");
			ResultSet rs = ps2.executeQuery();
			if (rs.next()) {
				p.setId(rs.getLong("MAXID"));
			}

			// fermer
			ps1.close();
			ps2.close();
			// il faut pas fermer l cnx ici, par ce que "Singleton"

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Produit> produitsParMC(String mc) {
		
		List<Produit> produits = new ArrayList<>();
		
		Connection connection = SingletonConnexion.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement
					("SELECT * FROM PRODUITS WHERE DESIGNATION LIKE ?");
			ps.setString(1, mc);
			
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				Produit p = new Produit();
				p.setId(rs.getLong("ID"));
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrix(rs.getDouble("PRIX"));
				p.setQuantite(rs.getInt("QUANTITE"));
				produits.add(p);
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	
		return produits;
	}

	@Override
	public List<Produit> produitsAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit getProduit(Long id) {
		Produit p = null;
		
		Connection connection = SingletonConnexion.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement
					("SELECT * FROM PRODUITS WHERE ID=?");
			ps.setLong(1,id);
			
			
			ResultSet rs = ps.executeQuery();
			
			
			if(rs.next()) {
				p = new Produit();
				p.setId(rs.getLong("ID"));
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrix(rs.getDouble("PRIX"));
				p.setQuantite(rs.getInt("QUANTITE"));
				
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	
		return p;
		
	}

	@Override
	public Produit updateProduit(Produit p) {
		
		Connection connection = SingletonConnexion.getConnection();
		try {
			PreparedStatement ps = connection
					.prepareStatement("UPDATE PRODUITS SET DESIGNATION=?,PRIX=?,QUANTITE=? WHERE ID=?");
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.setLong(4, p.getId());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public void deleteProduit(Long id) {
		Connection connection = SingletonConnexion.getConnection();
		try {
			
			PreparedStatement ps = connection
					.prepareStatement("DELETE FROM PRODUITS WHERE ID=?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
