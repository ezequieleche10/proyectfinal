package Desktop;

import javax.swing.JPanel;

import Entidades.Alumno;
import Entidades.AlumnoEnEjercicio;
import Entidades.Ejercicio;
import Entidades.Examen;
import Negocio.Controlador;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.JTextField;

public class PanelCargaNotas extends JPanel {

	Controlador contr;
	private JTable tableComisiones;
	private int codigprof;
	private JComboBox<Object> cboEjercicios;
	private JTable tableNotas;
	private JTextField txtTotalItems;
	private JLabel lblTotalItems;
	private JLabel lblSeleccionarEjercicio;
	private JScrollPane scrollNotas;
	private JTextField txtPorcentaje;
	private JLabel lblPorcentaje;
	private int op=0;
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public PanelCargaNotas(Controlador cont,JPanel panelPpal, int cod_profesor) throws Exception {
		contr=cont;
		codigprof = cod_profesor;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 109, 116, 0, 0, 33, 42, -28, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.2, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 7;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		
		tableComisiones = new JTable();
		scrollPane.setViewportView(tableComisiones);
		
		JLabel lblSeleccioneElModo = new JLabel("Seleccione el modo de ingresar las notas:");
		GridBagConstraints gbc_lblSeleccioneElModo = new GridBagConstraints();
		gbc_lblSeleccioneElModo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSeleccioneElModo.gridx = 1;
		gbc_lblSeleccioneElModo.gridy = 2;
		add(lblSeleccioneElModo, gbc_lblSeleccioneElModo);
		
		JComboBox cboOpcion = new JComboBox();
		cboOpcion.setModel(new DefaultComboBoxModel(new String[] {"seleccionar modo", "por ejercicio", "por alumno"}));
		GridBagConstraints gbc_cboOpcion = new GridBagConstraints();
		gbc_cboOpcion.insets = new Insets(0, 0, 5, 5);
		gbc_cboOpcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_cboOpcion.gridx = 2;
		gbc_cboOpcion.gridy = 2;
		add(cboOpcion, gbc_cboOpcion);
		
		JButton btnBuscar = new JButton("Buscar acta");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				op=cboOpcion.getSelectedIndex();
				int codigo=recuperarDatosTabla();
				if(op!=0 && codigo!=0){
					//se va a buscar los alumnos en examen en ejercicio
					cboEjercicios.setVisible(true);
					scrollNotas.setVisible(true);
					tableNotas.setVisible(true);
					lblSeleccionarEjercicio.setVisible(true);
					switch(op){
					case 1: try {
							cargaPorEjercicios(codigo);
							lblSeleccionarEjercicio.setText("Seleccione ejercicio");
						    lblTotalItems.setVisible(true);
						    txtTotalItems.setVisible(true);
						    
						    
						    txtPorcentaje.setVisible(true);
						    lblPorcentaje.setVisible(true);
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					case 2:
						try { 
							lblSeleccionarEjercicio.setText("Seleccione alumno");
							cargaPorAlumnos(codigo);
					
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					} 
				     
					
				}else if(op==0) JOptionPane.showMessageDialog(null, "Debe escoger el modo", "Error", JOptionPane.ERROR_MESSAGE);
				else JOptionPane.showMessageDialog(null, "Debe seleccionar un examen", "Error", JOptionPane.ERROR_MESSAGE);
			}

			
		});
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBuscar.anchor = GridBagConstraints.NORTH;
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscar.gridx = 3;
		gbc_btnBuscar.gridy = 2;
		add(btnBuscar, gbc_btnBuscar);
		
		scrollNotas = new JScrollPane();
		scrollNotas.setVisible(false);
		
		lblTotalItems = new JLabel("Total Items:");
		lblTotalItems.setVisible(false);
		
		cboEjercicios= new JComboBox<Object>();
		cboEjercicios.setVisible(false);
		cboEjercicios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cboEjercicios.getSelectedIndex()!=0)
					try {
						cargarTablaNotas(op);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		
		lblSeleccionarEjercicio = new JLabel("Seleccionar ejercicio:");
		lblSeleccionarEjercicio.setVisible(false);
		GridBagConstraints gbc_lblSeleccionarEjercicio = new GridBagConstraints();
		gbc_lblSeleccionarEjercicio.anchor = GridBagConstraints.EAST;
		gbc_lblSeleccionarEjercicio.insets = new Insets(0, 0, 5, 5);
		gbc_lblSeleccionarEjercicio.gridx = 1;
		gbc_lblSeleccionarEjercicio.gridy = 3;
		add(lblSeleccionarEjercicio, gbc_lblSeleccionarEjercicio);
		
		
		GridBagConstraints gbc_cboEjercicios = new GridBagConstraints();
		gbc_cboEjercicios.anchor = GridBagConstraints.NORTH;
		gbc_cboEjercicios.insets = new Insets(0, 0, 5, 5);
		gbc_cboEjercicios.fill = GridBagConstraints.HORIZONTAL;
		gbc_cboEjercicios.gridx = 2;
		gbc_cboEjercicios.gridy = 3;
		add(cboEjercicios, gbc_cboEjercicios);
		GridBagConstraints gbc_lblTotalItems = new GridBagConstraints();
		gbc_lblTotalItems.anchor = GridBagConstraints.EAST;
		gbc_lblTotalItems.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalItems.gridx = 3;
		gbc_lblTotalItems.gridy = 3;
		add(lblTotalItems, gbc_lblTotalItems);
		
		txtTotalItems = new JTextField();
		txtTotalItems.setEditable(false);
		txtTotalItems.setVisible(false);
		GridBagConstraints gbc_txtTotalItems = new GridBagConstraints();
		gbc_txtTotalItems.insets = new Insets(0, 0, 5, 5);
		gbc_txtTotalItems.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTotalItems.gridx = 4;
		gbc_txtTotalItems.gridy = 3;
		add(txtTotalItems, gbc_txtTotalItems);
		txtTotalItems.setColumns(10);
		
		lblPorcentaje = new JLabel("Porcentaje:");
		lblPorcentaje.setVisible(false);
		GridBagConstraints gbc_lblPorcentaje = new GridBagConstraints();
		gbc_lblPorcentaje.anchor = GridBagConstraints.EAST;
		gbc_lblPorcentaje.insets = new Insets(0, 0, 5, 5);
		gbc_lblPorcentaje.gridx = 5;
		gbc_lblPorcentaje.gridy = 3;
		add(lblPorcentaje, gbc_lblPorcentaje);
		
		txtPorcentaje = new JTextField();
		txtPorcentaje.setEditable(false);
		txtPorcentaje.setVisible(false);
		GridBagConstraints gbc_txtPorcentaje = new GridBagConstraints();
		gbc_txtPorcentaje.insets = new Insets(0, 0, 5, 5);
		gbc_txtPorcentaje.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPorcentaje.gridx = 6;
		gbc_txtPorcentaje.gridy = 3;
		add(txtPorcentaje, gbc_txtPorcentaje);
		txtPorcentaje.setColumns(10);
		GridBagConstraints gbc_scrollNotas = new GridBagConstraints();
		gbc_scrollNotas.gridheight = 4;
		gbc_scrollNotas.gridwidth = 7;
		gbc_scrollNotas.insets = new Insets(0, 0, 5, 5);
		gbc_scrollNotas.fill = GridBagConstraints.BOTH;
		gbc_scrollNotas.gridx = 1;
		gbc_scrollNotas.gridy = 4;
		add(scrollNotas, gbc_scrollNotas);
		
		tableNotas = new JTable();
		scrollNotas.setViewportView(tableNotas);
		tableNotas.setVisible(false);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Ejercicio ex= new Ejercicio();
				ex= (Ejercicio)cboEjercicios.getSelectedItem();
				contr.cargarNotas(ex);
				
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 8;
		gbc_btnCancelar.gridy = 8;
		add(btnCancelar, gbc_btnCancelar);
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.anchor = GridBagConstraints.WEST;
		gbc_btnGuardar.gridx = 9;
		gbc_btnGuardar.gridy = 8;
		add(btnGuardar, gbc_btnGuardar);
		llenarTabla();

	}
	private void llenarTabla() throws Exception {
		ArrayList<Examen> listaExamenes = new ArrayList<Examen>();
		listaExamenes = contr.buscarExamenes(codigprof);
		if (listaExamenes.size()!=0)
		{
			XTableModelExamenes modelo= new XTableModelExamenes();
			modelo.setDatasource(listaExamenes);
			tableComisiones.getTableHeader().setReorderingAllowed(false);
			tableComisiones.setModel(modelo);
		}
		
	}
	private int recuperarDatosTabla(){
		TableModel tc=	tableComisiones.getModel();
		//int cols = tc.getColumnCount(); 
		int filas = tc.getRowCount();
		int codigo=0;
		for(int i=0; i<filas; i++) { 
			
			if(Boolean.parseBoolean(tc.getValueAt(i, 3).toString()))
		     {codigo= Integer.parseInt(tc.getValueAt(i, 0).toString());
		     break;
		     }
		}
		
		return codigo;
		
	}
	private void cargaPorAlumnos(int codigo) {
		cboEjercicios.addItem("Seleccione alumno");
		ArrayList<Alumno> alums= new ArrayList<Alumno>();
	   	alums= contr.getAlumnosenExamen(codigo);
	   	for(int i=0; i<alums.size();++i){
	   		
	   			cboEjercicios.addItem(alums.get(i));
	   		}
	}

	private void cargaPorEjercicios(int codigo) throws Exception {
	   	cboEjercicios.addItem("Seleccione ejercicio");
	   	ArrayList<Ejercicio> ejs= new ArrayList<Ejercicio>();
	   	ejs= contr.getAllEjercicios(codigo);
	   	for(int i=0; i<ejs.size();++i){
	   		
	   			cboEjercicios.addItem(ejs.get(i));
	   		}
	
	}
	private void cargarTablaNotas(int opc) throws Exception{
		if(opc==1)
		{
		Ejercicio ej = new Ejercicio();
		ej=(Ejercicio)cboEjercicios.getSelectedItem();
		txtTotalItems.setText(String.valueOf(ej.getCant_items()));
		txtPorcentaje.setText(String.valueOf(ej.getPorcentaje()));
		XTableModelNotas modelo= new XTableModelNotas();
		modelo.setDatasource(ej.getListaAlumnos());
		tableNotas.getTableHeader().setReorderingAllowed(false);
		tableNotas.setModel(modelo);
		}
		else
		{
	    Alumno al = new Alumno();
		int cod_ex=recuperarDatosTabla();
		al=(Alumno)cboEjercicios.getSelectedItem();
		ArrayList<AlumnoEnEjercicio> alumenej= new ArrayList<AlumnoEnEjercicio>();
	    alumenej= contr.getAlumnosenEjercicio(cod_ex,al);
	    XTableModelNotasAl modeloA= new XTableModelNotasAl();
		modeloA.setDatasource(alumenej);
		tableNotas.getTableHeader().setReorderingAllowed(false);
		tableNotas.setModel(modeloA);
		}
	}
	

}
