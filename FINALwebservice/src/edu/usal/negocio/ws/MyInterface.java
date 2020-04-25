package edu.usal.negocio.ws;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import edu.usal.negocio.dominio.Tarjeta;

@WebService
public interface MyInterface {

	@WebMethod
	public Tarjeta alta(Tarjeta tar, @WebParam (name="DNIusuario")int DNI_usuario);
	
	
	@WebMethod
	public Tarjeta modificar(@WebParam (name="NROtarjeta")int Nro_tarjeta,@WebParam (name="NuevaFecha") String Nueva_fecha);
	
	@WebMethod
	public Tarjeta leer(@WebParam (name="NROtarjeta")int Nro_tarjeta);
	
	}
