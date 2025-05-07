package eletronica_java;

import java.io.IOException;
import java.util.Scanner;

import eletronica_java.model.Componentes;
import eletronica_java.model.Informatica;
import eletronica_java.util.Cores;

public class Menu {

    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);
        
        Componentes c1 = new Componentes(1, "Capacitor CWD", 1, 3.67f, 6, "Eletrolíticos", "Poliester");
        c1.visualizar();
        
        Informatica i1 = new Informatica(2, "Placa de Vídeo", 2, 560.67f, 2, "RX-560", "AMD");
        i1.visualizar();
        
        int opcao = 0;

        while (true) {
            System.out.println(Cores.TEXT_RED_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + "|====================================|");
            System.out.println("|          ELETRONICA GEN            |");
            System.out.println("|====================================|");
            System.out.println("|                                    |");
            System.out.println("|  1 - Criar Produto                 |");
            System.out.println("|  2 - Listar todos os Produtos      |");
            System.out.println("|  3 - Buscar Produto por Número     |");
            System.out.println("|  4 - Atualizar Dados do Produto    |");
            System.out.println("|  5 - Apagar o Produto              |");
            System.out.println("|  6 - Sair                          |");
            System.out.println("|====================================|");
            System.out.println("| Entre com a opção desejada:        |");
            System.out.println("|====================================|");
            System.out.println("");

            opcao = leia.nextInt();

            if (opcao == 6) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nEletrônica GEN - Compre os melhores componentes aqui! ");
				sobre();
				leia.close();
				System.exit(0);
			}

            switch (opcao) {
                case 1:
                    
                    keyPress();
                    break;
                case 2:
                    
                    keyPress();
                    break;
                case 3:
                    
                    keyPress();
                    break;
                case 4:
                    
                    keyPress();
                    break;
                case 5:
                    
                    keyPress();
                    break;
                default:
                    System.out.println("\nOpção Inválida!\n");
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


