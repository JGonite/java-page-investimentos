package com.jgonite.util;

import java.math.BigDecimal;

public class MathUtils {
	
	public static BigDecimal valorAcaoComoNumero(String valor) {
		return new BigDecimal(valor.replaceAll(",", "."));
	}

}
