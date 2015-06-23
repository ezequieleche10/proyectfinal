package Desktop;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;


import Negocio.Controlador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.GridBagLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;

public class PrincipalDesktop extends JFrame {

	private JPanel contentPane;
	private static Controlador cont;

	

	 
	public PrincipalDesktop() {
		cont= new Controlador();
		setTitle("Bienvenidos Instituto Olga Cossettini");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		menuBar.add( Box.createHorizontalStrut( 10 ) );  //this will add a 10 pixel space
		
		JMenu mnProfesor= new JMenu("Profesores");
		menuBar.add(mnProfesor);
		menuBar.add( Box.createHorizontalStrut( 10 ) );  //this will add a 10 pixel space
		
		JMenuItem mnuAgregar = new JMenuItem("Agregar");
		mnuAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProfesorDesktop prof = new ProfesorDesktop(cont);
				prof.setVisible(true);
				prof.setLocationRelativeTo(null);//la centra
			    prof.setMinimumSize(new Dimension(500,300));
			  
			}
		});
		mnProfesor.add(mnuAgregar);
		//define panel
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JMenu mnExamenes = new JMenu("Examenes");
		menuBar.add(mnExamenes);
		
		
		
		JPanel panelCargarAlumnos= new JPanel(new GridLayout());
		JLabel lblHola= new JLabel();
		lblHola.setText("Soy el panel que carga los alumnos");
		panelCargarAlumnos.add(lblHola);
		JPanel panelListarAlumnos= new JPanel( new GridLayout());
		JLabel lblChau= new JLabel();
		lblChau.setText("Soy el panel listar alumnos");
		panelListarAlumnos.add(lblChau);
		JPanel panelNulo= new JPanel();
		
		JPanel panelPpal = new JPanel();
		contentPane.add(panelPpal);
		panelPpal.setLayout(new CardLayout(0, 0));
		//Pon los paneles en el panel con el CardLayout
		PanelCargaAlumnos panelTA= new PanelCargaAlumnos(cont, panelPpal);
		PanelListarAlumnos panelGE= new PanelListarAlumnos(cont,panelPpal);
		PanelGenerarExamen panelGenerar= new PanelGenerarExamen(cont,panelPpal);
		
		panelPpal.add(panelNulo,"Panel por defecto");
		panelPpal.add(panelCargarAlumnos,"Panel para cargar alumnos");
		panelPpal.add(panelListarAlumnos,"Panel que lista alumnos");
		panelPpal.add(panelTA,"Panel carga alumnos");
		panelPpal.add(panelGE,"Panel lista alumnos");
		panelPpal.add(panelGenerar,"Panel genera examen");
	//	panelPpal.add(panelListarAlumnos, "Panel para la solicitud de clave");
	
		JMenuItem mnListarAlumnos = new JMenuItem("Alumnos en condiciones");
		mnListarAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout)(panelPpal.getLayout());
			      cl.show(panelPpal, "Panel lista alumnos");
				
			}
		});
		
		JMenuItem mnAgregarExamen = new JMenuItem("Agregar examen");
		mnAgregarExamen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ExamenDesktop exam = new ExamenDesktop(cont);
				exam.setVisible(true);
				exam.setLocationRelativeTo(null);//la centra
				exam.setMinimumSize(new Dimension(500,300));
			}
		});
		mnExamenes.add(mnAgregarExamen);
		mnExamenes.add(mnListarAlumnos);
		
		JMenuItem mnuGenerarExamen = new JMenuItem("Generar Examen");
		mnuGenerarExamen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panelPpal.getLayout());
			      cl.show(panelPpal, "Panel genera examen");
			}
		});
		mnExamenes.add(mnuGenerarExamen);
		
		JMenuItem mnuCargarAlumnos = new JMenuItem("Cargar Alumnos");
		mnuCargarAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout)(panelPpal.getLayout());
			      cl.show(panelPpal, "Panel carga alumnos");
			 
			 
			}
		});
		mnArchivo.add(mnuCargarAlumnos);
		
		JMenuItem mntmListarAlumnos = new JMenuItem("Listar Alumnos");
		mntmListarAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout)(panelPpal.getLayout());
			      cl.show(panelPpal, "Panel que lista alumnos");
			}
		});
		mnArchivo.add(mntmListarAlumnos);
		
		JMenuItem mnuCerrar = new JMenuItem("Cerrar");
		mnuCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mnArchivo.add(mnuCerrar);
	}
}
