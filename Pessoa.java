/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bim.agenda.aula1;
import java.io.Serializable;

public class Pessoa implements Serializable  {
    private static final long serialVersionUID = 1L; 

    private String nome;
    private String dataNascimento;
    private String telefone;
    private String email;
    private Tipo tipo;
    private String preferencia;
    private int id;



    public Pessoa(String nome, String dataNascimento, String telefone, String email, Tipo tipo, String preferencia) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
        this.tipo = tipo;
        this.preferencia = preferencia;
    }
    
        public Pessoa(int id, String nome, String dataNascimento, String telefone, String email, Tipo tipo, String preferencia) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
        this.tipo = tipo;
        this.preferencia = preferencia;
    }


    public String getNome() {
        return nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }
    
    public String getPreferencia() {
        return preferencia;
    }
    
    public Tipo getTipo() {
        return tipo;
    }
    
    public void setNome(String nome) {
    this.nome = nome;
}

public void setDataNascimento(String dataNascimento) {
    this.dataNascimento = dataNascimento;
}

public void setTelefone(String telefone) {
    this.telefone = telefone;
}

public void setEmail(String email) {
    this.email = email;
}

public void setTipo(Tipo tipo) {
    this.tipo = tipo;
}

public void setPreferencia(String preferencia) {
    this.preferencia = preferencia;
}

 public int getId() {
        return id;
    }

 public void SetId(int id) {
        this.id = id;
    }


}
