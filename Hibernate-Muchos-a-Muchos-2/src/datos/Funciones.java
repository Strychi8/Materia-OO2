package datos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class Funciones {

	// ES BISIESTO
	public static boolean esBisiesto(int anio) {
		boolean resultado = false;
		if ((anio % 4 == 0) && (anio % 100 != 0) || (anio % 100 == 0) && (anio % 400 == 0)) {
			resultado = true;
		}
		return resultado;
	}

	// ES FECHA VALIDA
	public static boolean esFechaValida(LocalDate fecha) {
		boolean resultado = false;
		if (esBisiesto(fecha.getYear()) && fecha.getDayOfMonth() < 30) {
			resultado = true;
		}
		return resultado;
	}

	// TREAR FECHA CORTA
	public static String traerFechaCorta(LocalDate fecha) {
		int dia = fecha.getDayOfMonth();
		int mes = fecha.getMonthValue();
		int anio = fecha.getYear();
		String fecha1 = dia + " / " + mes + " / " + anio;
		return fecha1;
	}

	// TRAER HORA CORTA
	public static String traerHoraCorta(LocalTime hora) {
		int horas = hora.getHour();
		int minutos = hora.getMinute();
		String hora1 = horas + " : " + minutos;
		return hora1;
	}

	// ES DIA HABIL
	public static boolean esDiaHabil(LocalDate fecha) {
		int d = fecha.getDayOfWeek().getValue();
		return ((d >= 1) && (d <= 5));
	}

	// TRAER DIA DE LA SEMANA
	public static String traerDiaDeLaSemana(LocalDate fecha) {
		int dia = fecha.getDayOfWeek().getValue();
		String diaSemana = "";
		switch (dia) {
		case 1:
			diaSemana = "Lunes";
			break;
		case 2:
			diaSemana = "Martes";
			break;
		case 3:
			diaSemana = "Miercoles";
			break;
		case 4:
			diaSemana = "Jueves";
			break;
		case 5:
			diaSemana = "Viernes";
			break;
		case 6:
			diaSemana = "Sabado";
			break;
		case 7:
			diaSemana = "Domingo";
			break;
		}

		return diaSemana;

	}

	// TRAER MES EN LETRAS
	public static String traerMesEnLetras(LocalDate fecha) {
		int dia = fecha.getMonthValue();
		String mes = "";
		switch (dia) {
		case 1:
			mes = "Enero";
			break;
		case 2:
			mes = "Febrero";
			break;
		case 3:
			mes = "Marzo";
			break;
		case 4:
			mes = "Abril";
			break;
		case 5:
			mes = "Mayo";
			break;
		case 6:
			mes = "Junio";
			break;
		case 7:
			mes = "Julio";
			break;
		case 8:
			mes = "Agosto";
			break;
		case 9:
			mes = "Septiembre";
			break;
		case 10:
			mes = "Octubre";
			break;
		case 11:
			mes = "Noviembre";
			break;
		case 12:
			mes = "Diciembre";
			break;
		}

		return mes;

	}

	// TRAER FECHA LARGA
	public static String traerFechaLarga(LocalDate fecha) {
		String fechaLarga = traerDiaDeLaSemana(fecha) + " " + fecha.getDayOfMonth() + " de " + traerMesEnLetras(fecha)
				+ " del " + fecha.getYear();
		return fechaLarga;
	}

	// TRAER DIAS DE UN MES
	public static int traerCantDiasDeUnMes(int anio, int mes) {
		int dias = 0;
		switch (mes) {

		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			dias = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			dias = 30;
			break;
		case 2:
			if (esBisiesto(anio)) {
				dias = 29;
			} else {
				dias = 28;
			}
			break;
		}
		return dias;
	}

	// APROXIMAR 2 DECIMALES
	public static double aproximar2Decimal(double valor) {

		double resultado = valor;
		double parteEntera = Math.floor(resultado);

		resultado = (resultado - parteEntera) * Math.pow(10, 2);
		resultado = Math.round(resultado);
		resultado = (resultado / Math.pow(10, 2)) + parteEntera;

		return resultado;
	}

	// VALIDAR ES NUMERO
	public static boolean esNumero(char c) {
		String caracter = String.valueOf(c);
		return (caracter.matches("[0-9]*"));

	}

	// VALIDAR ES NUMERO 2
	public static boolean esNumero2(char c) {
		return Character.isDigit(c);

	}

	// VALIDAR ES LETRA
	public static boolean esLetra(char c) {
		String caracter = String.valueOf(c);
		return (caracter.matches("[A-Za-z]*"));
	}

	// VALIDAR ES LETRA
	public static boolean esLetra2(char c) {
		return Character.isLetter(c);
	}

	// VALIDAR CADENA NUMEROS
	public static boolean esCadenaNros(String cadena) {
		return (cadena.matches("[0-9]*"));
	}

	// VALIDAR CADENA LETRAS
	public static boolean esCadenaLetras(String cadena) {
		return (cadena.matches("[A-Za-z]*"));
	}

	// RESTAR DIA
	public static LocalDate restarDia(LocalDate fecha) {
		LocalDate dia = fecha;
		dia = dia.minusDays(1);
		return dia;
	}

	// SUMAR DIA
	public static LocalDate sumarDia(LocalDate fecha) {
		LocalDate dia = fecha;
		dia = dia.plusDays(1);
		return dia;
	}

	// RESTAR DIAS
	public static LocalDate restarDias(LocalDate fecha, int dias) {
		LocalDate dia = fecha;
		for (int contador = 0; contador < dias; contador++) {
			dia = restarDia(dia);
		}
		return dia;

	}

	// SUMAR DIAS
	public static LocalDate sumarDias(LocalDate fecha, int dias) {
		LocalDate dia = fecha;
		for (int contador = 0; contador < dias; contador++) {
			dia = sumarDia(dia);
		}
		return dia;
	}

	// EXISTE FECHA EN INTERVALO
	public static boolean estaLaFechaEntre(LocalDate fecha, LocalDate desde, LocalDate hasta) {
		boolean resultado = false;
		if (!fecha.isAfter(hasta) && !fecha.isBefore(desde)) {
			resultado = true;
		}
		return resultado;
	}

	// EXISTE HORA EN INTERVALO
	public static boolean estaLaHoraEntre(LocalTime hora, LocalTime desde, LocalTime hasta) {
		boolean resultado = false;
		if (!hora.isAfter(hasta) && !hora.isBefore(desde)) {
			resultado = true;
		}
		return resultado;
	}

	// DIFERENCIA DE DIAS
	public static int diferenciaDias(LocalDate fechaInicio, LocalDate fechaFin) {
		return Period.between(fechaInicio, fechaFin).getDays();
	}

	// DIFERENCIA HORARIA
	public static LocalTime diferenciaHoraria(LocalTime horaInicio, LocalTime horaFin) {

		int hora = horaFin.minusHours(horaInicio.getHour()).getHour();
		int minutos = horaFin.minusMinutes(horaInicio.getMinute()).getMinute();
		int segundos = horaFin.minusSeconds(horaInicio.getSecond()).getSecond();

		return LocalTime.of(hora, minutos, segundos);
	}

	// CANTIDAD DIAS HABILES DE UN MES
	public static int diasHabilesMes(int mes, int anio) {
		LocalDate fechaInicio = LocalDate.of(anio, mes, 1);
		LocalDate fechaFin = LocalDate.of(anio, mes, traerCantDiasDeUnMes(anio, mes));

		int diasHabiles = 0;

		while (estaLaFechaEntre(fechaInicio, fechaInicio, fechaFin)) {
			if (esDiaHabil(fechaInicio)) {
				diasHabiles++;
			}
			fechaInicio = fechaInicio.plusDays(1);
		}

		return diasHabiles;
	}
	
	// CANTIDAD DIAS NO HABILES DE UN MES
	public static int diasNoHabilesMes(int mes, int anio) {
		return traerCantDiasDeUnMes(anio, mes) - diasHabilesMes(mes,anio);
	}

}
