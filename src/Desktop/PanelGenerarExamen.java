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
import javax.swing.border.LineBorder;

public class PanelGenerarExamen extends JPanel {
	Controlador contr;
	private JTextField txtTipoExamen;
	private JLabel lblEstadoExamen;
	private JLabel lblEstadoEjercicios;
	public JLabel lblEstadoComision;
	private JLabel lblEstadoLista;
	private int cod_examen;
	private String mensaje;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblErrorExamen;
	
	/**
	 * Create the panel.
	 */
	public PanelGenerarExamen(Controlador cont,JPanel panelPpal) {
		contr=cont;
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 82, 84, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 36, 36, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.1, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.1, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0, 0.0, 0.0, 0.1, 0.0, 0.0, 0.0, 0.1, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblAo = new JLabel("Ingrese el a\u00F1o:");
		GridBagConstraints gbc_lblAo = new GridBagConstraints();
		gbc_lblAo.gridwidth = 2;
		gbc_lblAo.anchor = GridBagConstraints.EAST;
		gbc_lblAo.insets = new Insets(0, 0, 5, 5);
		gbc_lblAo.gridx = 2;
		gbc_lblAo.gridy = 1;
		add(lblAo, gbc_lblAo);
		
		JSpinner spinAnio = new JSpinner();
		spinAnio.setModel(new SpinnerNumberModel(new Integer(2015), new Integer(1990), null, new Integer(1)));
		GridBagConstraints gbc_spinAnio = new GridBagConstraints();
		gbc_spinAnio.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinAnio.insets = new Insets(0, 0, 5, 5);
		gbc_spinAnio.gridx = 4;
		gbc_spinAnio.gridy = 1;
		add(spinAnio, gbc_spinAnio);
		
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int anio= Integer.parseInt(spinAnio.getValue().toString());
				Examen ex= contr.mostrarExamenPendiente(anio);
				if(ex!=null){
				cod_examen=ex.getCod_examen();
				txtTipoExamen.setText(ex.getTipo_examen());
				String estadoLista = ex.getEstado();
				lblEstadoLista.setText(estadoLista);
				validarComisionyEjercicio(cod_examen);
				 panel.setEnabled(true);
			     panel_1.setEnabled(true);
			     panel_2.setEnabled(true);
			     lblErrorExamen.setVisible(false);
				}
			    else {
			    	lblErrorExamen.setText("No se encontro el examen");
			    	lblErrorExamen.setForeground(Color.RED);
			    }
				
				
				
				
				
			}
		});
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.gridwidth = 2;
		gbc_btnBuscar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscar.gridx = 5;
		gbc_btnBuscar.gridy = 1;
		add(btnBuscar, gbc_btnBuscar);
		
		lblErrorExamen = new JLabel("");
		GridBagConstraints gbc_lblErrorExamen = new GridBagConstraints();
		gbc_lblErrorExamen.insets = new Insets(0, 0, 5, 5);
		gbc_lblErrorExamen.gridx = 7;
		gbc_lblErrorExamen.gridy = 1;
		add(lblErrorExamen, gbc_lblErrorExamen);
		
		JLabel lblTipo = new JLabel("Tipo examen:");
		GridBagConstraints gbc_lblTipo = new GridBagConstraints();
		gbc_lblTipo.anchor = GridBagConstraints.EAST;
		gbc_lblTipo.gridwidth = 2;
		gbc_lblTipo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipo.gridx = 2;
		gbc_lblTipo.gridy = 2;
		add(lblTipo, gbc_lblTipo);
		
		txtTipoExamen = new JTextField();
		GridBagConstraints gbc_txtTipoExamen = new GridBagConstraints();
		gbc_txtTipoExamen.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTipoExamen.insets = new Insets(0, 0, 5, 5);
		gbc_txtTipoExamen.gridx = 4;
		gbc_txtTipoExamen.gridy = 2;
		add(txtTipoExamen, gbc_txtTipoExamen);
		txtTipoExamen.setEditable(false);
		txtTipoExamen.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 5;
		gbc_lblEstado.gridy = 2;
		add(lblEstado, gbc_lblEstado);
		
		lblEstadoExamen = new JLabel("El estado");
		GridBagConstraints gbc_lblEstadoExamen = new GridBagConstraints();
		gbc_lblEstadoExamen.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstadoExamen.gridx = 6;
		gbc_lblEstadoExamen.gridy = 2;
		add(lblEstadoExamen, gbc_lblEstadoExamen);
		lblEstadoExamen.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 7;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 4;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{195, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnListaDeAlumnos = new JButton("Lista de alumnos en condiciones");
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
		gbc_btnListaDeAlumnos.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnListaDeAlumnos.insets = new Insets(0, 0, 0, 5);
		gbc_btnListaDeAlumnos.gridx = 0;
		gbc_btnListaDeAlumnos.gridy = 0;
		panel.add(btnListaDeAlumnos, gbc_btnListaDeAlumnos);
		
		JLabel lblEstado_1 = new JLabel("Estado:");
		GridBagConstraints gbc_lblEstado_1 = new GridBagConstraints();
		gbc_lblEstado_1.anchor = GridBagConstraints.WEST;
		gbc_lblEstado_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblEstado_1.gridx = 1;
		gbc_lblEstado_1.gridy = 0;
		panel.add(lblEstado_1, gbc_lblEstado_1);
		
		lblEstadoLista = new JLabel("El estado");
		lblEstadoLista.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		GridBagConstraints gbc_lblEstadoLista = new GridBagConstraints();
		gbc_lblEstadoLista.gridx = 2;
		gbc_lblEstadoLista.gridy = 0;
		panel.add(lblEstadoLista, gbc_lblEstadoLista);
		
		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 7;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 5;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{195, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
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
		gbc_btnCargarComision.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCargarComision.insets = new Insets(0, 0, 0, 5);
		gbc_btnCargarComision.gridx = 0;
		gbc_btnCargarComision.gridy = 0;
		panel_1.add(btnCargarComision, gbc_btnCargarComision);
		
		JLabel lblEstado_2 = new JLabel("Estado:");
		GridBagConstraints gbc_lblEstado_2 = new GridBagConstraints();
		gbc_lblEstado_2.anchor = GridBagConstraints.WEST;
		gbc_lblEstado_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblEstado_2.gridx = 1;
		gbc_lblEstado_2.gridy = 0;
		panel_1.add(lblEstado_2, gbc_lblEstado_2);
		
		lblEstadoComision = new JLabel("El estado");
		lblEstadoComision.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		GridBagConstraints gbc_lblEstadoComision = new GridBagConstraints();
		gbc_lblEstadoComision.gridx = 2;
		gbc_lblEstadoComision.gridy = 0;
		panel_1.add(lblEstadoComision, gbc_lblEstadoComision);
		
		panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 7;
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 2;
		gbc_panel_2.gridy = 6;
		add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{195, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
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
		gbc_btnCargarEjercicios.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCargarEjercicios.insets = new Insets(0, 0, 0, 5);
		gbc_btnCargarEjercicios.gridx = 0;
		gbc_btnCargarEjercicios.gridy = 0;
		panel_2.add(btnCargarEjercicios, gbc_btnCargarEjercicios);
		
		JLabel lblEstado_3 = new JLabel("Estado:");
		GridBagConstraints gbc_lblEstado_3 = new GridBagConstraints();
		gbc_lblEstado_3.anchor = GridBagConstraints.WEST;
		gbc_lblEstado_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblEstado_3.gridx = 1;
		gbc_lblEstado_3.gridy = 0;
		panel_2.add(lblEstado_3, gbc_lblEstado_3);
		
		lblEstadoEjercicios = new JLabel("El estado");
		lblEstadoEjercicios.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		GridBagConstraints gbc_lblEstadoEjercicios = new GridBagConstraints();
		gbc_lblEstadoEjercicios.gridx = 2;
		gbc_lblEstadoEjercicios.gridy = 0;
		panel_2.add(lblEstadoEjercicios, gbc_lblEstadoEjercicios);
       panel.setEnabled(false);
       panel_1.setEnabled(false);
       panel_2.setEnabled(false);
       
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
       						contr.agregarAlumnosEnEjercicio(cod_examen);
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
       			//JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
       		}
       		
       	}
       });
       
       JButton btnCancelar = new JButton("Cancelar");
       btnCancelar.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       		
       		CardLayout cl = (CardLayout)(panelPpal.getLayout());
       	      cl.show(panelPpal, "Panel nulo");
       	}

       	
       });
       GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
       gbc_btnCancelar.anchor = GridBagConstraints.EAST;
       gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
       gbc_btnCancelar.gridx = 7;
       gbc_btnCancelar.gridy = 8;
       add(btnCancelar, gbc_btnCancelar);
       GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
       gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
       gbc_btnGuardar.anchor = GridBagConstraints.WEST;
       gbc_btnGuardar.gridx = 8;
       gbc_btnGuardar.gridy = 8;
       add(btnGuardar, gbc_btnGuardar);
	}
	

	

	
	public boolean validar()
	{
		boolean e = true;
		if (!lblEstadoEjercicios.getText().toString().equals("Ejercicios cargados"))
				//mensaje+="Debe cargar ejercicios \n";
		{
			lblEstadoEjercicios.setForeground(Color.RED);
			e=false;
		}
		if (!lblEstadoComision.getText().toString().equals("Comision generada"))
		{	//mensaje+="Debe generar comision \n";
			lblEstadoComision.setForeground(Color.RED);
			e=false;
		}
		if(!lblEstadoLista.getText().toString().equals("alumnos cargados"))
		{	//mensaje+="Debe cargar la lista de alumnos \n";
			lblEstadoLista.setForeground(Color.RED);
			e=false;
		}
			
		
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
