package br.ufrn.imd.master.getbehavior.resource;

import java.util.HashMap;
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

import br.ufrn.imd.master.getbehavior.business.ReadingFromCarService;
import br.ufrn.imd.master.getbehavior.domain.MachineLearningModel;
import br.ufrn.imd.master.getbehavior.domain.ReadingFromCar;
import br.ufrn.imd.master.getbehavior.utils.ReadingFromCarUtils;
import br.ufrn.imd.master.getbehavior.utils.ReadingFromCarWorker;
import br.ufrn.imd.master.getbehavior.utils.StringWorker;
import weka.core.Instance;

@Stateless
@Path("/getbehavior")
public class ReadingFromCarResource {
	
	@EJB
	private ReadingFromCarService service;
	
	@EJB
	private MachineLearningModel mlm;

	
	// LIST
	@GET
	@Path("/rfc")
	@Produces("application/json; charset=UTF-8")
	public List<ReadingFromCar> listagem() {
		try {
			return service.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// FIND BY ID
	@GET
	@Path("/rfc/{id}")
	@Produces("application/json; charset=UTF-8")
	public ReadingFromCar findById(@PathParam("id") int id) {
		ReadingFromCar rfc;
		try {
			rfc = service.findById(id);
			return rfc;
		}  catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// FIND BY VEHICLE ID
	//returns the last classified data from this car
	@GET
	@Path("/rfc/vehicle/{id}")
	@Produces("application/json; charset=UTF-8")
	public ReadingFromCar findByVehicleId(@PathParam("id") int id) {
		ReadingFromCar rfc;
		try {
			rfc = service.findByVehicleId(id);
			return rfc;
		}  catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// CREATE
	@POST
	@Path("/rfc")
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	public Response newReadingFromCar(String string) {
		
		try {
			
			HashMap<String, String> hashMap = StringWorker.hashMapFromString(string);
			
			ReadingFromCar oldReading;
			oldReading = ReadingFromCarWorker.makeReadingFromHashMap(hashMap);
			String classValue = new String(classifyReadingFromCar(oldReading));
			oldReading.getElement().setPredictedValue(classValue);
		
			service.save(oldReading);
			System.out.println(oldReading.toString());
			
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
		ReadingFromCar rfc = new ReadingFromCar();
		try {
			rfc = service.findById(id);
			service.delete(rfc);
			return Response.status(200).entity(rfc).build();
		}  catch (Exception e) {
			return Response.status(204).entity(rfc).build();
		}
	}

	private String classifyReadingFromCar(ReadingFromCar reading) {
		ReadingFromCarUtils rfu = new ReadingFromCarUtils();
		
		Instance instance = rfu.readingFromCarToWekaInstance(reading);
		
		rfu.getDataset().add(instance);
		
		double value = -1;
		try {
			value = mlm.getCls().classifyInstance(rfu.getDataset().get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//get the name of the class value
		String prediction = null; 
		prediction = new String(rfu.getDataset().classAttribute().value((int)value));
		
		return prediction;

	}
}
