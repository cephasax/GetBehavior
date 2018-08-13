package br.set.domain;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import weka.classifiers.Classifier;
import weka.core.SerializationHelper;

/**
 * @author cephas
 *
 */
@Singleton
public class BeverageMachineLearningModel {

	private Classifier cls;
	private String modelName;
		
	@PostConstruct
	public void loadModel() {
		//choose and load model - 
		
		//server
		//this.modelName = new String("C:\\Users\\Administrator\\Documents\\workspace\\iaWork\\GetBehavior\\src\\main\\resources\\modelo_set_final.model");
		
		//local pc
		this.modelName = new String("C:\\Users\\cephas\\Documents\\Workspace\\iaWork\\GetBehavior\\src\\main\\resources\\modelo_set_final.model");
		
		
		try {
			this.cls = (Classifier) SerializationHelper.read(modelName);
			
		} catch (Exception e) {
			System.out.println("Nao foi poss�vel carregar o modelo - motivo: \n");
			e.printStackTrace();
		}		
	}

	public Classifier getCls() {
		return cls;
	}

	public void setCls(Classifier cls) {
		this.cls = cls;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

}
