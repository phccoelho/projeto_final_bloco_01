package eletronica_java;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

import eletronica_java.controller.ProdutoController;
import eletronica_java.model.Componentes;
import eletronica_java.model.Informatica;
import eletronica_java.model.Produto;
import eletronica_java.util.Cores;

public class Menu {

    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);
        
        ProdutoController produtos = new ProdutoController();
        
        //Componentes c1 = new Componentes(1, "Capacitor CWD", 1, 3.67f, 6, "Eletrolíticos", "Poliester");
        //c1.visualizar();
        
        //Informatica i1 = new Informatica(2, "Placa de Vídeo", 2, 560.67f, 2, "RX-560", "AMD");
        //i1.visualizar();
        
        int opcao, codigo, tipo, quantidade, quantVendida;
        String nome, categoria, material, fabricante, modelo;
        float preco;
        

        while (true) {
            System.out.println(Cores.TEXT_RED_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + "|====================================|");
            System.out.println("|          ELETRONICA GEN            |");
            System.out.println("|====================================|");
            System.out.println("|                                    |");
            System.out.println("|  1 - Criar Produto                 |");
            System.out.println("|  2 - Listar todos os Produtos      |");
            System.out.println("|  3 - Buscar Produto por Código     |");
            System.out.println("|  4 - Atualizar Dados do Produto    |");
            System.out.println("|  5 - Apagar o Produto              |");
            System.out.println("|  6 - Venda do Produto              |");
            System.out.println("|  7 - Sair                          |");
            System.out.println("|====================================|");
            System.out.println("| Entre com a opção desejada:        |");
            System.out.println("|====================================|");
            System.out.println("");

            opcao = leia.nextInt();

            if (opcao == 7) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nEletrônica GEN - Compre os melhores componentes aqui! ");
				sobre();
				leia.close();
				System.exit(0);
			}

            switch (opcao) {
                case 1:
                	System.out.println(Cores.TEXT_WHITE + "Criar Produto\n\n");

    				System.out.println("Digite o nome do Produto:");
    				leia.skip("\\R");
    				nome = leia.nextLine();

    				System.out.println("Digite o tipo do Produto (1 - COMP | 2 - INF):");
    				tipo = leia.nextInt();

    				System.out.println("Digite o preço do Produto:");
    				preco = leia.nextFloat();
    				
    				System.out.println("Digite a quantidade do Produto:");
    				quantidade = leia.nextInt();

    				switch (tipo) {
    				case 1 -> {
    					System.out.println("Digite a categoria do Componente:");
    					leia.skip("\\R");
    					categoria = leia.nextLine();
    					System.out.println("Digite o material do Componente:");
    					material = leia.nextLine();
    					produtos.cadastrar(new Componentes(produtos.gerarCodigo(), nome, tipo, preco, quantidade, categoria, material));
    				}
    				case 2 -> {
    					System.out.println("Digite o modelo do Produto:");
    					leia.skip("\\R");
    					modelo = leia.nextLine();
    					System.out.println("Digite o Fabricante do Produto:");
    					fabricante = leia.nextLine();
    					produtos.cadastrar(new Informatica(produtos.gerarCodigo(), nome, tipo, preco, quantidade, modelo, fabricante));
    				}
    				}
                    keyPress();
                    break;
                case 2:
                	System.out.println(Cores.TEXT_WHITE + "Listar todas as Produtos\n\n");
    				produtos.listarTodos();
                    keyPress();
                    break;
                case 3:
                	System.out.println(Cores.TEXT_WHITE + "Consultar dados da Produto - por número\n\n");

    				System.out.println("Digite o código do Produto: ");
    				codigo = leia.nextInt();

    				produtos.procurarPorCodigo(codigo);
                    keyPress();
                    break;
                case 4:
                	System.out.println(Cores.TEXT_WHITE + "Atualizar dados do Produto\n\n");

    				System.out.println("Digite o codigo do produto: ");
    				codigo = leia.nextInt();

    				Optional<Produto> produto = produtos.buscarNaCollection(codigo);
    				
    				//Verifica se existe o produto
    				if(produto.isPresent()) {
    					
    					System.out.println("Digite o nome do Produto:");
    					leia.skip("\\R");
    					nome = leia.nextLine();
    	
    					tipo = produto.get().getTipo();
    	
    					System.out.println("Digite o preço do Produto:");
    					preco = leia.nextFloat();
    					
    					System.out.println("Digite a quantidade do Produto:");
    					quantidade = leia.nextInt();
    	
    					switch (tipo) {
    						case 1 -> {
    							System.out.println("Digite a categoria do Componente:");
    	    					leia.skip("\\R");
    	    					categoria = leia.nextLine();
    	    					System.out.println("Digite o material do Componente:");
    	    					material = leia.nextLine();
    	    					produtos.atualizar(new Componentes(produtos.gerarCodigo(), nome, tipo, preco, quantidade, categoria, material));
    						}
    						case 2 -> {
    							System.out.println("Digite o modelo do Produto:");
    	    					leia.skip("\\R");
    	    					modelo = leia.nextLine();
    	    					System.out.println("Digite o Fabricante do Produto:");
    	    					fabricante = leia.nextLine();
    	    					produtos.atualizar(new Informatica(produtos.gerarCodigo(), nome, tipo, preco, quantidade, modelo, fabricante));
    						}
    					}
    				} else // Caso não exista a conta
    					System.out.printf("\n O Produto do código %d não existe!", codigo);
                    keyPress();
                    break;
                case 5:
                	System.out.println(Cores.TEXT_WHITE + "Apagar a Produto\n\n");

    				System.out.println("Digite o código do Produto: ");
    				codigo = leia.nextInt();

    				produtos.deletar(codigo);
                    keyPress();
                    break;
                case 6:
                	System.out.println(Cores.TEXT_WHITE + "Venda de Produto\n\n");

                    System.out.println("Digite o código do Produto: ");
                    codigo = leia.nextInt();

                    System.out.println("Digite a quantidade foi vendida: ");
                    quantVendida = leia.nextInt();

                    produtos.vender(codigo, quantVendida);
                    
                    keyPress();
                    break;
                default:
                	System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
                    keyPress();
                    break;
            }
        }
    }

    public static void sobre() {
        System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + "==============================================");
        System.out.println("║         Projeto Desenvolvido por:          ║");
        System.out.println("║                                            ║");
        System.out.println("║   Pedro Coelho - phcoelho2004@gmail.com    ║");
        System.out.println("║      https://github.com/phccoelho          ║");
        System.out.println("==============================================");
    }

    public static void keyPress() {
        try {
            System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
            while (System.in.read() != '\n') {
                
            }
        } catch (IOException e) {
            System.err.println("Erro de entrada/saída: " + e.getMessage());
        }
    }
}


