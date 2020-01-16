package br.com.alura.generator.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.generator.dao.CompanyDao;
import br.com.alura.generator.models.Company;

@WebServlet("/newCompany")
public class NewCompanyServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		PrintWriter writer = resp.getWriter();
		
		CompanyDao companyDao = new CompanyDao();
		Company company = new Company(name);
		companyDao.save(company);
		
		writer.println("<body>");
		writer.println("<h1>");
		writer.println("Bem vindo à " + company.getName() + " !");
		writer.println("</h1>");
		writer.println("</body>");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CompanyDao companyDao = new CompanyDao();
		
		PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.print("<th>");
        out.print("Empresas");
        out.print("</th>");
        out.println("<ul>");
        for (Company company: companyDao.findAll()) { 
            out.println("<li>" + company.getName() + "</li>");
        }        
        out.println("</ul>");
        out.println("</body></html>");
	}
}
