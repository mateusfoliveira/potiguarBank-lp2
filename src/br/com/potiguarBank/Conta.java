package br.com.potiguarBank;

public abstract class Conta {

	private static int numeroConta = 100;
	
	private int numero;
	
	private long saldo;
	
	private String cliente;
	
	private String tipo;

	public int getNumero() {
		return numero;
	}
	
	public String getTipo() {
		return tipo;
	}

	public long getSaldo() {
		return saldo;
	}

	public String getCliente() {
		return cliente;
	}
	

	public Conta(String cliente, String tipo) {
		this.numero = ++numeroConta;
		this.saldo = 0;
		this.cliente = cliente;
		this.tipo = tipo;
	}
	
	public void depositar(long valor){
		
		if(valor <= 0) {
			System.out.println("---------------------------------------");
			System.out.println("Depósito inválido! Cancelando operação.");
			System.out.println("---------------------------------------");
			return ;
		}
		
		
		saldo += valor;
		System.out.println("-----------------------------");
		System.out.println("Valor depositado com sucesso!");
		System.out.println("-----------------------------");
	}
}
