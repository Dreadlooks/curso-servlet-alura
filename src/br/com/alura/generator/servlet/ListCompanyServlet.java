package br.com.alura.generator.servlet;

import java.io.IOException;
import java.util.TimeZone;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.generator.dao.CompanyDao;

@WebServlet("/listCompany")
public class ListCompanyServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CompanyDao companyDao = new CompanyDao();
//		PrintWriter out = resp.getWriter();
//        out.println("<html><body>");
//        out.print("<th>");
//        out.print("Empresas");
//        out.print("</th>");
//        out.println("<ul>");
//        for (Company company: companyDao.findAll()) { 
//            out.println("<li>" + company.getName() + "</li>");
//        }        
//        out.println("</ul>");
//        out.println("</body></html>");
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/listcompany.jsp");
		req.setAttribute("list", companyDao.findAll());
		rd.forward(req, resp);
	}
}
