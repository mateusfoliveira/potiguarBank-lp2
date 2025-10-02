package br.com.potiguarBank;

public abstract class Conta {

	private static int numeroContas = 100;
	
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

	public Conta(long saldo, String cliente, String tipo) {
		super();
		this.numero = ++numeroContas;
		this.saldo = saldo;
		this.cliente = cliente;
		this.tipo = tipo;
	}
}
