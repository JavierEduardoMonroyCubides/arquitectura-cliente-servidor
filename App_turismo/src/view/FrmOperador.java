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

import model.Operador;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmOperador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTipoDocumento;
	private JTextField txtDocumento;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDireccion;
	private JTextField txtCorreo;
	private JTextField txtTelefono;
	private JTextField txtMatricula;
	private JTextField txtIdOperador;
	Operador cr = new Operador();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmOperador frame = new FrmOperador();
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
	public FrmOperador() {
		setTitle("operador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
contentPane.setLayout(null);
		
		txtTipoDocumento = new JTextField();
		txtTipoDocumento.setColumns(10);
		txtTipoDocumento.setBounds(120, 46, 86, 20);
		contentPane.add(txtTipoDocumento);
		
		txtDocumento = new JTextField();
		txtDocumento.setColumns(10);
		txtDocumento.setBounds(120, 77, 86, 20);
		contentPane.add(txtDocumento);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(120, 108, 86, 20);
		contentPane.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(120, 139, 86, 20);
		contentPane.add(txtApellido);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(120, 170, 86, 20);
		contentPane.add(txtDireccion);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(120, 201, 86, 20);
		contentPane.add(txtCorreo);
		
		JButton btnNewButton = new JButton("guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cr.create(Integer.parseInt(txtTipoDocumento.getText()),Integer.parseInt(txtDocumento.getText()), txtNombre.getText(), txtApellido.getText(), txtDireccion.getText(),
						txtCorreo.getText(), txtTelefono.getText(), Integer.parseInt(txtMatricula.getText()));
				
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			
		});
		btnNewButton.setBounds(241, 104, 110, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("tipodocumento:");
		lblNewLabel_1.setBounds(34, 49, 76, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblCorreo = new JLabel("documento:");
		lblCorreo.setBounds(50, 80, 60, 14);
		contentPane.add(lblCorreo);
		
		JLabel lblTelefono = new JLabel("nombre:");
		lblTelefono.setBounds(64, 111, 46, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblDireccion = new JLabel("apellido:");
		lblDireccion.setBounds(66, 142, 60, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblWeb = new JLabel("direccion:");
		lblWeb.setBounds(66, 173, 46, 14);
		contentPane.add(lblWeb);
		
		JLabel lblIdcompania = new JLabel("correo:");
		lblIdcompania.setBounds(76, 204, 60, 14);
		contentPane.add(lblIdcompania);
		
		JLabel lblTelefono_1 = new JLabel("telefono:");
		lblTelefono_1.setBounds(216, 46, 60, 14);
		contentPane.add(lblTelefono_1);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(265, 43, 86, 20);
		contentPane.add(txtTelefono);
		
		JLabel lblTelefono_1_1 = new JLabel("matricula:");
		lblTelefono_1_1.setBounds(216, 77, 60, 14);
		contentPane.add(lblTelefono_1_1);
		
		txtMatricula = new JTextField();
		txtMatricula.setColumns(10);
		txtMatricula.setBounds(265, 74, 86, 20);
		contentPane.add(txtMatricula);
		
		JLabel lblNewLabel_1_1 = new JLabel("IdOperador:");
		lblNewLabel_1_1.setBounds(34, 229, 76, 14);
		contentPane.add(lblNewLabel_1_1);
		
		txtIdOperador = new JTextField();
		txtIdOperador.setColumns(10);
		txtIdOperador.setBounds(120, 226, 86, 20);
		contentPane.add(txtIdOperador);
		
		JButton btnEliminar = new JButton("eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cr.delete(Integer.parseInt(txtIdOperador.getText()));
			}
		});
		
	
		btnEliminar.setBounds(241, 138, 110, 29);
		contentPane.add(btnEliminar);
		
		JButton btnUpdate = new JButton("update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.update(Integer.parseInt(txtIdOperador.getText()), Integer.parseInt(txtTipoDocumento.getText()),Integer.parseInt(txtDocumento.getText()), txtNombre.getText(), txtApellido.getText(), txtDireccion.getText(),
						txtCorreo.getText(), txtTelefono.getText(), Integer.parseInt(txtMatricula.getText()));
			}
		});
		btnUpdate.setBounds(241, 170, 110, 29);
		contentPane.add(btnUpdate);
	}
}
