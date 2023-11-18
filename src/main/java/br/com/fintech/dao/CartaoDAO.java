package br.com.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fintech.models.CartaoModel;

public class CartaoDAO implements IDAO<CartaoModel> {

public void create(CartaoModel cartao, Connection connection) {
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO TAB_CARTAO(NOME_BANDEIRA, DATA_VALIDADE, CODIGO_SEGURANCA, NOME_IMPRESSO, NUMERO_CARTAO, TIPO_CARTAO, ATIVO) VALUES(?, ?, ?, ?, ?, ?, ?)";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, cartao.getNomeBandeira());
            java.sql.Date dataValidade = new java.sql.Date(cartao.getDataValidade().getTimeInMillis());
            stmt.setDate(2, dataValidade);
            stmt.setInt(3, cartao.getCodigoSeguranca());
            stmt.setString(4, cartao.getNomeImpresso());
            stmt.setInt(5, cartao.getNumeroCartao());
            stmt.setString(6, cartao.getTipoCartao());
            stmt.setBoolean(7, cartao.isAtivo());
            stmt.executeUpdate();

            System.out.println("Dados do cartão inseridos com sucesso");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados na tabela cartão " + e.getMessage());
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
 public List<CartaoModel> getAll(Connection connection) {
        List<CartaoModel> cartoes = new ArrayList<>();
        String sql = "SELECT * FROM TAB_CARTAO";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nomeBandeira = resultSet.getString("nome_bandeira");
                java.sql.Date dataValidadeSql = resultSet.getDate("data_validade");
                Calendar dataValidade = Calendar.getInstance();
                dataValidade.setTime(new java.util.Date(dataValidadeSql.getTime()));
                int codigoSeguranca = resultSet.getInt("codigo_seguranca");
                String nomeImpresso = resultSet.getString("nome_impresso");
                int numeroCartao = resultSet.getInt("numero_cartao");
                String tipoCartao = resultSet.getString("tipo_cartao");
                boolean ativo = resultSet.getBoolean("ativo");

 CartaoModel cartao = new CartaoModel(id, nomeBandeira, dataValidade, codigoSeguranca, nomeImpresso, numeroCartao, tipoCartao, ativo);
                cartoes.add(cartao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao listar Cartões " + e.getMessage());
        }

        return cartoes;
    }
}
