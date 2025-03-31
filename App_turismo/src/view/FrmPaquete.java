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
import model.Paquete;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmPaquete extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIdDestino;
	private JTextField txtIdOrigen;
	private JTextField txtFechaVenta;
	private JTextField txtHoraVenta;
	private JTextField txtHoraSalida;
	private JTextField txtFechaEjecucion;
	private JTextField txtObservaciones;
	private JTextField txtIdAgencia;
	private JTextField txtMatricula;
	private JTextField txtIdPromotor;
	private JTextField txtIdCliente;
	private JTextField txtIdMedio;
	private JTextField txtPrecio;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPaquete frame = new FrmPaquete();
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
	public FrmPaquete() {
		setTitle("Paquete");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtIdDestino = new JTextField();
		txtIdDestino.setColumns(10);
		txtIdDestino.setBounds(108, 43, 86, 20);
		contentPane.add(txtIdDestino);
		
		txtIdOrigen = new JTextField();
		txtIdOrigen.setColumns(10);
		txtIdOrigen.setBounds(108, 74, 86, 20);
		contentPane.add(txtIdOrigen);
		
		txtFechaVenta = new JTextField();
		txtFechaVenta.setColumns(10);
		txtFechaVenta.setBounds(108, 105, 86, 20);
		contentPane.add(txtFechaVenta);
		
		txtHoraVenta = new JTextField();
		txtHoraVenta.setColumns(10);
		txtHoraVenta.setBounds(108, 136, 86, 20);
		contentPane.add(txtHoraVenta);
		
		txtHoraSalida = new JTextField();
		txtHoraSalida.setColumns(10);
		txtHoraSalida.setBounds(108, 167, 86, 20);
		contentPane.add(txtHoraSalida);
		
		txtFechaEjecucion = new JTextField();
		txtFechaEjecucion.setColumns(10);
		txtFechaEjecucion.setBounds(108, 198, 86, 20);
		contentPane.add(txtFechaEjecucion);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Paquete cr = new Paquete();
				cr.create(Integer.parseInt(txtIdDestino.getText()), Integer.parseInt(txtIdOrigen.getText()), txtFechaVenta.getText(), txtHoraVenta.getText(), txtHoraSalida.getText(),
						txtFechaEjecucion.getText(), txtObservaciones.getText(), Integer.parseInt(txtIdAgencia.getText()), Integer.parseInt(txtMatricula.getText()), Integer.parseInt(txtIdPromotor.getText()), Integer.parseInt(txtIdCliente.getText()),
						Integer.parseInt(txtIdMedio.getText()), txtPrecio.getText());
				
			}
		});
		btnNewButton.setBounds(267, 226, 108, 26);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("iddestino:");
		lblNewLabel_1.setBounds(22, 46, 60, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblCorreo = new JLabel("idorigen:");
		lblCorreo.setBounds(22, 77, 46, 14);
		contentPane.add(lblCorreo);
		
		JLabel lblTelefono = new JLabel("fechaventa:");
		lblTelefono.setBounds(22, 105, 62, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblDireccion = new JLabel("horaventa:");
		lblDireccion.setBounds(22, 136, 60, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblWeb = new JLabel("horasalida:");
		lblWeb.setBounds(22, 167, 60, 14);
		contentPane.add(lblWeb);
		
		JLabel lblIdcompania = new JLabel("fechaejecucion:");
		lblIdcompania.setBounds(22, 201, 79, 14);
		contentPane.add(lblIdcompania);
		
		JLabel lblObservaciones = new JLabel("observaciones:");
		lblObservaciones.setBounds(204, 46, 79, 14);
		contentPane.add(lblObservaciones);
		
		JLabel lblIdagencia = new JLabel("idagencia:");
		lblIdagencia.setBounds(204, 77, 79, 14);
		contentPane.add(lblIdagencia);
		
		JLabel lblMatricula = new JLabel("matricula:");
		lblMatricula.setBounds(204, 108, 79, 14);
		contentPane.add(lblMatricula);
		
		JLabel lblIdpromotor = new JLabel("idpromotor:");
		lblIdpromotor.setBounds(204, 139, 79, 14);
		contentPane.add(lblIdpromotor);
		
		JLabel lblIdcliente = new JLabel("idcliente:");
		lblIdcliente.setBounds(204, 170, 79, 14);
		contentPane.add(lblIdcliente);
		
		JLabel lblIdmedio = new JLabel("idmedio:");
		lblIdmedio.setBounds(202, 201, 79, 14);
		contentPane.add(lblIdmedio);
		
		JLabel lblPrecio = new JLabel("precio:");
		lblPrecio.setBounds(22, 232, 79, 14);
		contentPane.add(lblPrecio);
		
		txtObservaciones = new JTextField();
		txtObservaciones.setColumns(10);
		txtObservaciones.setBounds(289, 43, 86, 20);
		contentPane.add(txtObservaciones);
		
		txtIdAgencia = new JTextField();
		txtIdAgencia.setColumns(10);
		txtIdAgencia.setBounds(289, 74, 86, 20);
		contentPane.add(txtIdAgencia);
		
		txtMatricula = new JTextField();
		txtMatricula.setColumns(10);
		txtMatricula.setBounds(289, 105, 86, 20);
		contentPane.add(txtMatricula);
		
		txtIdPromotor = new JTextField();
		txtIdPromotor.setColumns(10);
		txtIdPromotor.setBounds(289, 136, 86, 20);
		contentPane.add(txtIdPromotor);
		
		txtIdCliente = new JTextField();
		txtIdCliente.setColumns(10);
		txtIdCliente.setBounds(289, 167, 86, 20);
		contentPane.add(txtIdCliente);
		
		txtIdMedio = new JTextField();
		txtIdMedio.setColumns(10);
		txtIdMedio.setBounds(289, 198, 86, 20);
		contentPane.add(txtIdMedio);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(107, 229, 86, 20);
		contentPane.add(txtPrecio);
	}

}
