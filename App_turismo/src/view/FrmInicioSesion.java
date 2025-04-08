package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Promotor;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class FrmInicioSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField psContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmInicioSesion frame = new FrmInicioSesion();
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
	public FrmInicioSesion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario: ");
		lblNewLabel.setBounds(119, 88, 49, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnValidar = new JButton("Validar");
		
		
		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Promotor pr = new Promotor();
				pr.controlAcceso(Integer.parseInt(txtUsuario.getText()), psContraseña.getText());
			}
		});
		btnValidar.setBounds(165, 165, 89, 23);
		contentPane.add(btnValidar);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(184, 85, 96, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña:");
		lblNewLabel_1.setBounds(119, 123, 71, 14);
		contentPane.add(lblNewLabel_1);
		
		psContraseña = new JPasswordField();
		psContraseña.setBounds(184, 120, 96, 20);
		contentPane.add(psContraseña);
	}
}
