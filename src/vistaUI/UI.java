package vistaUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.spi.LocaleServiceProvider;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import utiles.Mercancia;
import vista.controlador.ControladorPanelConsultarCamion;
import vista.controlador.ControladorPanelConsultarConductor;
import vistas.camion.PanelComprar;
import vistas.camion.PanelConsultaCamion;
import vistas.camion.PanelVender;
import vistas.comunes.PanelDatosPersonales;
import vistas.comunes.PanelInicio;
import vistas.comunes.PanelMatricula;
import vistas.comunes.PanelRuta;
import vistas.conductor.PanelConsultaConductor;
import vistas.conductor.PanelContratar;
import vistas.conductor.PanelDespedir;
import vistas.ruta.PanelHistorialRuta;
import vistas.ruta.PanelNuevaRuta;
import vistas.ruta.PanelRutaActiva;

public class UI extends JFrame {

	private JPanel contentPane;
	protected PanelInicio inicio = new PanelInicio();
	protected JTextField fecha;
	protected JTextField hora;
	protected JButton btnPasar;
	protected PanelContratar contratar = new PanelContratar("CONTRATAR");
	protected PanelDespedir despedir = new PanelDespedir("DESPEDIR");
	protected PanelConsultaConductor consultaConduc = new PanelConsultaConductor("LISTADO CONDUCTOR");
	protected PanelComprar comprar = new PanelComprar("COMPRAR");
	protected PanelVender vender = new PanelVender("VENDER");
	protected PanelConsultaCamion consultaCamion = new PanelConsultaCamion("HISTORIAL CAMIONES");
	protected PanelNuevaRuta ruta = new PanelNuevaRuta("NUEVA RUTA");
	protected PanelRutaActiva rutaActiva = new PanelRutaActiva("RUTAS ACTIVAS");
	protected PanelHistorialRuta historialRuta = new PanelHistorialRuta("HISTORIAL RUTAS");
	private ControladorPanelConsultarCamion controladorPanelConsultaCamion = new ControladorPanelConsultarCamion();
	private ControladorPanelConsultarConductor controladorPanelConsultaConduc = new ControladorPanelConsultarConductor();
	protected JMenuItem menuItemHistorialCamion;

	public UI() {
		setTitle("Trans Iberia S.L.");
		setMaximumSize(new Dimension(2047483647, 2047483647));

		setAutoRequestFocus(false);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(90, 50, 1200, 660);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(218, 165, 32));
		contentPane.setForeground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		GroupLayout groupLayout = (GroupLayout) inicio.getLayout();
		groupLayout.setAutoCreateGaps(true);
		inicio.setBorder(new LineBorder(new Color(0, 0, 0), 0));

		contentPane.add(inicio);
		// CONDUCTOR
		contentPane.add(contratar, "PanelContratar");
		contentPane.add(despedir, "PanelDespedir");
		contentPane.add(consultaConduc, "PanelConsultaConductor");
		// CAMION
		contentPane.add(comprar, "PanelComprar");
		contentPane.add(vender, "PanelVender");
		contentPane.add(consultaCamion, "PanelConsultaCamion");

		// RUTA
		contentPane.add(ruta, "PanelNuevaRuta");
		contentPane.add(rutaActiva, "PanelRutaActiva");
		contentPane.add(historialRuta, "PanelHistorialRuta");

		JPanel panelinicio = new JPanel();
		panelinicio.setBackground(new Color(204, 204, 51));
		contentPane.add(panelinicio, "name_969325539976868");
		panelinicio.setLayout(new CardLayout(0, 0));

		JLabel lblClinicaEpyGay = new JLabel("TRASPORTES IBERIA");
		lblClinicaEpyGay.setBackground(new Color(204, 204, 51));
		lblClinicaEpyGay.setFont(new Font("Tahoma", Font.BOLD, 41));
		lblClinicaEpyGay.setHorizontalAlignment(SwingConstants.CENTER);
		panelinicio.add(lblClinicaEpyGay, "inicio");

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		menuBar.setBackground(new Color(218, 165, 32));
		menuBar.setForeground(new Color(0, 0, 0));
		setJMenuBar(menuBar);

		JMenu mnConductor = new JMenu("   Conductor   ");
		mnConductor.setBorder(new MatteBorder(1, 1, 1, 0, (Color) new Color(0, 0, 0)));

		mnConductor.setBackground(new Color(218, 165, 32));
		mnConductor.setFont(new Font("Alef", Font.PLAIN, 32));
		menuBar.add(mnConductor);
//CONTRATAR
		JMenuItem mntmContratar = new JMenuItem("Contratar");
		mntmContratar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				asociarPanel("PanelContratar");
			}
		});
		mntmContratar.setHorizontalAlignment(SwingConstants.CENTER);
		mntmContratar.setFont(new Font("Alef", Font.BOLD, 20));
		mntmContratar.setBackground(new Color(204, 102, 102));
		mnConductor.add(mntmContratar);
//DESPEDIR

		JMenuItem mntmDespedir = new JMenuItem("Despedir");
		mntmDespedir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				asociarPanel("PanelDespedir");
			}
		});
		mntmDespedir.setHorizontalAlignment(SwingConstants.CENTER);
		mntmDespedir.setFont(new Font("Alef", Font.BOLD, 20));
		mntmDespedir.setBackground(new Color(204, 102, 102));
		mnConductor.add(mntmDespedir);

//CONSULTAR CONDUCTORES
		JMenuItem mntmConsultasConductor = new JMenuItem("Lista Empleados");
		mntmConsultasConductor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorPanelConsultaConduc.rellenarTablaCamion(consultaConduc);
				asociarPanel("PanelConsultaConductor");
			}
		});
		mntmConsultasConductor.setHorizontalAlignment(SwingConstants.CENTER);
		mntmConsultasConductor.setFont(new Font("Alef", Font.BOLD, 20));
		mntmConsultasConductor.setBackground(new Color(204, 102, 102));
		mnConductor.add(mntmConsultasConductor);

		JMenu mnCamiones = new JMenu("   Cami\u00F3n   ");
		mnCamiones.setBorder(new MatteBorder(1, 1, 1, 0, (Color) new Color(0, 0, 0)));

		mnCamiones.setBackground(new Color(139, 0, 139));
		mnCamiones.setHorizontalAlignment(SwingConstants.CENTER);
		mnCamiones.setFont(new Font("Alef", Font.PLAIN, 32));
		menuBar.add(mnCamiones);
//COMPRAR CAMION
		JMenuItem mntmComprar = new JMenuItem("Comprar");
		mntmComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				asociarPanel("PanelComprar");
			}
		});
		mntmComprar.setHorizontalAlignment(SwingConstants.CENTER);
		mntmComprar.setBackground(new Color(102, 102, 255));
		mntmComprar.setFont(new Font("Alef", Font.BOLD, 22));
		mnCamiones.add(mntmComprar);
//VENDER CAMION
		JMenuItem mntmVender = new JMenuItem("Vender");
		mntmVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asociarPanel("PanelVender");
			}
		});
		mntmVender.setHorizontalAlignment(SwingConstants.CENTER);
		mntmVender.setBackground(new Color(102, 102, 255));
		mntmVender.setFont(new Font("Alef", Font.BOLD, 22));
		mnCamiones.add(mntmVender);
//CONSULTA CAMION		
		menuItemHistorialCamion = new JMenuItem("Historial de Camiones");
		menuItemHistorialCamion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelConsultaCamion.rellenarTablaCamion(consultaCamion);
				asociarPanel("PanelConsultaCamion");
			}
		});
		menuItemHistorialCamion.setHorizontalAlignment(SwingConstants.CENTER);
		menuItemHistorialCamion.setFont(new Font("Alef", Font.BOLD, 22));
		menuItemHistorialCamion.setBackground(new Color(102, 102, 255));
		mnCamiones.add(menuItemHistorialCamion);
//RUTAS

		JMenu mnRutas = new JMenu("   Rutas   ");
		mnRutas.setBorder(new MatteBorder(1, 1, 1, 0, (Color) new Color(0, 0, 0)));
		mnRutas.setBackground(new Color(139, 69, 19));
		mnRutas.setFont(new Font("Alef", Font.PLAIN, 32));
		menuBar.add(mnRutas);
//NUEVA RUTA
		JMenuItem mntmCrearRuta = new JMenuItem("Nueva Ruta");
		mntmCrearRuta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asociarPanel("PanelNuevaRuta");
			}
		});
		mntmCrearRuta.setHorizontalAlignment(SwingConstants.CENTER);
		mntmCrearRuta.setBackground(new Color(255, 204, 153));
		mntmCrearRuta.setFont(new Font("Alef", Font.BOLD, 22));
		mnRutas.add(mntmCrearRuta);
//RUTA ACTIVAS		
		JMenuItem mntmRutasActivas = new JMenuItem("Rutas Activas");
		mntmRutasActivas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asociarPanel("PanelRutaActiva");
			}
		});
		mntmRutasActivas.setHorizontalAlignment(SwingConstants.CENTER);
		mntmRutasActivas.setFont(new Font("Dialog", Font.BOLD, 22));
		mntmRutasActivas.setBackground(new Color(255, 204, 153));
		mnRutas.add(mntmRutasActivas);
//HISTORIAL RUTA		
		JMenuItem mntmHistorialRutas = new JMenuItem("Historial de Rutas");
		mntmHistorialRutas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asociarPanel("PanelHistorialRuta");
			}
		});
		mntmHistorialRutas.setHorizontalAlignment(SwingConstants.CENTER);
		mntmHistorialRutas.setFont(new Font("Dialog", Font.BOLD, 22));
		mntmHistorialRutas.setBackground(new Color(255, 204, 153));
		mnRutas.add(mntmHistorialRutas);
//RELOJ
		hora = new JTextField();
		hora.setForeground(new Color(0, 0, 0));
		hora.setBackground(new Color(210, 180, 140));
		hora.setBorder(new MatteBorder(1, 2, 1, 2, (Color) new Color(0, 0, 0)));
		hora.setHorizontalAlignment(SwingConstants.CENTER);

		fecha = new JTextField();
		fecha.setForeground(new Color(0, 0, 0));
		fecha.setBackground(new Color(210, 180, 140));
		fecha.setBorder(new MatteBorder(1, 2, 1, 0, (Color) new Color(0, 0, 0)));
		fecha.setHorizontalAlignment(SwingConstants.CENTER);
		fecha.setFont(new Font("Tahoma", Font.PLAIN, 22));
		fecha.setEditable(false);
		menuBar.add(fecha);
		fecha.setColumns(10);
		hora.setFont(new Font("Tahoma", Font.BOLD, 22));
		hora.setEditable(false);
		menuBar.add(hora);
		hora.setColumns(10);

		Date sistFecha = new Date();
		SimpleDateFormat formato = new SimpleDateFormat(" dd / MM / YYYY ");
		fecha.setText(formato.format(sistFecha));

		JPanel panel = new JPanel();
		menuBar.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		btnPasar = new JButton("PASAR");

		btnPasar.setForeground(new Color(255, 255, 255));
		panel.add(btnPasar, BorderLayout.CENTER);
		btnPasar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnPasar.setBackground(new Color(165, 42, 42));
		// HORA
		Timer tiempo = new Timer(100, new UI.horas());
		tiempo.start();
		

	}

	private void asociarPanel(String string) {
		((CardLayout) contentPane.getLayout()).show(contentPane, string);
	}

	class horas implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Date sistHora = new Date();
			String pmAm = "hh:mm:ss a";
			SimpleDateFormat format = new SimpleDateFormat(pmAm);
			Calendar hoy = Calendar.getInstance();
			hora.setText(String.format(format.format(sistHora), hoy));

		}
	}

	// Camion

	public PanelMatricula getPanelMatriculaComprar() {
		return comprar.getPanelMatricula();
	}

	public PanelMatricula getPanelMatriculaVender() {
		return vender.getPanelMatricula();
	}

	// Conductor

	public PanelDatosPersonales getPanelDatosPersonalesContratar() {
		return contratar.getPanelDatosPersonales();
	}

	public PanelDatosPersonales getPanelDatosPersonalesDespedir() {
		return despedir.getPanelDatosPersonales();
	}

	// Camion

	public JComboBox getComboBoxIdVender() {
		return vender.getComboId();
	}

	public JComboBox getComboBoxMatriculaVender() {
		return vender.getComboNombre();
	}

	// Ruta
	public PanelRuta getPanelRuta() {
		return ruta.getPanelRuta();
	}

	// Conductor

	public JComboBox getComboBoxIdConductor() {
		return despedir.getComboId();
	}

	public JComboBox getComboBoxNombreConductor() {
		return despedir.getComboNombre();
	}

	// RUTA

	public JComboBox getComboBoxMercanica() {
		return ruta.getComboMercancia();
	}
	

	public JComboBox getComboBoxConductorUno() {
		return ruta.getComboConductorUno();
	}

	public JComboBox getComboBoxConductorDos() {
		return ruta.getComboConductorDos();
	}

	public JComboBox getComboBoxCamion() {
		return ruta.getComboCamion();
	}

}
