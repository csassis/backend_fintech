package br.com.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fintech.models.InvestimentoModel;

public class InvestimentoDAO implements IDAO<InvestimentoModel>{
	public void create(InvestimentoModel investimento, Connection connection) {
		PreparedStatement stmt = null;
		try {
			String sql = "INSERT INTO Tab_investimento(TIPO, VALOR, DATA_CRIACAO, DATA_VENCIMENTO, USUARIO_ID) "
					+ "VALUES (?, ?, ?, ?, ?)";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, investimento.getTipo());
			stmt.setDouble(2, investimento.getValor());
			java.sql.Date dataCriacao = new java.sql.Date(investimento.getDataCriacao().getTime());
			stmt.setDate(3, dataCriacao);
			java.sql.Date dataVenc = new java.sql.Date(investimento.getDataVencimento().getTime());
			stmt.setDate(4, dataVenc);
			stmt.setInt(5, investimento.getUsuarioID());
			stmt.executeUpdate();
			
			System.out.println("Dados inseridos com sucesso");
		}
		catch(Exception e) {
			System.out.println("Erro ao inserir dados na tabela despesa " + e.getMessage());
		}
	}

	public List<InvestimentoModel> getAll(Connection connection) {
		List<InvestimentoModel> investimentos = new ArrayList<>();
        String sql = "SELECT * FROM Tab_investimento";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tipo = resultSet.getString("tipo");
                double valor = resultSet.getDouble("valor");
				int usuarioID = resultSet.getInt("usuario_id");
    			java.sql.Date dataCriacao = resultSet.getDate("data_criacao");
    			java.sql.Date dataVencimento = resultSet.getDate("data_vencimento");
				InvestimentoModel investimento = 
						new InvestimentoModel(id, tipo, valor, dataCriacao, dataVencimento, usuarioID);
                investimentos.add(investimento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
			System.out.println("Erro ao listar Despesas " + e.getMessage());
        }
        
        return investimentos;
    }
}
