package br.com.fintech.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fintech.DBConnection.DBManager;
import br.com.fintech.dao.DespesaDAO;
import br.com.fintech.models.DespesaModel;

@WebServlet(name = "DespesaServlet", urlPatterns = { "/despesa" })
public class DespesaServlet extends HttpServlet {

	private DespesaDAO despesaDao = new DespesaDAO();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<DespesaModel> despesas = despesaDao.getAll(DBManager.getConnection());
		request.setAttribute("despesas", despesas);
		redirectToJsp(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DespesaModel despesa = new DespesaModel();
		despesa.setDataCriacao(new Date());
		despesa.setUsuarioID(1);

		String tipo = request.getParameter("tipoText");
		despesa.setTipo(tipo);

		String valor = request.getParameter("valorText");
		despesa.setValor(Double.parseDouble(valor));

		despesaDao.create(despesa, DBManager.getConnection());

		List<DespesaModel> despesas = despesaDao.getAll(DBManager.getConnection());
		request.setAttribute("despesas", despesas);
		redirectToJsp(request, response);

		System.out.println("Despesa inserida");
	}

	private void redirectToJsp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/despesa.jsp");
		dispatcher.forward(request, response);
	}
}