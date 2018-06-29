package br.ufrn.imd.master.getbehavior.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.ufrn.imd.master.getbehavior.dao.ElementDao;
import br.ufrn.imd.master.getbehavior.dao.ReadingFromCarDao;
import br.ufrn.imd.master.getbehavior.domain.ReadingFromCar;

@Stateless
public class ReadingFromCarService{

	@Inject
	private ReadingFromCarDao readingFromCarDao;
	
	@Inject
	private ElementDao elementDao;
	
	public List<ReadingFromCar> list(){
		ArrayList<ReadingFromCar> readingsFromCar = new ArrayList<ReadingFromCar>();
		readingsFromCar = readingFromCarDao.list();
		if(readingsFromCar.size() > 0){
			return readingsFromCar;
		}
		else{
			return null;		
		}
	}
	
	public ReadingFromCar findById(int entityId){
		ReadingFromCar readingFromCar = new ReadingFromCar();
		readingFromCar = readingFromCarDao.findById(entityId);
		return readingFromCar;
	}
	
	public ReadingFromCar findLastReadingByVehicleId(String vehicleId){
		ReadingFromCar readingFromCar = new ReadingFromCar();
		System.out.println(vehicleId);
		readingFromCar = readingFromCarDao.findLastReadingByVehicleId(vehicleId);
		return readingFromCar;
	}
	
	public ArrayList<ReadingFromCar> findByVehicleId(String vehicleId){
		ArrayList<ReadingFromCar> readingsFromCar = new ArrayList<>();
		readingsFromCar = readingFromCarDao.findByVehicleId(vehicleId);
		return readingsFromCar;
	}
	
	@SuppressWarnings("unchecked")
	public void save(ReadingFromCar readingFromCar){
		elementDao.save(readingFromCar.getElement());
		readingFromCarDao.save(readingFromCar);
	}

	public void delete(ReadingFromCar readingFromCar){
		readingFromCarDao.delete(readingFromCar);
	}
	
}
