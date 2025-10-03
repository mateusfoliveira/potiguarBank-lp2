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

