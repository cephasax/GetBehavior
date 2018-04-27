package br.ufrn.imd.master.getbehavior.testes;

import java.io.IOException;

import br.ufrn.imd.master.getbehavior.domain.MachineLearningModel;
import br.ufrn.imd.master.getbehavior.domain.ReadingFromCar;
import br.ufrn.imd.master.getbehavior.utils.ReadingFromCarUtils;
import weka.core.Instance;

public class ModelTest {

	public static MachineLearningModel mlm;
	public static ReadingFromCar rdf;
	
	
	public static void main(String[] args) throws IOException {
		
		makeAndLoadModel();
		makeReadingFromCar();
		
		ReadingFromCarUtils rfu = new ReadingFromCarUtils();
		Instance instance = rfu.readingFromCarToWekaInstance(rdf);
		
		rfu.getDataset().add(instance);
		
		System.out.println(rfu.getDataset().toString() + "\n");
		
		double value = -1;
		try {
			value = mlm.getCls().classifyInstance(rfu.getDataset().get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//get the name of the class value
		String prediction = new String(); 
		prediction = new String(rfu.getDataset().classAttribute().value((int)value));
		
		rfu.getDataset().get(0).setClassValue(prediction);
		
		System.out.println("Prediction: " + prediction + "\n");
		
		System.out.println(rfu.getDataset().toString() + "\n");
		
		System.out.println(rfu.getDataset().get(0).toString());
	}

	public static void makeReadingFromCar() {
		rdf = new ReadingFromCar("KIS-4509","10-02-2018");
		
		rdf.setEngineCoolantTemp(0.1342);
		rdf.setEngineLoad(0.1543);
		rdf.setEngineRpm(0.1346);
		rdf.setIntakeManifoldPressure(0.1356);
		rdf.setMaf(0.1523);
		rdf.setSpeed(0.1563);
		rdf.setShortTermFuelTrimBank1(0.1352);
		rdf.setThrottlePos(0.1342);
		rdf.setTimingAdvance(0.1523);
	}
	
	public static void makeAndLoadModel() {
		mlm = new MachineLearningModel();
		mlm.loadModel();
	}
}
