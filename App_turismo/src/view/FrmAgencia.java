package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Agencias;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmAgencia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtCorreo;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtWeb;
	private JTextField txtIdCompañia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAgencia frame = new FrmAgencia();
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
	public FrmAgencia() {
		setTitle("Agencia ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(108, 74, 86, 20);
		contentPane.add(txtNombre);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(108, 105, 86, 20);
		contentPane.add(txtCorreo);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(108, 136, 86, 20);
		contentPane.add(txtTelefono);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(108, 167, 86, 20);
		contentPane.add(txtDireccion);
		
		txtWeb = new JTextField();
		txtWeb.setColumns(10);
		txtWeb.setBounds(108, 198, 86, 20);
		contentPane.add(txtWeb);
		
		txtIdCompañia = new JTextField();
		txtIdCompañia.setColumns(10);
		txtIdCompañia.setBounds(108, 229, 86, 20);
		contentPane.add(txtIdCompañia);
		
		JButton btnNewButton = new JButton("guardar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Agencias cr = new Agencias();
				cr.create(txtNombre.getText(), txtCorreo.getText(), txtTelefono.getText(), txtDireccion.getText(), txtWeb.getText(), Integer.parseInt(txtIdCompañia.getText()));
				
			}
		});
		btnNewButton.setBounds(249, 67, 111, 35);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(27, 77, 62, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(27, 108, 46, 14);
		contentPane.add(lblCorreo);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(27, 139, 71, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(27, 170, 60, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblWeb = new JLabel("Web:");
		lblWeb.setBounds(27, 201, 46, 14);
		contentPane.add(lblWeb);
		
		JLabel lblIdcompania = new JLabel("Idcompañia:");
		lblIdcompania.setBounds(29, 232, 69, 14);
		contentPane.add(lblIdcompania);
	}
}
