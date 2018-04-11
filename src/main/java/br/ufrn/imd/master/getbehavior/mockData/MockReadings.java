package br.ufrn.imd.master.getbehavior.mockData;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.ThreadLocalRandom;

import br.ufrn.imd.master.getbehavior.domain.ReadingFromCar;
import br.ufrn.imd.master.getbehavior.utils.DateParser;

public class MockReadings {
	
	public static ArrayList<ReadingFromCar> createReadings(){
		
		ArrayList<ReadingFromCar> readings = new ArrayList<ReadingFromCar>();
		ArrayList<String> placas = new ArrayList<String>();
		placas.add(new String("MTC-4052"));
		placas.add(new String("IET-5682"));
		placas.add(new String("JZC-6601"));
		placas.add(new String("MZF-6638"));
		placas.add(new String("KIZ-5481"));
		placas.add(new String("MPJ-8698"));
		placas.add(new String("KFE-0204"));
		placas.add(new String("KGM-5852"));
		placas.add(new String("LZH-2182"));
		placas.add(new String("LWI-2246"));
		
		for(String s: placas) {
			Calendar c = Calendar.getInstance();
			ReadingFromCar rfc = new ReadingFromCar(s, DateParser.formatDate(c.getTime()));
			
			rfc.setEngineCoolantTemp(randomDouble());
			rfc.setEngineLoad(randomDouble());
			rfc.setEngineRpm(randomDouble());
			rfc.setIntakeManifoldPressure(randomDouble());
			rfc.setMaf(randomDouble());
			rfc.setSpeed(randomDouble());
			rfc.setShortTermFuelTrimBank1(randomDouble());
			rfc.setThrottlePos(randomDouble());
			rfc.setTimingAdvance(randomDouble());
			
			readings.add(rfc);
		}
		
		return readings;
	}
	
	private static double randomDouble() {
		double min = 0;
		double max = 1;
		
		double random = ThreadLocalRandom.current().nextDouble(min, max);

		return round(random, 4);
	}
	
	private static double round(double value, int places) {
	    if (places < 0) {
	    	throw new IllegalArgumentException();
	    }
	 
	    BigDecimal bd = new BigDecimal(Double.toString(value));
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
}
