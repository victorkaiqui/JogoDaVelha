/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jogodavelha.negocio;

/**
 *
 * @author vpaz
 */
public class Tabuleiro {

    private int[][] tabuleiro;
    private static final int CRUZ = 1;
    private static final int CIRCULO = -1;

    public Tabuleiro() {
        this.tabuleiro = new int[3][3];
    }

    public void limpar() {
        tabuleiro = new int[3][3];
    }

    public boolean efetuarJogada(int l, int c, Jogador j) {

        if (l > 3 || c > 3 || l < 0 || c < 0) {
            return false;
        }

        if (tabuleiro[l][c] != 0) {
            return false;
        }
        if (j.getId() == 1) {

            tabuleiro[l][c] = CRUZ;
            return true;

        } else if (j.getId() == 2) {

            tabuleiro[l][c] = CIRCULO;
            return true;
        }

        return false;

    }

    public boolean verificaTabuleiro() {

        for (int[] is : tabuleiro) {
            for (int i : is) {

                if (i == 0) {
                    return true;
                }
            }

        }

        return false;

    }

    public String exibirTabuleiro() {

        StringBuilder builder = new StringBuilder();


        for (int[] is : tabuleiro) {
            for (int i : is) {

                builder.append("|_").append(i != 0 ? ((i == 1) ? "X" : "O") : " ").append("_|");
            }
            builder.append("\n");
        }


        return builder.toString();


    }

    public int verificarGanhador() {

        if ((tabuleiro[0][0] == CIRCULO && tabuleiro[0][1] == CIRCULO && tabuleiro[0][2] == CIRCULO)
                || (tabuleiro[1][0] == CIRCULO && tabuleiro[1][1] == CIRCULO && tabuleiro[1][2] == CIRCULO)
                || (tabuleiro[2][0] == CIRCULO && tabuleiro[2][1] == CIRCULO && tabuleiro[2][2] == CIRCULO)
                || (tabuleiro[0][0] == CIRCULO && tabuleiro[1][0] == CIRCULO && tabuleiro[2][0] == CIRCULO)
                || (tabuleiro[0][1] == CIRCULO && tabuleiro[1][1] == CIRCULO && tabuleiro[2][1] == CIRCULO)
                || (tabuleiro[0][2] == CIRCULO && tabuleiro[1][2] == CIRCULO && tabuleiro[2][2] == CIRCULO)
                || (tabuleiro[0][0] == CIRCULO && tabuleiro[1][1] == CIRCULO && tabuleiro[2][2] == CIRCULO)
                || (tabuleiro[0][2] == CIRCULO && tabuleiro[1][1] == CIRCULO && tabuleiro[2][0] == CIRCULO)) {

            return CIRCULO;

        } else if ((tabuleiro[0][0] == CRUZ && tabuleiro[0][1] == CRUZ && tabuleiro[0][2] == CRUZ)
                || (tabuleiro[1][0] == CRUZ && tabuleiro[1][1] == CRUZ && tabuleiro[1][2] == CRUZ)
                || (tabuleiro[2][0] == CRUZ && tabuleiro[2][1] == CRUZ && tabuleiro[2][2] == CRUZ)
                || (tabuleiro[0][0] == CRUZ && tabuleiro[1][0] == CRUZ && tabuleiro[2][0] == CRUZ)
                || (tabuleiro[0][1] == CRUZ && tabuleiro[1][1] == CRUZ && tabuleiro[2][1] == CRUZ)
                || (tabuleiro[0][2] == CRUZ && tabuleiro[1][2] == CRUZ && tabuleiro[2][2] == CRUZ)
                || (tabuleiro[0][0] == CRUZ && tabuleiro[1][1] == CRUZ && tabuleiro[2][2] == CRUZ)
                || (tabuleiro[0][2] == CRUZ && tabuleiro[1][1] == CRUZ && tabuleiro[2][0] == CRUZ)) {

            return CRUZ;

        } else {

            return 0;

        }
    }
}
