package hmiRobotCartesiano;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal {

	//static String IPServidor="192.168.68.119";
	//static int PuertoServidor=80;
	
	static String IPServidor;
	static int PuertoServidor;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		VentanaPrincipal V1 = new VentanaPrincipal();
		lecturaDb lecturaCuadrado = new lecturaDb();
		lecturaDb lecturaCirculo = new lecturaDb();
		lecturaDb lecturaTriangulo = new lecturaDb();
		modificacionDb ingresarCuadrado = new modificacionDb();
		modificacionDb ingresarCirculo = new modificacionDb();
		modificacionDb ingresarTriangulo = new modificacionDb();
		comunicacionHMIArduino EnvioDatosArduino = new comunicacionHMIArduino();
		
		V1.setVisible(true);
		//VENTANA 1 ACCIONES BOTONES 
		V1.seleccionFiguras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				V1.jPFiguras.setVisible(true);
				V1.jPPrincipal.setVisible(false);
				V1.jPCoordenadas.setVisible(false);
				V1.jPInfo.setVisible(false);
				V1.jPConfig.setVisible(false);
				V1.jPEscalar.setVisible(false);
			}
		});
		V1.seteoConfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				V1.jPCoordenadas.setVisible(true);
				V1.jPPrincipal.setVisible(false);
				V1.jPFiguras.setVisible(false);
				V1.jPInfo.setVisible(false);
				V1.jPConfig.setVisible(false);
				V1.jPEscalar.setVisible(false);
			}
		});
		
		V1.btnConfigCNC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				V1.jPConfig.setVisible(true);
				V1.jPInfo.setVisible(false);
				V1.jPCoordenadas.setVisible(false);
				V1.jPPrincipal.setVisible(false);
				V1.jPFiguras.setVisible(false);
				V1.jPEscalar.setVisible(false);
			}
		});
		
		V1.escalarFiguras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				V1.jPEscalar.setVisible(true);
				V1.jPCoordenadas.setVisible(false);
				V1.jPPrincipal.setVisible(false);
				V1.jPFiguras.setVisible(false);
				V1.jPInfo.setVisible(false);
				V1.jPConfig.setVisible(false);
			}
		});
		
		V1.ventanaHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				V1.jPPrincipal.setVisible(true);
				V1.jPFiguras.setVisible(false);
				V1.jPCoordenadas.setVisible(false);
				V1.jPInfo.setVisible(false);
				V1.jPConfig.setVisible(false);
				V1.jPEscalar.setVisible(false);
			}
		});
		V1.btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				V1.jPInfo.setVisible(true);
				V1.jPFiguras.setVisible(false);
				V1.jPPrincipal.setVisible(false);
				V1.jPCoordenadas.setVisible(false);
				V1.jPConfig.setVisible(false);
				V1.jPEscalar.setVisible(false);
			}
		});
		
		 V1.btnEnviarManual.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		int[] guardardatos = new int[2]; 
		    		for (int i = 0; i < guardardatos.length; i++)
		    		{
		    			guardardatos[i]=0;
		    		}
		    		        		
		    		guardardatos[0]=Integer.parseInt(V1.coordXManual.getText());
		    		guardardatos[1]=Integer.parseInt(V1.coordYManual.getText());
		    		ingresarTriangulo.setCoordenadaX("coordenadaX");
		    		ingresarTriangulo.setCoordenadaY("coordenadaY");
		    		ingresarTriangulo.setTabla("Manual");
		    		ingresarTriangulo.setPrimaryKey("indice");
		    		ingresarTriangulo.setGuardardatos(guardardatos);
		    		ingresarTriangulo.modificarDb();
		    		
		      		List<ArrayList<Integer>> datos = new ArrayList<>();
		    		lecturaCuadrado.setCoordenadaX("coordenadaX");
		    		lecturaCuadrado.setCoordenadaY("coordenadaY");
		    		lecturaCuadrado.setTabla("Manual");
		    		datos=lecturaCuadrado.leerDb();
		    		EnvioDatosArduino.setIPServer(IPServidor);
		    		EnvioDatosArduino.setPuertoCom(PuertoServidor);
		    		EnvioDatosArduino.setData(datos);
		    		EnvioDatosArduino.comunicacion();
	        	}
	        });
		 
		V1.btnEnviarRed.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					IPServidor=V1.ipServidor.getText();
					PuertoServidor=Integer.parseInt(V1.puertoServidor.getText());
					JOptionPane.showMessageDialog(null, "DIRECCION IP SERVIDOR ACTUALIZADA CORRECTAMENTE");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "DIRECCION IP SERVIDOR NO VÁLIDA");
				}
        	}
        });
		
		
        V1.btnEnviarFactorCuad.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		List<ArrayList<Integer>> datos = new ArrayList<>();
        		float factorCuadrado;
        		int[] guardardatos = new int[8]; 
        		for (int i = 0; i < guardardatos.length; i++)
        		{
        			guardardatos[i]=0;
        		}
        		
        		factorCuadrado=Float.parseFloat(V1.factorCuad.getText());
	    		lecturaCuadrado.setCoordenadaX("coordenadaX");
	    		lecturaCuadrado.setCoordenadaY("coordenadaY");
	    		lecturaCuadrado.setTabla("Cuadrado");
	    		datos=lecturaCuadrado.leerDb();
	    		
	    		int k=0;
	    		
	    		for (int i = 0; i <= datos.size()-1; i++) {
	    	    	for (int j = 0; j <= 1; j++) {
	    	    		guardardatos[k]=(int)(factorCuadrado*datos.get(i).get(j));
	    	    		k=k+1;
	    	    	}
	    	    }
	    		
	    		ingresarCuadrado.setCoordenadaX("coordenadaX");
        		ingresarCuadrado.setCoordenadaY("coordenadaY");
        		ingresarCuadrado.setTabla("Cuadrado");
        		ingresarCuadrado.setPrimaryKey("indice");
        		ingresarCuadrado.setGuardardatos(guardardatos);
        		ingresarCuadrado.modificarDb();
        	}
        });
        
        V1.btnEnviarFactorCirc.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
          		List<ArrayList<Integer>> datos = new ArrayList<>();
        		float factorCirculo;
        		int[] guardardatos = new int[12]; 
        		for (int i = 0; i < guardardatos.length; i++)
        		{
        			guardardatos[i]=0;
        		}
        		
        		factorCirculo=Float.parseFloat(V1.factorCirc.getText());
	    		lecturaCirculo.setCoordenadaX("coordenadaX");
	    		lecturaCirculo.setCoordenadaY("coordenadaY");
	    		lecturaCirculo.setTabla("Circulo");
	    		datos=lecturaCirculo.leerDb();
	    		
	    		int k=0;
	    		
	    		for (int i = 0; i <= datos.size()-1; i++) {
	    	    	for (int j = 0; j <= 1; j++) {
	    	    		guardardatos[k]=(int)(factorCirculo*datos.get(i).get(j));
	    	    		k=k+1;
	    	    	}
	    	    }
	    		
	    		ingresarCirculo.setCoordenadaX("coordenadaX");
        		ingresarCirculo.setCoordenadaY("coordenadaY");
        		ingresarCirculo.setTabla("Circulo");
        		ingresarCirculo.setPrimaryKey("indice");
        		ingresarCirculo.setGuardardatos(guardardatos);
        		ingresarCirculo.modificarDb();
        	}
        });
        
        V1.btnEnviarFactorTria.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
          		List<ArrayList<Integer>> datos = new ArrayList<>();
        		float factorTriangulo;
        		int[] guardardatos = new int[6]; 
        		for (int i = 0; i < guardardatos.length; i++)
        		{
        			guardardatos[i]=0;
        		}
        		
        		factorTriangulo=Float.parseFloat(V1.factorTria.getText());
	    		lecturaTriangulo.setCoordenadaX("coordenadaX");
	    		lecturaTriangulo.setCoordenadaY("coordenadaY");
	    		lecturaTriangulo.setTabla("Triangulo");
	    		datos=lecturaTriangulo.leerDb();
	    		
	    		int k=0;
	    		
	    		for (int i = 0; i <= datos.size()-1; i++) {
	    	    	for (int j = 0; j <= 1; j++) {
	    	    		guardardatos[k]=(int)(factorTriangulo*datos.get(i).get(j));
	    	    		k=k+1;
	    	    	}
	    	    }
	    		
	    		ingresarTriangulo.setCoordenadaX("coordenadaX");
        		ingresarTriangulo.setCoordenadaY("coordenadaY");
        		ingresarTriangulo.setTabla("Triangulo");
        		ingresarTriangulo.setPrimaryKey("indice");
        		ingresarTriangulo.setGuardardatos(guardardatos);
        		ingresarTriangulo.modificarDb();
        	}
        });
        
		
	    V1.btnCuadrado.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		List<ArrayList<Integer>> datos = new ArrayList<>();
	    		lecturaCuadrado.setCoordenadaX("coordenadaX");
	    		lecturaCuadrado.setCoordenadaY("coordenadaY");
	    		lecturaCuadrado.setTabla("Cuadrado");
	    		datos=lecturaCuadrado.leerDb();
	    		EnvioDatosArduino.setIPServer(IPServidor);
	    		EnvioDatosArduino.setPuertoCom(PuertoServidor);
	    		EnvioDatosArduino.setData(datos);
	    		EnvioDatosArduino.comunicacion();
	    	}
	    });

	    V1.btnCirculo.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		List<ArrayList<Integer>> datos = new ArrayList<>();
	    		lecturaCirculo.setCoordenadaX("coordenadaX");
	    		lecturaCirculo.setCoordenadaY("coordenadaY");
	    		lecturaCirculo.setTabla("Circulo");
	    		datos=lecturaCirculo.leerDb();
	    		EnvioDatosArduino.setIPServer(IPServidor);
	    		EnvioDatosArduino.setPuertoCom(PuertoServidor);
	    		EnvioDatosArduino.setData(datos);
	    		EnvioDatosArduino.comunicacion();
	    		
	    	}
	    });

	    V1.btnTriangulo.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		List<ArrayList<Integer>> datos = new ArrayList<>();
	    		lecturaTriangulo.setCoordenadaX("coordenadaX");
	    		lecturaTriangulo.setCoordenadaY("coordenadaY");
	    		lecturaTriangulo.setTabla("Triangulo");
	    		datos=lecturaTriangulo.leerDb();
	    		EnvioDatosArduino.setIPServer(IPServidor);
	    		EnvioDatosArduino.setPuertoCom(PuertoServidor);
	    		EnvioDatosArduino.setData(datos);
	    		EnvioDatosArduino.comunicacion();
	    		
	    	}
	    });	
	    
	    V1.btnEnviarCuadrado.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int[] guardardatos = new int[8]; 
        		for (int i = 0; i < guardardatos.length; i++)
        		{
        			guardardatos[i]=0;
        		}
        		        		
        		guardardatos[0]=Integer.parseInt(V1.coordXCuad1.getText());
        		guardardatos[1]=Integer.parseInt(V1.coordYCuad1.getText());
        		guardardatos[2]=Integer.parseInt(V1.coordXCuad2.getText());
        		guardardatos[3]=Integer.parseInt(V1.coordYCuad2.getText());
        		guardardatos[4]=Integer.parseInt(V1.coordXCuad3.getText());
        		guardardatos[5]=Integer.parseInt(V1.coordYCuad3.getText());
        		guardardatos[6]=Integer.parseInt(V1.coordXCuad4.getText());
        		guardardatos[7]=Integer.parseInt(V1.coordYCuad4.getText());
        		ingresarCuadrado.setCoordenadaX("coordenadaX");
        		ingresarCuadrado.setCoordenadaY("coordenadaY");
        		ingresarCuadrado.setTabla("Cuadrado");
        		ingresarCuadrado.setPrimaryKey("indice");
        		ingresarCuadrado.setGuardardatos(guardardatos);
        		ingresarCuadrado.modificarDb();
        	}
        });
	    
	    V1.btnEnviarCirculo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int[] guardardatos = new int[12]; 
        		for (int i = 0; i < guardardatos.length; i++)
        		{
        			guardardatos[i]=0;
        		}
        		        		
        		guardardatos[0]=Integer.parseInt(V1.coordXCir1.getText());
        		guardardatos[1]=Integer.parseInt(V1.coordYCir1.getText());
        		guardardatos[2]=Integer.parseInt(V1.coordXCir2.getText());
        		guardardatos[3]=Integer.parseInt(V1.coordYCir2.getText());
        		guardardatos[4]=Integer.parseInt(V1.coordXCir3.getText());
        		guardardatos[5]=Integer.parseInt(V1.coordYCir3.getText());
        		guardardatos[6]=Integer.parseInt(V1.coordXCir4.getText());
        		guardardatos[7]=Integer.parseInt(V1.coordYCir4.getText());
        		guardardatos[8]=Integer.parseInt(V1.coordXCir5.getText());
        		guardardatos[9]=Integer.parseInt(V1.coordYCir5.getText());
        		guardardatos[10]=Integer.parseInt(V1.coordXCir6.getText());
        		guardardatos[11]=Integer.parseInt(V1.coordYCir6.getText());
        		ingresarCirculo.setCoordenadaX("coordenadaX");
        		ingresarCirculo.setCoordenadaY("coordenadaY");
        		ingresarCirculo.setTabla("Circulo");
        		ingresarCirculo.setPrimaryKey("indice");
        		ingresarCirculo.setGuardardatos(guardardatos);
        		ingresarCirculo.modificarDb();
        	}
        });
	    V1.btnEnviarTriangulo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int[] guardardatos = new int[6]; 
        		for (int i = 0; i < guardardatos.length; i++)
        		{
        			guardardatos[i]=0;
        		}
        		        		
        		guardardatos[0]=Integer.parseInt(V1.coordXTria1.getText());
        		guardardatos[1]=Integer.parseInt(V1.coordYTria1.getText());
        		guardardatos[2]=Integer.parseInt(V1.coordXTria2.getText());
        		guardardatos[3]=Integer.parseInt(V1.coordYTria2.getText());
        		guardardatos[4]=Integer.parseInt(V1.coordXTria3.getText());
        		guardardatos[5]=Integer.parseInt(V1.coordYTria3.getText());
        		ingresarTriangulo.setCoordenadaX("coordenadaX");
        		ingresarTriangulo.setCoordenadaY("coordenadaY");
        		ingresarTriangulo.setTabla("Triangulo");
        		ingresarTriangulo.setPrimaryKey("indice");
        		ingresarTriangulo.setGuardardatos(guardardatos);
        		ingresarTriangulo.modificarDb();
        	}
        });
	    V1.btnBorrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		V1.coordXCuad1.setText(null);
        		V1.coordYCuad1.setText(null);
        		V1.coordXCuad2.setText(null);
        		V1.coordYCuad2.setText(null);
        		V1.coordXCuad3.setText(null);
        		V1.coordYCuad3.setText(null);
        		V1.coordXCuad4.setText(null);
        		V1.coordYCuad4.setText(null);
        		
        		
        		V1.coordXTria1.setText(null);
        		V1.coordYTria1.setText(null);
        		V1.coordXTria2.setText(null);
        		V1.coordYTria2.setText(null);
        		V1.coordXTria3.setText(null);
        		V1.coordYTria3.setText(null);
        		
        		V1.coordXCir1.setText(null);
        		V1.coordYCir1.setText(null);
        		V1.coordXCir2.setText(null);
        		V1.coordYCir2.setText(null);
        		V1.coordXCir3.setText(null);
        		V1.coordYCir3.setText(null);
        		V1.coordXCir4.setText(null);
        		V1.coordYCir4.setText(null);
        		V1.coordXCir5.setText(null);
        		V1.coordYCir5.setText(null);
        		V1.coordXCir6.setText(null);
        		V1.coordYCir6.setText(null);

        	}
        });
	}
}
