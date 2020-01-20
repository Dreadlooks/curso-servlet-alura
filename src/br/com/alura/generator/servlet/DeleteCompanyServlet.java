package br.com.alura.generator.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.generator.dao.CompanyDao;

@WebServlet("/company-remove")
public class DeleteCompanyServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("id"));
		
		CompanyDao companyDao = new CompanyDao();
		companyDao.delete(id);
		
		resp.sendRedirect("listCompany");
	}
}
