package edu.usal.negocio.factory;

import edu.usal.negocio.dao.implementacion.SQL.TarjetaDAOsql;
import edu.usal.negocio.interfaces.TarjetaDAO;

public class TarjetaFactory {

	public static TarjetaDAO getTarjetaDAO(String datasource){
		
		if(datasource.equals("sql")) {
			return new TarjetaDAOsql();
		}else {
		return null;
}
}
}
