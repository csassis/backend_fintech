package br.com.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import br.com.fintech.models.EmprestimoModel;

public class EmprestimoDAO implements IDAO<EmprestimoModel> {

    public void create(EmprestimoModel emprestimo, Connection connection) {
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO TAB_EMPRESTIMO(VALOR, TRIBUTO, JUROS_MENSAL, QUANTIDADE_PARCELA, QUANTIDADE_PARCELA_PAGA, DATA) VALUES(?, ?, ?, ?, ?, ?)";
            stmt = connection.prepareStatement(sql);
            stmt.setDouble(1, emprestimo.getValor());
            stmt.setDouble(2, emprestimo.getTributo());
            stmt.setString(3, emprestimo.getJurosMensal());
            stmt.setInt(4, emprestimo.getQuantidadeParcela());
            stmt.setInt(5, emprestimo.getQuantidadeParcelaPaga());
            java.sql.Date date = new java.sql.Date(emprestimo.getData().getTimeInMillis());
            stmt.setDate(6, date);
            stmt.executeUpdate();

            System.out.println("Dados do empréstimo inseridos com sucesso");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados na tabela empréstimo " + e.getMessage());
            throw new RuntimeException(e);
        } finally {
            // Fechar o PreparedStatement no bloco finally para garantir a execução mesmo em caso de exceção.
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<EmprestimoModel> getAll(Connection connection) {
        List<EmprestimoModel> emprestimos = new ArrayList<>();
        String sql = "SELECT * FROM TAB_EMPRESTIMO";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                double valor = resultSet.getDouble("valor");
                double tributo = resultSet.getDouble("tributo");
                String jurosMensal = resultSet.getString("juros_mensal");
                int quantidadeParcela = resultSet.getInt("quantidade_parcela");
                int quantidadeParcelaPaga = resultSet.getInt("quantidade_parcela_paga");
                java.sql.Date dataSql = resultSet.getDate("data");
                Calendar data = Calendar.getInstance();
                data.setTime(new java.util.Date(dataSql.getTime()));

                EmprestimoModel emprestimoModel = new EmprestimoModel(id, valor, tributo, jurosMensal, quantidadeParcela, quantidadeParcelaPaga, data);
                emprestimos.add(emprestimoModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao listar Empréstimos " + e.getMessage());
        }

        return emprestimos;
    }
}

