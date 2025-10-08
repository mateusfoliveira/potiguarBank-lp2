package br.com.potiguarBank;

import java.math.BigDecimal;

public abstract class Conta {

	private static int numeroConta = 100;
	
	private int numero;
	
	private BigDecimal saldo;
	
	private String cliente;
	
	private String tipo;

	public int getNumero() {
		return numero;
	}
	
	public String getTipo() {
		return tipo;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}
	
	protected void setSaldo(BigDecimal saldo) {
		this.saldo =  saldo;
	}
	
	public String getSaldoFormatado(){
		return "R$ " + saldo.setScale(2).toString().replace(".", ",");
	}

	public String getCliente() {
		return cliente;
	}
	

	public Conta(String cliente, String tipo) {
		this.numero = ++numeroConta;
		this.saldo = new BigDecimal("0");
		this.cliente = cliente;
		this.tipo = tipo;
	}
	
	public void depositar(BigDecimal valor){
		
		BigDecimal zero = new BigDecimal("0");
		
		if(valor.compareTo(zero) <= 0){
			System.out.println("---------------------------------------------------");
			System.out.println("Depósito inválido! Cancelando operação de depósito.");
			System.out.println("---------------------------------------------------\n");
			return ;
		}
		
		saldo = saldo.add(valor);
		
		System.out.println("-----------------------------");
		System.out.println("Valor depositado com sucesso!");
		System.out.println("-----------------------------\n");
		
		System.out.println("-----------------------------");
		System.out.println("Novo saldo da conta " + getNumero() + ": " + getSaldoFormatado());
		System.out.println("-----------------------------");
	}
	
	public abstract void sacar(BigDecimal valor);
	
	public abstract void transferir(BigDecimal valor, Conta contaDestino);
	
	public void mostrarConta(){
		
		System.out.println("\n-----------");
		System.out.println("Conta " + getNumero() + " |");
		System.out.println("------------------");
		System.out.println("Titular: " + getCliente());
		System.out.println("Tipo: " + getTipo());
		System.out.println("Saldo: " + getSaldoFormatado());
		System.out.println("------------------\n");
		
	}
}
