package br.set.resources;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.set.business.BeverageService;
import br.set.domain.Beverage;
import br.set.domain.BeverageMachineLearningModel;
import br.set.utils.BeverageUtils;
import br.ufrn.imd.master.getbehavior.utils.StringWorker;
import weka.core.Instance;

@Stateless
@Path("/set")
public class BeverageResource {
	
	@EJB
	private BeverageService service;
	
	@EJB
	private BeverageMachineLearningModel bmlm;
	
	// LIST
	@GET
	@Path("/beverage")
	@Produces("application/json; charset=UTF-8")
	public List<Beverage> listagem() {
		try {
			return service.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//FIND BY ID
	@GET
	@Path("/beverage/{id}")
	@Produces("application/json; charset=UTF-8")
	public Beverage buscaId(@PathParam("id") int id){
		Beverage beverage;
		try {
			beverage = service.findById(id);
			return beverage;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// CREATE
	@POST
	@Path("/beverage/one")
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	public Response newBeverage(String string) {
		
		System.out.println("recebido: " + string);
		try {
			Beverage b = BeverageUtils.makeBeverageFromHashMap(StringWorker.getHashMapFromString(string));
			b.setProduto(classifyBeverage(b));
			
			System.out.println("Classificada: " + b.toString());
			
			return Response.status(200).entity(string).build();
		}  
		catch (Exception e) {
			return Response.status(204).entity(string).build();
		}
	}

	// DELETE
	@DELETE
	@Path("/rfc/{id}")
	@Produces("application/json; charset=UTF-8")
	public Response delete(@PathParam("id") int id) {
		Beverage beverage = new Beverage();
		try {
			beverage = service.findById(id);
			service.delete(beverage);
			return Response.status(200).entity(beverage).build();
		}  catch (Exception e) {
			return Response.status(204).entity(beverage).build();
		}
	}

	private String classifyBeverage(Beverage beverage) {
		BeverageUtils bu = new BeverageUtils();
		
		Instance instance = bu.beverageToWekaInstance(beverage);
		
		bu.getDataset().add(instance);
		
		double value = -1;
		try {
			value = bmlm.getCls().classifyInstance(bu.getDataset().get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//get the name of the class value
		String prediction = null; 
		prediction = new String(bu.getDataset().classAttribute().value((int)value));
		
		return prediction;

	}
}
