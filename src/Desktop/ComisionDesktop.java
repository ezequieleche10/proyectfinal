package Desktop;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JSplitPane;
import javax.swing.JList;

import java.awt.List;

import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.JTable;

import Entidades.Alumno;
import Entidades.Profesor;
import Negocio.Controlador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ComisionDesktop extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTable tablaProfesores;
	private JComboBox<Object> cboProfesores;
	private Controlador contr;
	private Profesor p;
	private ArrayList<Profesor> lp;
	
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ComisionDesktop(Controlador cont, int cod_examen, JLabel estadoComision) {
		contr = cont;
		lp= new ArrayList<Profesor>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{67, 85, 58, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 48, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		contentPane.add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 1;
		gbc_txtNombre.gridy = 1;
		contentPane.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		GridBagConstraints gbc_lblDescripcin = new GridBagConstraints();
		gbc_lblDescripcin.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblDescripcin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcin.gridx = 2;
		gbc_lblDescripcin.gridy = 1;
		contentPane.add(lblDescripcin, gbc_lblDescripcin);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 3;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		JTextArea txtDescripcion = new JTextArea();
		scrollPane.setViewportView(txtDescripcion);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Agregar profesores a la comision", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 6;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblProfesor = new JLabel("Profesor");
		GridBagConstraints gbc_lblProfesor = new GridBagConstraints();
		gbc_lblProfesor.anchor = GridBagConstraints.EAST;
		gbc_lblProfesor.insets = new Insets(0, 0, 0, 5);
		gbc_lblProfesor.gridx = 1;
		gbc_lblProfesor.gridy = 0;
		panel.add(lblProfesor, gbc_lblProfesor);
		
		cboProfesores = new JComboBox<Object>();
		GridBagConstraints gbc_cboProfesores = new GridBagConstraints();
		gbc_cboProfesores.gridwidth = 2;
		gbc_cboProfesores.insets = new Insets(0, 0, 0, 5);
		gbc_cboProfesores.fill = GridBagConstraints.HORIZONTAL;
		gbc_cboProfesores.gridx = 2;
		gbc_cboProfesores.gridy = 0;
		try{
			cargarCombo();
			}catch(Exception e ){
				JOptionPane.showMessageDialog(null, "Error al cargar combo, conecte a la base de datos y vuelva a iniciar el programa");
				//frame.dispose()
			}
		panel.add(cboProfesores, gbc_cboProfesores);
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridheight = 3;
		gbc_scrollPane_1.gridwidth = 6;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 3;
		contentPane.add(scrollPane_1, gbc_scrollPane_1);
		
		tablaProfesores = new JTable();
		scrollPane_1.setViewportView(tablaProfesores);
		
		
		
		
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int indi=cboProfesores.getSelectedIndex();
				if(indi!=0)
				{
				Profesor pr= new Profesor();
		        pr= (Profesor)cboProfesores.getSelectedItem();
		        cboProfesores.removeItem(pr);
		        lp.add(pr);
		        
		        cargarTabla(lp);
				}else JOptionPane.showMessageDialog(null, "No ha seleccionado ningun elemento");
			}
		});
		GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
		gbc_btnAgregar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAgregar.gridx = 4;
		gbc_btnAgregar.gridy = 0;
		panel.add(btnAgregar, gbc_btnAgregar);
		
		JButton btnCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.anchor = GridBagConstraints.EAST;
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 3;
		gbc_btnCancelar.gridy = 6;
		contentPane.add(btnCancelar, gbc_btnCancelar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TableModel tp=	tablaProfesores.getModel();
				int cols = tp.getColumnCount(); 
				int filas = tp.getRowCount();
				ArrayList<Profesor> profes= new ArrayList<Profesor>();
				for(int i=0; i<filas; i++) { 
					Profesor pr = new Profesor();
				for(int j=0; j<cols; j++){ 
					switch(j){
				case 0: pr.setCod_profesor((Integer.parseInt(tp.getValueAt(i,j).toString())));break;
				case 1: pr.setApellido(tp.getValueAt(i,j).toString());break;
				case 2: pr.setNombre(tp.getValueAt(i,j).toString()); break;
				
					}
					
				}
				profes.add(pr);
				}
				try {
					//llamar al controlador para que agregue el arraylist de profesores
					int cod_comision = contr.agregarComision(cod_examen, txtNombre.getText().toString(), txtDescripcion.getText().toString());
					contr.asignarProfesores(profes, cod_comision);
					estadoComision.setText("Comisión generada");
					dispose();
				  
				} catch (Exception el) {
					// TODO Auto-generated catch block
					el.printStackTrace();
				}
				
				}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.anchor = GridBagConstraints.WEST;
		gbc_btnGuardar.gridwidth = 2;
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 4;
		gbc_btnGuardar.gridy = 6;
		contentPane.add(btnGuardar, gbc_btnGuardar);
		
		
	}
	
	public void cargarCombo() throws Exception{
	       cboProfesores.addItem("Selecciones un profesor");	
	for(int i=0; i<contr.buscarProfesores().size();++i){
		p= new Profesor(contr.buscarProfesores().get(i).getCod_profesor(), contr.buscarProfesores().get(i).getNombre(), contr.buscarProfesores().get(i).getApellido());
		cboProfesores.addItem(p);
		}
	
	
}
	public void cargarTabla(ArrayList<Profesor> lp){
		XTableModelProfesores modelo= new XTableModelProfesores();
		modelo.setDatasource(lp);
		tablaProfesores.getTableHeader().setReorderingAllowed(false);
		tablaProfesores.setModel(modelo);
		
		
	}

}
