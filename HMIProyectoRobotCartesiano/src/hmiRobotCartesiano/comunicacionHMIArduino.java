package hmiRobotCartesiano;

import java.util.ArrayList;
import java.util.List;

public class comunicacionHMIArduino {
	public String IPServer;
	public int PuertoCom;
	List<ArrayList<Integer>> data = new ArrayList<>();
	
	public List<ArrayList<Integer>> getData() {
		return data;
	}

	public void setData(List<ArrayList<Integer>> data) {
		this.data = data;
	}

	public String getIPServer() {
		return IPServer;
	}

	public void setIPServer(String iPServer) {
		IPServer = iPServer;
	}

	public int getPuertoCom() {
		return PuertoCom;
	}

	public void setPuertoCom(int puertoCom) {
		PuertoCom = puertoCom;
	}
	
	public void comunicacion(){
		
		SocketCliente socketComCliente = new SocketCliente();
		String statusEnvioDatos;
		String statusConexionCliente;
		
		socketComCliente.setIPServidor(getIPServer());
		socketComCliente.setPuerto(getPuertoCom());
		socketComCliente.ConexionCliente();
		statusConexionCliente=socketComCliente.getStatusConexionCliente();
		System.out.println("Cliente1"+ statusConexionCliente);
		
		socketComCliente.EnvioDatosCliente(getData());
		statusEnvioDatos=socketComCliente.getStatusEnvioDatos();
		System.out.println("Cliente1"+ statusEnvioDatos);
		
		socketComCliente.CerrarConexionCliente();
		statusConexionCliente=socketComCliente.getStatusConexionCliente();
		System.out.println("Cliente1"+ statusConexionCliente);
		
	}

}
