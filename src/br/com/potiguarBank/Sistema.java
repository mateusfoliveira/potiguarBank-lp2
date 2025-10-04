package br.com.potiguarBank;

import java.util.ArrayList;
import java.util.Scanner;
//import java.util.InputMismatchException;

public class Sistema {
	
	private ArrayList <Conta> listaContas;
	
	public Sistema() {
		super();
		this.listaContas = new ArrayList<>();
		
	}

	
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
		
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("Deseja realizar um depósitio inicial? Se sim digite um valor maior do que zero.");
		System.out.println("-------------------------------------------------------------------------------\n");
		
		long saldo = scanner.nextLong();
		
		Conta novaConta = null;
		
		switch(entrada) {
			case 1:
					novaConta = new ContaPoupanca(nome);

			case 2:
					novaConta = new ContaCorrente(nome);
					
				break;
					
			default:
					System.out.println("---------------------------------------------");
					System.out.println("Opção de conta inválida, cancelando operação.");
					System.out.println("---------------------------------------------");
				return;	
		}
		listaContas.add(novaConta);
		
		System.out.println("Conta criada com sucesso!");
	}
	
	public void menu(){
		
		while(true) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("=============================");
		System.out.println("Bem vindo ao Potiguar Bank! |");
		System.out.println("=============================");
		System.out.println("------------------------");
		System.out.println("Escolha uma das opções: ");
		System.out.println("------------------------");
		System.out.println(" 1 - Criar conta\n 2 - Realizar depósito \n 3 - Realizar saque\n 4 - Realizar transferência");
		System.out.println(" 5 - Listar contas\n 6 - Calcular total de tributos \n 7 - Encerrar o programa");
		System.out.println("-------------------------");
		
		int entrada = scanner.nextInt();
		scanner.nextLine();
		
		switch(entrada) {
			//Criar conta
			case 1:
				//criarConta(Scanner scanner);
				break;
			//Depositar
			case 2:
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

