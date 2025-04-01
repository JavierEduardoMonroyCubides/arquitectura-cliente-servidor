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
import model.TipoTransporte;

public class FrmTipoTransporte extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtObservacion;
	TipoTransporte cr = new TipoTransporte();
	private JTextField txtIdTipoTransporte;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTipoTransporte frame = new FrmTipoTransporte();
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
	public FrmTipoTransporte() {
		setTitle("tipo de transporte");
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
		
		txtObservacion = new JTextField();
		txtObservacion.setColumns(10);
		txtObservacion.setBounds(108, 105, 86, 20);
		contentPane.add(txtObservacion);
		
		JButton btnNewButton = new JButton("guardar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			
				cr.create(txtNombre.getText(), txtObservacion.getText());
			}
		});
		btnNewButton.setBounds(258, 58, 95, 38);
		contentPane.add(btnNewButton);
		
		JLabel lblAgencia = new JLabel("");
		lblAgencia.setBounds(179, 6, 118, 26);
		contentPane.add(lblAgencia);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(38, 77, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblCorreo = new JLabel("observacion:");
		lblCorreo.setBounds(38, 108, 75, 14);
		contentPane.add(lblCorreo);
		
		JLabel lblNewLabel_1_1 = new JLabel("IdTipoTransporte:");
		lblNewLabel_1_1.setBounds(10, 139, 89, 14);
		contentPane.add(lblNewLabel_1_1);
		
		txtIdTipoTransporte = new JTextField();
		txtIdTipoTransporte.setColumns(10);
		txtIdTipoTransporte.setBounds(108, 136, 86, 20);
		contentPane.add(txtIdTipoTransporte);
		
		JButton btnEliminar = new JButton("eliminar");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.delete(Integer.parseInt(txtIdTipoTransporte.getText()));
			}
		});
		btnEliminar.setBounds(258, 104, 95, 38);
		contentPane.add(btnEliminar);
	}

}
