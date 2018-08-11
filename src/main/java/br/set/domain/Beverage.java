package br.set.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Beverage extends Item{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idBeverage;
	
	private String marca; 
	private String tipo;
	private String embalagem ;
	private String ncm;
	private float cfop;
	private float volume;
	private int qtd;
	private float valor;
	private String produto;

	public Integer getIdBeverage() {
		return idBeverage;
	}

	public void setIdBeverage(Integer idBeverage) {
		this.idBeverage = idBeverage;
	}

	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getEmbalagem() {
		return embalagem;
	}
	
	public void setEmbalagem(String embalagem) {
		this.embalagem = embalagem;
	}
	
	public String getNcm() {
		return ncm;
	}
	
	public void setNcm(String ncm) {
		this.ncm = ncm;
	}
	
	public float getCfop() {
		return cfop;
	}
	
	public void setCfop(float cfop) {
		this.cfop = cfop;
	}
	
	public float getVolume() {
		return volume;
	}
	
	public void setVolume(float volume) {
		this.volume = volume;
	}
	public int getQtd() {
		return qtd;
	}
	
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	
	public float getValor() {
		return valor;
	}
	
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public String getProduto() {
		return produto;
	}
	
	public void setProduto(String produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "Beverage [marca=" + marca + ", tipo=" + tipo + ", embalagem=" + embalagem + ", ncm=" + ncm + ", cfop="
				+ cfop + ", volume=" + volume + ", qtd=" + qtd + ", valor=" + valor + ", produto=" + produto + "]";
	}
	
	
}
