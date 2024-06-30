package arvore;

import java.util.Scanner;

public class Principal {

	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {

		ArvoreViagem arvoreV = new ArvoreViagem();
		ArvoreTurista arvoreT = new ArvoreTurista();

		while (true) {

			mostrarMenuPrincipal();
			int opcao = Integer.parseInt(entrada.nextLine());

			switch (opcao) {
			case 1:
				menuViagens(arvoreV, arvoreT);
				break;
			case 2:
				menuTuristas(arvoreT, arvoreV);
				break;
			case 0:
				System.out.println("Saindo...");
				entrada.close();
				System.exit(0);
				break;
			default:
				System.out.println("Opção inválida, tente novamente.");
				break;
			}
		}

	}

	public static void mostrarMenuPrincipal() {

		System.out.println("""
				1. Gerenciar Viagens.
				2. Gerenciar Turistas.
				0. Sair.
				""");

	}

	public static void menuViagens(ArvoreViagem arvoreV, ArvoreTurista arvoreT) {

		while (true) {

			opcoesViagem();
			int opcao = Integer.parseInt(entrada.nextLine());

			switch (opcao) {

			case 1:
				inserirViagemV(arvoreV);
				break;

			case 2:
				alterarViagem(arvoreV);
				break;

			case 3:
				removeViagem(arvoreV);
				break;

			case 4:
				if (arvoreV.getQuantNos() != 0) {

					System.out.println("------------------------------");
					mostraViagensPreFixado(arvoreV.getRaiz());

				}

				else {

					System.out.println();
					System.out.println("Não há mais viagens.");
					System.out.println();

				}
				break;
			case 5:
				contarTuristasPorViagem(arvoreT, arvoreV);
				break;
			case 0:
				return;

			default:
				System.out.println("Insira um número valido!");
				continue;
			}

		}

	}

	public static void menuTuristas(ArvoreTurista arvoreT, ArvoreViagem arvoreV) {

		while (true) {

			opcoesTurista();
			int opcao = Integer.parseInt(entrada.nextLine());

			switch (opcao) {

			case 1:
				inserirTurista(arvoreT, arvoreV);
				break;

			case 2:
				alterarViagemTurista(arvoreT, arvoreV);
				break;

			case 3:
				removeTurista(arvoreT);
				break;

			case 4:
				if (arvoreT.getQuantNos() != 0) {

					System.out.println("---------------------------");
					mostraTuristaPreFixado(arvoreT.getRaiz());
					break;

				} else {

					System.out.println();
					System.out.println("Não há mais turistas!");

				}

			case 5:
				calcularValorTotal(arvoreT, arvoreV);
				break;
			case 0:
				return;

			default:
				System.out.println("Insira um número valido!");
				continue;
			}

		}

	}

	public static void opcoesViagem() {

		System.out.println("""
				1. Adicionar Viagem.
				2. Alterar Viagem.
				3. Remover Viagem.
				4. Mostrar Viagens.
				5. Mostrar quantidade de turistas em uma viagem.
				0. Retornar
				""");

	}

	public static void opcoesTurista() {

		System.out.println("""
				1. Adicionar Turista em Viagem.
				2. Alterar Viagem do Turista.
				3. Remover turista da Viagem.
				4. Mostrar turistas.
				5. Calcular valor total da viagem.
				0. Retornar
				""");
	}

	public static void inserirViagemV(ArvoreViagem arvore) {

		System.out.println();

		ItemViagem item = new ItemViagem();

		System.out.println("Insira o codigo da viagem: ");
		int codigo = Integer.parseInt(entrada.nextLine());
		item.setCodigoV(codigo);

		System.out.println();

		System.out.println("Insira a origem da viagem: ");
		String origem = entrada.nextLine();
		item.setOrigemV(origem);

		System.out.println();

		System.out.println("Insira o destino da viagem: ");
		String destino = entrada.nextLine();
		item.setDestinoV(destino);

		System.out.println();

		System.out.println("Insira o valor da viagem: ");
		double valor = Double.parseDouble(entrada.nextLine());
		item.setValorV(valor);

		arvore.inserirViagem(item);

		System.out.println();

		System.out.println("Viagem adicionada com sucesso!");

	}

	public static void mostraViagensPreFixado(NoViagem arv) {

		if (arv != null) {

			System.out.println("Codigo da viagem: " + arv.getInfo().getCodigoV() + "\n");
			System.out.println("Origem da viagem " + arv.getInfo().getOrigemV() + "\n");
			System.out.println("Destino da viagem: " + arv.getInfo().getDestinoV() + "\n");
			System.out.println("Valor da viagem: " + arv.getInfo().getValorV() + "\n");

			System.out.println("------------------------");

			mostraViagensPreFixado(arv.getEsq());
			mostraViagensPreFixado(arv.getDir());
		}

	}

	public static void alterarViagem(ArvoreViagem arvore) {

		ItemViagem item = new ItemViagem();

		System.out.println("Digite o codigo da viagem que deseja alterar: ");
		int codigo = Integer.parseInt(entrada.nextLine());

		if (arvore.pesquisar(codigo) == true) {

			System.out.println("Insira o novo codigo da viagem: ");
			int codigoV = Integer.parseInt(entrada.nextLine());
			item.setCodigoV(codigoV);

			System.out.println();

			System.out.println("Insira a nova origem da viagem: ");
			String origem = entrada.nextLine();
			item.setOrigemV(origem);

			System.out.println();

			System.out.println("Insira o novo destino da viagem: ");
			String destino = entrada.nextLine();
			item.setDestinoV(destino);

			System.out.println();

			System.out.println("Insira o  novo valor da viagem: ");
			double valor = Double.parseDouble(entrada.nextLine());
			item.setValorV(valor);

			NoViagem novoNo = new NoViagem(item);

			System.out.println(arvore.alterarViagemBooleano(codigo, novoNo));

			System.out.println();

		}

		else {

			System.out.println("Viagem não encontrada!");

		}

	}

	public static void removeViagem(ArvoreViagem arvore) {

		System.out.println("Digite o codigo da viagem a ser removida: ");
		int codigo = Integer.parseInt(entrada.nextLine());

		boolean removeu = arvore.remover(codigo);

		if (removeu == true) {

			System.out.println();
			System.out.println("Viagem removida com sucesso!\n");

		}

		else {

			System.out.println("Viagem não encontrada!");

		}

	}

	public static void inserirTurista(ArvoreTurista arvoreT, ArvoreViagem arvoreV) {

		System.out.println();

		ItemTurista item = new ItemTurista();
		boolean tem = false;

		System.out.println("Insira o codigo da viagem: ");
		int codigoV = Integer.parseInt(entrada.nextLine());

		tem = arvoreV.pesquisar(codigoV);

		if (tem == true) {

			item.setCodigoV(codigoV);

			System.out.println();

			System.out.println("Insira o codigo do Turista: ");
			int codigoT = Integer.parseInt(entrada.nextLine());
			item.setCodigoT(codigoT);

			System.out.println();

			System.out.println("Insira o nome do turista: ");
			String nome = entrada.nextLine();
			item.setNome(nome);

			System.out.println();

			arvoreT.inserir(item);

			System.out.println();

			System.out.println("Turista adicionado com sucesso!");

		}

		else {

			System.out.println("Não existe viagem com esse codigo! ");

		}

	}

	public static void mostraTuristaPreFixado(NoTurista arvoreT) {

		if (arvoreT != null) {

			System.out.println("Codigo da viagem: " + arvoreT.getInfo().getCodigoV() + "\n");
			System.out.println("Nome do turista: " + arvoreT.getInfo().getNome() + "\n");
			System.out.println("Codigo do turista: " + arvoreT.getInfo().getCodigoT() + "\n");

			System.out.println("------------------------");

			mostraTuristaPreFixado(arvoreT.getEsq());
			mostraTuristaPreFixado(arvoreT.getDir());
		}

	}

	public static void removeTurista(ArvoreTurista arvoreT) {

		System.out.println("Digite o codigo do turista a ser removido: ");
		int codigo = Integer.parseInt(entrada.nextLine());

		boolean removeu = arvoreT.remover(codigo);

		if (removeu == true) {

			System.out.println();
			System.out.println("Turista removido com sucesso!\n");

		}

		else {

			System.out.println("Turista não encontrado!");

		}

	}

	public static void alterarViagemTurista(ArvoreTurista arvoreT, ArvoreViagem arvoreV) {

		System.out.println("Digite o codigo do turista que deseja alterar a viagem: ");
		int codigoT = Integer.parseInt(entrada.nextLine());

		System.out.println("Digite para qual viagem deseja alocá-lo: ");
		int codigoV = Integer.parseInt(entrada.nextLine());

		arvoreT.alterarTurista(codigoT, codigoV, arvoreV);

		System.out.println();

	}

	public static void calcularValorTotal(ArvoreTurista arvoreT, ArvoreViagem arvoreV) {

		int quantidade;
		double valorViagem;

		System.out.println("Digite o codigo da viagem: ");
		int codigoV = Integer.parseInt(entrada.nextLine());

		if (arvoreV.pesquisar(codigoV) == false) {

			System.out.println("Viagem não encontrada!");
			return;

		}

		else {

			quantidade = arvoreT.contarTuristasPorViagem(arvoreT.getRaiz(), codigoV);

			valorViagem = arvoreV.valorViagem(arvoreV.getRaiz(), codigoV);

			valorViagem = valorViagem * quantidade;

			System.out.println("O valor total da viagem é: " + valorViagem + "\n");

		}
	}

	public static void contarTuristasPorViagem(ArvoreTurista arvoreT, ArvoreViagem arvoreV) {
		int codigo;
		System.out.println("Digite o código da viagem: ");
		codigo = Integer.parseInt(entrada.nextLine());

		if (arvoreV.pesquisar(codigo) == false) {
			System.out.println("Viagem não encontrada!");
		} else {
			int totalTuristas = arvoreT.contarTuristasPorViagem(arvoreT.getRaiz(), codigo);
			System.out.println("Total de turistas para a viagem " + codigo + ": " + totalTuristas);
		}
	}
}
