package edu.usal.negocio.interfaces;

import java.sql.SQLException;
import java.util.Date;

import edu.usal.negocio.dominio.Tarjeta;

public interface TarjetaDAO {

	public Tarjeta alta(Tarjeta tar, int DNI_usuario) throws SQLException;
	public Tarjeta modificar(int Nro_tarjeta, String Nueva_fecha) throws SQLException;
	public Tarjeta leer(int Nro_tarjeta) throws SQLException;
	
}
