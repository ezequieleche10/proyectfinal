package Desktop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Negocio.Controlador;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class ExamenDesktop extends JFrame {

	private JPanel contentPane;
	private JTextField txtAño;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExamenDesktop frame = new ExamenDesktop();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public ExamenDesktop(Controlador cont) {
		setTitle("Examen");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 690, 244);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos del examen", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{117, 116, 90, 127, 76, 81, 0};
		gbl_panel.rowHeights = new int[]{14, 19, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.1, 1.0, 0.1, 1.0, 0.3, 0.3, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.1, 1.0, 0.1, 0.1, 0.1, 0.1, 0.5, 0.5, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		contentPane.add(panel);
		
		JLabel lblTipo_examen = new JLabel("Tipo Examen:");
		GridBagConstraints gbc_lblTipo_examen = new GridBagConstraints();
		gbc_lblTipo_examen.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipo_examen.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblTipo_examen.gridx = 0;
		gbc_lblTipo_examen.gridy = 1;
		panel.add(lblTipo_examen, gbc_lblTipo_examen);
		
		JComboBox cboTipo_examen = new JComboBox();
		cboTipo_examen.setModel(new DefaultComboBoxModel(new String[] {"Seleccion tipo examen", "A", "B", "C"}));
		GridBagConstraints gbc_cboTipo_examen = new GridBagConstraints();
		gbc_cboTipo_examen.anchor = GridBagConstraints.NORTH;
		gbc_cboTipo_examen.insets = new Insets(0, 0, 5, 5);
		gbc_cboTipo_examen.fill = GridBagConstraints.HORIZONTAL;
		gbc_cboTipo_examen.gridx = 1;
		gbc_cboTipo_examen.gridy = 1;
		panel.add(cboTipo_examen, gbc_cboTipo_examen);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.anchor = GridBagConstraints.NORTH;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 2;
		gbc_lblDescripcion.gridy = 1;
		panel.add(lblDescripcion, gbc_lblDescripcion);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 3;
		gbc_scrollPane.gridy = 1;
		panel.add(scrollPane, gbc_scrollPane);
		
		JTextArea textDescripcion = new JTextArea();
		scrollPane.setViewportView(textDescripcion);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		JLabel lblUsuario = new JLabel("Año:");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 2;
		panel.add(lblUsuario, gbc_lblUsuario);
		
		txtAño = new JTextField();
		GridBagConstraints gbc_txtAño = new GridBagConstraints();
		gbc_txtAño.insets = new Insets(0, 0, 5, 5);
		gbc_txtAño.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAño.gridx = 1;
		gbc_txtAño.gridy = 2;
		panel.add(txtAño, gbc_txtAño);
		txtAño.setColumns(10);
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 4;
		gbc_btnCancelar.gridy = 5;
		panel.add(btnCancelar, gbc_btnCancelar);
		
		JButton btnAgregarExamen = new JButton("Agregar");
		btnAgregarExamen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					cont.agregarExamen((String)cboTipo_examen.getSelectedItem(),Integer.parseInt((txtAño.getText().toString())),textDescripcion.getText());
					dispose();
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnAgregarExamen = new GridBagConstraints();
		gbc_btnAgregarExamen.insets = new Insets(0, 0, 5, 0);
		gbc_btnAgregarExamen.gridx = 5;
		gbc_btnAgregarExamen.gridy = 5;
		panel.add(btnAgregarExamen, gbc_btnAgregarExamen);
		
		
	}

}
