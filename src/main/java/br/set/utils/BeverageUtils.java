package br.set.utils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.set.domain.Beverage;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

/**
 * 
 * @author cephas
 *
 *	attribute sequence and names for Beverage Instance:
 *		marca
 *		tipo
 *		embalagem
 *		ncm
 *		cfop
 *		volume
 *		qtd
 *		valor
 *		produto
 *
 */

public class BeverageUtils {
	
	private Instances dataset;
	private ArrayList<Attribute> attributes;
	
	public BeverageUtils() {
		createInstances();
	}
	
	private void createInstances() {
		this.dataset = new Instances("dataset", createAttributesToBeverage(), 0);
		this.dataset.setClassIndex(this.dataset.numAttributes() - 1);;
	}
	
	private ArrayList<Attribute> createAttributesToBeverage() {
		
		this.attributes = new ArrayList<Attribute>();
	
		attributes.add(new Attribute("marca"));
		attributes.add(new Attribute("tipo"));
		attributes.add(new Attribute("embalagem"));
		attributes.add(new Attribute("ncm"));
		attributes.add(new Attribute("cfop"));
		attributes.add(new Attribute("volume"));
		attributes.add(new Attribute("qtd"));
		attributes.add(new Attribute("valor"));
	
		// Create Class Attribute
		attributes.add(new Attribute("produto", createValuesForClass()));
		
		return attributes;
	}
	
	private List<String> createValuesForClass() {

		List<String> classValues = new ArrayList<String>();

		classValues.add(new String("AGUA"));
		classValues.add(new String("CERVEJA"));
		classValues.add(new String("REFRIGERANTE"));
		classValues.add(new String("SUCO"));
		classValues.add(new String("DESTILADO"));
		classValues.add(new String("DIVERSOS"));
		return classValues;
	}
		
	public Instance beverageToWekaInstance(Beverage beverage) {
		
		Instance inst = new DenseInstance(9); 
				
		inst.setValue(0, beverage.getMarca());
		inst.setValue(1, beverage.getTipo());
		inst.setValue(2, beverage.getEmbalagem());
		inst.setValue(3, beverage.getNcm());
		inst.setValue(4, beverage.getCfop());
		inst.setValue(5, beverage.getVolume());
		inst.setValue(6, beverage.getQtd());
		inst.setValue(7, beverage.getValor());
		inst.setValue(8, beverage.getProduto());
		
		return inst;
		
	}

	public static Beverage makeBeverageFromHashMap(HashMap<String,String> hash) throws ParseException{

		Beverage beverage = new Beverage();
		
		beverage.setMarca(hash.get("marca"));
		beverage.setTipo(hash.get("tipo"));
		beverage.setEmbalagem(hash.get("embalagem"));
		beverage.setNcm(hash.get("ncm"));
		beverage.setCfop(Integer.valueOf(hash.get("cfop")));
		beverage.setVolume(Float.valueOf(hash.get("volume")));
		beverage.setQtd(Float.valueOf(hash.get("qtd")));
		beverage.setValor(Float.valueOf(hash.get("valor")));
		beverage.setProduto(hash.get("produto"));

		return beverage;
	}
	
 	public Instances getDataset() {
		return dataset;
	}

	public void setDataset(Instances dataset) {
		this.dataset = dataset;
	}
	
}
