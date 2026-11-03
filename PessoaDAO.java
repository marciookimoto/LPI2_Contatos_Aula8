/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bim.agenda.aula1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author marci
 */
public class PessoaDAO {

    public void inserir(Pessoa pessoa) {
        String sql = "INSERT INTO contatos (nome, dataNascimento, telefone, email, tipo_id, preferencia) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBanco.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getDataNascimento());
            stmt.setString(3, pessoa.getTelefone());
            stmt.setString(4, pessoa.getEmail());
            stmt.setInt(5, pessoa.getTipo().getId());

            stmt.setString(6, pessoa.getPreferencia());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao salvar no banco: " + e.getMessage());
        }
    }

    public ArrayList<Pessoa> listarTodos() {
        String sql = "SELECT id, nome, dataNascimento,telefone, email, tipo_id, preferencia FROM contatos";
        ArrayList<Pessoa> pessoas = new ArrayList<>();

        try (
                Connection conn = ConexaoBanco.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String dataNascimento = rs.getString("dataNascimento");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                int tipo_id = rs.getInt("tipo_id");

                String preferencia = rs.getString("preferencia");
                Pessoa pessoa = new Pessoa(id, nome, dataNascimento, telefone,email, TipoDAO.buscarPorId(tipo_id), preferencia);

                pessoas.add(pessoa);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar dados do banco: " + e.getMessage());
        }
        return pessoas;
    }

    public void atualizar(int id, Pessoa pessoa) {
        String sql = "UPDATE contatos SET nome=?, dataNascimento = ?, telefone = ?, email=?, tipo_id=?, preferencia=? WHERE id = ?";
        try (Connection conn = ConexaoBanco.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getDataNascimento());
            stmt.setString(3, pessoa.getTelefone());
            stmt.setString(4, pessoa.getEmail());
            stmt.setInt(5, pessoa.getTipo().getId());

            stmt.setString(6, pessoa.getPreferencia());
            stmt.setString(7, String.valueOf(id));

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao salvar no banco: " + e.getMessage());
        }
    }
    
     public void excluir(int id) {

        String sql = "DELETE FROM contatos WHERE id = ?";
        try (Connection conn = ConexaoBanco.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, String.valueOf(id));
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar no banco: " + e.getMessage());
        }

    }


}
