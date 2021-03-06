package br.ufrn.imd.master.getbehavior.resource;

import java.util.ArrayList;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import br.ufrn.imd.master.getbehavior.business.ReadingFromCarService;
import br.ufrn.imd.master.getbehavior.domain.MachineLearningModel;
import br.ufrn.imd.master.getbehavior.domain.ReadingFromCar;
import br.ufrn.imd.master.getbehavior.utils.ReadingFromCarUtils;
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

	// FIND ALL BY VEHICLE ID
	//returns all classified data from one car
	@GET
	@Path("/rfc/vehicle")
	@Produces("application/json; charset=UTF-8")
	public ArrayList<ReadingFromCar> findByVehicleId(@QueryParam("vehicleId") String vehicleId) {
		ArrayList<ReadingFromCar> readingsFromCar = new ArrayList<ReadingFromCar>();
		try {
			readingsFromCar = service.findByVehicleId(vehicleId);
			return readingsFromCar;
		}  catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// FIND LAST BY VEHICLE ID
	//returns last classified data from one car
	@GET
	@Path("/rfc/vehicle/last")
	@Produces("application/json; charset=UTF-8")
	public ReadingFromCar findLastReadingByVehicleId(@QueryParam("vehicleId") String vehicleId) {
		System.out.println(vehicleId);
		ReadingFromCar readingFromCar;
		try {
			readingFromCar = service.findLastReadingByVehicleId(vehicleId);
			return readingFromCar;
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
		
		System.out.println("recebido: " + string);
		try {
			ReadingFromCar r = ReadingFromCarUtils.makeReadingFromHashMap(StringWorker.getHashMapFromString(string));
			r.getElement().setPredictedValue(classifyReadingFromCar(r));
			
			System.out.println("Classificada: " + r.toString());
			service.save(r);
			
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
