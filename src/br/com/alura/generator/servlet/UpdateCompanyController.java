package br.com.alura.generator.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.generator.dao.CompanyDao;
import br.com.alura.generator.models.Company;

@WebServlet("/update-company")
public class UpdateCompanyController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("id"));
		String name = req.getParameter("name");
		Calendar openingDate = Calendar.getInstance();

		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy")
					.parse(req.getParameter("openingDate"));
			openingDate.setTime(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Company company = new Company(id, name, openingDate);

		CompanyDao companyDao = new CompanyDao();
		companyDao.update(company);
		
		resp.sendRedirect("/curso-servlet-alura/listCompany");
	}
}
