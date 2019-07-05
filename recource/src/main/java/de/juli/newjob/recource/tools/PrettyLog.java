/**
 * 
 */
package de.juli.newjob.recource.tools;

import java.util.List;

import org.slf4j.Logger;

/**
 * Bietet Methoden, die auf der Konsole augeloggte Informatonen ewas uebersichtlicher
 * gestallten 
 * @author ukloodt
 *
 */
public class PrettyLog {
	private Logger log;
	
	/**
	 * parameterisierter Konstuktuor
	 * 
	 * @param log {@link Logger}
	 */
	public PrettyLog(Logger log) {
		super();
		this.log = log;	
	}

	
	/**
	 * loggt ein Wert auf Level INFO aus
	 * @param value Wert als {@link Object}
	 */
	public void info(Object value) {
		log.info("\n\n\t{}\n", value);			
	}

	/**
	 * loggt ein Werte aus einem Array vom Typ {@link String} auf Level INFO aus
	 * @param values Array von {@link String}
	 */
	public void info(String ... values ) {
		log.info("\n\n\t{}\n", bulidStringFromArr(values));			
	}

	/**
	 * loggt ein Schluesel Wertepaar auf Level INFO aus
	 * @param key Scluessel als {@link String}
	 * @param value Wert als {@link Object}
	 */
	public void info(String key, Object value) {
		log.info("\n\n\t{} : {}\n", key, value);			
	}
	
	/**
	 * Loggt eine Liste mit Verten aus 
	 * @param values {@link List}
	 */
	public void info(List<?> values) {
		StringBuilder sb = new StringBuilder();
		for (Object value : values) {
			if(value.equals(values.get(values.size()-1))) {
				sb.append(String.format("\t%s", value));				
			} else {
				sb.append(String.format("\t%s\n", value));
			}
		}
		log.info("\n\n{}\n", sb.toString());			
	}

	/**
	 * Loggt eine Liste mit Verten aus 
	 * @param key {@link String}
	 * @param values {@link List}
	 */
	public void info(String key, List<?> values) {
		StringBuilder sb = new StringBuilder();
		log.info("\n\n{}\n", key);			
		for (Object value : values) {
			if(value.equals(values.get(values.size()-1))) {
				sb.append(String.format("\t%s", value));				
			} else {
				sb.append(String.format("\t%s\n", value));
			}
		}
		log.info("\n\n{}\n", sb.toString());			
	}

	/**
	 * Loggt eine Liste mit Verten aus 
	 * @param values {@link List}
	 */
	public void debug(List<?> values) {
		StringBuilder sb = new StringBuilder();
		for (Object value : values) {
			if(value.equals(values.get(values.size()-1))) {
				sb.append(String.format("\t%s", value));				
			} else {
				sb.append(String.format("\t%s\n", value));
			}
		}
		log.debug("\n\n{}\n", sb.toString());			
	}
	
	/**
	 * Loggt eine Liste mit Verten aus 
	 * @param key {@link String}
	 * @param values {@link List}
	 */
	public void debug(String key, List<?> values) {
		StringBuilder sb = new StringBuilder();
		log.info("\n\n{}\n", key);			
		for (Object value : values) {
			if(value.equals(values.get(values.size()-1))) {
				sb.append(String.format("\t%s", value));				
			} else {
				sb.append(String.format("\t%s\n", value));
			}
		}
		log.debug("\n\n{}\n", sb.toString());			
	}

	/**
	 * loggt ein Wert auf Level DEBUG aus
	 * @param value Wert als {@link Object}
	 */
	public void debug(Object value) {
		log.debug("\n\n\t{}\n", value);			
	}

	/**
	 * loggt ein Schluesel Wertepaar auf Level DEBUG aus
	 * @param key Scluessel als {@link String}
	 * @param value Wert als {@link Object}
	 */
	public void debug(String key, Object value) {
		log.debug("\n\n\t{} : {}\n", key, value);			
	}
	
	/**
	 * loggt ein Werte aus einem Array vom Typ {@link String} auf Level INFO aus
	 * @param values Array von {@link String}
	 */
	public void debug(String ... values ) {
		log.info("{}", bulidStringFromArr(values));			
	}

	/**
	 * loggt die Mesage einer Exception auf Level Error aus und delegiert die Exeption
	 * @param e {@link Exception} die auzuloggenden Exeption
	 */
	public void error(Exception e) {
		log.error("\n\n\t{}\n",e.getMessage(), e);			
	}

	/**
	 * loggt einen Text Message und Einen Wet auf Level Error aus
	 * 
	 * @param msg {@link String} auzuloggender Text
	 * @param value {@link Object} auzuloggender Wert
	 */
	public void error(String msg, Object value) {
		log.error("\n\n\t{} {}\n", msg, value);			
	}

	/**
	 * loggt einen Text auf Level Error aus und delegiert eine Exeption
	 * 
	 * @param msg {@link String} auzuloggender Text fuer die Exception   
	 * @param e {@link Exception} die zu deligierende Exeption
	 */
	public void error(String msg, Exception e) {
		log.error("\n\n\t{}\n", msg, e);			
	}

	/**
	 * loggt einen Text, eine Mesage auf Level Error aus und delegiert eine Exeption
	 * @param msg {@link String} auzuloggender Text   
	 * @param value {@link Object} auzuloggender Wert 
	 * @param e {@link Exception} zu delegierende Exeption
	 */
	public void error(String msg, Object value, Exception e) {
		log.error("\n\n\t{} {}\n", msg, value, e);			
	}

	/**
	 * Durlauft ein Array vom Typ {@link String} und konkateniert dessen Werte
	 * in eine Zeichenkette
	 * 
	 * @param values Array of {@link String}
	 * @return aneineser gekettete Zeichenfolge {@link String}
	 */
	private String bulidStringFromArr(String[] values) {
		StringBuilder sb = new StringBuilder();
		for (String value : values) {
			sb.append(String.format("%s ", value));
		}
		return sb.toString().trim();
	}

}
