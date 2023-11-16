import java.util.Date;
import java.util.List;

import br.com.fintech.DBConnection.DBManager;
import br.com.fintech.dao.DespesaDAO;
import br.com.fintech.dao.InvestimentoDAO;
import br.com.fintech.models.DespesaModel;
import br.com.fintech.models.InvestimentoModel;

public class Inicializador {

	public static void main(String[] args) {
		Date hoje = new Date();
		int usuarioId = 1;

		DespesaModel despesa = new DespesaModel();
		despesa.setDataCriacao(hoje);
		despesa.setTipo("Supermercado");
		despesa.setValor(110.20);
		despesa.setUsuarioID(usuarioId);

		DespesaDAO despesaDao = new DespesaDAO();
		despesaDao.create(despesa, DBManager.getConnection());
		System.out.println("Buscando as despesas");
		List<DespesaModel> despesas = despesaDao.getAll(DBManager.getConnection());
		System.out.println(despesas);

		System.out.println("Inserindo o investimento");
		Date futuro = new Date(2026, 5, 10);
		InvestimentoModel investimento = new InvestimentoModel("renda_fixa", 50.00, hoje, futuro, usuarioId);
		InvestimentoDAO investimentoDao = new InvestimentoDAO();
		investimentoDao.create(investimento, DBManager.getConnection());

		System.out.println("Buscando os investimentos");
		List<InvestimentoModel> investimentos = investimentoDao.getAll(DBManager.getConnection());
		System.out.println(investimentos);
	}

}
