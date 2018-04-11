package br.ufrn.imd.master.getbehavior.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import br.ufrn.imd.master.getbehavior.utils.DateParser;

@Entity
public class ReadingFromCar extends Reading implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idReadingFromCar;
	
	@NotNull
	private String vehicleId;
	
	private double engineCoolantTemp;
	private double engineLoad; 
	private double engineRpm;
	private double intakeManifoldPressure; 
	private double maf;
	private double speed;
	private double shortTermFuelTrimBank1; 
	private double throttlePos; 
	private double timingAdvance;
	
	@ManyToOne
	@JoinColumn(name = "idElement")
	private Element element;
	
	public ReadingFromCar() {}
	
	public ReadingFromCar(String vehicleId, String date) {
		this.vehicleId = vehicleId;
		this.element = new Element();
		
		try {
			this.element.setDate(DateParser.parseString(date));
		} catch (Exception e) {
			this.element.setDate(null);
			e.printStackTrace();
		}
	}
	
	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Integer getIdReadingFromCar() {
		return idReadingFromCar;
	}

	public void setIdReadingFromCar(Integer idReadingFromCar) {
		this.idReadingFromCar = idReadingFromCar;
	}

	public double getEngineCoolantTemp() {
		return engineCoolantTemp;
	}
	
	public void setEngineCoolantTemp(double engineCoolantTemp) {
		this.engineCoolantTemp = engineCoolantTemp;
	}
	
	public double getEngineLoad() {
		return engineLoad;
	}
	
	public void setEngineLoad(double engineLoad) {
		this.engineLoad = engineLoad;
	}
	
	public double getEngineRpm() {
		return engineRpm;
	}
	
	public void setEngineRpm(double engineRpm) {
		this.engineRpm = engineRpm;
	}
	
	public double getIntakeManifoldPressure() {
		return intakeManifoldPressure;
	}
	
	public void setIntakeManifoldPressure(double intakeManifoldPressure) {
		this.intakeManifoldPressure = intakeManifoldPressure;
	}
	
	public double getMaf() {
		return maf;
	}
	
	public void setMaf(double maf) {
		this.maf = maf;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public double getShortTermFuelTrimBank1() {
		return shortTermFuelTrimBank1;
	}
	
	public void setShortTermFuelTrimBank1(double shortTermFuelTrimBank1) {
		this.shortTermFuelTrimBank1 = shortTermFuelTrimBank1;
	}
	
	public double getThrottlePos() {
		return throttlePos;
	}
	
	public void setThrottlePos(double throttlePos) {
		this.throttlePos = throttlePos;
	}
	
	public double getTimingAdvance() {
		return timingAdvance;
	}
	
	public void setTimingAdvance(double timingAdvance) {
		this.timingAdvance = timingAdvance;
	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	@Override
	public String toString() {
		return "ReadingFromCar: " + "\n"
				+ " vehicleId = " + vehicleId + "\n"
				+ " engineCoolantTemp = " + engineCoolantTemp + "\n"
				+ " engineLoad = " + engineLoad + "\n"
				+ " engineRpm = " + engineRpm + "\n"
				+ " intakeManifoldPressure = " + intakeManifoldPressure + "\n"
				+ " maf = " + maf +"\n"
				+ " speed = " + speed +"\n"
				+ " shortTermFuelTrimBank1 = " + shortTermFuelTrimBank1 + "\n"
				+ " throttlePos = " + throttlePos + "\n"
				+ " timingAdvance = " + timingAdvance + "\n"
				+ " elementDate = " + DateParser.formatDate(element.getDate()) + "\n"
				+ " predictedValue = " + element.getPredictedValue();
	}	
	
}