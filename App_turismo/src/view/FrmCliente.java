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
import model.Cliente;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDocumento;
	private JTextField txtApellido;
	private JTextField txtAlergias;
	private JTextField txtCorreo;
	private JTextField txtDireccion;
	private JTextField txtTelefonico;
	private JTextField txtEstadoCivil;
	private JTextField txtNombre;
	private JTextField txtEps;
	private JTextField txtFechaNacimiento;
	private JTextField txtTipoDocumento;
	Cliente cr = new Cliente();
	private JTextField txtIdCliente;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCliente frame = new FrmCliente();
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
	public FrmCliente() {
		setTitle("Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
contentPane.setLayout(null);
		
		txtDocumento = new JTextField();
		txtDocumento.setColumns(10);
		txtDocumento.setBounds(112, 32, 86, 20);
		contentPane.add(txtDocumento);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(112, 63, 86, 20);
		contentPane.add(txtApellido);
		
		txtAlergias = new JTextField();
		txtAlergias.setColumns(10);
		txtAlergias.setBounds(112, 94, 86, 20);
		contentPane.add(txtAlergias);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(112, 125, 86, 20);
		contentPane.add(txtCorreo);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(112, 156, 86, 20);
		contentPane.add(txtDireccion);
		
		txtTelefonico = new JTextField();
		txtTelefonico.setColumns(10);
		txtTelefonico.setBounds(112, 187, 86, 20);
		contentPane.add(txtTelefonico);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				cr.create(Integer.parseInt(txtTipoDocumento.getText()), Integer.parseInt(txtDocumento.getText()), txtNombre.getText(), txtApellido.getText(), txtEps.getText(), txtAlergias.getText(),
						txtFechaNacimiento.getText(), txtCorreo.getText(), txtEstadoCivil.getText(), txtDireccion.getText(), txtTelefonico.getText());
				
			}
		});
		btnNewButton.setBounds(261, 204, 71, 35);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(205, 63, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblCorreo = new JLabel("Eps:");
		lblCorreo.setBounds(205, 94, 46, 14);
		contentPane.add(lblCorreo);
		
		JLabel lblTelefono = new JLabel("alergias:");
		lblTelefono.setBounds(56, 97, 46, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblDireccion = new JLabel("correo:");
		lblDireccion.setBounds(54, 128, 60, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblWeb = new JLabel("direccion:");
		lblWeb.setBounds(56, 159, 46, 14);
		contentPane.add(lblWeb);
		
		JLabel lblIdcompania = new JLabel("telefonico:");
		lblIdcompania.setBounds(42, 190, 60, 14);
		contentPane.add(lblIdcompania);
		
		txtEstadoCivil = new JTextField();
		txtEstadoCivil.setColumns(10);
		txtEstadoCivil.setBounds(310, 156, 86, 20);
		contentPane.add(txtEstadoCivil);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(310, 63, 86, 20);
		contentPane.add(txtNombre);
		
		txtEps = new JTextField();
		txtEps.setColumns(10);
		txtEps.setBounds(310, 94, 86, 20);
		contentPane.add(txtEps);
		
		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setColumns(10);
		txtFechaNacimiento.setBounds(310, 125, 86, 20);
		contentPane.add(txtFechaNacimiento);
		
		txtTipoDocumento = new JTextField();
		txtTipoDocumento.setColumns(10);
		txtTipoDocumento.setBounds(310, 32, 86, 20);
		contentPane.add(txtTipoDocumento);
		
		JLabel lblTipoDeId = new JLabel("Tipo de documento: ");
		lblTipoDeId.setBounds(205, 32, 112, 14);
		contentPane.add(lblTipoDeId);
		
		JLabel lblDocumento = new JLabel("Documento:");
		lblDocumento.setBounds(40, 35, 62, 14);
		contentPane.add(lblDocumento);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(52, 66, 62, 14);
		contentPane.add(lblApellido);
		
		JLabel lblFechanacimiento = new JLabel("fechanacimiento:");
		lblFechanacimiento.setBounds(205, 125, 96, 14);
		contentPane.add(lblFechanacimiento);
		
		JLabel lblEstadocivil = new JLabel("estadocivil:");
		lblEstadocivil.setBounds(205, 156, 62, 14);
		contentPane.add(lblEstadocivil);
		
		JButton btnEliminar = new JButton("");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cr.delete(Integer.parseInt(txtIdCliente.getText()));
			}
		});
		btnEliminar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\8666597_trash_2_icon (1).png"));
		btnEliminar.setBounds(212, 204, 39, 35);
		contentPane.add(btnEliminar);
		
		txtIdCliente = new JTextField();
		txtIdCliente.setColumns(10);
		txtIdCliente.setBounds(112, 218, 86, 20);
		contentPane.add(txtIdCliente);
		
		JLabel lblIdcliente = new JLabel("IdCliente:");
		lblIdcliente.setBounds(42, 224, 62, 14);
		contentPane.add(lblIdcliente);
		
		JButton btnActualzar = new JButton("actualzar");
		btnActualzar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.update(Integer.parseInt(txtIdCliente.getText()),Integer.parseInt(txtTipoDocumento.getText()), Integer.parseInt(txtDocumento.getText()), txtNombre.getText(), txtApellido.getText(), txtEps.getText(), txtAlergias.getText(),
						txtFechaNacimiento.getText(), txtCorreo.getText(), txtEstadoCivil.getText(), txtDireccion.getText(), txtTelefonico.getText());
			}
		});
		btnActualzar.setBounds(342, 204, 82, 35);
		contentPane.add(btnActualzar);
	}
}
