package org.ciberfarma.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.ciberfarma.modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class FrmCrudUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtUsuario;
	private JTextField txtClave;
	private JTextField txtFecha;
	private JTextField txtTipo;
	private JTextField txtEstado;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCrudUsuario frame = new FrmCrudUsuario();
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
	public FrmCrudUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Codigo = new JLabel("Codigo :");
		Codigo.setBounds(29, 24, 46, 14);
		contentPane.add(Codigo);
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setBounds(29, 83, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido :");
		lblApellido.setBounds(29, 139, 46, 14);
		contentPane.add(lblApellido);
		
		JLabel lblUsuario = new JLabel("Usuario :");
		lblUsuario.setBounds(29, 195, 46, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblClave = new JLabel("Clave :");
		lblClave.setBounds(242, 192, 46, 14);
		contentPane.add(lblClave);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento :");
		lblFechaDeNacimiento.setBounds(27, 244, 124, 14);
		contentPane.add(lblFechaDeNacimiento);
		
		JLabel lblTipo = new JLabel("Tipo :");
		lblTipo.setBounds(29, 295, 46, 14);
		contentPane.add(lblTipo);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(29, 326, 46, 14);
		contentPane.add(lblEstado);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(114, 21, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(114, 80, 168, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(114, 136, 168, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(114, 192, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtClave = new JTextField();
		txtClave.setBounds(298, 189, 86, 20);
		contentPane.add(txtClave);
		txtClave.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(174, 241, 86, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		
		txtTipo = new JTextField();
		txtTipo.setBounds(114, 292, 86, 20);
		contentPane.add(txtTipo);
		txtTipo.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(114, 323, 86, 20);
		contentPane.add(txtEstado);
		txtEstado.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//llama al  metoodo 
				
				registro();
				
				
				
				
				
				
				
			}
		});
		btnRegistrar.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnRegistrar.setBounds(466, 24, 168, 80);
		contentPane.add(btnRegistrar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//llama al  metodo
				
				consultar();
				
				
				
				
				
				
			}
		});
		btnConsultar.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnConsultar.setBounds(466, 116, 168, 80);
		contentPane.add(btnConsultar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//llama al  metodo
				listado();
				
				
			}
		});
		btnListar.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnListar.setBounds(466, 208, 168, 80);
		contentPane.add(btnListar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 361, 639, 152);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
	}
	
	//7 despues de  hacer  el frame  hacemos  los  metodos  y todo  del rtegistro  listar  , etc 
	
	//metodo  limpiar
	
	protected void limpiar() {
		txtNombre.setText("");
		txtApellido.setText("");
		txtUsuario.setText("");
		txtClave.setText("");
		txtFecha.setText("");
		txtTipo.setText("");
		txtEstado.setText("");
		
	
	}
	
	//metodo  listar
	protected void listado() {
		
		// obtener un listado de los usuarios 
				EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
				EntityManager em = fabrica.createEntityManager();
				
				//TypedQuery<Usuario> consulta = em.createNamedQuery("Usuario.findAll", Usuario.class);
				//List<Usuario> lstUsuarios = consulta.getResultList();  //   estas  2  lineas comentadas  es como   lo de abajo  lo que esta dentro del  if
				
				
				
				List<Usuario> lstUsuarios;
				if(txtTipo.getText().isEmpty()) {
					lstUsuarios = em.createNamedQuery("Usuario.findAll", Usuario.class).getResultList();
				} else {
					//como este es  listado  por  tipo  , aca se captura el tipo
					int tipo = Integer.parseInt(txtTipo.getText());
					lstUsuarios = em.createNamedQuery("Usuario.findAllxTipo", Usuario.class)
							.setParameter("xtipo", tipo).getResultList();
				}
				
				
				
				
				// muestro el listado en el txt/pdf
				txtS.setText("Listado de Usuarios\n");
				for (Usuario u : lstUsuarios) {
					txtS.append(u.getCodigo() + "\t" + u.getNombre() + "\t" + u.getApellido() + "\n");
				}
		
	
		
	}

	
	
	//METODO CONSULTAR
	
protected void consultar() {
		
	
	// obtener el código a buscar
			int codigo = Integer.parseInt(txtCodigo.getText());
			
			// buscar el código en los Usuarios(Entidad), si existe muestra los datos, sino avisa
			EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
			EntityManager em = fabrica.createEntityManager();
			// este  metodo  devuelve  un  elemento de  la clase
			Usuario u = em.find(Usuario.class, codigo);  // esto es como  un  metodo  ,  ya sin  utlizar  un  store  procedure de buscar   en  la bd 
			
			
			
			if(u == null) {
				JOptionPane.showMessageDialog(this, "Usuario NO registrado");
			} else {
				txtNombre.setText(u.getNombre());
				txtApellido.setText(u.getApellido());
				txtUsuario.setText(u.getUsuario());
				txtClave.setText(u.getClave());
				txtFecha.setText(u.getFnacim());
				txtTipo.setText(u.getTipo() + "");
				txtEstado.setText(u.getEstado() + "");
			}
		
	}


	
	//METODO REGISTRO 
	 void registro() {
		
		// entradas 
			String nombre = txtNombre.getText();
			String apellido = txtApellido.getText();
			String usuario = txtUsuario.getText();
			String clave = txtClave.getText();
			String fecha = txtFecha.getText();
			int tipo = Integer.parseInt(txtTipo.getText());
			int estado = Integer.parseInt(txtEstado.getText());
			
			Usuario u = new Usuario();
			u.setNombre(nombre);
			u.setApellido(apellido);
			u.setUsuario(usuario);
			u.setClave(clave);
			u.setFnacim(fecha);
			u.setTipo(tipo);
			u.setEstado(estado);
			
			
			//proceso
			EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
			EntityManager em = fabrica.createEntityManager();
			
			try {
				em.getTransaction().begin();
				em.persist(u);
				em.getTransaction().commit();
				JOptionPane.showMessageDialog(this, "Usuario registrado");
				limpiar();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Error al registrar : " + e.getMessage());
			} finally {
				em.close();
			}
		 
		 
		 
		 
		 
		 
		 
		 
		 


		 
		 
		 
		 
		 
		 
		 
		
	}
	
	
	
	
}
