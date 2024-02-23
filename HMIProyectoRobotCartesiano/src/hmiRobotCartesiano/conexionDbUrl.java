package hmiRobotCartesiano;

import java.sql.*;

import javax.swing.JOptionPane;

public class conexionDbUrl {
	
	public String urlDb;
	public String usuarioDb;
	public String contrasenaDb;
	
	public String getUsuarioDb() {
		return usuarioDb;
	}

	public void setUsuarioDb(String usuarioDb) {
		this.usuarioDb = usuarioDb;
	}

	public String getContrasenaDb() {
		return contrasenaDb;
	}

	public void setContrasenaDb(String contrasenaDb) {
		this.contrasenaDb = contrasenaDb;
	}

	public String getUrlDb() {
		return urlDb;
	}

	public void setUrlDb(String urlDb) {
		this.urlDb = urlDb;
	}
	
	public Connection getConexion() {
		Connection con = null;
		
		try {
			
			con = DriverManager.getConnection(getUrlDb(),getUsuarioDb(),getContrasenaDb());
			//con = DriverManager.getConnection("jdbc:mysql://www.onlybuzy.site:3306/admin_CNC","admin_usercnc","GRUPO2cnc");
			//Statement stmt = con.createStatement();
					
			JOptionPane.showMessageDialog(null, "SE HA CONECTADO A LA BASE DE DATOS");
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "NO SE HA CONECTADO A LA BASE DE DATOS");			
		}
		
		return con;
	}
	
	

}
