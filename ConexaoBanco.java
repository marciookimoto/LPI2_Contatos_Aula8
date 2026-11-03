/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bim.agenda.aula1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
    private static final String URL = "jdbc:mysql://localhost:3306/agenda?useTimezone=true&serverTimezone=UTC";
    private static final String USUARIO = "root"; 
    private static final String SENHA = "";
    public static Connection getConexao() {
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           return DriverManager.getConnection(URL, USUARIO, SENHA);
            
        } catch (ClassNotFoundException e) {
            System.err.println("Erro: Driver do MySQL não foi encontrado! " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            return null;
        }
    }
}

