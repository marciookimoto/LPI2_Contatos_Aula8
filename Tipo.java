/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bim.agenda.aula1;

/**
 *
 * @author marci
 */
public class Tipo {
    private int id;
    private String nome;
    private String descricao;
    public Tipo(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }
    public Tipo(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    @Override
public String toString() {
    return nome;
}

}

