package edu.usal.negocio.ws;

import java.sql.SQLException;
import java.util.Date;

import javax.jws.WebService;

import edu.usal.negocio.dominio.Tarjeta;
import edu.usal.negocio.factory.TarjetaFactory;
import edu.usal.negocio.interfaces.TarjetaDAO;

@WebService(endpointInterface="edu.usal.negocio.ws.MyInterface")
public class Implement implements MyInterface{

	private TarjetaDAO dao;

	@Override
	public Tarjeta alta(Tarjeta tar, int DNI_usuario) {
		 dao = TarjetaFactory.getTarjetaDAO("sql");
		try {
			return dao.alta(tar, DNI_usuario);
		}catch(SQLException e) {
			return null;
		}
		
	}



	@Override
	public Tarjeta modificar(int Nro_tarjeta, String Nueva_fecha) {
		 dao = TarjetaFactory.getTarjetaDAO("sql");
		try {
			return dao.modificar(Nro_tarjeta, Nueva_fecha);
		}catch(SQLException e) {
			return null;
		}
		
	}

	@Override
	public Tarjeta leer(int Nro_tarjeta) {
		dao = TarjetaFactory.getTarjetaDAO("sql");
		try {
			return dao.leer(Nro_tarjeta);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	
	}


}
