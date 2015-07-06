package Desktop;

import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.CardLayout;
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
import Entidades.NotaExamenAlumno;
import Negocio.Controlador;

import javax.swing.SpinnerNumberModel;
import javax.swing.table.TableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;

public class PanelVerNotas extends JPanel {
	private JTable tablaAlumnosenCondiciones;
	private Controlador contr;
	private ArrayList<Alumno> alumnos;
	private JTextField txtCod_examen;
	private JButton btnGenerarExamen;
	private JComboBox cboTipoExamen;
	private JSpinner spinAnio;
	private JTextArea txtDescripcion;
	private JTextField txtEstado;
	private Examen exa;

	/**
	 * Create the panel.
	 */
	public PanelVerNotas(Controlador cont, JPanel panelPpal) {
		contr=cont;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 233, 0, 33, 78, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 28, 0, 136, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblTipoExamen = new JLabel("Tipo Examen:");
		GridBagConstraints gbc_lblTipoExamen = new GridBagConstraints();
		gbc_lblTipoExamen.anchor = GridBagConstraints.EAST;
		gbc_lblTipoExamen.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoExamen.gridx = 0;
		gbc_lblTipoExamen.gridy = 1;
		add(lblTipoExamen, gbc_lblTipoExamen);
		
		cboTipoExamen = new JComboBox();
		cboTipoExamen.setModel(new DefaultComboBoxModel(new String[] {"Seleccione opcion", "A", "B", "C"}));
		GridBagConstraints gbc_cboTipoExamen = new GridBagConstraints();
		gbc_cboTipoExamen.insets = new Insets(0, 0, 5, 5);
		gbc_cboTipoExamen.fill = GridBagConstraints.HORIZONTAL;
		gbc_cboTipoExamen.gridx = 1;
		gbc_cboTipoExamen.gridy = 1;
		add(cboTipoExamen, gbc_cboTipoExamen);
		
		JLabel lblAnio = new JLabel("A\u00F1o:");
		GridBagConstraints gbc_lblAnio = new GridBagConstraints();
		gbc_lblAnio.anchor = GridBagConstraints.EAST;
		gbc_lblAnio.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnio.gridx = 2;
		gbc_lblAnio.gridy = 1;
		add(lblAnio, gbc_lblAnio);
		
		spinAnio = new JSpinner();
		spinAnio.setModel(new SpinnerNumberModel(2015, 1990, 2030, 1));
		//spinAnio.set
		GridBagConstraints gbc_spinAnio = new GridBagConstraints();
		gbc_spinAnio.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinAnio.insets = new Insets(0, 0, 5, 5);
		gbc_spinAnio.gridx = 3;
		gbc_spinAnio.gridy = 1;
		add(spinAnio, gbc_spinAnio);
		
		JButton btnBuscarExamen = new JButton("Buscar");
		btnBuscarExamen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int anio= Integer.parseInt(spinAnio.getValue().toString());
				if(cboTipoExamen.getSelectedIndex()!=0){
					String tipoEx=cboTipoExamen.getSelectedItem().toString();
					exa= new Examen();
					exa=contr.buscarExamen(tipoEx, anio);
					exa.setListaNotaExamenAlumno(contr.getNotasExamen(exa.getCod_examen()));
					txtCod_examen.setText(String.valueOf(exa.getCod_examen()));
					txtDescripcion.setText(String.valueOf(exa.getDescripcion()));
					txtEstado.setText(String.valueOf(exa.getEstado()));
					
					try {
						cargarTabla(exa);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//nea=contr.getNotasExamen()
				}else JOptionPane.showMessageDialog(null, "Seleccione tipo examen");
			}
		});
		/*
		

				int anio= Integer.parseInt(spinAnio.getValue().toString());
				
				//alumnos=new ArrayList<Alumno>();
				Examen ex= contr.mostrarExamenPendiente(anio);
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
		}); */
		GridBagConstraints gbc_btnBuscarExamen = new GridBagConstraints();
		gbc_btnBuscarExamen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBuscarExamen.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscarExamen.gridx = 4;
		gbc_btnBuscarExamen.gridy = 1;
		add(btnBuscarExamen, gbc_btnBuscarExamen);
		
		
		
		JLabel lblCodexamen = new JLabel("Cod_examen");
		GridBagConstraints gbc_lblCodexamen = new GridBagConstraints();
		gbc_lblCodexamen.anchor = GridBagConstraints.EAST;
		gbc_lblCodexamen.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodexamen.gridx = 0;
		gbc_lblCodexamen.gridy = 2;
		add(lblCodexamen, gbc_lblCodexamen);
		
		txtCod_examen = new JTextField();
		txtCod_examen.setEditable(false);
		GridBagConstraints gbc_txtCod_examen = new GridBagConstraints();
		gbc_txtCod_examen.insets = new Insets(0, 0, 5, 5);
		gbc_txtCod_examen.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCod_examen.gridx = 1;
		gbc_txtCod_examen.gridy = 2;
		add(txtCod_examen, gbc_txtCod_examen);
		txtCod_examen.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.anchor = GridBagConstraints.NORTH;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 2;
		gbc_lblDescripcion.gridy = 2;
		add(lblDescripcion, gbc_lblDescripcion);
		
		JScrollPane scrollDesc = new JScrollPane();
		GridBagConstraints gbc_scrollDesc = new GridBagConstraints();
		gbc_scrollDesc.gridheight = 2;
		gbc_scrollDesc.gridwidth = 2;
		gbc_scrollDesc.insets = new Insets(0, 0, 5, 5);
		gbc_scrollDesc.fill = GridBagConstraints.BOTH;
		gbc_scrollDesc.gridx = 3;
		gbc_scrollDesc.gridy = 2;
		add(scrollDesc, gbc_scrollDesc);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.setEditable(false);
		scrollDesc.setViewportView(txtDescripcion);
		
		JLabel lblEstado = new JLabel("Estado:");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 0;
		gbc_lblEstado.gridy = 3;
		add(lblEstado, gbc_lblEstado);
		
		txtEstado = new JTextField();
		txtEstado.setEnabled(false);
		GridBagConstraints gbc_txtEstado = new GridBagConstraints();
		gbc_txtEstado.insets = new Insets(0, 0, 5, 5);
		gbc_txtEstado.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEstado.gridx = 1;
		gbc_txtEstado.gridy = 3;
		add(txtEstado, gbc_txtEstado);
		txtEstado.setColumns(10);
		
		JScrollPane scrollTabla = new JScrollPane();
		scrollTabla.setToolTipText("sadsd");
		GridBagConstraints gbc_scrollTabla = new GridBagConstraints();
		gbc_scrollTabla.gridwidth = 5;
		gbc_scrollTabla.insets = new Insets(0, 0, 5, 5);
		gbc_scrollTabla.fill = GridBagConstraints.BOTH;
		gbc_scrollTabla.gridx = 0;
		gbc_scrollTabla.gridy = 4;
		add(scrollTabla, gbc_scrollTabla);
		
		tablaAlumnosenCondiciones = new JTable();
		scrollTabla.setViewportView(tablaAlumnosenCondiciones);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panelPpal.getLayout());
	       	      cl.show(panelPpal, "Panel nulo");
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 4;
		gbc_btnCancelar.gridy = 5;
		add(btnCancelar, gbc_btnCancelar);
		
		btnGenerarExamen = new JButton("Guardar");
		btnGenerarExamen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//no puede modificar las notas si el estado del examen es generado, procede a cerrar las notas
				int resp = JOptionPane.showConfirmDialog(null, "Las notas pasarán a ser las definitivas ¿Desea continuar?");
				if (JOptionPane.OK_OPTION==resp)
				{
					try {
						contr.actualizarNotasExamen(exa);
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
		gbc_btnGenerarExamen.anchor = GridBagConstraints.WEST;
		gbc_btnGenerarExamen.insets = new Insets(0, 0, 5, 0);
		gbc_btnGenerarExamen.gridx = 5;
		gbc_btnGenerarExamen.gridy = 5;
		add(btnGenerarExamen, gbc_btnGenerarExamen);
		
		
		
	}


public void cargarTabla(Examen ex) throws Exception {
	XTableModelListarNotas modelo1= new XTableModelListarNotas();
	modelo1.setDatasource(ex.getListaNotaExamenAlumno());
	tablaAlumnosenCondiciones.getTableHeader().setReorderingAllowed(false);
	tablaAlumnosenCondiciones.setModel(modelo1);
	btnGenerarExamen.setEnabled(true);
	
}


}
