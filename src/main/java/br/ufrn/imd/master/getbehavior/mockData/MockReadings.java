package br.ufrn.imd.master.getbehavior.mockData;

import java.util.ArrayList;
import java.util.Calendar;

import br.ufrn.imd.master.getbehavior.domain.ReadingFromCar;
import br.ufrn.imd.master.getbehavior.utils.DateParser;
import br.ufrn.imd.master.getbehavior.utils.DoubleWorker;

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
			
			rfc.setEngineCoolantTemp(DoubleWorker.randomDouble());
			rfc.setEngineLoad(DoubleWorker.randomDouble());
			rfc.setEngineRpm(DoubleWorker.randomDouble());
			rfc.setIntakeManifoldPressure(DoubleWorker.randomDouble());
			rfc.setMaf(DoubleWorker.randomDouble());
			rfc.setSpeed(DoubleWorker.randomDouble());
			rfc.setShortTermFuelTrimBank1(DoubleWorker.randomDouble());
			rfc.setThrottlePos(DoubleWorker.randomDouble());
			rfc.setTimingAdvance(DoubleWorker.randomDouble());
			
			readings.add(rfc);
		}
		
		return readings;
	}
	
	
	
}
