package br.com.fintech.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	private static Connection connection;
	private static final String dbUrl = "jdbc:oracle:thin:@oracle.fiap.com.br:1521/ORCL";
	private static final String dbUser = "rm551229";
	private static final String dbPassword = "240380";

	public static void main(String[] args) {
		DBManager.openConnection();
	}

	// Método para abrir a conexão com o banco de dados
	private static void openConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			System.out.println("Conexão com o banco de dados estabelecida.");
		} catch (Exception e) {
			System.err.println("Erro ao abrir a conexão com o banco de dados: " + e.getMessage());
			throw new RuntimeException(e);
		}
	}

	public static Connection getConnection() {
		try {
			if (connection == null || connection.isClosed())
				openConnection();
		} catch (SQLException e) {
			openConnection();
		}

		return connection;
	}
}
