package hmiRobotCartesiano;

import java.text.DateFormat;
import java.util.Date;
import javax.swing.Timer;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame {

	@SuppressWarnings("unused")
	private JFrame ventanaPrincipal;
	//VentanaFiguras VFiguras=new VentanaFiguras();
	JPanel jPFiguras = new JPanel();
    JPanel jPPrincipal = new JPanel();
    JPanel jPCoordenadas = new JPanel();
    JPanel jPInfo = new JPanel();
    JPanel jPConfig = new JPanel();
    JPanel jPEscalar = new JPanel();
	JButton seleccionFiguras=new JButton("SELECCION FIGURAS");
	JButton ventanaHome = new JButton("PRINCIPAL");
	JButton seteoConfig = new JButton("COORDENADAS");
	JButton escalarFiguras = new JButton("ESCALAMIENTO");
	JButton btnInfo = new JButton("INFO");
	JButton btnConfigCNC = new JButton("CONFIGURACIONES");
	JButton btnCirculo = new JButton("HEXAGONO");
    JButton btnTriangulo = new JButton("TRIANGULO");
    JButton btnCuadrado = new JButton("CUADRADO");
    JButton btnEnviarCuadrado = new JButton("Enviar Cuadrado");
    JButton btnEnviarCirculo = new JButton("Enviar Hexágono");
    JButton btnEnviarTriangulo = new JButton("Enviar Triangulo");
    JButton btnBorrar = new JButton("Limpiar");
    JButton btnEnviarManual = new JButton("Enviar");
    JButton btnEnviarRed = new JButton("Enviar");
    JButton btnEnviarFactorCuad = new JButton("Enviar Factor Cuadrado");
    JButton btnEnviarFactorCirc = new JButton("Enviar Factor Hexágono");
    JButton btnEnviarFactorTria = new JButton("Enviar Factor Triangulo");
    JTextField coordXCuad1 = new JTextField();
    JTextField coordYCuad1 = new JTextField();
    JTextField coordXCuad2 = new JTextField();
    JTextField coordYCuad2 = new JTextField();
    JTextField coordXCuad3 = new JTextField();
    JTextField coordYCuad3 = new JTextField();
    JTextField coordXCuad4 = new JTextField();
    JTextField coordYCuad4 = new JTextField();
    JTextField coordXCir1 = new JTextField();
    JTextField coordYCir1 = new JTextField();
    JTextField coordXCir2 = new JTextField();
    JTextField coordYCir2 = new JTextField();
    JTextField coordXCir3 = new JTextField();
    JTextField coordYCir3 = new JTextField();
    JTextField coordXCir4 = new JTextField();
    JTextField coordYCir4 = new JTextField();
    JTextField coordXCir6 = new JTextField();
    JTextField coordXCir5 = new JTextField();
    JTextField coordYCir5 = new JTextField();
    JTextField coordYCir6 = new JTextField();
    JTextField coordXTria1 = new JTextField();
    JTextField coordYTria1 = new JTextField();
    JTextField coordXTria2 = new JTextField();
    JTextField coordYTria2 = new JTextField();
    JTextField coordXTria3 = new JTextField();
    JTextField coordYTria3 = new JTextField();
    JTextField coordXManual = new JTextField();
    JTextField coordYManual = new JTextField();
    JTextField ipServidor = new JTextField();
    JTextField puertoServidor = new JTextField();
    JTextField factorCuad = new JTextField();
    JTextField factorCirc = new JTextField();
    JTextField factorTria = new JTextField();
    
 
    
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VentanaPrincipal window = new VentanaPrincipal();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBackground(new Color(240, 240, 240));
		setBounds(100, 100, 800, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		BufferedImage imgCNC = null;
		BufferedImage imgSquare = null;
		BufferedImage imgCircle = null;
		BufferedImage imgTriangle = null;
		BufferedImage imgEPN = null;
        jPFiguras.setVisible(false);
        jPConfig.setVisible(false);       
        jPCoordenadas.setVisible(false);
        jPEscalar.setVisible(false);
        jPInfo.setVisible(false);
        
        jPPrincipal.setBounds(224, 60, 552, 358);
        getContentPane().add(jPPrincipal);
        jPPrincipal.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("ROBOT CARTESIANO DE DOS EJES (XY)");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel.setBounds(87, 23, 339, 20);
        jPPrincipal.add(lblNewLabel);
        
        JLabel graficoCNC = new JLabel();
        graficoCNC.setBounds(74, 72, 364, 229);
        jPPrincipal.add(graficoCNC);
                
        jPEscalar.setBounds(224, 60, 552, 358);
        getContentPane().add(jPEscalar);
        jPEscalar.setLayout(null);
        
        JLabel lblNewLabel_2_3 = new JLabel("INGRESE EL FACTOR DE ESCALAMIENTO DE LA FIGURA A REALIZAR");
        lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2_3.setBounds(33, 10, 486, 17);
        jPEscalar.add(lblNewLabel_2_3);
        
        JLabel lblNewLabel_2_1_5 = new JLabel("Cuadrado");
        lblNewLabel_2_1_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1_5.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2_1_5.setBounds(63, 56, 70, 17);
        jPEscalar.add(lblNewLabel_2_1_5);
        
        JLabel lblNewLabel_2_1_3_5 = new JLabel("Factor");
        lblNewLabel_2_1_3_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1_3_5.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2_1_3_5.setBounds(68, 83, 60, 17);
        jPEscalar.add(lblNewLabel_2_1_3_5);
        
        factorCuad = new JTextField();
        factorCuad.setColumns(10);
        factorCuad.setBounds(68, 110, 60, 19);
        jPEscalar.add(factorCuad);
        
        JLabel lblNewLabel_2_1_1_2 = new JLabel("Hexágono");
        lblNewLabel_2_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2_1_1_2.setBounds(238, 56, 74, 17);
        jPEscalar.add(lblNewLabel_2_1_1_2);
        
        JLabel lblNewLabel_2_1_3_2_1 = new JLabel("Factor");
        lblNewLabel_2_1_3_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2_1_3_2_1.setBounds(245, 83, 60, 17);
        jPEscalar.add(lblNewLabel_2_1_3_2_1);
        
        factorCirc = new JTextField();
        factorCirc.setColumns(10);
        factorCirc.setBounds(245, 110, 60, 19);
        jPEscalar.add(factorCirc);
        
        JLabel lblNewLabel_2_1_2_2 = new JLabel("Triangulo");
        lblNewLabel_2_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2_1_2_2.setBounds(416, 56, 70, 17);
        jPEscalar.add(lblNewLabel_2_1_2_2);
        
        JLabel lblNewLabel_2_1_3_3_1 = new JLabel("Factor");
        lblNewLabel_2_1_3_3_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1_3_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2_1_3_3_1.setBounds(421, 83, 60, 17);
        jPEscalar.add(lblNewLabel_2_1_3_3_1);
        
        factorTria = new JTextField();
        factorTria.setColumns(10);
        factorTria.setBounds(421, 110, 60, 19);
        jPEscalar.add(factorTria);
        
        
        btnEnviarFactorCuad.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnEnviarFactorCuad.setBounds(21, 156, 155, 23);
        jPEscalar.add(btnEnviarFactorCuad);     
        
        btnEnviarFactorCirc.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnEnviarFactorCirc.setBounds(197, 156, 157, 23);
        jPEscalar.add(btnEnviarFactorCirc);
               
        btnEnviarFactorTria.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnEnviarFactorTria.setBounds(376, 156, 151, 23);
        jPEscalar.add(btnEnviarFactorTria);
        jPCoordenadas.setBounds(224, 60, 552, 358);
        getContentPane().add(jPCoordenadas);
        jPCoordenadas.setLayout(null);
        
        JLabel lblNewLabel_2 = new JLabel("INGRESE LAS COORDENADAS DE LAS FIGURAS A REALIZAR");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2.setBounds(50, 10, 426, 17);
        jPCoordenadas.add(lblNewLabel_2);
        
        JLabel lblNewLabel_2_1 = new JLabel("Cuadrado");
        lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2_1.setBounds(61, 37, 70, 17);
        jPCoordenadas.add(lblNewLabel_2_1);
        
        JLabel lblNewLabel_2_1_1 = new JLabel("Hexágono");
        lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2_1_1.setBounds(214, 37, 74, 17);
        jPCoordenadas.add(lblNewLabel_2_1_1);
        
        JLabel lblNewLabel_2_1_2 = new JLabel("Triangulo");
        lblNewLabel_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2_1_2.setBounds(376, 37, 70, 17);
        jPCoordenadas.add(lblNewLabel_2_1_2);
        
        coordXCuad1.setBounds(28, 83, 60, 19);
        jPCoordenadas.add(coordXCuad1);
        coordXCuad1.setColumns(10);
        
        coordYCuad1.setColumns(10);
        coordYCuad1.setBounds(103, 83, 60, 19);
        jPCoordenadas.add(coordYCuad1);
        
        coordXCuad2.setColumns(10);
        coordXCuad2.setBounds(28, 124, 60, 19);
        jPCoordenadas.add(coordXCuad2);
        
        coordYCuad2.setColumns(10);
        coordYCuad2.setBounds(103, 124, 60, 19);
        jPCoordenadas.add(coordYCuad2);
        
        coordXCuad3.setColumns(10);
        coordXCuad3.setBounds(28, 166, 60, 19);
        jPCoordenadas.add(coordXCuad3);
        
        coordYCuad3.setColumns(10);
        coordYCuad3.setBounds(103, 166, 60, 19);
        jPCoordenadas.add(coordYCuad3);
        
        coordXCuad4.setColumns(10);
        coordXCuad4.setBounds(28, 205, 60, 19);
        jPCoordenadas.add(coordXCuad4);
        
        coordYCuad4.setColumns(10);
        coordYCuad4.setBounds(103, 205, 60, 19);
        jPCoordenadas.add(coordYCuad4);
        
        JLabel lblNewLabel_2_1_3 = new JLabel("X");
        lblNewLabel_2_1_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2_1_3.setBounds(28, 56, 60, 17);
        jPCoordenadas.add(lblNewLabel_2_1_3);
        
        JLabel lblNewLabel_2_1_3_1 = new JLabel("Y");
        lblNewLabel_2_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2_1_3_1.setBounds(103, 56, 60, 17);
        jPCoordenadas.add(lblNewLabel_2_1_3_1);
        
        JLabel lblNewLabel_2_1_3_2 = new JLabel("X");
        lblNewLabel_2_1_3_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1_3_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2_1_3_2.setBounds(188, 56, 60, 17);
        jPCoordenadas.add(lblNewLabel_2_1_3_2);
        
        JLabel lblNewLabel_2_1_3_1_1 = new JLabel("Y");
        lblNewLabel_2_1_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2_1_3_1_1.setBounds(263, 56, 60, 17);
        jPCoordenadas.add(lblNewLabel_2_1_3_1_1);
        
        coordXCir1.setColumns(10);
        coordXCir1.setBounds(188, 83, 60, 19);
        jPCoordenadas.add(coordXCir1);
        
        coordYCir1.setColumns(10);
        coordYCir1.setBounds(263, 83, 60, 19);
        jPCoordenadas.add(coordYCir1);
        
        JLabel lblNewLabel_2_1_3_3 = new JLabel("X");
        lblNewLabel_2_1_3_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1_3_3.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2_1_3_3.setBounds(341, 56, 60, 17);
        jPCoordenadas.add(lblNewLabel_2_1_3_3);
        
        JLabel lblNewLabel_2_1_3_1_2 = new JLabel("Y");
        lblNewLabel_2_1_3_1_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2_1_3_1_2.setBounds(416, 56, 60, 17);
        jPCoordenadas.add(lblNewLabel_2_1_3_1_2);
        
        coordXTria1.setColumns(10);
        coordXTria1.setBounds(341, 83, 60, 19);
        jPCoordenadas.add(coordXTria1);
        
        coordYTria1.setColumns(10);
        coordYTria1.setBounds(416, 83, 60, 19);
        jPCoordenadas.add(coordYTria1);
        
        coordXTria2.setColumns(10);
        coordXTria2.setBounds(341, 124, 60, 19);
        jPCoordenadas.add(coordXTria2);
        
        coordYTria2.setColumns(10);
        coordYTria2.setBounds(416, 124, 60, 19);
        jPCoordenadas.add(coordYTria2);
        
        coordXTria3.setColumns(10);
        coordXTria3.setBounds(341, 166, 60, 19);
        jPCoordenadas.add(coordXTria3);
        
        coordYTria3.setColumns(10);
        coordYTria3.setBounds(416, 166, 60, 19);
        jPCoordenadas.add(coordYTria3);
        
        
        btnEnviarCuadrado.setFont(new Font("Tahoma", Font.PLAIN, 12));
        
        btnEnviarCuadrado.setBounds(44, 309, 121, 21);
        jPCoordenadas.add(btnEnviarCuadrado);
                
        btnEnviarCirculo.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnEnviarCirculo.setBounds(198, 309, 121, 21);
        jPCoordenadas.add(btnEnviarCirculo);
        
        btnEnviarTriangulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnEnviarTriangulo.setBounds(356, 309, 121, 21);
        jPCoordenadas.add(btnEnviarTriangulo);
        
		 btnBorrar.setBounds(467, 337, 85, 21);
		 
		 jPCoordenadas.add(btnBorrar);
		 coordXCir2.setColumns(10);
		 coordXCir2.setBounds(188, 124, 60, 19);
		 
		 jPCoordenadas.add(coordXCir2);
		 coordYCir2.setColumns(10);
		 coordYCir2.setBounds(263, 124, 60, 19);
		 
		 jPCoordenadas.add(coordYCir2);
		 coordXCir3.setColumns(10);
		 coordXCir3.setBounds(188, 166, 60, 19);
		 
		 jPCoordenadas.add(coordXCir3);
		 coordYCir3.setColumns(10);
		 coordYCir3.setBounds(263, 166, 60, 19);
		 
		 jPCoordenadas.add(coordYCir3);
		 coordXCir4.setColumns(10);
		 coordXCir4.setBounds(188, 205, 60, 19);
		 
		 jPCoordenadas.add(coordXCir4);
		 coordYCir4.setColumns(10);
		 coordYCir4.setBounds(263, 205, 60, 19);
		 
		 jPCoordenadas.add(coordYCir4);
		 coordXCir6.setColumns(10);
		 coordXCir6.setBounds(188, 280, 60, 19);
		 
		 jPCoordenadas.add(coordXCir6);
		 coordXCir5.setColumns(10);
		 coordXCir5.setBounds(188, 241, 60, 19);
		 
		 jPCoordenadas.add(coordXCir5);
		 coordYCir5.setColumns(10);
		 coordYCir5.setBounds(263, 241, 60, 19);
		 
		 jPCoordenadas.add(coordYCir5);
		 coordYCir6.setColumns(10);
		 coordYCir6.setBounds(263, 280, 60, 19);
		 
		 jPCoordenadas.add(coordYCir6);
        jPConfig.setLayout(null);
        jPConfig.setBounds(224, 60, 552, 358);
        
        
        
        JLabel lblNewLabel_2_1_2_1_1_1 = new JLabel("IP Servidor");
        getContentPane().add(jPConfig);
        lblNewLabel_2_1_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2_1_2_1_1_1.setBounds(254, 123, 98, 17);
        jPConfig.add(lblNewLabel_2_1_2_1_1_1);
        
        JLabel lblNewLabel_2_2_2_1 = new JLabel("CONFIGURACIONES CNC");
        lblNewLabel_2_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2_2_2_1.setBounds(171, 28, 179, 17);
        jPConfig.add(lblNewLabel_2_2_2_1);
        
        JLabel lblNewLabel_2_1_3_4 = new JLabel("X");
        lblNewLabel_2_1_3_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1_3_4.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2_1_3_4.setBounds(40, 97, 60, 17);
        jPConfig.add(lblNewLabel_2_1_3_4);
        
        JLabel lblNewLabel_2_1_3_1_3 = new JLabel("Y");
        lblNewLabel_2_1_3_1_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1_3_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2_1_3_1_3.setBounds(115, 97, 60, 17);
        jPConfig.add(lblNewLabel_2_1_3_1_3);
        
        coordXManual.setColumns(10);
        coordXManual.setBounds(40, 124, 60, 19);
        jPConfig.add(coordXManual);
        
        coordYManual.setColumns(10);
        coordYManual.setBounds(115, 124, 60, 19);
        jPConfig.add(coordYManual);
        
        JLabel lblNewLabel_2_2_2_1_1 = new JLabel("MOVIMIENTO MANUAL");
        lblNewLabel_2_2_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_2_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2_2_2_1_1.setBounds(27, 70, 166, 17);
        jPConfig.add(lblNewLabel_2_2_2_1_1);
        
        JLabel lblNewLabel_2_2_2_1_1_1 = new JLabel("CONFIGURACION SERVIDOR");
        lblNewLabel_2_2_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_2_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2_2_2_1_1_1.setBounds(282, 70, 209, 17);
        jPConfig.add(lblNewLabel_2_2_2_1_1_1); 
        
        btnEnviarManual.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnEnviarManual.setBounds(59, 177, 89, 21);
        jPConfig.add(btnEnviarManual);
        
        JLabel lblNewLabel_2_1_2_1_1_1_1 = new JLabel("Puerto");
        lblNewLabel_2_1_2_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2_1_2_1_1_1_1.setBounds(254, 161, 98, 17);
        jPConfig.add(lblNewLabel_2_1_2_1_1_1_1);
        
        ipServidor.setColumns(10);
        ipServidor.setBounds(374, 121, 130, 19);
        jPConfig.add(ipServidor);
        
        puertoServidor.setColumns(10);
        puertoServidor.setBounds(374, 162, 130, 19);
        jPConfig.add(puertoServidor);
        
        btnEnviarRed.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnEnviarRed.setBounds(348, 212, 89, 21);
        jPConfig.add(btnEnviarRed);
             
        jPFiguras.setBackground(SystemColor.menu);
        jPFiguras.setBounds(224, 60, 552, 358);
        getContentPane().add(jPFiguras);
        jPFiguras.setLayout(null);
        
        btnCuadrado.setBounds(23, 191, 140, 21);
        jPFiguras.add(btnCuadrado);
        
        JLabel lblSeleccionDeFiguras = new JLabel("SELECCION DE FIGURAS GEOMETRICAS A DIBUJAR");
        lblSeleccionDeFiguras.setForeground(SystemColor.windowText);
        lblSeleccionDeFiguras.setHorizontalAlignment(SwingConstants.CENTER);
        lblSeleccionDeFiguras.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblSeleccionDeFiguras.setBounds(31, 23, 460, 20);
        jPFiguras.add(lblSeleccionDeFiguras);
        
        btnCirculo.setBounds(186, 191, 140, 21);
        jPFiguras.add(btnCirculo);
        
        btnTriangulo.setBounds(349, 191, 140, 21);
        jPFiguras.add(btnTriangulo);
        
        JLabel logoCuadrado = new JLabel("");
        logoCuadrado.setBounds(23, 76, 140, 105);
        jPFiguras.add(logoCuadrado);
        
        JLabel logoCirculo = new JLabel("");
        logoCirculo.setBounds(186, 76, 140, 105);
        jPFiguras.add(logoCirculo);
        
        JLabel logoTriangulo = new JLabel("");
        logoTriangulo.setBounds(349, 76, 140, 105);
        jPFiguras.add(logoTriangulo);    	  
        
        JPanel HMIDatos = new JPanel();
		HMIDatos.setBackground(SystemColor.activeCaption);
		HMIDatos.setBounds(10, 10, 766, 40);
		getContentPane().add(HMIDatos);
		HMIDatos.setLayout(null);
        
        JLabel logoEPN = new JLabel();
		logoEPN.setBounds(0, 1, 99, 40);
		HMIDatos.add(logoEPN);
          
        
        try {
		    imgCNC = ImageIO.read(this.getClass().getResource("/CNC.jpg"));
		    imgSquare = ImageIO.read(this.getClass().getResource("/CUADRADO.png"));
		    imgCircle = ImageIO.read(this.getClass().getResource("/CIRCULO.png"));
		    imgTriangle = ImageIO.read(this.getClass().getResource("/TRIANGULO.png"));
		    imgEPN = ImageIO.read(this.getClass().getResource("/LOGOEPN.png"));
		    
		} catch (IOException e) {
		    e.printStackTrace();
		}
        Image dimgEPN = imgEPN.getScaledInstance(logoEPN.getWidth(), logoEPN.getHeight(), Image.SCALE_SMOOTH);
        Image dimgSquare = imgSquare.getScaledInstance(logoCuadrado.getWidth(), logoCuadrado.getHeight(), Image.SCALE_SMOOTH);
        Image dimgCircle = imgCircle.getScaledInstance(logoCirculo.getWidth(), logoCirculo.getHeight(), Image.SCALE_SMOOTH);
        Image dimgTriangle = imgTriangle.getScaledInstance(logoTriangulo.getWidth(),logoTriangulo.getHeight(), Image.SCALE_SMOOTH);
        Image dimgCNC = imgCNC.getScaledInstance(graficoCNC.getWidth(), graficoCNC.getHeight(), Image.SCALE_SMOOTH);
        
        ImageIcon idimgCNC = new ImageIcon(dimgCNC);
		ImageIcon idimgEPN = new ImageIcon(dimgEPN);
		ImageIcon idimgSquare = new ImageIcon(dimgSquare);
		ImageIcon idimgCircle= new ImageIcon(dimgCircle);
		ImageIcon idimgTriangle= new ImageIcon(dimgTriangle);
		graficoCNC.setIcon(idimgCNC);
        logoCuadrado.setIcon(idimgSquare);
        logoCirculo.setIcon(idimgCircle);
        logoTriangulo.setIcon(idimgTriangle);
		logoEPN.setIcon(idimgEPN);
    
	    JLabel clock = new JLabel("Reloj");
		clock.setForeground(new Color(255, 255, 255));
		clock.setHorizontalAlignment(SwingConstants.CENTER);
		clock.setBounds(604, 10, 152, 23);
		HMIDatos.add(clock);
		
		  Timer timer = new Timer(500, new ActionListener() {
			  @Override
			  public void actionPerformed(ActionEvent e) {
				  clock.setText(DateFormat.getDateTimeInstance().format(new Date()));;
		      	}
			    });
		    timer.setRepeats(true);
		    timer.setCoalesce(true);
		    timer.setInitialDelay(0);
		    timer.start();
			
		JLabel lblNewLabel_1 = new JLabel("Electrónica y Control de Post-Procesadores");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(252, 8, 310, 23);
		HMIDatos.add(lblNewLabel_1);
		
		JPanel MenuPrincipal = new JPanel();
		MenuPrincipal.setBackground(SystemColor.activeCaption);
		MenuPrincipal.setBounds(10, 60, 204, 358);
		getContentPane().add(MenuPrincipal);
		MenuPrincipal.setLayout(null);
		
		seleccionFiguras.setFont(new Font("Tahoma", Font.BOLD, 10));
		seleccionFiguras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		seleccionFiguras.setBounds(27, 31, 140, 25);
		MenuPrincipal.add(seleccionFiguras);
		
			seteoConfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		seteoConfig.setFont(new Font("Tahoma", Font.BOLD, 10));
		seteoConfig.setBounds(27, 107, 140, 25);
		MenuPrincipal.add(seteoConfig);
		
		
		escalarFiguras.setFont(new Font("Tahoma", Font.BOLD, 10));
		escalarFiguras.setBounds(27, 183, 140, 25);
		MenuPrincipal.add(escalarFiguras);
		
		ventanaHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ventanaHome.setFont(new Font("Tahoma", Font.BOLD, 10));
		ventanaHome.setBounds(10, 327, 89, 21);
		MenuPrincipal.add(ventanaHome);
		
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInfo.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnInfo.setBounds(109, 327, 85, 21);
		MenuPrincipal.add(btnInfo);
			
			
		btnConfigCNC.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnConfigCNC.setBounds(27, 259, 140, 25);
		MenuPrincipal.add(btnConfigCNC);
		jPInfo.setVisible(false);
		
		jPInfo.setBounds(224, 60, 552, 358);
		getContentPane().add(jPInfo);
		jPInfo.setLayout(null);
		
        JLabel lblNewLabel_2_2 = new JLabel("ELECTRÓNICA Y CONTROL DE POST-PROCESADORES");
        lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2_2.setBounds(81, 173, 382, 17);
        jPInfo.add(lblNewLabel_2_2);
        
        JLabel lblNewLabel_2_1_4 = new JLabel("AYMARA JORGE");
        lblNewLabel_2_1_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2_1_4.setBounds(111, 280, 114, 17);
        jPInfo.add(lblNewLabel_2_1_4);
        
        JLabel lblNewLabel_2_1_1_1 = new JLabel("GIA JANIS");
        lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2_1_1_1.setBounds(111, 307, 114, 17);
        jPInfo.add(lblNewLabel_2_1_1_1);
        
        JLabel lblNewLabel_2_1_2_1 = new JLabel("TACO ERICK");
        lblNewLabel_2_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2_1_2_1.setBounds(302, 280, 114, 17);
        jPInfo.add(lblNewLabel_2_1_2_1);
        
        JLabel lblNewLabel_2_1_2_1_1 = new JLabel("ZUÑIGA JOSÉ");
        lblNewLabel_2_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2_1_2_1_1.setBounds(302, 307, 114, 17);
        jPInfo.add(lblNewLabel_2_1_2_1_1);
        
        JLabel lblNewLabel_2_2_1 = new JLabel("DRA. ING. SILVANA GAMBOA BENÍTEZ");
        lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2_2_1.setBounds(134, 200, 276, 17);
        jPInfo.add(lblNewLabel_2_2_1);
        
        JLabel lblNewLabel_2_1_4_1 = new JLabel("INTEGRANTES:");
        lblNewLabel_2_1_4_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2_1_4_1.setBounds(208, 253, 114, 17);
        jPInfo.add(lblNewLabel_2_1_4_1);
        
        JLabel lblNewLabel_2_2_2 = new JLabel("IMPLEMENTACIÓN Y PUESTA EN MARCHA - MÁQUINA CNC PARA DIBUJO");
        lblNewLabel_2_2_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2_2_2.setBounds(16, 127, 526, 17);
        jPInfo.add(lblNewLabel_2_2_2);
        
        JLabel lblNewLabel_2_2_3 = new JLabel("\r\n\r\n");
        lblNewLabel_2_2_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_2_3.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2_2_3.setBounds(332, 115, 210, 17);
        jPInfo.add(lblNewLabel_2_2_3);
        
        JLabel lblNewLabel_2_2_4 = new JLabel("ESCUELA POLITÉCNICA NACIONAL");
        lblNewLabel_2_2_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_2_4.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2_2_4.setBounds(111, 10, 322, 22);
        jPInfo.add(lblNewLabel_2_2_4);
        
        JLabel lblNewLabel_2_2_1_1 = new JLabel("FACULTAD DE INGENIERÍA MECÁNICA ");
        lblNewLabel_2_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel_2_2_1_1.setBounds(115, 42, 315, 20);
        jPInfo.add(lblNewLabel_2_2_1_1);
        
        JLabel lblNewLabel_2_2_3_1 = new JLabel("MAESTRÍA EN MECATRÓNICA Y ROBÓTICA \r\n");
        lblNewLabel_2_2_3_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_2_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_2_2_3_1.setBounds(103, 72, 338, 19);
        jPInfo.add(lblNewLabel_2_2_3_1);
	    
	}
}

