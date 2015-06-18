package Desktop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txtClave;
	private JTextField txtUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setTitle("Cossetini Ingreso");
		setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 300);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(300, 300));
		contentPane.setMinimumSize(new Dimension(300, 300));
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{60, 130, 100, 100, 150};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.2, 0.2, 0.2, 0.2, 0.2};
		gbl_contentPane.rowWeights = new double[]{0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblBienvenido = new JLabel("Bienvenido");
		GridBagConstraints gbc_lblBienvenido = new GridBagConstraints();
		gbc_lblBienvenido.insets = new Insets(0, 0, 5, 5);
		
		gbc_lblBienvenido.gridx = 2;
		gbc_lblBienvenido.gridy = 2;
		gbc_lblBienvenido.gridwidth=2;
		gbc_lblBienvenido.gridheight=1;
		gbc_lblBienvenido.anchor=GridBagConstraints.CENTER;
		contentPane.add(lblBienvenido, gbc_lblBienvenido);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 1;
		gbc_lblUsuario.gridy = 4;
		contentPane.add(lblUsuario, gbc_lblUsuario);
		
		txtClave = new JTextField();
		GridBagConstraints gbc_txtClave = new GridBagConstraints();
		gbc_txtClave.gridwidth = 2;
		gbc_txtClave.insets = new Insets(0, 0, 5, 5);
		gbc_txtClave.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtClave.gridx = 2;
		gbc_txtClave.gridy = 4;
		contentPane.add(txtClave, gbc_txtClave);
		txtClave.setColumns(10);
		
		JLabel lblClave = new JLabel("Clave: ");
		GridBagConstraints gbc_lblClave = new GridBagConstraints();
		gbc_lblClave.insets = new Insets(0, 0, 5, 5);
		gbc_lblClave.gridx = 1;
		gbc_lblClave.gridy = 5;
		contentPane.add(lblClave, gbc_lblClave);
		
		txtUsuario = new JTextField();
		GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
		gbc_txtUsuario.gridwidth = 2;
		gbc_txtUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsuario.gridx = 2;
		gbc_txtUsuario.gridy = 5;
		gbc_txtUsuario.gridheight=1;
		contentPane.add(txtUsuario, gbc_txtUsuario);
		txtUsuario.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 2;
		gbc_btnCancelar.gridy = 6;
		gbc_btnCancelar.gridwidth=1;
		gbc_btnCancelar.gridheight=1;
		contentPane.add(btnCancelar, gbc_btnCancelar);
		
		JButton btnIngresar = new JButton("Ingresar");
		GridBagConstraints gbc_btnIngresar = new GridBagConstraints();
		gbc_btnIngresar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnIngresar.insets = new Insets(0, 0, 5, 5);
		gbc_btnIngresar.gridx = 3;
		gbc_btnIngresar.gridy = 6;
		gbc_btnIngresar.gridwidth=1;
		gbc_btnIngresar.gridheight=1;
		contentPane.add(btnIngresar, gbc_btnIngresar);
	}

}
