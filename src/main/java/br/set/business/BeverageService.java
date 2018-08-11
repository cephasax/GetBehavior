package br.set.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.set.dao.BeverageDao;
import br.set.domain.Beverage;

@Stateless
public class BeverageService{

	@Inject
	private BeverageDao beverajeDao;
	
	public List<Beverage> list(){
		ArrayList<Beverage> beverages = new ArrayList<Beverage>();
		beverages = beverajeDao.list();
		if(beverages.size() > 0){
			return beverages;
		}
		else{
			return null;		
		}
	}
	
	public Beverage findById(int entityId){
		Beverage beverage = new Beverage();
		beverage = beverajeDao.findById(entityId);
		return beverage;
	}
	
	@SuppressWarnings("unchecked")
	public void save(Beverage beverage){
		beverajeDao.save(beverage);
	}

	public void delete(Beverage beverage){
		beverajeDao.delete(beverage);
	}
	
}
