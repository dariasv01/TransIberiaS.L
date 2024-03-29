package control.nucleo;

import java.util.ArrayList;
import java.util.HashMap;

import modelo.dao.ConductorDAO;
import modelo.dto.ConductorDTO;
import modelo.vista.ConductorMV;
import utiles.EstadoConductor;
import utiles.Validator;

public class ConductorNucleo {
private ConductorDAO dao= new ConductorDAO();
	
	public ConductorNucleo() {
	}
	
	public boolean altaConductor(ConductorMV conductor) {
		ConductorDTO conductorDTO= new ConductorDTO();
		conductorDTO.setNombre(conductor.getNombre());
		conductorDTO.setDireccion(conductor.getDireccion());
		conductorDTO.setTelefono(conductor.getTelefono());
		conductorDTO.setHabilidad(conductor.getHabilidad());
		conductorDTO.setEstado((EstadoConductor) EstadoConductor.Parado);
		Long IDconductor =dao.obtnerIDconductor();
		conductorDTO.setID(IDconductor);
		if (validacionConductor(conductor)) {
			return  dao.guardar(conductorDTO);
		}
		return false;
		
	}
	
	public boolean modificarConductor(String id, EstadoConductor estado) {
		ConductorDTO conductorDTO = dao.consultar(new Long(id));
		conductorDTO.setEstado(estado);
		if (dao.modificar(conductorDTO)) {
			return true;
		}
		return false;

	}
	public boolean bajaConductor(ConductorMV conductor) {
		ConductorDTO conductorDTO= dao.consultar(conductor.getID());
		return  dao.eliminar(conductorDTO);
	}
	
	public boolean validacionConductor(ConductorMV conductor) {
		if (Validator.isNombre(conductor.getNombre()) && Validator.isPhone(conductor.getTelefono())
				&& Validator.isDireccion(conductor.getDireccion())) {
			return true;
		}
		return false;
	}
	
	public ConductorMV obtenerConductor(String id) {
		ConductorMV modelo=new ConductorMV();
		ConductorDTO conductor=dao.consultar(new Long(id));
		
		modelo.setID(conductor.getID());
		modelo.setNombre(conductor.getNombre());
		modelo.setDireccion(conductor.getDireccion());
		modelo.setTelefono(conductor.getTelefono());
		modelo.setHabilidad(conductor.getHabilidad());
		modelo.setEstado(conductor.getEstado());
		return modelo;
	}

	public ArrayList<String> listadoIdConductores() {
		return dao.obtenerTodosLosId();
	}

	public HashMap<Long, String> obtenerMapaIDNombre() {
		return dao.obtenerMapaIDNombre();
	}
	
	public HashMap<Long, String> obtenerMapaIDParado() {
		return dao.obtenerMapaIDParado();
	}
	
	public HashMap<Long, String> obtenerMapaIDComun() {
		return dao.obtenerMapaIDComun();
	}
	
	public HashMap<Long, String> obtenerMapaIDFragil() {
		return dao.obtenerMapaIDFragil();
	}
	
	public HashMap<Long, String> obtenerMapaIDInflamable() {
		return dao.obtenerMapaIDInflamable();
	}
	public HashMap<Long, String> obtenerMapaIDPesada() {
		return dao.obtenerMapaIDPesada();
	}
}
