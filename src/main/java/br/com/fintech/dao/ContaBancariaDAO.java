package br.com.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fintech.models.ContaBancariaModel;

public class ContaBancariaDAO implements IDAO<ContaBancariaModel> {

    public void create(ContaBancariaModel conta, Connection connection) {
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO TAB_CONTA_BANCARIA(AGENCIA, CONTA, SALDO, TIPO_CONTA, ATIVO,USUARIO_ID) VALUES(?, ?, ?, ?, ?,?)";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, conta.getAgencia());
            stmt.setString(2, conta.getConta());
            stmt.setDouble(3, conta.getSaldo());
            stmt.setString(4, conta.getTipoConta());
            stmt.setInt(5,conta.isAtivo() ? 1 : 0);
            stmt.setInt (6,conta.getUsuarioID());
            stmt.executeUpdate();
            System.out.println("Dados da conta bancária inseridos com sucesso");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados na tabela conta bancária " + e.getMessage());
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

    public List<ContaBancariaModel> getAll(Connection connection) {
        List<ContaBancariaModel> contas = new ArrayList<>();
        String sql = "SELECT * FROM TAB_CONTA_BANCARIA";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                String agencia = resultSet.getString("agencia");
                String conta = resultSet.getString("conta");
                double saldo = resultSet.getDouble("saldo");
                String tipoConta = resultSet.getString("tipo_conta");
                boolean ativo = resultSet.getBoolean("ativo");

                ContaBancariaModel contaBancaria = new ContaBancariaModel(agencia, conta, saldo, tipoConta, ativo);
                contas.add(contaBancaria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao listar Contas Bancárias " + e.getMessage());
        }

        return contas;
    }
}
