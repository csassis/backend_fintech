package br.com.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fintech.models.TransacaoModel;

public class TransacaoDAO implements IDAO<TransacaoModel>{
	public void create(TransacaoModel transacao, Connection connection) {
		PreparedStatement stmt = null;
		try {
			String sql = "INSERT INTO transacao(TIPO, VALOR, DATA_CRIACAO, DATA_VENCIMENTO, USUARIO_ID) "
					+ "VALUES (?, ?, ?, ?, ?)";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, transacao.getTipo());
			stmt.setDouble(2, transacao.getValor());
			java.sql.Date dataCriacao = new java.sql.Date(transacao.getDataCriacao().getTimeInMillis());
			stmt.setDate(3, dataCriacao);
			java.sql.Date dataVenc = new java.sql.Date(transacao.getDataVencimento().getTimeInMillis());
			stmt.setDate(4, dataVenc);
			stmt.setInt(5, transacao.getUsuarioID());
			stmt.executeUpdate();
			
			System.out.println("Dados inseridos com sucesso");
		}
		catch(Exception e) {
			System.out.println("Erro ao inserir dados na tabela despesa " + e.getMessage());
		}
	}

	public List<TransacaoModel> getAll(Connection connection) {
		List<TransacaoModel> transacoes = new ArrayList<>();
        String sql = "SELECT * FROM transacao";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tipo = resultSet.getString("tipo");
                double valor = resultSet.getDouble("valor");
                Calendar dataCriacao = Calendar.getInstance();
				dataCriacao.setTimeInMillis(resultSet.getTimestamp("data_criacao").getTime());
                Calendar dataVencimento = Calendar.getInstance();
				dataCriacao.setTimeInMillis(resultSet.getTimestamp("data_vencimento").getTime());
				int usuarioID = resultSet.getInt("usuario_id");
				TransacaoModel transacao = new TransacaoModel(id, tipo, valor, dataCriacao, dataVencimento, usuarioID);
                transacoes.add(transacao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
			System.out.println("Erro ao listar Despesas " + e.getMessage());
        }
        
        return transacoes;
    }
}
