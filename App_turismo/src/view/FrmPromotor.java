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

import model.Cliente;
import model.Promotor;

public class FrmPromotor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTipoDocumento;
	private JTextField txtDocumento;
	private JTextField txtDireccion;
	private JTextField txtCorreoPersonal;
	private JTextField txtCorreoCorp;
	private JTextField txtFechaNacimiento;
	private JTextField txtTelefono;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPromotor frame = new FrmPromotor();
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
	public FrmPromotor() {
		setTitle("Promotor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(98, 46, 86, 20);
		contentPane.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(98, 77, 86, 20);
		contentPane.add(txtApellido);
		
		txtTipoDocumento = new JTextField();
		txtTipoDocumento.setColumns(10);
		txtTipoDocumento.setBounds(98, 108, 86, 20);
		contentPane.add(txtTipoDocumento);
		
		txtDocumento = new JTextField();
		txtDocumento.setColumns(10);
		txtDocumento.setBounds(98, 139, 86, 20);
		contentPane.add(txtDocumento);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(98, 170, 86, 20);
		contentPane.add(txtDireccion);
		
		txtCorreoPersonal = new JTextField();
		txtCorreoPersonal.setColumns(10);
		txtCorreoPersonal.setBounds(98, 201, 86, 20);
		contentPane.add(txtCorreoPersonal);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Promotor cr = new Promotor();
				cr.create(txtNombre.getText(), txtApellido.getText(), Integer.parseInt(txtTipoDocumento.getText()), Integer.parseInt(txtDocumento.getText()), txtDireccion.getText(), txtCorreoPersonal.getText(),
						txtCorreoCorp.getText(), txtFechaNacimiento.getText(), txtTelefono.getText());
				
			}
		});
		btnNewButton.setBounds(238, 150, 110, 37);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(44, 49, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblCorreo = new JLabel("apellido:");
		lblCorreo.setBounds(44, 80, 46, 14);
		contentPane.add(lblCorreo);
		
		JLabel lblTelefono = new JLabel("tipodocumento:");
		lblTelefono.setBounds(10, 111, 81, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblDireccion = new JLabel("documento:");
		lblDireccion.setBounds(28, 142, 60, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblWeb = new JLabel("direccion:");
		lblWeb.setBounds(44, 173, 46, 14);
		contentPane.add(lblWeb);
		
		JLabel lblIdcompania = new JLabel("correopersonal:");
		lblIdcompania.setBounds(10, 204, 86, 14);
		contentPane.add(lblIdcompania);
		
		JLabel lblCorreocorp = new JLabel("correocorp:");
		lblCorreocorp.setBounds(199, 46, 86, 14);
		contentPane.add(lblCorreocorp);
		
		JLabel lblFechanacimiento = new JLabel("fechanacimiento:");
		lblFechanacimiento.setBounds(199, 77, 86, 14);
		contentPane.add(lblFechanacimiento);
		
		JLabel lblTelefono_1 = new JLabel("telefono:");
		lblTelefono_1.setBounds(199, 105, 86, 14);
		contentPane.add(lblTelefono_1);
		
		txtCorreoCorp = new JTextField();
		txtCorreoCorp.setColumns(10);
		txtCorreoCorp.setBounds(286, 43, 86, 20);
		contentPane.add(txtCorreoCorp);
		
		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setColumns(10);
		txtFechaNacimiento.setBounds(286, 74, 86, 20);
		contentPane.add(txtFechaNacimiento);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(286, 102, 86, 20);
		contentPane.add(txtTelefono);
	}

}
