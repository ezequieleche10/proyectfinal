package Desktop;

import javax.swing.JPanel;

import Entidades.Examen;
import Negocio.Controlador;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

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

public class PanelCargaNotas extends JPanel {

	Controlador contr;
	private JTable tableComisiones;
	private int codigprof;
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public PanelCargaNotas(Controlador cont,JPanel panelPpal, int cod_profesor) throws Exception {
		contr=cont;
		codigprof = cod_profesor;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 1;
		add(label, gbc_label);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 6;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);
		
		tableComisiones = new JTable();
		scrollPane.setViewportView(tableComisiones);
		
		JLabel lblSeleccioneElModo = new JLabel("Seleccione el modo de ingresar las notas:");
		GridBagConstraints gbc_lblSeleccioneElModo = new GridBagConstraints();
		gbc_lblSeleccioneElModo.gridwidth = 3;
		gbc_lblSeleccioneElModo.anchor = GridBagConstraints.EAST;
		gbc_lblSeleccioneElModo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSeleccioneElModo.gridx = 0;
		gbc_lblSeleccioneElModo.gridy = 3;
		add(lblSeleccioneElModo, gbc_lblSeleccioneElModo);
		
		JComboBox cboOpcion = new JComboBox();
		cboOpcion.setModel(new DefaultComboBoxModel(new String[] {"seleccionar modo", "por ejercicio", "por alumno"}));
		GridBagConstraints gbc_cboOpcion = new GridBagConstraints();
		gbc_cboOpcion.gridwidth = 4;
		gbc_cboOpcion.insets = new Insets(0, 0, 5, 5);
		gbc_cboOpcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_cboOpcion.gridx = 3;
		gbc_cboOpcion.gridy = 3;
		add(cboOpcion, gbc_cboOpcion);
		
		JButton btnBuscar = new JButton("Buscar acta");
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBuscar.anchor = GridBagConstraints.NORTH;
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscar.gridx = 7;
		gbc_btnBuscar.gridy = 3;
		add(btnBuscar, gbc_btnBuscar);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridheight = 4;
		gbc_scrollPane_1.gridwidth = 6;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 2;
		gbc_scrollPane_1.gridy = 4;
		add(scrollPane_1, gbc_scrollPane_1);
		
		JButton btnCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.anchor = GridBagConstraints.EAST;
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 7;
		gbc_btnCancelar.gridy = 8;
		add(btnCancelar, gbc_btnCancelar);
		
		JButton btnGuardar = new JButton("Guardar");
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.anchor = GridBagConstraints.WEST;
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 8;
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

}
