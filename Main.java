//Grupo: Thiago Rochedo, Fábio Giordani e Gustavo de Lima.
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Banco banco = new Banco("Banco XYZ");
		int opcao = 0;

		while (opcao != 6) {
			System.out.println("----- MENU -----");
			System.out.println("1 - Criar conta");
			System.out.println("2 - Consultar saldo");
			System.out.println("3 - Depositar");
			System.out.println("4 - Sacar");
			System.out.println("5 - Transferir");
			System.out.println("6 - Sair");
			System.out.print("Escolha uma opção: ");
			opcao = scanner.nextInt();

			switch (opcao) {
			case 1:
				System.out.print("Digite o nome do titular: ");
				String nome = scanner.next();
				System.out.print("Digite o CPF do titular: ");
				String cpf = scanner.next();
				Conta conta = new Conta(nome, cpf);
				banco.addConta(conta);
				System.out.println("Conta criada com sucesso! Número da conta: " + conta.getNumero());
				break;

			case 2:
				System.out.print("Digite o número da conta: ");
				int numeroConta = scanner.nextInt();
				Conta contaSaldo = banco.getConta(numeroConta);
				if (contaSaldo == null) {
					System.out.println("Conta não encontrada!");
				} else {
					System.out.println("Saldo: R$ " + contaSaldo.getSaldo());
				}
				break;

			case 3:
				System.out.print("Digite o número da conta: ");
				int numeroContaDeposito = scanner.nextInt();
				Conta contaDeposito = banco.getConta(numeroContaDeposito);
				if (contaDeposito == null) {
					System.out.println("Conta não encontrada!");
				} else {
					System.out.print("Digite o valor do depósito: ");
					double valorDeposito = scanner.nextDouble();
					contaDeposito.depositar(valorDeposito);
					System.out.println("Depósito realizado com sucesso! Novo saldo: R$ " + contaDeposito.getSaldo());
				}
				break;

			case 4:
				System.out.print("Digite o número da conta: ");
				int numeroContaSaque = scanner.nextInt();
				Conta contaSaque = banco.getConta(numeroContaSaque);
				if (contaSaque == null) {
					System.out.println("Conta não encontrada!");
				} else {
					System.out.print("Digite o valor do saque: ");
					double valorSaque = scanner.nextDouble();
					if (contaSaque.sacar(valorSaque)) {
						System.out.println("Saque realizado com sucesso! Novo saldo: R$ " + contaSaque.getSaldo());
					} else {
						System.out.println("Saldo insuficiente!");
					}
				}
				break;

			case 5:
				System.out.print("Digite o número da conta remetente: ");
				int numeroContaRemetente = scanner.nextInt();
				Conta contaRemetente = banco.getConta(numeroContaRemetente);
				if (contaRemetente == null) {
					System.out.println("Conta remetente não encontrada!");
				} else {
					System.out.print("Digite o número da conta destinatária: ");
					int numeroContaDestinataria = scanner.nextInt();
					Conta contaDestinataria = banco.getConta(numeroContaDestinataria);
					if (contaDestinataria == null) {
						System.out.println("Conta destinatária não encontrada!");
					} else {
						System.out.print("Digite o valor da transferência: ");
						double valorTransferencia = scanner.nextDouble();
						if (contaRemetente.transferir(contaDestinataria, valorTransferencia)) {
							System.out.println("Transferência realizada com sucesso!");
						} else {
							System.out.println("Saldo insuficiente!");
						}
					}
				}
				break;
			case 6:
				System.out.println("Encerrando...");
				break;

			default:
				System.out.println("Opção inválida!");
				break;
			}
		}

		scanner.close();
	}
}