package br.ufrn.imd.master.getbehavior.utils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.ufrn.imd.master.getbehavior.domain.Element;
import br.ufrn.imd.master.getbehavior.domain.ReadingFromCar;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

/**
 * 
 * @author cephas
 *
 *	attribute sequence and names for ReadingFromCar Instance:
 *		engineCoolantTemp
 *		engineLoad
 *		engineRpm
 *		intakeManifoldPressure 
 *		maf
 *		speed
 *		shortTermFuelTrimBank1 
 *		throttlePos
 *		timingAdvance
 *		cluster
 */

public class ReadingFromCarUtils {
	
	private Instances dataset;
	private ArrayList<Attribute> attributes;
	
	public ReadingFromCarUtils() {
		createInstances();
	}
	
	private void createInstances() {
		this.dataset = new Instances("dataset", createAttributesToReadingFromCar(), 0);
		this.dataset.setClassIndex(this.dataset.numAttributes() - 1);;
	}
	
	private ArrayList<Attribute> createAttributesToReadingFromCar() {
		
		this.attributes = new ArrayList<Attribute>();
	
		attributes.add(new Attribute("engineCoolantTemp"));
		attributes.add(new Attribute("engineLoad"));
		attributes.add(new Attribute("engineRpm"));
		attributes.add(new Attribute("intakeManifoldPressure"));
		attributes.add(new Attribute("maf"));
		attributes.add(new Attribute("speed"));
		attributes.add(new Attribute("shortTermFuelTrimBank1"));
		attributes.add(new Attribute("throttlePos"));
		attributes.add(new Attribute("timingAdvance"));
	
		// Create Class Attribute
		attributes.add(new Attribute("cluster", createValuesForClass()));
		
		return attributes;
	}
	
	private List<String> createValuesForClass() {

		List<String> classValues = new ArrayList<String>();

		classValues.add(new String("cluster1"));
		classValues.add(new String("cluster2"));
		classValues.add(new String("cluster3"));

		return classValues;
	}
		
	public Instance readingFromCarToWekaInstance(ReadingFromCar readingFromCar) {
		
		double[] values = new double[dataset.numAttributes()];

		values[0] = readingFromCar.getEngineCoolantTemp();
		values[1] = readingFromCar.getEngineLoad();
		values[2] = readingFromCar.getEngineRpm();
		values[3] = readingFromCar.getIntakeManifoldPressure();
		values[4] = readingFromCar.getMaf();
		values[5] = readingFromCar.getSpeed();
		values[6] = readingFromCar.getShortTermFuelTrimBank1();
		values[7] = readingFromCar.getThrottlePos();
		values[8] = readingFromCar.getTimingAdvance();
		values[9] = dataset.attribute(9).indexOfValue(readingFromCar.getElement().getPredictedValue());
		
		Instance instance = new DenseInstance(1, values);
		
		return instance;
		
	}

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
	
 	public Instances getDataset() {
		return dataset;
	}

	public void setDataset(Instances dataset) {
		this.dataset = dataset;
	}
	
}
