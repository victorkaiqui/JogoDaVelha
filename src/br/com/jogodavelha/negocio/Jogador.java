/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jogodavelha.negocio;

/**
 *
 * @author vpaz
 */
public class Jogador {

    private int id;
    private String nome;

    public Jogador(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
