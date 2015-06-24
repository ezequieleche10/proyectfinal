package Desktop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JButton;

import Entidades.Usuario;
import Negocio.Controlador;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginDesktop extends JFrame {

	private JPanel contentPane;
	private JTextField txtClave;
	private JTextField txtUsuario;
    private static Controlador cont;
    private JButton btnIngresar;
	
	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 LoginDesktop frame= new LoginDesktop();
					 frame.setVisible(true);
				     frame.setLocationRelativeTo(null);//la centra
				     
				 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	
	
	
	public LoginDesktop() {
		
		setResizable(false);
		cont= new Controlador();
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
		txtUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
                {
					procesar();
                }
				
			}
		});
		txtUsuario.setToolTipText("");
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
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procesar();
			}
		});
		GridBagConstraints gbc_btnIngresar = new GridBagConstraints();
		gbc_btnIngresar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnIngresar.insets = new Insets(0, 0, 5, 5);
		gbc_btnIngresar.gridx = 3;
		gbc_btnIngresar.gridy = 6;
		gbc_btnIngresar.gridwidth=1;
		gbc_btnIngresar.gridheight=1;
		contentPane.add(btnIngresar, gbc_btnIngresar);
	}
	private void procesar(){
		String usu=txtUsuario.getText().toString();
		String pass=txtClave.getText().toString();
		Usuario usua = new Usuario();
		if(usu.length()!=0 && pass.length()!=0 )
	   {
	    
		try {
			usua=cont.validarIngreso(usu,pass);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    if(usua.getTipo_Usuario()!=0)
	    {
	   
		PrincipalDesktop pd;
		try {
			pd = new PrincipalDesktop(cont,usua);
			pd.setVisible(true);
			pd.setExtendedState(MAXIMIZED_BOTH); //inicia maximizada
			dispose();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	    }else JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrecto/s","Error" , JOptionPane.ERROR_MESSAGE);
	    
	    
	   }else 
	   JOptionPane.showMessageDialog(null, "Debe completar usuario y contraseña","Informacion" , JOptionPane.WARNING_MESSAGE);
	}

}
