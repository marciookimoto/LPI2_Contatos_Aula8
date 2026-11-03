/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bim.agenda.aula1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TipoDAO {
    public void inserir(Tipo categoria) {
        String sql = "INSERT INTO Tipos (nome, descricao) VALUES (?, ?)";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, categoria.getNome());
            stmt.setString(2, categoria.getDescricao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar no banco: " + e.getMessage());
        }
    }

    public ArrayList<Tipo> listarTodos() {
        String sql = "SELECT id, nome, descricao FROM Tipos";
        ArrayList<Tipo> categorias = new ArrayList<>();
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                Tipo categoria = new Tipo(id, nome, descricao);
                categorias.add(categoria);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar dados do banco: " + e.getMessage());
        }
        return categorias;
    }
    public void atualizar(int id, Tipo categoria) {
        String sql = "UPDATE Tipos SET nome = ?, descricao = ? WHERE id = ?";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, categoria.getNome());
            stmt.setString(2, categoria.getDescricao());
            stmt.setInt(3, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar no banco: " + e.getMessage());
        }
    }
    public void excluir(int id) {
        String sql = "DELETE FROM Tipos WHERE id = ?";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao excluir do banco: " + e.getMessage());
        }
    }
    
     public static Tipo buscarPorId(int id) {
    String sql = "SELECT id, nome, descricao FROM tipos WHERE id = ?";
    try (Connection conn = ConexaoBanco.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, id);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return new Tipo(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("descricao")
                );
            }
        }

    } catch (SQLException e) {
        System.out.println("Erro ao buscar tipo: " + e.getMessage());
    }

    return null;
}
    
}

