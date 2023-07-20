package com.jgonite.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Currency;
import java.util.Locale;

public class StringUtils {
	
	private static Locale locale = new Locale("pt", "BR");
	
	public static String trocarVirgulaPorPonto(String s) {
		return s.replaceAll(",", ".");
	}
	
	public static String bigDecimalParaMoeda(BigDecimal valor) {
		if (BigDecimal.ZERO.compareTo(valor) != 0) {
			NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
	        formatter.setMaximumFractionDigits(2);
	        formatter.setMinimumFractionDigits(2);
	        formatter.setCurrency(Currency.getInstance("BRL"));
	        String formattedValue = formatter.format(valor);
	        return formattedValue;
		} else {
			return "-";
		}
		
	}
	
	public static String bigDecimalParaPorcentagem(BigDecimal valor) {
        NumberFormat formatter = NumberFormat.getPercentInstance(locale);
        formatter.setMaximumFractionDigits(1);
        formatter.setMinimumFractionDigits(1);
        formatter.setRoundingMode(RoundingMode.HALF_UP);
        String formattedValue = formatter.format(valor);
        return formattedValue;
	}
	
	public static String localDateTimeParaDDMMYYYYhhmm(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return dateTime.format(formatter);
    }
	
	public static LocalDateTime YYYYMMDDparaLocalDateTime(String dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ld = LocalDate.parse(dateTime, formatter);
        return LocalDateTime.of(ld, LocalDateTime.now().toLocalTime());
    }

}
