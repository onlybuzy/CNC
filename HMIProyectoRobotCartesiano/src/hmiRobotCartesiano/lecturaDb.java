package hmiRobotCartesiano;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class lecturaDb {
	
	public String coordenadaX;
	public String coordenadaY;
	public String tabla;
	public List<ArrayList<Integer>> data = new ArrayList<>();
	
	public String getCoordenadaX() {
		return coordenadaX;
	}

	public void setCoordenadaX(String coordenadaX) {
		this.coordenadaX = coordenadaX;
	}

	public String getCoordenadaY() {
		return coordenadaY;
	}

	public void setCoordenadaY(String coordenadaY) {
		this.coordenadaY = coordenadaY;
	}

	public String getTabla() {
		return tabla;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public List<ArrayList<Integer>> leerDb() {
		
		conexionDbUrl con1 = new conexionDbUrl();
		
		String urlDb = "jdbc:mysql://www.onlybuzy.site:3306/admin_CNC";
		String usuarioDb="admin_usercnc";
		String contrasenaDb="GRUPO2cnc";
		
		con1.setUrlDb(urlDb);
		con1.setUsuarioDb(usuarioDb);
		con1.setContrasenaDb(contrasenaDb);
		
		Connection con = con1.getConexion();
		
		try {
			//El estamento crea la instruccion que vamos a trabajar hacia la base de datos
			//Aqui el Statement se utiliza uno normal porque envio instruccion de consulta
			Statement stmt = con.createStatement();
			String SQL = "SELECT "+getCoordenadaX()+" , "+getCoordenadaY()+" FROM "+getTabla();
	        ResultSet rs = stmt.executeQuery(SQL);
	        JOptionPane.showMessageDialog(null, "SE HA LEIDO LA BASE DE DATOS");
	        //Permite recorrer todos los elementos o registros.
	        //rs.next() es verdadero mientras todavia haya elementos que leer
	        //Si ya no hay que leer, rs.next() dará falso

	        data.clear();
			ArrayList<Integer> innerArraylist;
	        while (rs.next()) {
	        	innerArraylist = new ArrayList<Integer>();
	        	innerArraylist.add(rs.getInt(getCoordenadaX()));
	 	        innerArraylist.add(rs.getInt(getCoordenadaY()));

	 	        data.add(innerArraylist);
	        }
	        System.out.println(data.toString());
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}
