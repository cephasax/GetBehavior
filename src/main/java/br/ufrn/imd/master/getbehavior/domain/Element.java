package br.ufrn.imd.master.getbehavior.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Element implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idElement;

	@Temporal(TemporalType.DATE)
	private Date date;
	
	private String predictedValue;
	
	protected Element() {
		this.date = new Date();
		this.predictedValue = new String("cluster1");
	}
	
	public Integer getIdElement() {
		return idElement;
	}

	public void setIdElement(Integer idElement) {
		this.idElement = idElement;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPredictedValue() {
		return predictedValue;
	}

	public void setPredictedValue(String predictedValue) {
		this.predictedValue = predictedValue;
	}
	
}
