package br.com.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fintech.models.DespesaModel;

public class DespesaDAO implements IDAO<DespesaModel> {

	public void create(DespesaModel despesa, Connection connection) {
		PreparedStatement stmt = null;
		try {
			String sql = "INSERT INTO TAB_DESPESA(TIPO, VALOR, DATA_CRIACAO, USUARIO_ID) VALUES(?, ?, ?, ?)";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, despesa.getTipo());
			stmt.setDouble(2, despesa.getValor());
			java.sql.Date date = new java.sql.Date(despesa.getDataCriacao().getTime());
			stmt.setDate(3, date);
			stmt.setInt(4, despesa.getUsuarioID());
			stmt.executeUpdate();

			System.out.println("Dados inseridos com sucesso");
		} catch (Exception e) {
			System.out.println("Erro ao inserir dados na tabela despesa " + e.getMessage());
			throw new RuntimeException(e);
		}
	}

	public List<DespesaModel> getAll(Connection connection) {
		List<DespesaModel> despesas = new ArrayList<>();
		String sql = "SELECT * FROM TAB_DESPESA";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String tipo = resultSet.getString("tipo");
				double valor = resultSet.getDouble("valor");
				int usuarioID = resultSet.getInt("usuario_id");
				java.sql.Date dataCriacaoSql = resultSet.getDate("data_criacao");
				java.util.Date dataCriacao = new java.util.Date(dataCriacaoSql.getTime());
				DespesaModel despesa = new DespesaModel(id, tipo, valor, dataCriacao, usuarioID);
				despesas.add(despesa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao listar Despesas " + e.getMessage());
		}

		return despesas;
	}

}
