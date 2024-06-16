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
                    menuViagens(arvoreV);
                    break;
                case 2:
                    menuTuristas(arvoreT);
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


    public static void mostrarMenuPrincipal () {

        System.out.println("""
                1. Gerenciar Viagens.
                2. Gerenciar Turistas.
                0. Sair.
                """);

    }


    public static void menuViagens (ArvoreViagem arvoreV) {

        while(true) {
            
            opcoesViagem();
            int opcao = Integer.parseInt(entrada.nextLine());

            switch(opcao) {

                case 1:
                inserirViagemV(arvoreV);
                break;

                case 2:


                case 3:
                removeViagem(arvoreV);
                break;

                case 4:
                if(arvoreV.getQuantNos() != 0) {
                
                    System.out.println("------------------------------");
                    arvoreV.mostraViagensPreFixado(arvoreV.getRaiz());
                
                }

                else {

                    System.out.println();
                    System.out.println("Não há mais viagens.");
                    System.out.println();

                }
                break;

                case 0:
                return;

                default:
                System.out.println("Insira um número valido!");
                continue;
                }
                
            }

    }

    public static void menuTuristas (ArvoreTurista arvoreT) {

        while(true) {
            
            opcoesTurista();
            int opcao = Integer.parseInt(entrada.nextLine());

            switch(opcao) {

                case 1:
                break;

                case 2:
                break;

                case 3:
                break;

                case 4:
                break;

                case 0:
                return;

                default:
                System.out.println("Insira um número valido!");
                continue;
                }
                
            }

    } 


    public void alterarViagem(ArvoreViagem arvore) {


        System.out.println("Digite o codigo da viagem que deseja alterar: ");
        int codigo = Integer.parseInt(entrada.nextLine());

        arvore.pesquisar(codigo, arvore.getRaiz()); {


        }


    }


    public static void opcoesViagem () {

        System.out.println("""
                1. Adicionar Viagem. 
                2. Alterar Viagem.
                3. Remover Viagem.
                4. Mostrar Viagens.
                0. Retornar
                """);

    }

    public static void opcoesTurista () {

        System.out.println("""
                1. Adicionar Turista em Viagem.
                2. Alterar Viagem do Turista.
                3. Remover turista da Viagem.
                4. Mostrar valor em viagem.
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

        NoViagem no = new NoViagem(item);
        arvore.inserirViagem(item);

        System.out.println();

        System.out.println("Viagem adicionada com sucesso!");
        
    }


    public static void removeViagem(ArvoreViagem arvore) {

        System.out.println("Digite o codigo da viagem a ser removida: ");
        int codigo = Integer.parseInt(entrada.nextLine());

        boolean removeu = arvore.removerViagemNaoRecursivo(codigo);
        
        if(removeu == true) {
            
            System.out.println();
            System.out.println("Viagem removida com sucesso!\n");
            
        }
        
        else {

            System.out.println("Viagem não encontrada!");
            
        }

    }


    }