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
	
		attributes.add(new Attribute("marca", createMarcas()));
		attributes.add(new Attribute("tipo", createTipos()));
		attributes.add(new Attribute("embalagem", createEmbalagens()));
		attributes.add(new Attribute("ncm", createNcms()));
		attributes.add(new Attribute("cfop"));
		attributes.add(new Attribute("volume"));
		attributes.add(new Attribute("qtd"));
		attributes.add(new Attribute("valor"));
	
		// Create Class Attribute
		attributes.add(new Attribute("produto", createValuesForClass()));
		
		return attributes;
	}
	
	//CREATE SPECIFIC NOMINAL VALUES FOR ATTRIBUTES
	private List<String> createMarcas(){
		List<String> marcas =  new ArrayList<String>();
		marcas.add("51");
		marcas.add("ABSOLUT");
		marcas.add("ADES");
		marcas.add("ALE");
		marcas.add("ANTARCTICA");
		marcas.add("ANTARTICA");
		marcas.add("BADEN_BADEN");
		marcas.add("BALLANTINES");
		marcas.add("BATON");
		marcas.add("BAVARIA");
		marcas.add("BLACK_PRINCESS");
		marcas.add("BLACK_STONE");
		marcas.add("BLACK_WHITE");
		marcas.add("BLANCA");
		marcas.add("BOBS");
		marcas.add("BOHEMIA");
		marcas.add("BOLVANA");
		marcas.add("BRAHMA");
		marcas.add("BUCHANANS");
		marcas.add("BUDWEISER");
		marcas.add("CACHACA_51");
		marcas.add("CARACU");
		marcas.add("CARANGUEJO");
		marcas.add("CASA_MADEIRA");
		marcas.add("CERPA");
		marcas.add("CHIVAS_REGAL");
		marcas.add("CHOKITO");
		marcas.add("CIROC");
		marcas.add("COCA_COLA");
		marcas.add("COCAR");
		marcas.add("CORONA");
		marcas.add("CORONITA");
		marcas.add("CRISTALINA");
		marcas.add("CRYSTAL");
		marcas.add("DAFRUTA");
		marcas.add("DEL_VALLE");
		marcas.add("DETOX");
		marcas.add("DEVASSA");
		marcas.add("DIAMANTE");
		marcas.add("DORE");
		marcas.add("DORFLEX");
		marcas.add("DRAMIM");
		marcas.add("EISENBAHM");
		marcas.add("EISENBAHN");
		marcas.add("ESSO");
		marcas.add("FANTA");
		marcas.add("FONTE_CLARA");
		marcas.add("GALIOTTO");
		marcas.add("GATORADE");
		marcas.add("GLENLIVET");
		marcas.add("GOSTOSA");
		marcas.add("GRAN_MACNISH");
		marcas.add("GRANTS");
		marcas.add("GRAPETTE");
		marcas.add("GREY_GOOSE");
		marcas.add("H2OH");
		marcas.add("HEINEKEN");
		marcas.add("ICE_COLA");
		marcas.add("IDAIA");
		marcas.add("INDAIA");
		marcas.add("INDAIA_CITRUS");
		marcas.add("IPIRANGA");
		marcas.add("ISIS");
		marcas.add("ITAIPAVA");
		marcas.add("JACK_DANIELS");
		marcas.add("JESUS");
		marcas.add("JOHN_WALKER_BLACK");
		marcas.add("JOHN_WALKER_RED");
		marcas.add("JOHNNIE_WALKER_BLUE");
		marcas.add("JUREMINHA");
		marcas.add("KADOV");
		marcas.add("KAISER");
		marcas.add("KAPO");
		marcas.add("KIBOM");
		marcas.add("KISLLA");
		marcas.add("KIT_KAT");
		marcas.add("KUAT");
		marcas.add("MARATA");
		marcas.add("MATUTA");
		marcas.add("MILLER");
		marcas.add("MINALBA");
		marcas.add("MR_DETOX");
		marcas.add("MULLER");
		marcas.add("NATASHA");
		marcas.add("NEOSORO");
		marcas.add("NINA");
		marcas.add("OLD_EIGHT");
		marcas.add("OLD_PARR");
		marcas.add("OLDEN_BLEND");
		marcas.add("ORLOFF");
		marcas.add("OURO_BRANCO");
		marcas.add("PALLOFF");
		marcas.add("PANIZZON");
		marcas.add("PASSPORT");
		marcas.add("PEPSI");
		marcas.add("PERGOLA");
		marcas.add("PETRA");
		marcas.add("PETROBRAS");
		marcas.add("PINHEIRO");
		marcas.add("PITU");
		marcas.add("POLAK");
		marcas.add("PROIBIDA");
		marcas.add("QUINTA_DO_MORGADO");
		marcas.add("RED_LABEL");
		marcas.add("REDE_OESTE");
		marcas.add("RUSSOV");
		marcas.add("SAGATIBA");
		marcas.add("SALINAS");
		marcas.add("SAMANAU");
		marcas.add("SANTA_MARIA");
		marcas.add("SAO_GERALDO");
		marcas.add("SCHIN");
		marcas.add("SERENATA_AMOR");
		marcas.add("SERRAMALTE");
		marcas.add("SHELL");
		marcas.add("SIMBA");
		marcas.add("SKINKA");
		marcas.add("SKOL");
		marcas.add("SKYY");
		marcas.add("SLOVA");
		marcas.add("SMIRNOFF");
		marcas.add("SODA");
		marcas.add("SOL");
		marcas.add("SPRITE");
		marcas.add("STELLA");
		marcas.add("STERBOM");
		marcas.add("SUFRESH");
		marcas.add("SUKITA");
		marcas.add("SUMO");
		marcas.add("TAMPICO");
		marcas.add("TEACHERS");
		marcas.add("THEREZOPOLIS");
		marcas.add("TYFLEN");
		marcas.add("VORUS");
		marcas.add("WHISKAS");
		marcas.add("WHITE_HORSE");
		marcas.add("WILLIAN_LAWSONS");
		marcas.add("YPIOCA");
		return marcas;
	}
	
	private List<String> createTipos(){
		List<String> tipos =  new ArrayList<String>();
		tipos.add("SEM_GAS");
		tipos.add("COM_GAS");
		tipos.add("PILSEN");
		tipos.add("LAGER");
		tipos.add("MALZIBIER");
		tipos.add("CHOPP");
		tipos.add("VERMELA");
		tipos.add("VERMELHA");
		tipos.add("BEATS");
		tipos.add("LIMAO");
		tipos.add("ABACAXI");
		tipos.add("COLA");
		tipos.add("UVA");
		tipos.add("LARANJA");
		tipos.add("GUARANA");
		tipos.add("TUTI_FRUTI");
		tipos.add("CAJU");
		tipos.add("ACEROLA");
		tipos.add("MARACUJA");
		tipos.add("CAJA");
		tipos.add("MORANGO");
		tipos.add("CITRUS");
		tipos.add("PESSEGO");
		tipos.add("MANGA");
		tipos.add("GOIABA");
		tipos.add("TANGERINA");
		tipos.add("TANJERINA");
		tipos.add("VODKA");
		tipos.add("CACHACA");
		tipos.add("WHISKY");
		tipos.add("DIESEL");
		tipos.add("ETANOL");
		tipos.add("GNV");
		tipos.add("GASOLINA");
		tipos.add("AO_LEITE");
		tipos.add("AOL_LEITE");
		tipos.add("AMARGO");
		tipos.add("BRANCO");
		tipos.add("MIXTO");
		tipos.add("COMPRIMIDO");
		tipos.add("NAZAL");
		tipos.add("ORAL");
		tipos.add("GATO");
		tipos.add("NAPOLITANO");
		tipos.add("FLOCOS");
		tipos.add("CHOCOLOATE");
		tipos.add("CREME");
		tipos.add("PASSAS");
		tipos.add("CHOCOLATE");
		tipos.add("BRIGADEIRO");
		tipos.add("COCO");
		return tipos;
	}

	private List<String> createEmbalagens(){
		List<String> embalagens = new ArrayList<String>();
		embalagens.add("GARRAFA");
		embalagens.add("COPO");
		embalagens.add("LATA");
		embalagens.add("LONG_NECK");
		embalagens.add("PET");
		embalagens.add("CAIXA");
		embalagens.add("AVULSO");
		embalagens.add("PAPEL");
		embalagens.add("FRASCO");
		embalagens.add("SACO");
		embalagens.add("POTE");
		return embalagens;
	}

	private List<String> createNcms(){
		List<String> ncms = new ArrayList<String>();
		ncms.add("22011000");
		ncms.add("1012900");
		ncms.add("11041900");
		ncms.add("22021000");
		ncms.add("22030000");
		ncms.add("21039091");
		ncms.add("22029000");
		ncms.add("0");
		ncms.add("2012090");
		ncms.add("22089000");
		ncms.add("33051000");
		ncms.add("2071400");
		ncms.add("19022000");
		ncms.add("20029010");
		ncms.add("96081000");
		ncms.add("96091000");
		ncms.add("39174090");
		ncms.add("34022000");
		ncms.add("20089900");
		ncms.add("49019900");
		ncms.add("3028990");
		ncms.add("82142000");
		ncms.add("20098990");
		ncms.add("20099000");
		ncms.add("20096100");
		ncms.add("9012100");
		ncms.add("20096900");
		ncms.add("11081400");
		ncms.add("4039000");
		ncms.add("4031000");
		ncms.add("38085010");
		ncms.add("10063029");
		ncms.add("38099190");
		ncms.add("4022930");
		ncms.add("38089419");
		ncms.add("34011900");
		ncms.add("21069010");
		ncms.add("22084000");
		ncms.add("1019000");
		ncms.add("96082000");
		ncms.add("19021900");
		ncms.add("21069029");
		ncms.add("96039000");
		ncms.add("22019000");
		ncms.add("20059900");
		ncms.add("34052000");
		ncms.add("8012200");
		ncms.add("8013200");
		ncms.add("20098100");
		ncms.add("27101932");
		ncms.add("28047020");
		ncms.add("34029031");
		ncms.add("22029900");
		ncms.add("22021001");
		ncms.add("32089039");
		ncms.add("23025000");
		ncms.add("20093100");
		ncms.add("20092100");
		ncms.add("20097100");
		ncms.add("21069090");
		ncms.add("21069030");
		ncms.add("22086000");
		ncms.add("22083020");
		ncms.add("22072020");
		ncms.add("22082000");
		ncms.add("10061010");
		ncms.add("22083010");
		ncms.add("22060010");
		ncms.add("27101921");
		ncms.add("22071090");
		ncms.add("27112100");
		ncms.add("27101259");
		ncms.add("84133010");
		ncms.add("18063110");
		ncms.add("30049039");
		ncms.add("23099010");
		ncms.add("21050010");
		return ncms;
	}
	
	//CREATE SPECIFIC NOMINAL VALUES FOR CLASS ATTRIBUTE

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
		
		double[] values = new double[dataset.numAttributes()];
		
		values[0] = dataset.attribute(0).indexOfValue(beverage.getMarca());
		values[1] = dataset.attribute(1).indexOfValue(beverage.getTipo());
		values[2] = dataset.attribute(2).indexOfValue(beverage.getEmbalagem());
		values[3] = dataset.attribute(3).indexOfValue(beverage.getNcm());
		values[4] = beverage.getCfop();
		values[5] = beverage.getVolume();
		values[6] = beverage.getQtd();
		values[7] = beverage.getValor();
		values[8] = dataset.attribute(8).indexOfValue(beverage.getProduto());
		
		Instance instance = new DenseInstance(1, values);
		return instance;
		
	}

	public static Beverage makeBeverageFromHashMap(HashMap<String,String> hash) throws ParseException{

		Beverage beverage = new Beverage();
		
		beverage.setMarca(hash.get("marca"));
		beverage.setTipo(hash.get("tipo"));
		beverage.setEmbalagem(hash.get("embalagem"));
		beverage.setNcm(hash.get("ncm"));
		beverage.setCfop(Double.valueOf(hash.get("cfop")));
		beverage.setVolume(Double.valueOf(hash.get("volume")));
		beverage.setQtd(Double.valueOf(hash.get("qtd")));
		beverage.setValor(Double.valueOf(hash.get("valor")));
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
