package br.com.potiguarBank;

import java.math.BigDecimal;

public class ContaPoupanca extends Conta{
	
	@Override
	public void sacar(BigDecimal valor) {
		
		BigDecimal zero = new BigDecimal("0");
		
		if(valor.compareTo(zero) <= 0) {
			System.out.println("--------------------------------------");
			System.out.println("Valor inválido, encerrando a operação.");
			System.out.println("--------------------------------------\n");
			return;
		}
		
		if(getSaldo().compareTo(valor) < 0) {
			System.out.println("---------------------------------------");
			System.out.println("Saldo insuficiente para realizar saque.");
			System.out.println("---------------------------------------\n");
			return;
		}
		
		setSaldo(getSaldo().subtract(valor));
		
		System.out.println("----------------------------");
		System.out.println("Saque realizado com sucesso!");
		System.out.println("----------------------------\n");
		
		System.out.println("-----------------------------");
		System.out.println("Novo saldo da conta " + getNumero() + ": " + getSaldoFormatado());
		System.out.println("-----------------------------");
		
		
	}

	public ContaPoupanca(String cliente){
		super(cliente, "Poupanca");
	}
}
