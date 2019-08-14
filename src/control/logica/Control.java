package control.logica;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import facade.Facade;

public class Control {

	public float recorrerDistancia(LocalDateTime fechaAntigua, Facade facade) {

		float kmSegundo = 0.022222222222222f;

		float segundosTotales = contadorDeSegundos(fechaAntigua, facade);

		return kmSegundo * segundosTotales;
	}

	public float contadorDeSegundos(LocalDateTime fechaAntigua, Facade facade) {
		float segundosTotales = 0;
		LocalDateTime tempDateTime = LocalDateTime.from(fechaAntigua);
		LocalDateTime fechaActual = facade.obtenerHoraAplicacion();

		long days = tempDateTime.until(fechaActual, ChronoUnit.DAYS);
		tempDateTime = tempDateTime.plusDays(days);

		long hours = tempDateTime.until(fechaActual, ChronoUnit.HOURS);
		tempDateTime = tempDateTime.plusHours(hours);

		long minutes = tempDateTime.until(fechaActual, ChronoUnit.MINUTES);
		tempDateTime = tempDateTime.plusMinutes(minutes);

		long seconds = tempDateTime.until(fechaActual, ChronoUnit.SECONDS);

		segundosTotales = seconds + 60 * minutes + hours * 3600 + days * 86400;
		return segundosTotales;
	}

	public boolean rutaFinalizada(float km, float kmRecorrido) {

		if (km <= kmRecorrido) {
			return true;
		}
		return false;
	}

	public boolean cambioConductorDosOdescansar(LocalDateTime fechaInicio, Facade facade) {
		if (28800 <= contadorDeSegundos(fechaInicio, facade)) {
			return true;
		}
		return false;
	}

	public boolean cambioConductorUno(LocalDateTime fechaInicio, Facade facade) {
		if (57600 <= contadorDeSegundos(fechaInicio, facade)) {
			return true;
		}
		return false;
	}

}
