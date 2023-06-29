import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] Args) {
        Scanner entrada = new Scanner(System.in);

        // CRIAÇÃO DO TABULEIRO
        char tabuleiro[][] = new char[4][4];
        for (int i = 1; i < tabuleiro.length; i++) {
            for (int j = 1; j < tabuleiro[i].length; j++) {
                tabuleiro[0][0] = '0';
                tabuleiro[i][j] = ' ';
                tabuleiro[0][i] = (char) (i + 48);
                tabuleiro[j][0] = (char) (j + 48);
            }
            System.out.println();
        }

        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print("|" + tabuleiro[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println();

        // CRIAÇÃO DO JOGO
        char peca = 'X';
        int jogada = 1;
        boolean fimJogo = false;
        while (fimJogo == false) {

            // ATRIBUINDO A PEÇA DE CADA JOGADOR
            if (jogada % 2 == 1) {
                peca = 'X';
                System.out.println("Jogador 1");
            } else {
                peca = 'O';
                System.out.println("Jogador 2");
            }

            
            // RECEBENDO VALOR DO JOGADOR
            tabuleiro[0][0] = (char) (jogada + 48);
            System.out.println("Onde deseja inserir?");

            System.out.print("Linha: ");
            int linha = entrada.nextInt();
            System.out.print("Coluna: ");
            int coluna = entrada.nextInt();


            // VALIDANDO A ESCOLHA DO JOGADOR
            if (linha < 0 || linha > 3 || coluna < 0 || coluna > 3)
                System.out.println("\nPosição Não Existe, Escolha Outra!\n");

            else if (tabuleiro[linha][coluna] == 'X' || tabuleiro[linha][coluna] == 'O')
                System.out.println("\nPosição Já Preenchida, Escolha Outra!");

            else {
                tabuleiro[linha][coluna] = peca;

                for (int i = 0; i < tabuleiro.length; i++) {
                    for (int j = 0; j < tabuleiro[i].length; j++) {
                        System.out.print("|" + tabuleiro[i][j] + "|");
                    }
                    System.out.println();
                }
                System.out.println();
                jogada++;


                // CONDIÇÕES PARA O JOGO ACABAR
                if (jogada == 9) {
                    System.out.println("Velha!");
                    fimJogo = true;
                }

                if ((tabuleiro[1][1] == 'X' && tabuleiro[2][2] == 'X' && tabuleiro[3][3] == 'X') ||
                    (tabuleiro[1][3] == 'X' && tabuleiro[2][2] == 'X' && tabuleiro[3][1] == 'X') ||

                    (tabuleiro[1][1] == 'X' && tabuleiro[1][2] == 'X' && tabuleiro[1][3] == 'X') ||
                    (tabuleiro[2][1] == 'X' && tabuleiro[2][2] == 'X' && tabuleiro[2][3] == 'X') ||
                    (tabuleiro[3][1] == 'X' && tabuleiro[3][2] == 'X' && tabuleiro[3][3] == 'X') ||

                    (tabuleiro[1][1] == 'X' && tabuleiro[2][1] == 'X' && tabuleiro[3][1] == 'X') ||
                    (tabuleiro[1][2] == 'X' && tabuleiro[2][2] == 'X' && tabuleiro[3][2] == 'X') ||
                    (tabuleiro[1][3] == 'X' && tabuleiro[2][3] == 'X' && tabuleiro[3][3] == 'X') ){
                    System.out.println("|---------------------|");
                    System.out.println("| O Jogador 1 Ganhou! |");
                    System.out.println("|---------------------|");
                    fimJogo = true;
                }

                if ((tabuleiro[1][1] == 'O' && tabuleiro[2][2] == 'O' && tabuleiro[3][3] == 'O') ||
                    (tabuleiro[1][3] == 'O' && tabuleiro[2][2] == 'O' && tabuleiro[3][1] == 'O') ||

                    (tabuleiro[1][1] == 'O' && tabuleiro[1][2] == 'O' && tabuleiro[1][3] == 'O') ||
                    (tabuleiro[2][1] == 'O' && tabuleiro[2][2] == 'O' && tabuleiro[2][3] == 'O') ||
                    (tabuleiro[3][1] == 'O' && tabuleiro[3][2] == 'O' && tabuleiro[3][3] == 'O') ||

                    (tabuleiro[1][1] == 'O' && tabuleiro[2][1] == 'O' && tabuleiro[3][1] == 'O') ||
                    (tabuleiro[1][2] == 'O' && tabuleiro[2][2] == 'O' && tabuleiro[3][2] == 'O') ||
                    (tabuleiro[1][3] == 'O' && tabuleiro[2][3] == 'O' && tabuleiro[3][3] == 'O') ){
                    System.out.println("|---------------------|");
                    System.out.println("| O Jogador 2 Ganhou! |");
                    System.out.println("|---------------------|");
                    fimJogo = true;
                }
                System.out.println();
            }
        }
        entrada.close();
    }
}