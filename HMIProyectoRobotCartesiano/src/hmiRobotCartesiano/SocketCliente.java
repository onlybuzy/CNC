package hmiRobotCartesiano;

import java.net.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import java.io.*;
import java.io.IOException;

public class SocketCliente {
	
	public String IPServidor;
	public int Puerto;
	public String StatusConexionCliente;
	public Socket clientSocket = new Socket();
	public String StatusEnvioDatos;
	List<ArrayList<Integer>> data = new ArrayList<>();
	

	public List<ArrayList<Integer>> getData() {
		return data;
	}

	public void setData(List<ArrayList<Integer>> data) {
		this.data = data;
	}

	public String getIPServidor() {
		return IPServidor;
	}

	public void setIPServidor(String iPServidor) {
		IPServidor = iPServidor;
	}

	public int getPuerto() {
		return Puerto;
	}

	public void setPuerto(int puerto) {
		Puerto = puerto;
	}

	public String getStatusConexionCliente() {
		return StatusConexionCliente;
	}

	public void setStatusConexionCliente(String statusConexionCliente) {
		StatusConexionCliente = statusConexionCliente;
	}

	public Socket getClientSocket() {
		return clientSocket;
	}

	public void setClientSocket(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}
	
	public String getStatusEnvioDatos() {
		return StatusEnvioDatos;
	}

	public void setStatusEnvioDatos(String statusEnvioDatos) {
		StatusEnvioDatos = statusEnvioDatos;
	}

	public void ConexionCliente() {
		
		String auxStatusConexion;
		//CODIGO DEL CLIENTE
		
		try {
		    // Se crea un socket del cliente y se conecta al servidor en la dirección IP y puerto especificados
		    //Si esta en RED, reemplazar localhost con la direccion IP del servidor
		   setClientSocket(new Socket(getIPServidor(), getPuerto()));
		   // Se cierra el socket del cliente auxiliar
		   auxStatusConexion="CONEXION ESTABLECIDA CON EL SERVIDOR EN LA DIRECCION IP " + getClientSocket().getInetAddress().getHostAddress();
		   JOptionPane.showMessageDialog(null, auxStatusConexion);
		} catch (IOException e) {
		    e.printStackTrace();
		    auxStatusConexion="CONEXION NO ESTABLECIDA";
		    JOptionPane.showMessageDialog(null, auxStatusConexion);
		}	
		
		setStatusConexionCliente(auxStatusConexion);
	}
	
	public void EnvioDatosCliente(List<ArrayList<Integer>> data) {
		
		String auxStatusEnvio;
		System.out.println(getStatusConexionCliente());
		System.out.println("CONEXION ESTABLECIDA CON EL SERVIDOR EN LA DIRECCION IP " + getClientSocket().getInetAddress().getHostAddress());
		
		try {
	    // Se obtiene la salida de datos del socket del cliente
	    OutputStream outputStream = getClientSocket().getOutputStream();
	    
	    // Se envían los datos al servidor
	    //String mensaje = "Hola, servidor!";
	    
	    StringBuilder sb = new StringBuilder();
	    //System.out.println(data);
	    for (int i = 0; i <= data.size()-1; i++) {
	    	for (int j = 0; j <= 1; j++) {
	    		int num = data.get(i).get(j);
	    		sb.append(num);
	    		sb.append(',');
	    		//outputStream.write(num);
	    	}
	    }
	  
	    String result = sb.toString();
	    System.out.println(result);
	    outputStream.write(result.getBytes());
	    sb.setLength(0);
	    auxStatusEnvio="ENVIO DE DATOS COMPLETO";
	   // System.out.println("Byte array is : " + Arrays.toString(bytes));
	    //System.out.println(result.getBytes());
	    JOptionPane.showMessageDialog(null, auxStatusEnvio);

	} catch (IOException e) {
		auxStatusEnvio="ERROR ENVIO DE DATOS";
		e.printStackTrace();
		JOptionPane.showMessageDialog(null, auxStatusEnvio);
	}
		setStatusEnvioDatos(auxStatusEnvio);
	}
	
	public void CerrarConexionCliente() {
		// Se cierra el socket del cliente
		try {
			getClientSocket().close();
			setStatusConexionCliente("Conexion Cerrada Correctamente");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			setStatusConexionCliente("No se pudo cerrar la conexion");
		}
	}
	
}