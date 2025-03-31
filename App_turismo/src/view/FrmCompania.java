package view;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Agencias;
import model.Compania;

public class FrmCompania extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtRazonSocial;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtFechaCreacion;
	private JTextField txtCorreo;
	private JTextField txtWeb;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCompania frame = new FrmCompania();
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
	public FrmCompania() {
		setTitle("Compañia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtRazonSocial = new JTextField();
		txtRazonSocial.setColumns(10);
		txtRazonSocial.setBounds(108, 33, 86, 20);
		contentPane.add(txtRazonSocial);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(108, 64, 86, 20);
		contentPane.add(txtDireccion);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(108, 95, 86, 20);
		contentPane.add(txtTelefono);
		
		txtFechaCreacion = new JTextField();
		txtFechaCreacion.setColumns(10);
		txtFechaCreacion.setBounds(108, 126, 86, 20);
		contentPane.add(txtFechaCreacion);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(108, 157, 86, 20);
		contentPane.add(txtCorreo);
		
		txtWeb = new JTextField();
		txtWeb.setColumns(10);
		txtWeb.setBounds(108, 188, 86, 20);
		contentPane.add(txtWeb);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Compania cr = new Compania();
				cr.create(txtRazonSocial.getText(), txtDireccion.getText(), txtTelefono.getText(), txtFechaCreacion.getText(), txtCorreo.getText(),txtWeb.getText());
				
			}
		});
		btnNewButton.setBounds(261, 83, 110, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("razonsocial:");
		lblNewLabel_1.setBounds(38, 36, 74, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblCorreo = new JLabel("direccion:");
		lblCorreo.setBounds(52, 67, 46, 14);
		contentPane.add(lblCorreo);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(52, 98, 46, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblDireccion = new JLabel("fechacreacion:");
		lblDireccion.setBounds(26, 129, 86, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblWeb = new JLabel("correo:");
		lblWeb.setBounds(66, 160, 46, 14);
		contentPane.add(lblWeb);
		
		JLabel lblIdcompania = new JLabel("web:");
		lblIdcompania.setBounds(76, 191, 60, 14);
		contentPane.add(lblIdcompania);
	}

}
