/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelha;

import br.com.jogodavelha.negocio.Jogador;
import br.com.jogodavelha.negocio.Tabuleiro;
import java.util.Scanner;

/**
 *
 * @author vpaz
 */
public class JogoDaVelha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in);
        Tabuleiro t = new Tabuleiro();
        boolean aindaTemJogo = true;
        int rodada = 1;


        System.out.println("Jogador X informe seu nome:");
        String nome = sc.next();
        System.out.println("Jogador O informe seu nome:");
        String nome2 = sc.next();

        Jogador j = new Jogador(1, nome);
        Jogador j2 = new Jogador(2, nome2);


        while (aindaTemJogo) {

            System.out.println(t.exibirTabuleiro());
            if (rodada % 2 == 1) {

                System.out.println("Jogador: " + j.getNome());

                System.out.println("linha");
                int l = sc.nextInt();
                System.out.println("Coluna");
                int c = sc.nextInt();

                if (!t.efetuarJogada(l, c, j)) {
                    System.out.println("O animal so é permitido de 0 a 2");
                    break;
                }
            } else {

                System.out.println("Jogador: " + j2.getNome());
                System.out.println("linha");

                int l = sc.nextInt();
                System.out.println("Coluna");
                int c = sc.nextInt();

                if (!t.efetuarJogada(l, c, j2)) {
                    System.out.println("O animal so é permitido de 0 a 2");
                    break;
                }
            }

            rodada++;

            int i = t.verificarGanhador();

            if (i == 1) {

                System.out.println(j.getNome() + " ganhou");
                aindaTemJogo = false;

            } else if (i == -1) {

                System.out.println(j2.getNome() + " ganhou");
                aindaTemJogo = false;

            } else if (i == 0) {

                if (!t.verificaTabuleiro()) {


                    System.out.println("Jogo empatado");
                    aindaTemJogo = false;

                }

            }

        }


        System.out.println(t.exibirTabuleiro());

    }
}
