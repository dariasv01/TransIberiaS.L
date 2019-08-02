package control.logica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import facade.Facade;
import listener.ComboBox.ActionComboCamion;
import listener.ComboBox.ActionComboConductor;
import listener.ComboBox.ActionComboMercancias;
import vista.controlador.ControladorDatosPersonales;
import vista.controlador.ControladorMensaje;
import vista.controlador.ControladorPanelConsultarCamion;
import vista.controlador.ControladorPanelMatricula;
import vista.controlador.ControladorPanelRuta;
import vistaUI.UI;

public class ParaUI extends UI {
	private Facade facade = new Facade();
	private ControladorPanelMatricula controladorPanelMatricula = new ControladorPanelMatricula();
	private ControladorMensaje controladorMensaje = new ControladorMensaje();
	private ControladorDatosPersonales controlDatosPersonales = new ControladorDatosPersonales();
	private ControladorPanelRuta controlPanelRuta = new ControladorPanelRuta();

	public ParaUI() {
		rellenarComboBox();
		setActionListener();
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
	//RUTA
	ActionListener NuevaRutaListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			facade.guardarRuta(controlPanelRuta.obtenerDatos(getPanelRuta()));
			//controlPanelRuta.vaciarDatos(despedir.getPanelDatosPersonales());
			controladorMensaje.mostrarMensajes(ruta.getPanelMensaje(), "Ruta creada");
		}
	};

	private void setActionListener() {
		// CAMION
		comprar.panelMensaje.getBtnAplicr().addActionListener(ComprarCamionListener);
		vender.panelMensaje.getBtnAplicr().addActionListener(VenderCamionListener);
		// CONDUCTOR
		contratar.panelMensaje.getBtnAplicr().addActionListener(ContratarListener);
		despedir.panelMensaje.getBtnAplicr().addActionListener(DespedirListener);
		//RUTA
		//ruta.panelMensaje.getBtnAplicr().addActionListener(NuevaRutaListener);
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
		//RUTA
//		ActionComboMercancias actionComboMercancia = new ActionComboMercancias(getComboBoxMercanica(),getComboBoxConductorUno(),getComboBoxConductorDos(),
//				getComboBoxCamion(),facade, controlPanelRuta, getPanelRuta());
//		getComboBoxMercanica().addFocusListener(actionComboMercancia);
//		getComboBoxMercanica().addActionListener(actionComboMercancia);
	}

}
