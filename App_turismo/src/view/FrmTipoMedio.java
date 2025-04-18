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
import model.TipoMedio;

public class FrmTipoMedio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtObservacion;
	TipoMedio cr = new TipoMedio();
	private JTextField txtIdTipoMedio;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTipoMedio frame = new FrmTipoMedio();
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
	public FrmTipoMedio() {
		setTitle("tipo de medio");
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
		
		JButton btnNewButton = new JButton("guardar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				cr.create(txtNombre.getText(), txtObservacion.getText());					
				
			}
		});
		btnNewButton.setBounds(237, 69, 108, 31);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(39, 77, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Observacion:");
		lblNewLabel_1_1.setBounds(39, 108, 74, 14);
		contentPane.add(lblNewLabel_1_1);
		
		txtObservacion = new JTextField();
		txtObservacion.setColumns(10);
		txtObservacion.setBounds(108, 105, 86, 20);
		contentPane.add(txtObservacion);
		
		JLabel lblNewLabel_1_2 = new JLabel("IdTipoMedio:");
		lblNewLabel_1_2.setBounds(34, 133, 90, 14);
		contentPane.add(lblNewLabel_1_2);
		
		txtIdTipoMedio = new JTextField();
		txtIdTipoMedio.setColumns(10);
		txtIdTipoMedio.setBounds(108, 133, 86, 20);
		contentPane.add(txtIdTipoMedio);
		
		JButton btnEliminar = new JButton("eliminar");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.delete(Integer.parseInt(txtIdTipoMedio.getText()));
			}
		});
		btnEliminar.setBounds(237, 111, 108, 31);
		contentPane.add(btnEliminar);
		
		JButton btnActualizar = new JButton("actualizar");
		btnActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.update(Integer.parseInt(txtIdTipoMedio.getText()), txtNombre.getText(), txtObservacion.getText());
			}
		});
		btnActualizar.setBounds(237, 153, 108, 31);
		contentPane.add(btnActualizar);
		
		JButton btnBuscar = new JButton("buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.readOne(Integer.parseInt(txtIdTipoMedio.getText()), txtNombre, txtObservacion);
			}
		});
		btnBuscar.setBounds(237, 195, 108, 31);
		contentPane.add(btnBuscar);
	}
}
