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
import model.Vehiculo;

public class FrmVehiculo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMatricula;
	private JTextField txtMarca;
	private JTextField txtPuestos;
	private JTextField txtModelo;
	private JTextField txtNumeroMotor;
	private JTextField txtCategoria;
	private JTextField txtIdTipo;
	Vehiculo cr = new Vehiculo();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmVehiculo frame = new FrmVehiculo();
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
	public FrmVehiculo() {
		setTitle("Vehiculo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtMatricula = new JTextField();
		txtMatricula.setBounds(108, 74, 86, 20);
		contentPane.add(txtMatricula);
		txtMatricula.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(108, 105, 86, 20);
		contentPane.add(txtMarca);
		
		txtPuestos = new JTextField();
		txtPuestos.setColumns(10);
		txtPuestos.setBounds(108, 136, 86, 20);
		contentPane.add(txtPuestos);
		
		txtModelo = new JTextField();
		txtModelo.setColumns(10);
		txtModelo.setBounds(108, 167, 86, 20);
		contentPane.add(txtModelo);
		
		txtNumeroMotor = new JTextField();
		txtNumeroMotor.setColumns(10);
		txtNumeroMotor.setBounds(108, 198, 86, 20);
		contentPane.add(txtNumeroMotor);
		
		txtCategoria = new JTextField();
		txtCategoria.setColumns(10);
		txtCategoria.setBounds(108, 229, 86, 20);
		contentPane.add(txtCategoria);
		
		JButton btnNewButton = new JButton("guardar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				cr.create(Integer.parseInt(txtMatricula.getText()), txtMarca.getText(), Integer.parseInt(txtPuestos.getText()), txtModelo.getText(), txtNumeroMotor.getText(), txtCategoria.getText(), Integer.parseInt(txtIdTipo.getText()));
				
			}
		});
		btnNewButton.setBounds(231, 125, 104, 31);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("matricula:");
		lblNewLabel.setBounds(25, 77, 62, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblCorreo = new JLabel("marca:");
		lblCorreo.setBounds(25, 108, 46, 14);
		contentPane.add(lblCorreo);
		
		JLabel lblTelefono = new JLabel("puestos:");
		lblTelefono.setBounds(25, 139, 46, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblDireccion = new JLabel("modelo:");
		lblDireccion.setBounds(25, 170, 60, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblWeb = new JLabel("numero de motor:");
		lblWeb.setBounds(25, 201, 86, 14);
		contentPane.add(lblWeb);
		
		JLabel lblIdcompania = new JLabel("categoria:");
		lblIdcompania.setBounds(25, 232, 60, 14);
		contentPane.add(lblIdcompania);
		
		JLabel lblIdtipo = new JLabel("idtipo:");
		lblIdtipo.setBounds(212, 46, 62, 14);
		contentPane.add(lblIdtipo);
		
		txtIdTipo = new JTextField();
		txtIdTipo.setColumns(10);
		txtIdTipo.setBounds(268, 43, 86, 20);
		contentPane.add(txtIdTipo);
		
		JButton btnEliminar = new JButton("eliminar");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.delete(Integer.parseInt(txtMatricula.getText()));
			}
		});
		btnEliminar.setBounds(231, 73, 104, 31);
		contentPane.add(btnEliminar);
		
		JButton btnActualizar = new JButton("actualizar");
		btnActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.update(Integer.parseInt(txtMatricula.getText()), txtMarca.getText(), Integer.parseInt(txtPuestos.getText()), txtModelo.getText(), txtNumeroMotor.getText(), txtCategoria.getText(), Integer.parseInt(txtIdTipo.getText()));
			}
		});
		btnActualizar.setBounds(231, 166, 104, 31);
		contentPane.add(btnActualizar);
		
		JButton btnBuscar = new JButton("buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.readOne(Integer.parseInt(txtMatricula.getText()), txtMarca, txtPuestos, txtModelo, txtNumeroMotor, txtCategoria, txtIdTipo);
			}
		});
		btnBuscar.setBounds(231, 201, 104, 31);
		contentPane.add(btnBuscar);
	}
}
