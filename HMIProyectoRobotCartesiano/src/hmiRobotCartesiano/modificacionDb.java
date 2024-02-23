package hmiRobotCartesiano;

import java.sql.*;
import javax.swing.JOptionPane;

public class modificacionDb {
	
	public String coordenadaX;
	public String coordenadaY;
	public String tabla;
	public String primaryKey;
	public int[] guardardatos; 
	public String getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}

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

	public int[] getGuardardatos() {
		return guardardatos;
	}

	public void setGuardardatos(int[] guardardatos) {
		this.guardardatos = guardardatos;
	}

	public void modificarDb() {
		
		conexionDbUrl con1 = new conexionDbUrl();

		String urlDb = "jdbc:mysql://www.onlybuzy.site:3306/admin_CNC";
		String usuarioDb="admin_usercnc";
		String contrasenaDb="GRUPO2cnc";
		
		con1.setUrlDb(urlDb);
		con1.setUsuarioDb(usuarioDb);
		con1.setContrasenaDb(contrasenaDb);
		
		Connection con = con1.getConexion();
		//En este String SQl, debe especificarse que campos y con que valor desean modificarse
		//String SQL = "UPDATE Estudiante SET nivel=2, carreraId=3  WHERE estudianteId=2";
		//Tambien puede hacerse utilizando variables:
		int[] auxguardardatos;
						
		auxguardardatos=getGuardardatos();
		
//		 for (int i = 0; i < auxguardardatos.length; i++)
//	            System.out.println("Element at index " + i
//	                               + " : " + auxguardardatos[i]);
		try {
			int k=1;
			for(int i=0;i<=(((getGuardardatos().length)/2)-1);i++)
			{
				String SQL = "UPDATE "+getTabla()+" SET "+getCoordenadaX()+"="+auxguardardatos[2*i]+", "+getCoordenadaY()+"="+auxguardardatos[(2*i)+1]+" WHERE "+getPrimaryKey()+"="+k;
				System.out.println(SQL);
				PreparedStatement pps = con.prepareStatement(SQL);
				pps.executeUpdate();
				k++;
			}
			
			
	        JOptionPane.showMessageDialog(null, "SE HA ESCRITO LA BASE DE DATOS");
	        for (int j = 0; j < auxguardardatos.length; j++)
			{
				auxguardardatos[j]=0;
			}
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
