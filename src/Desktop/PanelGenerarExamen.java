package Desktop;

import javax.swing.JPanel;

import Entidades.Examen;
import Negocio.Controlador;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import java.awt.Font;

import javax.swing.UIManager;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelGenerarExamen extends JPanel {

	private JComboBox<Object> comboCarrera;
	Controlador contr;
	private JTextField txtTipoExamen;
	private JLabel lblEstadoExamen;
	private JLabel lblEstadoEjercicios;
	public JLabel lblEstadoComision;
	private JLabel lblEstadoLista;
	private int cod_examen;
	private String mensaje;
	
	/**
	 * Create the panel.
	 */
	public PanelGenerarExamen(Controlador cont,JPanel panelPpal) {
		contr=cont;
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 38, 146, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 48, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.1, 1.0, 0.0, 0.1, 1.0, 0.1, 0.1, 0.1, 0.1, 0.0, 0.1, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.1, 0.1, 0.0, 1.0, 1.0, 0.1, 1.0, 1.0, 0.0, 0.0, 0.1, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblAo = new JLabel("A\u00F1o:");
		GridBagConstraints gbc_lblAo = new GridBagConstraints();
		gbc_lblAo.anchor = GridBagConstraints.EAST;
		gbc_lblAo.insets = new Insets(0, 0, 5, 5);
		gbc_lblAo.gridx = 1;
		gbc_lblAo.gridy = 1;
		add(lblAo, gbc_lblAo);
		
		JSpinner spinAnio = new JSpinner();
		spinAnio.setModel(new SpinnerNumberModel(new Integer(2015), new Integer(1990), null, new Integer(1)));
		GridBagConstraints gbc_spinAnio = new GridBagConstraints();
		gbc_spinAnio.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinAnio.insets = new Insets(0, 0, 5, 5);
		gbc_spinAnio.gridx = 2;
		gbc_spinAnio.gridy = 1;
		add(spinAnio, gbc_spinAnio);
		
		JLabel lblCarrera = new JLabel("Carrera:");
		GridBagConstraints gbc_lblCarrera = new GridBagConstraints();
		gbc_lblCarrera.anchor = GridBagConstraints.EAST;
		gbc_lblCarrera.insets = new Insets(0, 0, 5, 5);
		gbc_lblCarrera.gridx = 3;
		gbc_lblCarrera.gridy = 1;
		add(lblCarrera, gbc_lblCarrera);
		
		
		
		comboCarrera = new JComboBox<Object>();
		GridBagConstraints gbc_comboCarrera = new GridBagConstraints();
		gbc_comboCarrera.gridwidth = 3;
		gbc_comboCarrera.insets = new Insets(0, 0, 5, 5);
		gbc_comboCarrera.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboCarrera.gridx = 4;
		gbc_comboCarrera.gridy = 1;
		add(comboCarrera, gbc_comboCarrera);
		try{
			cargarCombo();
			}catch(Exception e ){
		//		JOptionPane.showMessageDialog(null, "Error al cargar combo, conecte a la base de datos y vuelva a iniciar el programa");
			    
			}
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cod_carrera = 0;
				int anio= Integer.parseInt(spinAnio.getValue().toString());
				String nombre_carrera= comboCarrera.getSelectedItem().toString();
				if(nombre_carrera.equals("Traductorado de Ingles")){
					cod_carrera=1;
				}else cod_carrera=2;
				Examen ex= contr.mostrarExamenPendiente(anio, cod_carrera);
				cod_examen=ex.getCod_examen();
				txtTipoExamen.setText(ex.getTipo_examen());
				String estadoLista = ex.getEstado();
				lblEstadoLista.setText(estadoLista);
				validarComisionyEjercicio(cod_examen);
				
				
				
				
				
			}
		});
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscar.gridx = 7;
		gbc_btnBuscar.gridy = 1;
		add(btnBuscar, gbc_btnBuscar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Evaluacion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.gridheight = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 3;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 102, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblTipo = new JLabel("Tipo:");
		GridBagConstraints gbc_lblTipo = new GridBagConstraints();
		gbc_lblTipo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipo.anchor = GridBagConstraints.EAST;
		gbc_lblTipo.gridx = 1;
		gbc_lblTipo.gridy = 0;
		panel.add(lblTipo, gbc_lblTipo);
		
		txtTipoExamen = new JTextField();
		txtTipoExamen.setEditable(false);
		GridBagConstraints gbc_txtTipoExamen = new GridBagConstraints();
		gbc_txtTipoExamen.insets = new Insets(0, 0, 5, 5);
		gbc_txtTipoExamen.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTipoExamen.gridx = 2;
		gbc_txtTipoExamen.gridy = 0;
		panel.add(txtTipoExamen, gbc_txtTipoExamen);
		txtTipoExamen.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.insets = new Insets(0, 0, 0, 5);
		gbc_lblEstado.gridx = 1;
		gbc_lblEstado.gridy = 1;
		panel.add(lblEstado, gbc_lblEstado);
		
		lblEstadoExamen = new JLabel("El estado");
		lblEstadoExamen.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		GridBagConstraints gbc_lblEstadoExamen = new GridBagConstraints();
		gbc_lblEstadoExamen.insets = new Insets(0, 0, 0, 5);
		gbc_lblEstadoExamen.gridx = 2;
		gbc_lblEstadoExamen.gridy = 1;
		panel.add(lblEstadoExamen, gbc_lblEstadoExamen);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Alumnos en condiciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 2;
		gbc_panel_1.gridwidth = 5;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 4;
		gbc_panel_1.gridy = 3;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnListaDeAlumnos = new JButton("Lista de alumnos");
		btnListaDeAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlumnosDesktop ad= new AlumnosDesktop(contr,cod_examen);
				ad.setVisible(true);
				ad.setLocationRelativeTo(null);//la centra
			    ad.setMinimumSize(new Dimension(500,300));
			   // ad.setMaximumSize(new Dimension(800,800));
			}
		});
		GridBagConstraints gbc_btnListaDeAlumnos = new GridBagConstraints();
		gbc_btnListaDeAlumnos.gridwidth = 3;
		gbc_btnListaDeAlumnos.insets = new Insets(0, 0, 5, 0);
		gbc_btnListaDeAlumnos.gridx = 2;
		gbc_btnListaDeAlumnos.gridy = 0;
		panel_1.add(btnListaDeAlumnos, gbc_btnListaDeAlumnos);
		
		JLabel lblEstado_1 = new JLabel("Estado:");
		GridBagConstraints gbc_lblEstado_1 = new GridBagConstraints();
		gbc_lblEstado_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblEstado_1.gridx = 2;
		gbc_lblEstado_1.gridy = 1;
		panel_1.add(lblEstado_1, gbc_lblEstado_1);
		
		lblEstadoLista = new JLabel("El estado");
		lblEstadoLista.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		GridBagConstraints gbc_lblEstadoLista = new GridBagConstraints();
		gbc_lblEstadoLista.gridwidth = 2;
		gbc_lblEstadoLista.gridx = 3;
		gbc_lblEstadoLista.gridy = 1;
		panel_1.add(lblEstadoLista, gbc_lblEstadoLista);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Comision", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 3;
		gbc_panel_2.gridheight = 4;
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 5;
		add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JButton btnCargarComision = new JButton("Cargar comisi\u00F3n");
		btnCargarComision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ComisionDesktop cd= new ComisionDesktop(contr,cod_examen, lblEstadoComision);
				cd.setVisible(true);
				cd.setLocationRelativeTo(null);//la centra
			    cd.setMinimumSize(new Dimension(500,300));
				
			}
		});
		GridBagConstraints gbc_btnCargarComision = new GridBagConstraints();
		gbc_btnCargarComision.insets = new Insets(0, 0, 5, 5);
		gbc_btnCargarComision.gridx = 2;
		gbc_btnCargarComision.gridy = 0;
		panel_2.add(btnCargarComision, gbc_btnCargarComision);
		
		JLabel lblEstado_2 = new JLabel("Estado:");
		GridBagConstraints gbc_lblEstado_2 = new GridBagConstraints();
		gbc_lblEstado_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblEstado_2.gridx = 1;
		gbc_lblEstado_2.gridy = 1;
		panel_2.add(lblEstado_2, gbc_lblEstado_2);
		
		lblEstadoComision = new JLabel("El estado");
		lblEstadoComision.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		GridBagConstraints gbc_lblEstadoComision = new GridBagConstraints();
		gbc_lblEstadoComision.insets = new Insets(0, 0, 0, 5);
		gbc_lblEstadoComision.gridx = 2;
		gbc_lblEstadoComision.gridy = 1;
		panel_2.add(lblEstadoComision, gbc_lblEstadoComision);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Ejercicios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridheight = 4;
		gbc_panel_3.gridwidth = 5;
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 4;
		gbc_panel_3.gridy = 5;
		add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JButton btnCargarEjercicios = new JButton("Cargar Ejercicios");
		btnCargarEjercicios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EjerciciosDesktop ed= new EjerciciosDesktop(contr,cod_examen, lblEstadoEjercicios);
				ed.setVisible(true);
				ed.setLocationRelativeTo(null);//la centra
			    ed.setMinimumSize(new Dimension(500,300));
			}
		});
		GridBagConstraints gbc_btnCargarEjercicios = new GridBagConstraints();
		gbc_btnCargarEjercicios.insets = new Insets(0, 0, 5, 5);
		gbc_btnCargarEjercicios.gridx = 2;
		gbc_btnCargarEjercicios.gridy = 0;
		panel_3.add(btnCargarEjercicios, gbc_btnCargarEjercicios);
		
		JLabel lblEstado_3 = new JLabel("Estado:");
		GridBagConstraints gbc_lblEstado_3 = new GridBagConstraints();
		gbc_lblEstado_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblEstado_3.gridx = 1;
		gbc_lblEstado_3.gridy = 1;
		panel_3.add(lblEstado_3, gbc_lblEstado_3);
		
		lblEstadoEjercicios = new JLabel("El estado");
		lblEstadoEjercicios.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		GridBagConstraints gbc_lblEstadoEjercicios = new GridBagConstraints();
		gbc_lblEstadoEjercicios.insets = new Insets(0, 0, 0, 5);
		gbc_lblEstadoEjercicios.gridx = 2;
		gbc_lblEstadoEjercicios.gridy = 1;
		panel_3.add(lblEstadoEjercicios, gbc_lblEstadoEjercicios);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CardLayout cl = (CardLayout)(panelPpal.getLayout());
			      cl.show(panelPpal, "Panel por defecto");
			}

			
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.anchor = GridBagConstraints.EAST;
		gbc_btnCancelar.gridwidth = 2;
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 6;
		gbc_btnCancelar.gridy = 9;
		add(btnCancelar, gbc_btnCancelar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mensaje="";
				
				if (validar())
				{
					int resp = JOptionPane.showConfirmDialog(null, "¿Estas seguro de generar el examen?");
					if (JOptionPane.OK_OPTION==resp)
					{
						
							try {
								contr.cambiarEstadoExamen(cod_examen, "generado");
								CardLayout cl = (CardLayout)(panelPpal.getLayout());
							      cl.show(panelPpal, "Panel por defecto");
								
							} catch (Exception e1) {
							
								e1.printStackTrace();
							}
						
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.anchor = GridBagConstraints.WEST;
		gbc_btnGuardar.gridwidth = 3;
		gbc_btnGuardar.insets = new Insets(0, 0, 5, 0);
		gbc_btnGuardar.gridx = 8;
		gbc_btnGuardar.gridy = 9;
		add(btnGuardar, gbc_btnGuardar);

	}
	
	

	public void cargarCombo() throws Exception{
	       comboCarrera.addItem("Seleccione una carrera");	
	for(int i=0; i<contr.buscarCarreras().size();++i){
			comboCarrera.addItem(contr.buscarCarreras().get(i).getNombre());
		}
	
}
	
	public boolean validar()
	{
		boolean e = true;
		if (!lblEstadoEjercicios.getText().toString().equals("Ejercicios cargados"))
				mensaje+="Debe cargar ejercicios \n";
		if (!lblEstadoComision.getText().toString().equals("Comision generada"))
			mensaje+="Debe generar comision \n";
		if(!lblEstadoLista.getText().toString().equals("alumnos cargados"))
			mensaje+="Debe cargar la lista de alumnos \n";
		if(!mensaje.equals(""))
			e=false;
		return e;
	}
	public void validarComisionyEjercicio(int cod_examen){
	  int[] valores=contr.validarComisionyEjercicio(cod_examen);
	  
	  lblEstadoExamen.setText("sin generar");
	  if(valores[0]!=0){
		  lblEstadoComision.setText("Comision generada");
	  }else lblEstadoComision.setText("sin generar");
		
		
	  if(valores[1]!=0){
		  lblEstadoEjercicios.setText("Ejercicios cargados");
	  }else lblEstadoEjercicios.setText("sin generar");
	}
	

}
