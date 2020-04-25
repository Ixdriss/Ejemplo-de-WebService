package edu.usal.negocio.dao.implementacion.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import edu.usal.negocio.dominio.Tarjeta;
import edu.usal.negocio.interfaces.TarjetaDAO;
import edu.usal.util.Coneccion;

public class TarjetaDAOsql implements TarjetaDAO{
	
	Connection con;
	Statement stm;
	PreparedStatement prep;
	String query;
	String query2;
	String query3;
	String query4;
	

	public Tarjeta alta(Tarjeta tar, int DNI_usuario) throws SQLException{
		con = Coneccion.iniciarConeccion();
		try {
			if(!con.isClosed()) {
				
				
				con.setAutoCommit(false);
				
				query = ("SELECT * FROM Usuario WHERE Dni=?;");
				prep = con.prepareStatement(query);
				
				prep.setInt(1,DNI_usuario);
				ResultSet rs = prep.executeQuery();
		
				if(rs.next()) {
				
				tar.setIdcliente(rs.getInt(1));}
					
				query = ("INSERT INTO Tarjetas VALUES (?,?,?,?,?);");
				prep = con.prepareStatement(query);
				
				
				prep.setInt(1, tar.getNro());
				prep.setString(2, tar.getMarca());
				prep.setString(3, tar.getFechavenc());
				prep.setString(4,tar.getTipo());
				prep.setInt(5,tar.getIdcliente());
				
				prep.executeUpdate();
		
				
							query = "SELECT * FROM Tarjetas WHERE Nro_tarjeta=?";
							prep = con.prepareStatement(query);
							prep.setInt(1, tar.getNro());
						
						
							ResultSet rss = prep.executeQuery();
							if(rss.next()) {
							
							tar.setId(rss.getInt(1));
							}
				}
				
				
				prep.close();

				
					con.commit();
					con.close();
						
						
						
						return tar;
				
			}catch (SQLException e) {
			
			e.printStackTrace();
		}
		con.rollback();
		prep.close();
		con.close();
		return null;
	}
	
	
	public Tarjeta modificar(int Nro_tarjeta, String Nueva_fecha) throws SQLException {
		con = Coneccion.iniciarConeccion();
		Tarjeta tar=new Tarjeta();
		
		try {
			if(!con.isClosed()) {
				query = "UPDATE Tarjetas SET Fecha_vencimiento=? WHERE Nro_tarjeta=?";
				prep = con.prepareStatement(query);
				

				prep.setString(1, Nueva_fecha);
				prep.setInt(2,Nro_tarjeta);
				
				prep.executeUpdate();
				prep.close();
				
									query2 = "SELECT * FROM Tarjetas WHERE Nro_tarjeta=?";
									prep = con.prepareStatement(query2);
									prep.setInt(1, Nro_tarjeta);
								
								
									ResultSet rs = prep.executeQuery();
									if(rs.next()) {
										
										tar.setId(rs.getInt(1));
										tar.setNro(rs.getInt(2));
										tar.setMarca(rs.getString(3));
										tar.setFechavenc(rs.getString(4));
										tar.setTipo(rs.getString(5));
										tar.setIdcliente(rs.getInt(6));
											
										}else {
											return null;
										}
				
					prep.close();
					con.close();
					return tar;
				
			}} catch (SQLException e) {
			e.printStackTrace();
		}
		prep.close();
		con.close();
		return null;
	}
	
	public Tarjeta leer(int Nro_tarjeta) throws SQLException {
	
		Tarjeta tarjeta=new Tarjeta();
		con = Coneccion.iniciarConeccion();
		if(!con.isClosed()) {
			PreparedStatement prep=null;
			
				query = "SELECT * FROM Tarjetas WHERE Nro_tarjeta=?";
				prep = con.prepareStatement(query);
				prep.setInt(1, Nro_tarjeta);
			
			
			ResultSet rs = prep.executeQuery();
			
			if(rs.next()) {
			tarjeta.setId(rs.getInt(1));
			tarjeta.setNro(rs.getInt(2));
			tarjeta.setMarca(rs.getString(3));
			tarjeta.setFechavenc(rs.getString(4));
			tarjeta.setTipo(rs.getString(5));
			tarjeta.setIdcliente(rs.getInt(6));
				
			}else {
				return null;
			}
			rs.close();
			prep.close();
			con.close();
			return tarjeta;
		}
		return null;
		
	}
	
	
	
}
