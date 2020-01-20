package br.com.alura.generator.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.generator.dao.CompanyDao;
import br.com.alura.generator.models.Company;

@WebServlet("/company-detail")
public class CompanyDetail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("id"));
		CompanyDao companyDao = new CompanyDao();
		
		Company company = companyDao.findById(id);
		
		req.setAttribute("company", company);
		RequestDispatcher rd = req.getRequestDispatcher("/update-company.jsp");
		rd.forward(req, resp);
	}
}
