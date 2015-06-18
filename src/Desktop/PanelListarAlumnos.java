package Desktop;

import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Entidades.Alumno;
import Entidades.Examen;
import Negocio.Controlador;

import javax.swing.SpinnerNumberModel;
import javax.swing.table.TableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class PanelListarAlumnos extends JPanel {
	private JTable tablaAlumnosenCondiciones;
	private JComboBox<Object> cboCarrera;
	private Controlador contr;
	private ArrayList<Alumno> alumnos;
	private JTextField txtCod_examen;
	private JTextField txtTipo_examen;
	private JButton btnGenerarExamen;

	/**
	 * Create the panel.
	 */
	public PanelListarAlumnos(Controlador cont, JPanel panel) {
		contr=cont;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 122, 0, 0, 33, 78, 0, 38, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 28, 0, 342, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblIngreseCarrera = new JLabel("Ingrese carrera:");
		GridBagConstraints gbc_lblIngreseCarrera = new GridBagConstraints();
		gbc_lblIngreseCarrera.anchor = GridBagConstraints.EAST;
		gbc_lblIngreseCarrera.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngreseCarrera.gridx = 1;
		gbc_lblIngreseCarrera.gridy = 1;
		add(lblIngreseCarrera, gbc_lblIngreseCarrera);
		
		cboCarrera = new JComboBox<Object>();
		GridBagConstraints gbc_cboCarrera = new GridBagConstraints();
		gbc_cboCarrera.anchor = GridBagConstraints.NORTH;
		gbc_cboCarrera.insets = new Insets(0, 0, 5, 5);
		gbc_cboCarrera.fill = GridBagConstraints.HORIZONTAL;
		gbc_cboCarrera.gridx = 2;
		gbc_cboCarrera.gridy = 1;
		add(cboCarrera, gbc_cboCarrera);
		try{
			cargarCombo();
			}catch(Exception e ){
				//JOptionPane.showMessageDialog(null, "Error al cargar combo, conecte a la base de datos y vuelva a iniciar el programa");
				//frame.dispose()
			}
		
		JLabel lblAnio = new JLabel("A\u00F1o:");
		GridBagConstraints gbc_lblAnio = new GridBagConstraints();
		gbc_lblAnio.anchor = GridBagConstraints.EAST;
		gbc_lblAnio.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnio.gridx = 3;
		gbc_lblAnio.gridy = 1;
		add(lblAnio, gbc_lblAnio);
		
		JSpinner spinAnio = new JSpinner();
		spinAnio.setModel(new SpinnerNumberModel(2015, 1990, 2030, 1));
		//spinAnio.set
		GridBagConstraints gbc_spinAnio = new GridBagConstraints();
		gbc_spinAnio.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinAnio.insets = new Insets(0, 0, 5, 5);
		gbc_spinAnio.gridwidth = 2;
		gbc_spinAnio.gridx = 4;
		gbc_spinAnio.gridy = 1;
		add(spinAnio, gbc_spinAnio);
		
		JButton btnBuscarExamen = new JButton("Buscar");
		btnBuscarExamen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int cod_carrera=0;
				int anio= Integer.parseInt(spinAnio.getValue().toString());
				String nombre_carrera= cboCarrera.getSelectedItem().toString();
				if(nombre_carrera.equals("Traductorado de Ingles")){
					cod_carrera=1;
				}else cod_carrera=2;
				//alumnos=new ArrayList<Alumno>();
				Examen ex= contr.mostrarExamenPendiente(anio, cod_carrera);
				txtCod_examen.setText(String.valueOf(ex.getCod_examen()));
				txtTipo_examen.setText(ex.getTipo_examen());
				if(txtTipo_examen.getText()!=null)
				{
					try {
						cargarTabla(contr.listarAlumnos(Integer.parseInt(txtCod_examen.getText().toString())));
						btnGenerarExamen.setEnabled(true);
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		});
		GridBagConstraints gbc_btnBuscarExamen = new GridBagConstraints();
		gbc_btnBuscarExamen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBuscarExamen.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscarExamen.gridx = 6;
		gbc_btnBuscarExamen.gridy = 1;
		add(btnBuscarExamen, gbc_btnBuscarExamen);
		
		
		
		JLabel lblCodexamen = new JLabel("Cod_examen");
		GridBagConstraints gbc_lblCodexamen = new GridBagConstraints();
		gbc_lblCodexamen.anchor = GridBagConstraints.EAST;
		gbc_lblCodexamen.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodexamen.gridx = 1;
		gbc_lblCodexamen.gridy = 2;
		add(lblCodexamen, gbc_lblCodexamen);
		
		txtCod_examen = new JTextField();
		txtCod_examen.setEditable(false);
		GridBagConstraints gbc_txtCod_examen = new GridBagConstraints();
		gbc_txtCod_examen.insets = new Insets(0, 0, 5, 5);
		gbc_txtCod_examen.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCod_examen.gridx = 2;
		gbc_txtCod_examen.gridy = 2;
		add(txtCod_examen, gbc_txtCod_examen);
		txtCod_examen.setColumns(10);
		
		JLabel lblTipoExamen = new JLabel("Tipo Examen:");
		GridBagConstraints gbc_lblTipoExamen = new GridBagConstraints();
		gbc_lblTipoExamen.anchor = GridBagConstraints.EAST;
		gbc_lblTipoExamen.gridwidth = 2;
		gbc_lblTipoExamen.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoExamen.gridx = 3;
		gbc_lblTipoExamen.gridy = 2;
		add(lblTipoExamen, gbc_lblTipoExamen);
		
		txtTipo_examen = new JTextField();
		txtTipo_examen.setEditable(false);
		GridBagConstraints gbc_txtTipo_examen = new GridBagConstraints();
		gbc_txtTipo_examen.insets = new Insets(0, 0, 5, 5);
		gbc_txtTipo_examen.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTipo_examen.gridx = 5;
		gbc_txtTipo_examen.gridy = 2;
		add(txtTipo_examen, gbc_txtTipo_examen);
		txtTipo_examen.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("sadsd");
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 4;
		add(scrollPane, gbc_scrollPane);
		
		tablaAlumnosenCondiciones = new JTable();
		scrollPane.setViewportView(tablaAlumnosenCondiciones);
		
		JButton btnCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 6;
		gbc_btnCancelar.gridy = 5;
		add(btnCancelar, gbc_btnCancelar);
		
		btnGenerarExamen = new JButton("Guardar");
		btnGenerarExamen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int resp = JOptionPane.showConfirmDialog(null, "¿Estas seguro de generar el examen?");
				if (JOptionPane.OK_OPTION==resp)
				{
					try {
						alumnos = recuperarAlumnos();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				 try {
					
					cont.agregarAlumnosEnExamen(alumnos, Integer.parseInt(txtCod_examen.getText().toString()));
				    this.limpiarPanel();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				}
				
			}

			private void limpiarPanel() {
			  removeAll();
			  repaint();
			}
		});
		btnGenerarExamen.setEnabled(false);
		GridBagConstraints gbc_btnGenerarExamen = new GridBagConstraints();
		gbc_btnGenerarExamen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGenerarExamen.insets = new Insets(0, 0, 5, 5);
		gbc_btnGenerarExamen.gridx = 7;
		gbc_btnGenerarExamen.gridy = 5;
		add(btnGenerarExamen, gbc_btnGenerarExamen);
		
		
		
	}
public void cargarCombo() throws Exception{
	       cboCarrera.addItem("Seleccione una carrera");	
	for(int i=0; i<contr.buscarCarreras().size();++i){
			cboCarrera.addItem(contr.buscarCarreras().get(i).getNombre());
		}
	
}

public void cargarTabla(ArrayList<Alumno> alumnos) throws Exception {
	XTableModelAlumnos modelo1= new XTableModelAlumnos();
	modelo1.setDatasource(alumnos);

	tablaAlumnosenCondiciones.getTableHeader().setReorderingAllowed(false);
	tablaAlumnosenCondiciones.setModel(modelo1);
	btnGenerarExamen.setEnabled(true);
	
}

public ArrayList<Alumno> recuperarAlumnos() throws Exception
{
	TableModel tm=	tablaAlumnosenCondiciones.getModel();
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
	return alums;
}
}
