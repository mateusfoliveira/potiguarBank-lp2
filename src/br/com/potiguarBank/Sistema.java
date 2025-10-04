package br.com.potiguarBank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;


public class Sistema {
	
	private ArrayList <Conta> listaContas;
	
	public Sistema() {
		super();
		this.listaContas = new ArrayList<>();
		
	}
	
	public BigDecimal converterValor(String entrada) {
		
		String valorString = entrada.trim().replace(",", ".");
		
		BigDecimal valor = new BigDecimal (valorString);

		return valor;
	}
	
	//Case 1 
	public void criarConta(Scanner scanner){
		
		System.out.println("--------------------------------");
		System.out.println("Digite o nome do dono da conta: ");
		System.out.println("--------------------------------");
		
		String nome = scanner.nextLine();
		
		System.out.println("--------------------------------------");
		System.out.println("Escolha o tipo da conta a ser criada: ");
		System.out.println("--------------------------------------");
		System.out.println(" 1 - Poupança\n 2 - Corrente");
		System.out.println("------------------------\n");
		
		int entrada = scanner.nextInt();
		scanner.nextLine();
	
		Conta novaConta = null;
		
		switch(entrada) {
			case 1:
				novaConta = new ContaPoupanca(nome);
				break;

			case 2:
				novaConta = new ContaCorrente(nome);	
				break;
					
			default:
				System.out.println("---------------------------------------------");
				System.out.println("Opção de conta inválida, cancelando operação.");
				System.out.println("---------------------------------------------\n");
				return;	
		}
		
		System.out.println("-----------------------------------------");
		System.out.println("Deseja realizar um depósitio inicial? s/n");
		System.out.println("------------------------------------------\n");
		
		String entradaString = scanner.nextLine();
		
		if(entradaString.equalsIgnoreCase("s")){
			System.out.println("-----------------------------------------------");
			System.out.println("Digite o valor a ser depositado.\"Ex: 22,50\" :");
			System.out.println("-----------------------------------------------");
			String valorString = scanner.nextLine();
			novaConta.depositar(converterValor(valorString));	
		}
		
		
		listaContas.add(novaConta);
		
		System.out.println("-------------------------");
		System.out.println("Conta criada com sucesso!");
		System.out.println("-------------------------");
	}
	
	//Case 2
	public void realizarDeposito(Scanner scanner){
		
		if(listaContas.isEmpty()) {
			System.out.println("----------------------------------------------------------");
			System.out.println("Não foram criadas contas no sistema, cancelando operação.");
			System.out.println("----------------------------------------------------------");
			return;
		}
		
		System.out.println("-------------------------");
		System.out.println("Digite o número da conta:");
		System.out.println("-------------------------\n");
		
		int numeroConta = scanner.nextInt();
		scanner.nextLine();
		
		Conta contaDeposito = null;
		
		for(Conta conta : listaContas) {
			if(conta.getNumero() == numeroConta) {
				contaDeposito = conta;
				break;
			}
		}
		
		if(contaDeposito == null) {
			System.out.println("------------------------------------------");
			System.out.println("Conta não encontrada! Cancelando depósito.");
			System.out.println("------------------------------------------");
			return;
		}
		
		System.out.println("-----------------------------------------------");
		System.out.println("Digite o valor a ser depositado.\"Ex: 22,50\" :");
		System.out.println("-----------------------------------------------");
		
		String valorString = scanner.nextLine();
		

		contaDeposito.depositar(converterValor(valorString));
		
		
	}
	
	public void menu(){
		System.out.println("=============================");
		System.out.println("Bem vindo ao Potiguar Bank! |");
		System.out.println("=============================");
		
		while(true) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("-----------------------");
		System.out.println("Escolha uma das opções: ");
		System.out.println("-------------------------------");
		System.out.println(" 1 - Criar conta\n 2 - Realizar depósito \n 3 - Realizar saque\n 4 - Realizar transferência");
		System.out.println(" 5 - Listar contas\n 6 - Calcular total de tributos \n 7 - Encerrar o programa");
		System.out.println("-------------------------------");
		
		int entrada = scanner.nextInt();
		scanner.nextLine();
		
		switch(entrada) {
			case 1:
				criarConta(scanner);
				break;
				
			case 2:
				realizarDeposito(scanner);
				break;
			//Sacar
			case 3:
				break;
			//Transferir
			case 4:
				break;
			//Listar contas
			case 5:
				break;
				
			case 6:
			//Calcular tributos
				break;
				
			case 7:				
			System.out.println("-------------------");
			System.out.println("Programa encerrado.");
			System.out.println("-------------------\n");
				scanner.close();
				return;
				
			default:
				System.out.println("--------------------------------------------------------");
				System.out.println("Entrada inválida, tente novamente ou digite 7 para sair.");
				System.out.println("--------------------------------------------------------\n");
				break;
				
			}
		
		}
	}

}

