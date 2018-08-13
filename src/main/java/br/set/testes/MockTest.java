package br.set.testes;

import java.util.ArrayList;

import br.ufrn.imd.master.getbehavior.domain.ReadingFromCar;
import br.ufrn.imd.master.getbehavior.mockdata.MockReadings;

public class MockTest {

	public static void main(String[] args) {
		ArrayList<ReadingFromCar> readings = MockReadings.createReadings();

		for (ReadingFromCar r: readings) {
			System.out.println(r.toString());
			System.out.println();
		}
	}

}
