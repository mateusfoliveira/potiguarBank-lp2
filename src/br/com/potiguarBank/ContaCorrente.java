package br.com.potiguarBank;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ContaCorrente extends Conta implements ITributavel {

	public ContaCorrente(String cliente) {
		super(cliente, "Corrente");
		
	}
	
	@Override
	public void sacar(BigDecimal valor) {
		
		BigDecimal zero = new BigDecimal("0");
		
		if(valor.compareTo(zero) <= 0) {
			System.out.println("--------------------------------------");
			System.out.println("Valor inválido, encerrando a operação.");
			System.out.println("--------------------------------------\n");
			return;
		}
		
		BigDecimal taxa = new BigDecimal ("1.05");
		
		BigDecimal valorComTaxa = valor.multiply(taxa).setScale(2, RoundingMode.HALF_UP);
		
		if(getSaldo().compareTo(valorComTaxa) <= 0) {
			System.out.println("----------------------------------------------------------------");
			System.out.println("Saldo insuficiente para realizar saque. Considere a taxa de 5% |");
			System.out.println("----------------------------------------------------------------\n");
			return;
		}
		
		setSaldo(getSaldo().subtract(valorComTaxa));
		
		System.out.println("----------------------------");
		System.out.println("Saque realizado com sucesso!");
		System.out.println("----------------------------\n");
		
		System.out.println("------------------------------------");
		System.out.println("Novo saldo da conta " + getNumero() + ": " + getSaldoFormatado());
		System.out.println("------------------------------------");
		
	}
	
	@Override
	public void transferir(BigDecimal valor, Conta contaDestino) {
		
		BigDecimal zero = new BigDecimal("0");
		
		if(valor.compareTo(zero) <= 0) {
			System.out.println("--------------------------------------");
			System.out.println("Valor inválido, encerrando a operação.");
			System.out.println("--------------------------------------\n");
			return;
		}
		
		BigDecimal taxa = new BigDecimal ("1.05");
		
		BigDecimal valorComTaxa = valor.multiply(taxa).setScale(2, RoundingMode.HALF_UP);
		
		
		if(getSaldo().compareTo(valor) < 0) {
			System.out.println("-----------------------------------------------");
			System.out.println("Saldo insuficiente para realizar transferência.");
			System.out.println("-----------------------------------------------\n");
			return;
		}
		
		this.setSaldo(this.getSaldo().subtract(valorComTaxa));
		
		System.out.println("------------------------------------");
		System.out.println("Transferência concluida com sucesso!");
		System.out.println("------------------------------------\n");
		
		contaDestino.depositar(valorComTaxa);
		
		
	}
	
	public BigDecimal calcularTributos() {
		BigDecimal tributo = new BigDecimal("0.01");
		return this.getSaldo().multiply(tributo).setScale(2, RoundingMode.HALF_UP);
	}

}
