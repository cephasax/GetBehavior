package br.set.testes;

import java.io.IOException;

import br.set.domain.Beverage;
import br.set.domain.BeverageMachineLearningModel;
import br.set.utils.BeverageUtils;
import weka.core.Instance;

public class ModelTest {

	public static BeverageMachineLearningModel bmlm;
	public static Beverage beverage;
	
	
	public static void main(String[] args) throws IOException {
		
		makeAndLoadModel();
		makeBeverage();
		
		BeverageUtils rfu = new BeverageUtils();
		Instance instance = rfu.beverageToWekaInstance(beverage);
		
		rfu.getDataset().add(instance);
		
		System.out.println(rfu.getDataset().toString() + "\n");
		
		double value = -1;
		try {
			value = bmlm.getCls().classifyInstance(rfu.getDataset().get(0));
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

	public static void makeBeverage() {
		beverage = new Beverage();
		
		beverage.setMarca("SCHIN");
		beverage.setTipo("GUARANA");
		beverage.setEmbalagem("PET");
		beverage.setNcm("22021000");
		beverage.setCfop(5405);
		beverage.setVolume(2000);
		beverage.setQtd(1);
		beverage.setValor((float) 2.99);
		beverage.setProduto("DIVERSOS");
	}
	
	public static void makeAndLoadModel() {
		bmlm = new BeverageMachineLearningModel();
		bmlm.loadModel();
	}
}
