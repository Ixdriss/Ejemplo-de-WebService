package edu.usal.negocio.dominio;

import java.io.Serializable;
import java.util.Date;

public class Tarjeta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int nro;
	private String marca;
	private String fechavenc;
	private String tipo;
	private int idcliente;
	
	public Tarjeta() {
		
	}
	
	public Tarjeta(int nro, String marca, String fechavenc, String tipo, int idc) {
		
		this.nro = nro;
		this.marca = marca;
		this.fechavenc = fechavenc;
		this.tipo = tipo;
		this.idcliente=idc;
	}
	
	

	
	
	public String getMarca() {
		return marca;
	}

	public int getNro() {
		return nro;
	}

	public void setNro(int nro) {
		this.nro = nro;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getFechavenc() {
		return fechavenc;
	}

	public void setFechavenc(String fechavenc) {
		this.fechavenc = fechavenc;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
