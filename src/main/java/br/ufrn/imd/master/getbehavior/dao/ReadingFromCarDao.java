package br.ufrn.imd.master.getbehavior.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import br.ufrn.imd.master.getbehavior.domain.ReadingFromCar;

@Stateless
public class ReadingFromCarDao extends GenericDao {

	public ReadingFromCarDao(){
		super(ReadingFromCar.class);
	}
	
	public ArrayList<ReadingFromCar> list() {
		Query query = em.createQuery("Select r from ReadingFromCar r");
		List<ReadingFromCar> results = new ArrayList<ReadingFromCar>();
		results = query.getResultList();
		return (ArrayList<ReadingFromCar>) results;
	}
	
	public ReadingFromCar findById(int idReadingFromCar) {
		//MAKING SQL QUERY
		String sql = " Select r FROM ReadingFromCar r";
		StringBuilder where = new StringBuilder();
		where.append(" WHERE r.idReadingFromCar = :idReadingFromCar");
		
		StringBuilder sqlFinal = new StringBuilder();
		sqlFinal.append(sql);
		sqlFinal.append(where.toString());	
		Query query = em.createQuery(sqlFinal.toString());
		
		//QUERY PARAMETERS
		query.setParameter("idReadingFromCar", idReadingFromCar);
		
		//RUN AND RETURN
		return (ReadingFromCar)query.getSingleResult();
	}

	public ReadingFromCar findLastReadingByVehicleId(String vehicleId) {
		//MAKING SQL QUERY
		String sql = " Select r FROM ReadingFromCar r"
				+ " JOIN r.element element";
		StringBuilder where = new StringBuilder();
		where.append(" WHERE r.vehicleId = :vehicleId");
		where.append(" ORDER BY r.element.date DESC");
		
		StringBuilder sqlFinal = new StringBuilder();
		sqlFinal.append(sql);
		sqlFinal.append(where.toString());	
		Query query = em.createQuery(sqlFinal.toString());
		
		//QUERY PARAMETERS
		query.setParameter("vehicleId", vehicleId);
		query.setMaxResults(1);
		
		//RUN AND RETURN
		return (ReadingFromCar)query.getSingleResult();
	}
	
	public ArrayList<ReadingFromCar> findByVehicleId(String vehicleId) {
		//MAKING SQL QUERY
		String sql = " Select r FROM ReadingFromCar r";
		StringBuilder where = new StringBuilder();
		where.append(" WHERE r.vehicleId = :vehicleId");
		
		StringBuilder sqlFinal = new StringBuilder();
		sqlFinal.append(sql);
		sqlFinal.append(where.toString());	
		Query query = em.createQuery(sqlFinal.toString());
		
		//QUERY PARAMETERS
		query.setParameter("vehicleId", vehicleId);
		
		//RUN AND RETURN
		return (ArrayList<ReadingFromCar>) query.getResultList();
	}
		
	public void delete(ReadingFromCar readingFromCar) {
		super.delete(readingFromCar.getIdReadingFromCar(), ReadingFromCar.class);
	}
}
