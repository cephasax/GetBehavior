package br.ufrn.imd.master.getbehavior.utils;

import java.text.ParseException;
import java.util.HashMap;

import br.ufrn.imd.master.getbehavior.domain.Element;
import br.ufrn.imd.master.getbehavior.domain.ReadingFromCar;

public class ReadingFromCarWorker {
	
	public static ReadingFromCar makeReadingFromHashMap(HashMap<String,String> hash) throws ParseException{

		String vehicleId = new String(hash.get("vehicleId"));
		String date = new String(hash.get("date"));
		
		Element element = new Element();
		
		ReadingFromCar reading = new ReadingFromCar(vehicleId, date);
		
		reading.setEngineCoolantTemp(Double.valueOf(hash.get("engineCoolantTemp")));
		reading.setEngineLoad(Double.valueOf(hash.get("engineLoad")));
		reading.setEngineRpm(Double.valueOf(hash.get("engineRpm")));
		reading.setIntakeManifoldPressure(Double.valueOf(hash.get("intakeManifoldPressure")));
		reading.setMaf(Double.valueOf(hash.get("maf")));
		reading.setSpeed(Double.valueOf(hash.get("speed")));
		reading.setShortTermFuelTrimBank1(Double.valueOf(hash.get("shortTermFuelTrimBank1")));
		reading.setThrottlePos(Double.valueOf(hash.get("throttlePos")));
		reading.setTimingAdvance(Double.valueOf(hash.get("timingAdvance")));
		
		element.setDate(DateParser.parseString(date));
		
		reading.setElement(element);
		
		return reading;
		
		
	}

}
