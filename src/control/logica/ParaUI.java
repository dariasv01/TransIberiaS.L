package control.logica;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Timer;

import facade.Facade;
import listener.ComboBox.ActionComboCamion;
import listener.ComboBox.ActionComboConductor;
import listener.ComboBox.ActionComboMercancias;
import modelo.dto.HoraDTO;
import utiles.Mercancia;
import vista.controlador.ControladorDatosPersonales;
import vista.controlador.ControladorMensaje;
import vista.controlador.ControladorPanelConsultarCamion;
import vista.controlador.ControladorPanelConsultarConductor;
import vista.controlador.ControladorPanelHistorialRutas;
import vista.controlador.ControladorPanelMatricula;
import vista.controlador.ControladorPanelRuta;
import vista.controlador.ControladorPanelRutasActivas;
import vistaUI.UI;
import vistas.ruta.PanelRutaActiva;

public class ParaUI extends UI implements ActionListener {
	private Facade facade = new Facade();
	private Control control = new Control();
	private ControladorPanelMatricula controladorPanelMatricula = new ControladorPanelMatricula();
	private ControladorMensaje controladorMensaje = new ControladorMensaje();
	private ControladorDatosPersonales controlDatosPersonales = new ControladorDatosPersonales();
	private ControladorPanelRuta controlPanelRuta = new ControladorPanelRuta();
	private ControladorPanelConsultarCamion controladorPanelConsultaCamion = new ControladorPanelConsultarCamion();
	private ControladorPanelConsultarConductor controladorPanelConsultaConduc = new ControladorPanelConsultarConductor();
	private ControladorPanelRutasActivas controladorPanelRutasActivas = new ControladorPanelRutasActivas();
	private ControladorPanelHistorialRutas controladorPanelHistorialRuta = new ControladorPanelHistorialRutas();
	LocalDateTime fechaActual;
	LocalDateTime fechaSistemaAntigua;
	boolean primeraVez;

	public ParaUI() {
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				if (facade.optenerListaHora().isEmpty()) {
					fechaActual = LocalDateTime.of(2020, 1, 1, 00, 00, 00);
					primeraVez = true;
				} else {
					pasarTiempo();
				}
			}
		});
		paneles();
		rellenarComboBox();
		setActionListener();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (primeraVez) {
					facade.guardarHoraAplicacion(fechaActual);
				} else {
					facade.modificarHoraAplicacion(fechaActual);
				}
			}
		});
		// HORA
		Timer tiempo = new Timer(1000, this);
		tiempo.start();
	}

	private void paneles() {
		// CONDUCTOR
		contratar();
		despedir();
		historialConductor();
		//CAMION
		comprar();
		vender();
		historialCamiones();
		//RUTA
		nuevaRuta();
		rutaActiva();
		historialRuta();

	}

	private void contratar() {
		mntmContratar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				asociarPanel("PanelContratar");
			}
		});
	}

	private void despedir() {
		mntmDespedir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				asociarPanel("PanelDespedir");
			}
		});
	}

	private void historialConductor() {
		mntmConsultasConductor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorPanelConsultaConduc.rellenarTablaConductor(consultaConduc, facade);
				asociarPanel("PanelConsultaConductor");
			}
		});
	}

	private void comprar() {
		mntmComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				asociarPanel("PanelComprar");
			}
		});
	}

	private void vender() {
		mntmVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asociarPanel("PanelVender");
			}
		});
	}

	private void historialCamiones() {
		menuItemHistorialCamion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelConsultaCamion.rellenarTablaCamion(consultaCamion, facade);
				asociarPanel("PanelConsultaCamion");
			}
		});
	}

	private void nuevaRuta() {
		mntmCrearRuta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asociarPanel("PanelNuevaRuta");
			}
		});
	}

	private void rutaActiva() {
		mntmRutasActivas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorPanelRutasActivas.rellenarTablaRutasActivas(rutaActiva, facade);
				asociarPanel("PanelRutaActiva");
			}
		});
	}

	private void historialRuta() {
		mntmHistorialRutas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorPanelHistorialRuta.rellenarTablaHistorialRutas(historialRuta, facade);
				asociarPanel("PanelHistorialRuta");
			}
		});
	}

//CAMION
	ActionListener ComprarCamionListener = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			if (facade.guardarCamion(controladorPanelMatricula.obtenerDatos(getPanelMatriculaComprar()))) {
				controladorMensaje.mostrarMensajes(comprar.getPanelMensaje(), "Compra realizada correctamente");
				controladorPanelMatricula.vaciarDatos(comprar.getPanelMatricula());
			} else {
				controladorMensaje.mostrarMensajes(comprar.getPanelMensaje(), "Campos erróneos");
			}
		}
	};
	ActionListener VenderCamionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			facade.venderCamion(controladorPanelMatricula.obtenerDatos(getPanelMatriculaVender()));
			controladorPanelMatricula.vaciarDatos(vender.getPanelMatricula());
			controladorMensaje.mostrarMensajes(vender.getPanelMensaje(), "Baja correctamente");
		}
	};
//CONDUCTOR
	ActionListener ContratarListener = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			if (facade.guardarConductor(controlDatosPersonales.obtenerDatos(getPanelDatosPersonalesContratar()))) {
				controladorMensaje.mostrarMensajes(contratar.getPanelMensaje(), "Contrato realizado correctamente");
				controlDatosPersonales.vaciarDatos(contratar.getPanelDatosPersonales());
			} else {
				controladorMensaje.mostrarMensajes(contratar.getPanelMensaje(), "Campos erróneos");
			}
		}
	};
	ActionListener DespedirListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			facade.darBajaConductor(controlDatosPersonales.obtenerDatos(getPanelDatosPersonalesDespedir()));
			controlDatosPersonales.vaciarDatos(despedir.getPanelDatosPersonales());
			controladorMensaje.mostrarMensajes(despedir.getPanelMensaje(), "Baja correctamente");
		}
	};
// RUTA
	ActionListener NuevaRutaListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (facade.guardarRuta(controlPanelRuta.obtenerDatos(getPanelRuta()), fechaActual)) {
				controlPanelRuta.vaciarDatos(ruta.getPanelRuta());
				controladorMensaje.mostrarMensajes(ruta.getPanelMensaje(), "Ruta creada");
			} else {
				controladorMensaje.mostrarMensajes(contratar.getPanelMensaje(), "Campos erróneos");
			}
		}
	};

	private void setActionListener() {
		// CAMION
		comprar.panelMensaje.getBtnAplicr().addActionListener(ComprarCamionListener);
		vender.panelMensaje.getBtnAplicr().addActionListener(VenderCamionListener);
		// CONDUCTOR
		contratar.panelMensaje.getBtnAplicr().addActionListener(ContratarListener);
		despedir.panelMensaje.getBtnAplicr().addActionListener(DespedirListener);
		// RUTA
		ruta.panelMensaje.getBtnAplicr().addActionListener(NuevaRutaListener);
		getChBoxUno().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getChBoxDos().setSelected(false);
				getComboBoxConductorCinco().setEnabled(false);
			}
		});

		getChBoxDos().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getChBoxUno().setSelected(false);
				getComboBoxConductorCinco().setEnabled(true);
			}
		});
		// PasarHora
		btnPasar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fechaActual = fechaActual.plusHours(+1);
			}
		});

	}

	private void rellenarComboBox() {
		// CAMION
		ActionComboCamion actionComboCamionBaja = new ActionComboCamion(getComboBoxIdVender(),
				getComboBoxMatriculaVender(), facade, controladorPanelMatricula, getPanelMatriculaVender());
		getComboBoxIdVender().addFocusListener(actionComboCamionBaja);
		getComboBoxIdVender().addActionListener(actionComboCamionBaja);
		getComboBoxMatriculaVender().addFocusListener(actionComboCamionBaja);
		getComboBoxMatriculaVender().addActionListener(actionComboCamionBaja);
		// CONDUCTOR
		ActionComboConductor actionComboConductorBaja = new ActionComboConductor(getComboBoxIdConductor(),
				getComboBoxNombreConductor(), facade, controlDatosPersonales, getPanelDatosPersonalesDespedir());
		getComboBoxIdConductor().addFocusListener(actionComboConductorBaja);
		getComboBoxIdConductor().addActionListener(actionComboConductorBaja);
		getComboBoxNombreConductor().addFocusListener(actionComboConductorBaja);
		getComboBoxNombreConductor().addActionListener(actionComboConductorBaja);
		// RUTA
		ActionComboMercancias actionComboMercancia = new ActionComboMercancias(getComboBoxMercanica(),
				getComboBoxConductorUno(), getComboBoxConductorCinco(), getChBoxUno(), getChBoxDos(),
				getComboBoxCamion(), facade, controlPanelRuta, getPanelRuta());
		getComboBoxMercanica().addFocusListener(actionComboMercancia);
		getComboBoxMercanica().addActionListener(actionComboMercancia);
		for (Mercancia d : Mercancia.values()) {
			getComboBoxMercanica().addItem(d);
		}

	}

	private void asociarPanel(String string) {
		((CardLayout) contentPane.getLayout()).show(contentPane, string);
	}
	
	private void pasarTiempo() {
		fechaActual = facade.obtenerHoraAplicacion();
		fechaSistemaAntigua = facade.obtenerHoraSistema();
		LocalDateTime tempDateTime = LocalDateTime.from(fechaSistemaAntigua);

		long years = tempDateTime.until(LocalDateTime.now(), ChronoUnit.YEARS);
		tempDateTime = tempDateTime.plusYears(years);

		long months = tempDateTime.until(LocalDateTime.now(), ChronoUnit.MONTHS);
		tempDateTime = tempDateTime.plusMonths(months);

		long days = tempDateTime.until(LocalDateTime.now(), ChronoUnit.DAYS);
		tempDateTime = tempDateTime.plusDays(days);

		long hours = tempDateTime.until(LocalDateTime.now(), ChronoUnit.HOURS);
		tempDateTime = tempDateTime.plusHours(hours);

		long minutes = tempDateTime.until(LocalDateTime.now(), ChronoUnit.MINUTES);
		tempDateTime = tempDateTime.plusMinutes(minutes);

		long seconds = tempDateTime.until(LocalDateTime.now(), ChronoUnit.SECONDS);
		fechaActual = fechaActual.plusYears(years);
		fechaActual = fechaActual.plusMonths(months);
		fechaActual = fechaActual.plusDays(days);
		fechaActual = fechaActual.plusHours(hours);
		fechaActual = fechaActual.plusMinutes(minutes);
		fechaActual = fechaActual.plusSeconds(seconds);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		fechaActual = fechaActual.plusSeconds(+1);
		hora.setText(fechaActual.toLocalTime().toString());
		fecha.setText(fechaActual.toLocalDate().toString());
		facade.modificarHoraAplicacion(fechaActual);
	}

}
