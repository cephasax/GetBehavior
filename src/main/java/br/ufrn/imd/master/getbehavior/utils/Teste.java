package br.ufrn.imd.master.getbehavior.utils;

import java.util.HashMap;

public class Teste {

	public static void main(String[] args) {
		
		HashMap<String, String> hash = StringWorker.ReadingFromHashString(
					"engineRpm:0.7538,"
				+ 	" engineLoad:0.8195,"
				+ 	" speed:0.2398,"
				+ 	" idReadingFromCar:0,"
				+ 	" intakeManifoldPressure:0.4863,"
				+ 	" vehicleId:MTC-4052,"
				+ 	" predictedValue:cluster1,"
				+ 	" date:2018-04-16,"
				+ 	" idElement:0,"
				+ 	" maf:0.8129,"
				+ 	" timingAdvance:0.8278,"
				+ 	" throttlePos:0.3833,"
				+ 	" shortTermFuelTrimBank1:0.4165,"
				+ 	" engineCoolantTemp:0.7737"
				);
		//System.out.println(hash.toString());
		
	}

}
