package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



import controller.Conexion;
import model.User;

public class Principal extends JFrame {

	private JFrame frame;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
Connection miConexion=new Conexion().conectar();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
		verusUarios();
	}//cierra el constructor
	//crear listado usuarios
	
	public ArrayList<User> listadoUsuarios() {
		ArrayList<User> usuarios=new ArrayList<User>();
		try {
			Statement st =miConexion.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM user");
			User usuario;
			while(rs.next()) {
				usuario=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				usuarios.add(usuario);
				st.close();
				rs.close();
			}//cierra el while
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		
		
		return usuarios;
	}//cierra el metodo usuarios
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAccesoOk = new JLabel("acceso ok");
		lblAccesoOk.setBounds(10, 11, 92, 14);
		frame.getContentPane().add(lblAccesoOk);
		
		JPanel panel = new JPanel();
		panel.setBounds(31, 88, 155, 115);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(77, 5, 0, 0);
		panel.add(table);
		
		table_1 = new JTable();
		table_1.setBounds(82, 5, 0, 0);
		panel.add(table_1);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, ""},
			},
			new String[] {
				"ID", "Usuario", "Contrase\u00F1a", "Estado"
			}
		));
		table_2.setBounds(0, 0, 165, 155);
		panel.add(table_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(242, 88, 182, 150);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 11, 46, 14);
		panel_1.add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(86, 8, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(10, 48, 66, 14);
		panel_1.add(lblContrasea);
		
		textField_1 = new JTextField();
		textField_1.setBounds(86, 45, 86, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(10, 90, 46, 14);
		panel_1.add(lblEstado);
		
		textField_2 = new JTextField();
		textField_2.setBounds(86, 87, 86, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnusuario = new JButton("Nuevo Usuario");
		btnusuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnusuario.setBounds(122, 7, 212, 23);
		frame.getContentPane().add(btnusuario);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEliminar.setBounds(122, 44, 89, 23);
		frame.getContentPane().add(btnEliminar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnActualizar.setBounds(256, 44, 89, 23);
		frame.getContentPane().add(btnActualizar);
	}
	
public void verusUarios() {//cargar un modelo de usuarios del AL
	//pero falta llenar la Jtable con el modelo
	System.out.println("hola buenas");
	ArrayList<User>ustabla= listadoUsuarios();
	DefaultTableModel modelo=(DefaultTableModel)table.getModel();
	Object fila[]=new Object[4];
	for (int i = 0; i < ustabla.size(); i++) {
	fila[0]=ustabla.get(i).getId();	
	fila[1]=ustabla.get(i).getUsername();	
	fila[2]=ustabla.get(i).getPassword();
	fila[3]=ustabla.get(i).getUser_status();	
	
	
	modelo.addRow(fila);
	}
}//cierra el ver usuarios
}
