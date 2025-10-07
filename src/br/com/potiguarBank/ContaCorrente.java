package br.com.potiguarBank;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ContaCorrente extends Conta implements ITributavel {

	public ContaCorrente(String cliente) {
		super(cliente, "Corrente");
		
	}
	
	public BigDecimal calcularTributos() {
		BigDecimal tributo = new BigDecimal("0.01");
		return this.getSaldo().multiply(tributo).setScale(2, RoundingMode.HALF_UP);
	}
}
