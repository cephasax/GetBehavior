package br.set.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import br.set.domain.Beverage;


@Stateless
public class BeverageDao extends GenericDao {

	public BeverageDao(){
		super(Beverage.class);
	}
	
	public ArrayList<Beverage> list() {
		Query query = em.createQuery("Select b from Beverage b");
		List<Beverage> results = new ArrayList<Beverage>();
		results = query.getResultList();
		return (ArrayList<Beverage>) results;
	}
	
	public Beverage findById(int idBeverage) {
		//MAKING SQL QUERY
		String sql = " Select b FROM Beverage b";
		StringBuilder where = new StringBuilder();
		where.append(" WHERE b.idBeverage = :idBeverage");
		
		StringBuilder sqlFinal = new StringBuilder();
		sqlFinal.append(sql);
		sqlFinal.append(where.toString());	
		Query query = em.createQuery(sqlFinal.toString());
		
		//QUERY PARAMETERS
		query.setParameter("idBeverage", idBeverage);
		
		//RUN AND RETURN
		return (Beverage)query.getSingleResult();
	}
	
	public void delete(Beverage beverage) {
		super.delete(beverage.getIdBeverage(), Beverage.class);
	}
}
