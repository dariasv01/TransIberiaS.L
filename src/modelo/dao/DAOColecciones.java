package modelo.dao;

import java.util.ArrayList;
import java.util.Map;


public class DAOColecciones<T> {
	
	private ArrayList<T> lista;
	private DAO<ArrayList<T>> accesoFichero;
	
	public DAOColecciones(String path,boolean create) {
		accesoFichero=new DAO<>(path, create);
		lista=accesoFichero.getOne();
		if(null==lista) {
			lista=new ArrayList<>();
		}
	}

	public ArrayList<T> getAll() {
		lista=accesoFichero.getOne();
		if(null==lista) {
			lista=new ArrayList<>();
		}
		return lista;
	}
	
	public boolean save(T element) {
		lista.add(element);
		return accesoFichero.override(lista); 
	}
	
	public T findById(T idElement) {
		for(T element:getAll()) {
			if(element.equals(idElement)) {
				return element;
			}
		}
		return null;
	}
	
	public boolean modify(T element) {
		T elementOriginal=findById(element);
		lista.remove(elementOriginal);
		lista.add(element);
		return accesoFichero.override(lista);
	}
	
	public boolean delete(T element) {
		T elementOriginal=findById(element);
		lista.remove(elementOriginal);
		return accesoFichero.override(lista);
	}
	
}

