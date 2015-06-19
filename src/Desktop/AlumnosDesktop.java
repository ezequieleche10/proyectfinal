package Desktop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Negocio.Controlador;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Insets;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlumnosDesktop extends JFrame {

	
	private Controlador cont;
	private JPanel contentPane;
	private JPanel panelPpal;
	private JTable tablaAlumnos;
	private JButton btnCerrar;
    private Controlador contr;
    private int codigo_examen;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public AlumnosDesktop(Controlador contro, int cod_examen) {
		contr=contro;
		codigo_examen=cod_examen;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		tablaAlumnos = new JTable();
		scrollPane.setViewportView(tablaAlumnos);
		cargarTabla();
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnCerrar = new GridBagConstraints();
		gbc_btnCerrar.anchor = GridBagConstraints.EAST;
		gbc_btnCerrar.gridx = 0;
		gbc_btnCerrar.gridy = 1;
		contentPane.add(btnCerrar, gbc_btnCerrar);
		
		
	}

	private void cargarTabla() {
		XTableModelAlumnos modelo= new XTableModelAlumnos();
		modelo.setDatasource(contr.getAlumnosenExamen(codigo_examen));
		tablaAlumnos.getTableHeader().setReorderingAllowed(false);
		tablaAlumnos.setModel(modelo);
		
		
	}
	

}
