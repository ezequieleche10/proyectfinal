package Desktop;

import javax.swing.JPanel;

import java.awt.GridLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import Entidades.Alumno;
import Negocio.Controlador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

public class PanelCargaAlumnos extends JPanel {
	private JTable table;
	private JTextField txtExaminar;
	private JButton btnAgregarAlumnos;

	/**
	 * Create the panel.
	 */
	public PanelCargaAlumnos(Controlador cont ,JPanel panel) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 607, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 336, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
	
	/*
		
		
		*/
		
		JLabel lblRuta = new JLabel("Ruta:");
		GridBagConstraints gbc_lblRuta = new GridBagConstraints();
		gbc_lblRuta.anchor = GridBagConstraints.EAST;
		gbc_lblRuta.insets = new Insets(0, 0, 5, 5);
		gbc_lblRuta.gridx = 1;
		gbc_lblRuta.gridy = 1;
		add(lblRuta, gbc_lblRuta);
		
		txtExaminar = new JTextField();
		GridBagConstraints gbc_txtExaminar = new GridBagConstraints();
		gbc_txtExaminar.insets = new Insets(0, 0, 5, 5);
		gbc_txtExaminar.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtExaminar.gridx = 2;
		gbc_txtExaminar.gridy = 1;
		add(txtExaminar, gbc_txtExaminar);
		txtExaminar.setColumns(10);
		
		JButton btnExaminarArchivo = new JButton("Examinar archivo");
		btnExaminarArchivo.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("XLS files", "xls");
				chooser.setFileFilter(filter);
				
				int returnVal = chooser.showOpenDialog(getComponentPopupMenu());
					if(returnVal == JFileChooser.APPROVE_OPTION) {
				         txtExaminar.setText(chooser.getSelectedFile().getPath());
					      
					}
			}
		});
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 3;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		GridBagConstraints gbc_btnExaminarArchivo = new GridBagConstraints();
		gbc_btnExaminarArchivo.gridwidth = 2;
		gbc_btnExaminarArchivo.insets = new Insets(0, 0, 5, 5);
		gbc_btnExaminarArchivo.gridx = 3;
		gbc_btnExaminarArchivo.gridy = 1;
		add(btnExaminarArchivo, gbc_btnExaminarArchivo);
		
		JButton btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReadExcel leeArchivo= new ReadExcel();
				leeArchivo.setInputFile(txtExaminar.getText());
				try {
					ArrayList<Alumno> alumnosEnTabla=new ArrayList<Alumno>(); 
					alumnosEnTabla=leeArchivo.read();
					cargarTabla(alumnosEnTabla);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnProcesar = new GridBagConstraints();
		gbc_btnProcesar.gridwidth = 3;
		gbc_btnProcesar.insets = new Insets(0, 0, 5, 0);
		gbc_btnProcesar.gridx = 5;
		gbc_btnProcesar.gridy = 1;
		add(btnProcesar, gbc_btnProcesar);
		
		btnAgregarAlumnos = new JButton("Agregar alumnos");
		btnAgregarAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			TableModel tm=	table.getModel();
			int cols = tm.getColumnCount(); 
			int filas = tm.getRowCount();
			ArrayList<Alumno> alums= new ArrayList<Alumno>();
			for(int i=0; i<filas; i++) { 
				Alumno alum = new Alumno();
			for(int j=0; j<cols; j++){ 
				switch(j){
			case 0: alum.setDni(Integer.parseInt(tm.getValueAt(i,j).toString()));break;
			case 1: alum.setApellido(tm.getValueAt(i,j).toString());break;
			case 2: alum.setNombre(tm.getValueAt(i,j).toString()); break;
			case 3: alum.setMail(tm.getValueAt(i,j).toString()); break;
			case 4:alum.setIngreso_directo(tm.getValueAt(i,j).toString());break;
			case 5: alum.setTurno_eleccion(tm.getValueAt(i,j).toString());break;
				}
				
			}
			alums.add(alum);
			}
			try {
				cont.agregarAlumnos(alums);
				CardLayout cl = (CardLayout)(panel.getLayout());
			      cl.show(panel, "Panel por defecto");
			  
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}});
		
		GridBagConstraints gbc_btnAgregarAlumnos = new GridBagConstraints();
		gbc_btnAgregarAlumnos.insets = new Insets(0, 0, 0, 5);
		gbc_btnAgregarAlumnos.gridx = 4;
		gbc_btnAgregarAlumnos.gridy = 4;
		add(btnAgregarAlumnos, gbc_btnAgregarAlumnos);
		btnAgregarAlumnos.setEnabled(false);
		
		

	}
	public void cargarTabla(ArrayList<Alumno> alumnos){
		XTableModelAlumnos modelo= new XTableModelAlumnos();
		modelo.setDatasource(alumnos);
		table.getTableHeader().setReorderingAllowed(false);
		table.setModel(modelo);
		btnAgregarAlumnos.setEnabled(true);
	}

}
